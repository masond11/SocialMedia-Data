/**
 * 
 */
package prj5;
import student.TestCase;
/**
 * @author Ellie McDaniel
 * @version 11/15/2022
 * tests the methods in the Engagement class
 *
 */
public class EngagementTest 
    extends TestCase {
    
    private Engagement engagement;
    
    
    /**
     * sets up the conditions for testing
     */
    public void setUp()
    {
        engagement = new Engagement("jan", 50, 40, 30, 20, 10);
    }
    
    /**
     * tests getMonth()
     */
    public void testGetMonth()
    {
        assertEquals(engagement.getMonth(), "jan");
        
    }
    
    
    /**
     * tests getLikes()
     */
    public void testGetLikes()
    {
        assertEquals(engagement.getLikes(), 50);
    }
    
    
    /**
     * tests getFollowers()
     */
    public void testGetFollowers()
    {
        assertEquals(engagement.getFollowers(), 40);
    }
    
    
    /**
     * tests getComments()
     */
    public void getGetComments()
    {
        assertEquals(engagement.getComments(), 30);
    }
    
    
    /**
     * tests getViews()
     */
    public void testGetViews()
    {
        assertEquals(engagement.getViews(), 20);
        
    }
    
    
    /**
     * tests getPosts()
     */
    public void testGetPosts()
    {
        assertEquals(engagement.getPosts(), 10);
    }
    
    
    /**
     * tests getTraditionalEngagement()
     */
    public void testGetTraditionalEngagement()
    {
        
        assertEquals(engagement.getTraditionalEngagement(), 200.0, .01);
        engagement = new Engagement("jan", 50, 0, 30, 40, 10);
        assertEquals(engagement.getTraditionalEngagement(), 0.0, .01);
    }
    
    
    /**
     * tests getTraditionalEngagement()
     */
    public void testGetReachEngagement()
    {
        assertEquals(engagement.getReachEngagement(), 400.0, .01);
        engagement = new Engagement("jan", 50, 40, 30, 0, 10);
        assertEquals(engagement.getReachEngagement(), 0.0, .01);
    }
    
    
    /**
     * tests toString()
     */
    public void testToString()
    {
        String result = "Month: jan, Likes: 50, Followers: 40,"
            + " Comments: 30, Views: 20, Posts: 10, Total "
            + "Engagement: 80";
        assertEquals(engagement.toString(), result);
    }

}
