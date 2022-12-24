/**
 * 
 */
package prj5;

/**
 * @author Ellie McDaniel
 * @version 11/15/2022
 *class to hold the engagement statistics for 
 *an influencer for a month
 */
public class Engagement {
    
    private String month;
    private int likes;
    private int followers;
    private int comments;
    private int views;
    private int posts;
    private int totalEngagement;
     
    /**
     * constructor for the Engagement class
     * 
     * @param influencer for this engagement
     * @param month for this engagement 
     * @param likes that the influencer got during the month
     * @param followers that the influencer got during the month
     * @param comments that the influencer got
     * @param views that the influencer got during the month
     * @param posts the influencer made during the month
     */
    public Engagement(String month, int likes, int followers,
        int comments, int views, int posts)
    {
        this.month = month;
        this.likes = likes;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
        this.posts = posts;
        totalEngagement = comments + likes;
    }
    
    /**
     * gets the month for the engagement data
     * @return the month
     */
    public String getMonth()
    {
        return month;
    }
    
    
    /**
     * gets the likes the influencer recieved
     * during the month
     * @return the number of likes
     */
    public int getLikes()
    {
        return likes;
    }
    
    
    /**
     * gets the number of followers the influencer
     * had that month
     * @return the number of followers
     */
    public int getFollowers()
    {
        return followers;
    }
    
    
    /**
     * gets the number of comments the influencer
     * received that month
     * @return the number of comments
     */
    public int getComments()
    {
        return comments;
    }
    
    
    /**
     * gets the number of views the influencer
     * received that month
     * @return the number of views
     */
    public int getViews()
    {
        return views;
    }
    
    
    /**
     * gets the number of posts the influencer made
     * that month
     * @return the number of posts made
     */
    public int getPosts()
    {
        return posts;
    }
    
    
    /**
     * gets the engagement of people with the influencer
     * using the traditional formula
     * @return traditional engagement rate
     */
    public double getTraditionalEngagement()
    {
        
        if (followers != 0)
        {
            return (Double.valueOf(totalEngagement) /
                Double.valueOf(getFollowers())) * 100;
        }
        return 0.0;
        
    }
    
    
    /**
     * gets the engagement rate of the influencer
     * using the reach formula
     * @return reach engageme"nt rate
     */
    public double getReachEngagement()
    {
        
        if (views == 0)
        {
            return 0.0;
        }
        return (Double.valueOf(totalEngagement) / Double.valueOf(views)) * 100;
    }
    
    
    
    /**
     * builds a string with all of the important
     * values in the month's engagement
     * 
     * @return a string representation of the 
     * Engagement
     */
    public String toString()
    {
        return "Month: " + month + ", Likes: " + likes
            + ", Followers: " + followers + ", Comments: " 
            + comments + ", Views: " + views + ", Posts: " 
            + posts + ", Total Engagement: " + totalEngagement;
    }

}
