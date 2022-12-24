/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * Will compare the TraditionalEngagement of two Engagements
 * 
 * @author Mason Dooley
 * @version 2022.11.15
 */
public class CompareByTraditionalEngagementMonth implements Comparator<Influencer> {
    
    //Fields
    private String month;
    
    /**
     * Constructor that initializes the month field
     * 
     * @param month Engagement month to be sorted
     */
    public CompareByTraditionalEngagementMonth(String month) {
        this.month = month;
    }

    /**
     * Will compare two ints for which is greater
     * @return int which TraditionalEngagement is greater
     **/
    @Override
    public int compare(Influencer influencer1, Influencer influencer2) {
        
        //Get the engagements array for each influencer
        Engagement[] engagements = influencer1.getEngagements();
        Engagement[] engagements2 = influencer2.getEngagements();
        
        //Create to double fields. If an influencer does not have
        //an Engagement for a month, the corresponding reach value
        //will be unchanged
        Double traditional1 = Double.MIN_VALUE;
        Double traditional2 = Double.MIN_VALUE;
        
        //Loop through influencer1's engagements
        for (int i = 0; i < influencer1.getEngagementsSize(); i++) {
            
            //Obtain the proper traditionalEngagement
            if (engagements[i].getMonth().equals(this.month)) {
                traditional1 = engagements[i].getTraditionalEngagement();
            }
        }
        
        //Loop through influencer2's engagement
        for (int i = 0; i < influencer2.getEngagementsSize(); i++) {
            
            if (engagements2[i].getMonth().equals(this.month)) {
                traditional2 = engagements2[i].getTraditionalEngagement();
            }
        }
        
        //Determine which engagement is greater
        double difference = traditional1 - traditional2;
        
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
