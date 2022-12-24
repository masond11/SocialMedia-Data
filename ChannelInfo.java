/**
 * 
 */
package prj5;

/**
 * @author Ellie McDaniel
 * @version 11/15/2022
 * @author Andrei Zaitsev
 * @version 11/17/22
 * @author Mason Dooley
 * @version 11/18/22
 *
 *
 *class to hold the basic information of the channel
 *an influencer runs
 */
public class ChannelInfo {
    
    private String channelName;
    private String country;
    private String mainTopic;
    
    
    /**
     * constructor for ChannelInfo class
     * @param name of channel
     * @param count country of origin
     * @param topic that channel focuses on
     */
    public ChannelInfo(String name, String count, String topic)
    {
        channelName = name;
        country = count;
        mainTopic = topic;
    }
    
    
    /**
     * gets the name of the channel
     * @return name of channel
     */
    public String getChannelName()
    {
        return channelName;
    }
    
    
    /**
     * gets the country that the influencer's
     * main audience is in
     * @return country
     */
    public String getCountry()
    {
        return country;
    }
    
    
    /**
     * gets the main topic of the channel
     * @return topic of channel
     */
    public String getMainTopic()
    {
        return mainTopic;
    }
    
    
    /**
     * sees if the object passed in is the same
     * channel info
     * @return true if they are the same channelinfo
     * @param other Object tested for equality
     */
    public boolean equals(Object other)
    {
        if (other == null)
        {
            return false;
        }
        
        else if (other == this)
        {
            return true;
        }
        
        else if (this.getClass().equals(other.getClass()))
        {
            ChannelInfo otherC = (ChannelInfo) other;
            return (this.channelName.equals(otherC.getChannelName())
                && this.mainTopic.equals(otherC.getMainTopic()));
        }
        
        return false;
    }
    
    
    /**
     * Displays the attributes of a ChannelInfo 
     * as a String
     * @return String of channelInfo contents
     */
    public String toString()
    {
        if (country.equals("")) {
            return "Channel Name: " + channelName + 
                ", Main Topic: " + mainTopic;
        }
        return "Channel Name: " + channelName + 
            ", Country: " + country + ", Main Topic: " + mainTopic;
    }

}

