// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.
// -- Mason Dooley (masond11)
// -- Ellie McDaniel
// -- Andrei Zaitsev
package prj5;

import java.awt.Color;
import java.util.Random;

/**
 * @author Ellie McDaniel
 * @version 11/15/2022
 * @author Mason Dooley
 * @version 11/18/22
 * @author Andrei Zaitsev
 * @version 11/30/22
 *          class to represent a social media influencer
 *
 */
public class Influencer {

    /**
     * Maximum amount of engagements and influencer
     * can have
     */
    public static final int MAX_ENGAGEMENTS = 12;
    private Engagement[] engagements;
    private String username;
    private ChannelInfo channelInfo;
    private int engagementsSize;
    private Color color;

    /**
     * constructor for the Influencer class
     * 
     * @param userName
     *            of the influencer
     * @param channelName
     *            that the influencer chose
     * @param country
     *            that the main audience is in
     * @param mainTopic
     *            that the channel discusses
     */
    public Influencer(
        String userName,
        String channelName,
        String country,
        String mainTopic) {
        channelInfo = new ChannelInfo(channelName, country, mainTopic);
        this.username = userName;
        engagements = new Engagement[MAX_ENGAGEMENTS];
        engagementsSize = 0;
        Random random = new Random();
        int r1 = random.nextInt(256);
        int r2 = random.nextInt(256);
        int r3 = random.nextInt(256);
        color = new Color(r1, r2, r3);
    }


    /**
     * gets the username of the influencer
     * 
     * @return the username
     */
    public String getUsername() {
        return username;
    }


    /**
     * gets the engagement for a particular month
     * for the influencer
     * 
     * @param month
     *            that we want to look at
     * @return the engagement for that month
     */
    public Engagement getEngagement(String month) {
        for (int i = 0; i < engagementsSize; i++) {
            if (engagements[i].getMonth().equals(month)) {

                return engagements[i];
            }
        }

        return null;
    }


    /**
     * gets the channel info
     * 
     * @return the channelInfo
     */
    public ChannelInfo getChannelInfo() {
        return channelInfo;
    }


    /**
     * gets color
     * 
     * @return color
     */
    public Color getColor() {
        return color;
    }


    /**
     * sets the engagement for a particular month for the
     * influencer
     * 
     * @param en
     *            the engagement for that month
     * @return boolean if adding Engagement was successful
     */
    public boolean addEngagement(Engagement en) {
        if (en == null) {
            return false;
        }

        if (engagementsSize == MAX_ENGAGEMENTS) {
            return false;
        }

        engagements[engagementsSize] = en;
        engagementsSize++;
        return true;
    }


    /**
     * Getter method for engagementsSize
     * 
     * @return int engagementsSize
     */
    public int getEngagementsSize() {
        return engagementsSize;
    }


    /**
     * Getter method for engagements
     * 
     * @return Engagement[] engagements
     */
    public Engagement[] getEngagements() {
        return engagements;
    }


    /**
     * determines if the object passed in is the same
     * influencer
     * 
     * @return whether it is the same influencer
     * @param obj
     *            tested for equality
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        else if (obj == null) {
            return false;
        }

        else if (obj.getClass().equals(this.getClass())) {
            Influencer other = (Influencer)obj;
            if (other.getUsername().equals(this.getUsername())
                && this.channelInfo.getChannelName().equals(other.channelInfo
                    .getChannelName())) {
                return true;
            }

        }
        return false;
    }


    /**
     * builds a string representation of the influencer
     * including their username and engagements by month
     * 
     * @return a string representation of the Influencer
     */
    public String toString() {
        StringBuilder entries = new StringBuilder();
        entries.append("Username: " + username + ", ");
        entries.append(channelInfo.toString() + ", ");

        for (int i = 0; i < engagementsSize; i++) {

            if (i == 0) {
                entries.append("Monthly Engagements: ");
            }

            entries.append(engagements[i]);

            if (i != engagementsSize - 1) {
                entries.append(", ");
            }
        }
        return entries.toString();
    }


    /**
     * returns an Engagement for the first quarter so
     * that we can sort by engagement for a quarter
     * 
     * @return Engagement for quarter
     */
    public Engagement getEngagementForQuarter() {
        int totalViews = 0;
        int totalLikes = 0;
        int totalFollowers = 0;
        int totalComments = 0;
        int totalPosts = 0;
        int count = 0;
        Engagement e = engagements[0];
        while (e != null && count < 12) {
            if (e.getMonth().equals("January")) {
                totalViews += e.getViews();
                totalLikes += e.getLikes();

                totalComments += e.getComments();
                totalPosts += e.getPosts();
            }
            if (e.getMonth().equals("February")) {
                totalViews += e.getViews();
                totalLikes += e.getLikes();

                totalComments += e.getComments();
                totalPosts += e.getPosts();
            }
            if (e.getMonth().equals("March")) {
                totalViews += e.getViews();
                totalLikes += e.getLikes();
                totalFollowers += e.getFollowers();
                // System.out.println(totalFollowers);
                totalComments += e.getComments();
                totalPosts += e.getPosts();
                // System.out.println(e.getFollowers());
            }
            count++;
            e = engagements[count];
        }

        Engagement newE = new Engagement("quarter", totalLikes,
            totalFollowers, totalComments, totalViews, totalPosts);
        return newE;
    }
}
