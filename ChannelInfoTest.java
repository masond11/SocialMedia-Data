/**
 * 
 */
package prj5;
import student.TestCase;
/**
 * @author Ellie McDaniel
 * @version 11/15/2022
 * @author Andrei Zaitsev
 * @version 11/17/22
 * @author Mason Dooley
 * @version 11/18/22
 *class to test the methods in ChannelInfo class
 */
public class ChannelInfoTest 
    extends TestCase {
    
    private ChannelInfo info;
    
    
    /**
     * sets up the conditions for testing
     */
    public void setUp()
    {
        info = new ChannelInfo("personChannel", "USA", "general");
    }
    
    
    /**
     * tests getChannelName()
     */
    public void testGetChannelName()
    {
        assertEquals(info.getChannelName(), "personChannel");
        
    }
    
    
    /**
     * tests getCountry()
     */
    public void testGetCountry()
    {
        assertEquals(info.getCountry(), "USA");
    }
    
    
    /**
     * tests getMainTopic()
     */
    public void testGetMainTopic()
    {
        assertEquals(info.getMainTopic(), "general");
    }
    
    
    /**
     * tests equals() when the object passed in is null, the
     * same instance, the same channelinfo, and when the name
     *  and country are wrong
     */
    public void testEquals()
    {
        assertFalse(info.equals(null));
        assertTrue(info.equals(info));
        ChannelInfo infoTwo = new ChannelInfo(
            "personChannel", "USA", "general");
        assertFalse(info.equals(new Object()));
        assertTrue(info.equals(infoTwo));
        infoTwo = new ChannelInfo("otherChannel", "USA", "general");
        assertFalse(info.equals(infoTwo));
        infoTwo = new ChannelInfo("personChannel", "USA", "sports");
        assertFalse(info.equals(infoTwo));
        infoTwo = new ChannelInfo("personChannelTwo", "USA", "sports");
        assertFalse(info.equals(infoTwo));
    }
    
    
    
    /**
     * tests toString()
     */
    public void testToString()
    {
        String result = "Channel Name: personChannel,"
            + " Country: USA, Main Topic: general";
        assertEquals(info.toString(), result);
        String noCountryResult = "Channel Name: personChannel,"
            + " Main Topic: general";
        ChannelInfo temp = new ChannelInfo("personChannel", "", "general");
        assertEquals(temp.toString(), noCountryResult);
    }

}

