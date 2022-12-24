/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * This class compares two Influencer objects to see
 * which has a higher Reach Engagement for the first quarter
 * 
 * @author Mason Dooley
 * @version 2022.11.29
 *
 */
public class CompareByReachQuarter implements Comparator<Influencer> {

    /**
     * This method determines which Influencer has a greater reach for the
     * first quarter of a year.
     */
    @Override
    public int compare(Influencer influencer1, Influencer influencer2) {
        
        //Get the Quarter Engagement for an influencer and then get
        //the corresponding reach
        Double reach1 = influencer1.getEngagementForQuarter().
            getReachEngagement();
        Double reach2 = influencer2.getEngagementForQuarter().
            getReachEngagement();
        
        //Determine which reach is greater
        double difference = reach1 - reach2;
        
        if (Math.abs(difference) <= 0.000001) {
            return 0;
        }
        
        if (difference < 0) {
            return -1;
        }
        
        return 1;
    }

}
