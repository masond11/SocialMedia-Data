/**
 * 
 */
package prj5;

import java.util.Comparator;
/**
 * Will compare the username of two Influencers
 * 
 * @author Mason Dooley
 * @version 11/15/22
 * @author Andrei Zaitsev
 * @version 11/17/22
 */
public class CompareByChannelName implements Comparator<Influencer> {

    /**
     * Will compare two names for lexicographic order
     * 
     * @return int which name is greater
     */
    @Override
    public int compare(Influencer influencer1, Influencer influencer2) {
        
        int result = influencer2.getChannelInfo().getChannelName().
            compareToIgnoreCase(influencer1.getChannelInfo().getChannelName());
        
        return result;
    }
}
