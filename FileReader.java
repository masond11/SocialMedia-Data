/**
 * 
 */
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Andrei Zaitsev
 * @version 11/17/22
 */
public class FileReader 
{
    private LinkedList<Influencer> influencers;
    /**
     * Constructor for File Reader which stores information from given file
     * @param fileName
     * Name of file to be scanned
     * @throws FileNotFoundException
     */
    public FileReader(String fileName) throws FileNotFoundException 
    {

        influencers = new LinkedList<Influencer>();
        readFile(fileName);
        new SocialMediaWindow(influencers);
    }
    
    
    /**
     * Scans file and stores information in list of Influencers
     * @param fileName
     * name of file to be scanned
     * @return LinkedList of Influencers
     * @throws FileNotFoundException
     */
    private void readFile(String fileName) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(fileName));
        sc.nextLine();
        while (sc.hasNextLine()) {
            String thisLine = sc.nextLine();
            Scanner line = new Scanner(thisLine).useDelimiter(",\\s*");
            String[] tokens = new String[10];
            int tokenCount = 0;
            while (line.hasNext() && tokenCount < 10)
            {
                tokens[tokenCount++] = line.next();
            }
            
            line.close();
            
            String month = tokens[0];
            String username = tokens[1];
            String chnl = tokens[2];
            String country = tokens[3];
            String mTopic = tokens[4];
            int likes = Integer.valueOf(tokens[5]);
            int posts = Integer.valueOf(tokens[6]);
            int followers = Integer.valueOf(tokens[7]);
            int comments = Integer.valueOf(tokens[8]);
            int views = Integer.valueOf(tokens[9]);
            
            Influencer in = getInfluencer(username);
            
            if (in == null)
            {
                Influencer inf = new Influencer(username, chnl, country, mTopic);
                Engagement engagement = new Engagement(month, likes,
                    followers, comments, views, posts);
                inf.addEngagement(engagement);
                influencers.add(inf);
            }
            
            else
            {
                
                Engagement engagement = new Engagement(month, likes,
                    followers, comments, views, posts);
                in.addEngagement(engagement);
            }
            
        }
        sc.close();
    }
    
    /**
     * Gets an Influencer from the list. Will return null
     * if Influencer is not in the list.
     * 
     * @param username Influencer username
     * @return Influencer from the list
     */
    private Influencer getInfluencer(String username)
    {

        if (influencers.size() == 0)
        {
            return null;
        }
       
        for (int i = 0; i < influencers.size(); i++)
        {
            if (username.equalsIgnoreCase(influencers.get(i).getUsername()))
            {
                return influencers.get(i);
            }
            
        }
        return null;
    }
    
}
