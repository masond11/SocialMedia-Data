/**
 * 
 */
package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * This class runs the project by
 * creating a FileReader Object
 * 
 * @author Andrei  Zaitsev
 * @version 11/17/22
 */
public class Input {

    /**
     * main method
     * 
     * @throws SpaceColonyDataException
     * @throws ParseException
     * @throws FileNotFoundException 
     */
    public static void main(String[] args)
        throws FileNotFoundException 
    {
        if (args.length == 0)
        {
            new FileReader("SampleInput2_2022.csv");
        }
        
        else
        {
            for (String s : args)
            {
                new FileReader(s);
            }
        }
        
    }
}