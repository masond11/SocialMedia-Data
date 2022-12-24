package prj5;

import student.TestCase;

/**
 * test class for CompareByUsername
 * 
 * @author Mason Dooley
 * @version 11/15/22
 * @author Andrei Zaitsev
 * @version 11/17/22
 */
public class CompareByChannelNameTest extends TestCase {

  //Fields
    private CompareByChannelName comparator;
    private Influencer influencer1;
    private Influencer influencer2;
    
    /**
     * Setup method runs before each test. Creates a CompareByUsername
     * object with two Influencers.
     */
    public void setUp() {
        
        comparator = new CompareByChannelName();
        influencer1 = new Influencer(
            "aaFootball", "allaboutFootball", "UK", "Sports");
        influencer2 = new Influencer(
            "fashion32", "fashionest", "US", "Fashion");
    }
    
    /**
     * Will test that a negative int is returned if influencer1 username
     * is less than influencer2.
     */
    public void testCompare() {
        assertTrue(comparator.compare(influencer1, influencer2) > 0);
    }
    
    /**
     * Will test that a positive int is returned if influencer2 username
     * is greater than influencer1.
     */
    public void testCompare2() {
        assertTrue(comparator.compare(influencer2, influencer1) < 0);
    }
    
    /**
     * Will test that 0 is returned if influencer1 and influencer2
     * usernames are the same.
     */
    public void testCompare3() {
        Influencer newInfluencer2 =
            new Influencer("aaFootball", "allaboutFootball", "UK", "Sports");
        
        assertEquals(comparator.compare(influencer1, newInfluencer2), 0);
    }

}
