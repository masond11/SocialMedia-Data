/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * This class will compare the traditional Engagement
 * Rates of two influencers for the first quarter
 * 
 * @author Mason Dooley
 * @version 2022.11.29
 *
 */
public class CompareByTraditionalQuarter implements Comparator<Influencer>{

    /**
     * This method determines which Influencer has a greater traditional
     * rate for the first quarter of a year.
     */
    @Override
    public int compare(Influencer influencer1, Influencer influencer2) {
        
        //Get an Influencer's quarter engagement and then corresponding
        //traditional Engagement
        Double traditional1 = influencer1.getEngagementForQuarter()
            .getTraditionalEngagement();
        Double traditional2 = influencer2.getEngagementForQuarter()
            .getTraditionalEngagement();
        
        double difference = traditional1 - traditional2;
        
        if (Math.abs(difference) <= 0.000001) {
            return 0;
        }
        
        if (difference < 0) {
            return -1;
        }
        
        return 1;
    }

}
