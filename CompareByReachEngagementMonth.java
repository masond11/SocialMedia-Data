/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * Will compare the ReachEngagement of two Influencers
 * 
 * @author Mason Dooley
 * @version 2022.12.2
 *
 */
public class CompareByReachEngagementMonth implements Comparator<Influencer> {

    //Fields
    private String month;
    
    /**
     * Constructor that initializes the month field
     * 
     * @param month Engagement month to be sorted
     */
    public CompareByReachEngagementMonth(String month) {
        this.month = month;
    }
    
    /**
     * Will determine which ReachEngagement between two Influencers
     * are greater
     * 
     * @return int which reach is greater
     */
    @Override
    public int compare(Influencer influencer1, Influencer influencer2) {
        
        //Obtain the engagement array for each influencer
        Engagement[] engagements = influencer1.getEngagements();
        Engagement[] engagements2 = influencer2.getEngagements();
        
        //Create to double fields. If an influencer does not have
        //an Engagement for a month, the corresponding reach value
        //will be unchanged
        Double reach1 = Double.MIN_VALUE;
        Double reach2 = Double.MIN_VALUE;
        
        //Loop through engagements for influencer1
        for (int i = 0; i < influencer1.getEngagementsSize(); i++) {
            
            //Using the month field the proper reach engagement
            //can be obtained
            if (engagements[i].getMonth().equals(this.month)) {
                reach1 = engagements[i].getReachEngagement();
            }
        }
        
        //Loop through engagements for influencer2
        for (int i = 0; i < influencer2.getEngagementsSize(); i++) {
            
            if (engagements2[i].getMonth().equals(this.month)) {
                reach2 = engagements2[i].getReachEngagement();
            }
        }
        
        //Determine which influencer's reach is greater
        double difference = reach1 - reach2;
        
        if (Math.abs(difference) <= 0.000001)
        {
            return 0;
        }
        else if (difference < 0)
        {
            return -1;
        }
        return 1;
    }

}
