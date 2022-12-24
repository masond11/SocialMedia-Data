/**

 * 
 */

package prj5;
import java.awt.Color;
import student.TestCase;


/**
 * @author Ellie McDaniel
 * @version 11/15/2022
 * @author Mason Dooley
 * @version 11/18/22
 * @author Andrei Zaitsev
 * @version 11/18/22
 * @version 11/30/22
 * 
 * class to test the methods in the Influencer class
 *
 */
public class InfluencerTest 
    extends TestCase {
    
    private Influencer person;
    private Engagement january;
    private ChannelInfo info;
    private Color color;
    
    /**
     * sets up conditions for testing
     */
    public void setUp()
    {
        color = new Color(16);
        person = new Influencer("person345", 
            "personChannel", "USA", "general");
        january = new Engagement("January", 50, 100, 100, 30, 2);
        info = new ChannelInfo("personChannel", "USA", "general");
        
    }
    
   /**
    * tests getUsername() 
    */
    public void testGetUsername()
    {
        assertEquals(person.getUsername(), "person345");
    }
    
    
    /**
     * tests getColor()
     */
    public void testColor() {
        assertNotNull(person.getColor());
    }
    
    
    /**
     * tests getEngagements() 
     * 
     */
    public void testGetEngagements() {
        Engagement[] engagements = person.getEngagements();
        assertNull(engagements[0]);
        
        person.addEngagement(january);
        engagements = person.getEngagements();
        assertEquals(engagements[0].getMonth(), "January");
    }
    
    /**
     * tests getEngagement()
     */
    public void testGetEngagement()
    {
        person.addEngagement(january);
        assertEquals(person.getEngagement("January"), january);
        Engagement february = new Engagement("February", 50, 100, 100, 30, 2);
        person.addEngagement(february);
        assertEquals(person.getEngagement("February"), february);
        assertNull(person.getEngagement("March"));
    }
    
    /**
     * tests addEngagement()
     */
    public void testAddEngagement()
    {
        assertFalse(person.addEngagement(null));
        
        for (int i = 0; i < Influencer.MAX_ENGAGEMENTS; i++) {
            assertTrue(person.addEngagement(january));
            assertEquals(person.getEngagementsSize(), i + 1);
        }
        
        assertFalse(person.addEngagement(january));
    }
    
    /**
     * tests getChannelInfo()
     */
    public void testGetChannelInfo()
    {
        assertEquals(person.getChannelInfo(), info);
    }
    
    
    /**
     * tests every combination for equals()
     */
    public void testEquals()
    {
        assertTrue(person.equals(person));
        assertFalse(person.equals(null));
        Object object = new Object();
        assertFalse(person.equals(object));
        
        Influencer personTwo = new Influencer("person345", 
            "personChannel", "USA", "general");
        assertTrue(person.equals(personTwo));
        personTwo = new Influencer("person444", 
            "personChannel", "USA", "general");
        assertFalse(person.equals(personTwo));
        personTwo = new Influencer("person345", 
            "personChannelTwo", "USA", "general");
        assertFalse(person.equals(personTwo));
        personTwo = new Influencer("person345", 
            "personChannel", "USA", "general");
        assertFalse(person.equals(personTwo));
    }
    
    
    /**
     * tests the toString() method
     */
    public void testToString()
    {
        person.addEngagement(january);
        String result = "Username: person345, Channel Name:"
            + " personChannel, Country: USA, Main Topic:"
            + " general, Monthly Engagements: Month: "
            + "January, Likes: 50, Followers: 100, "
            + "Comments: 100, Views: 30, Posts: 2, "
            + "Total Engagement: 150";

        assertEquals(person.toString(), result);
    }
    
    /**
     * tests the toString() method
     */
    public void testToString2()
    {
        person.addEngagement(january);
        Engagement february = new Engagement("February", 50, 100, 100, 30, 2);
        person.addEngagement(february);
        
        String result = "Username: person345, Channel Name:"
            + " personChannel, Country: USA, Main Topic:"
            + " general, Monthly Engagements: Month: "
            + "January, Likes: 50, Followers: 100, "
            + "Comments: 100, Views: 30, Posts: 2, "
            + "Total Engagement: 150, Month: February, "
            + "Likes: 50, Followers: 100, Comments: 100, Views: 30, Posts: 2, "
            +  "Total Engagement: 150";
        
        assertEquals(person.toString(), result);
    }
    
    
    /**
     * tests the getEngagementForQuarter() method
     */
    public void testGetEngagementForQuarter() {
        Engagement february = new Engagement("February", 50, 100, 100, 30, 2);
        Engagement march = new Engagement("March", 50, 100, 100, 30, 2);
        person.addEngagement(january);
        person.addEngagement(february);
        person.addEngagement(march);
        Engagement quarter = person.getEngagementForQuarter();

        assertEquals(150, quarter.getLikes());
        assertEquals(100, quarter.getFollowers());
        assertEquals(300, quarter.getComments());
        assertEquals(90, quarter.getViews());
        assertEquals(6, quarter.getPosts());

    }
}
