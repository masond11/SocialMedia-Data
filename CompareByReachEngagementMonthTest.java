/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * Will test the methods in the CompareByReachEngagementMonth class
 * 
 * @author Mason Dooley
 * @version 2022.11.15
 *
 */
public class CompareByReachEngagementMonthTest extends TestCase {

  //Fields
    private CompareByReachEngagementMonth comparator;
    private Influencer influencer1;
    private Influencer influencer2;
    
    /**
     * Setup() will run before each test method and create
     * a CompareByReachEngagement object with two
     * Influencer objects and two Engagement Objects that are
     * added to an Influencer
     */
    public void setUp() {
        comparator = new CompareByReachEngagementMonth("January");
        
        influencer1 = new Influencer("person345", 
            "personChannel", "USA", "general");
        influencer2 = new Influencer("Michael1", 
            "MichaelChannel", "USA", "general");
        Engagement engagement1 = new Engagement("January", 1, 2, 3, 4, 5);
        Engagement engagement2 = new Engagement("January", 6, 2, 28, 9, 20);
        influencer1.addEngagement(engagement1);
        influencer2.addEngagement(engagement2);
        
    }
    
    /**
     * Will test that a number less than 0 is returned when
     * influencer1 has a smaller reachEngagement than influencer2
     */
    public void testCompare() {
        assertTrue(comparator.compare(influencer1, influencer2) < 0);
    }
    
    /**
     * Will test that a number greater than 0 is returned when
     * influencer2 has a greater reachEngagement than influencer1
     */
    public void testCompare2() {
        assertTrue(comparator.compare(influencer2, influencer1) > 0);
    }
    
    /**
     * Will test that 0 is returned when
     * influencer1 and influencer2 have the same reachEngagement
     */
    public void testCompare3() {
        Engagement newEngagement = new Engagement("February", 1, 2, 3, 4, 5);
        influencer1.addEngagement(newEngagement);
        influencer2.addEngagement(newEngagement);
        CompareByReachEngagementMonth comparator = 
            new CompareByReachEngagementMonth("February");
        assertEquals(comparator.compare(influencer1, influencer2), 0);
    }
}
