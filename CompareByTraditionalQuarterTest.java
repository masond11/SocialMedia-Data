/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * This class tests the CompareByTraditionalQuarter class
 * 
 * @author Mason Dooley
 * @version 2022.11.29
 */
public class CompareByTraditionalQuarterTest extends TestCase {
    
  //Fields
    private CompareByTraditionalQuarter comparator;
    private Influencer influencer1;
    private Influencer influencer2;
    
    /**
     * Runs before each test method and creates two influencers and adds
     * several Engagements to each one
     */
    public void setUp() {
        comparator = new CompareByTraditionalQuarter();
        influencer1 = new Influencer("person345", 
            "personChannel", "USA", "general");
        influencer2 = new Influencer("Michael1", 
            "MichaelChannel", "USA", "general");
        
        Engagement engagement1 = new Engagement("January", 1, 2, 3, 4, 5);
        Engagement engagement2 = new Engagement("January", 6, 2, 28, 9, 20);
        Engagement engagement3 = new Engagement("February", 6, 7, 8, 9, 10);
        Engagement engagement4 = new Engagement("February", 34, 21, 8, 9, 10);
        Engagement engagement5 = new Engagement("March", 92, 41, 12, 21, 51);
        Engagement engagement6 = new Engagement("March", 64, 22, 21, 4, 20);
        Engagement engagement7 = new Engagement("April", 1, 2, 3, 4, 5);
        Engagement engagement8 = new Engagement("April", 6, 2, 28, 9, 20);
        influencer1.addEngagement(engagement1);
        influencer2.addEngagement(engagement2);
        influencer1.addEngagement(engagement3);
        influencer2.addEngagement(engagement4);
        influencer1.addEngagement(engagement5);
        influencer2.addEngagement(engagement6);
        influencer1.addEngagement(engagement7);
        influencer2.addEngagement(engagement8);
        
    }
    
    /**
     * Tests that when influencer1 has a smaller quarter reach
     * than influencer2 that a negative number is produced by compare()
     */
    public void testCompare1() {
        
        assertTrue(comparator.compare(influencer1, influencer2) < 0);
    }
    
    /**
     * Tests that when influencer2 has a greater quarter reach
     * than influencer1 that a positive number is produced by compare()
     */
    public void testCompare2() {
        
        assertTrue(comparator.compare(influencer2, influencer1) > 0);
    }
    
    /**
     * Tests that when the two influencers have the same reach engagement
     * for the first quarter that 0 is returned
     */
    public void testCompare3() {
        Influencer influencer3 = new Influencer("Michael1", 
            "MichaelChannel", "USA", "general");
        
        Engagement engagement1 = new Engagement("January", 1, 2, 3, 4, 5);
        Engagement engagement2 = new Engagement("February", 6, 7, 8, 9, 10);
        Engagement engagement3 = new Engagement("March", 92, 41, 12, 21, 51);
        Engagement engagement4 = new Engagement("April", 12, 22, 13, 24, 95);
        
        influencer3.addEngagement(engagement1);
        influencer3.addEngagement(engagement2);
        influencer3.addEngagement(engagement3);
        influencer3.addEngagement(engagement4);
        assertTrue(comparator.compare(influencer1, influencer3) == 0);
    }

}
