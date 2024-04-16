package prj5;

import dailymixes.DailyMixDataException;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author ddmat
 *  @version Apr 16, 2024
 */
public class InputFileReader
{
    // ~ Fields ................................................................
    private SinglyLinkedList<Influencer> input;
    // ~ Constructors ..........................................................
    /**
     * Create a new InputFileReader object.
     * @param fileName
     *          the file that will be read through the constructor
     * @throws ParseException 
     *          if an error has been reached while parsing the input file.
     * @throws FileNotFoundException 
     *          if the input file is inaccessible or does not exist.
     */
    public InputFileReader(String fileName) throws ParseException,
    FileNotFoundException, MonthException 
    {
        input = readAllPosts(fileName);
    }
    // ~ Public Methods ........................................................
    /**
     * reads the posts file to to populate the linkedList full of month object
     * @param file
     *          reads a file of posts and puts them in a linkedlist
     * @return a SinglyLinkedList of month objects
     */
    public SinglyLinkedList<Influencer> readAllPosts(String postsFile)
    {
        SinglyLinkedList<Influencer> parsedList = new 
            SinglyLinkedList<Influencer>();
        
        File newFile = new File(postsFile);
        Scanner file = new Scanner(newFile);
        
        while (file.hasNextLine()) 
        {
            String read = file.nextLine();
            String[] tokens = read.split(",\\s*");
            
            String month = tokens[0];
            String username = tokens[1];
            String channel = tokens[2];
            String mainTopic = tokens[3];
            int likes = Integer.valueOf(tokens[4]);
            int posts = Integer.valueOf(tokens[5]);
            int followers = Integer.valueOf(tokens[6]);
            int comments = Integer.valueOf(tokens[7]);
            int views = Integer.valueOf(tokens[8]);
            
            if (!isAValidMonth(month)) 
            {
                throw new MonthException("month given is not a valid month of "
                    + "the week");
            }
            
            Influencer newInfluencer = new Influencer(username, channel, 
                mainTopic);
            
            newInfluencer.add(readSinglePost(month, likes, posts, followers, 
                comments, views));
            
            parsedList.add(newInfluencer);
        }
        file.close();
        return parsedList;
    }
    
    /**
     * reads a single posts given the varaibles from above an adds turns it into
     * a month object
     * 
     */
    private Month readSinglePosts(String month, int likes, int posts, 
        int followers, int comments, int views) 
    {
        Month newMonth = new Month(month, likes, posts, followers, comments, 
            views);
        return newMonth;
    }
    
    /**
     * checks to see if the month is a valid month of the year
     * 
     * @param month
     *          the month being checked
     * @return whether the month is a valid month or not
     */
    private boolean isAValidMonth(String month) 
    {
        month.toUpperCase();
        if (month.equals(MONTH[0]) || month.equals(MONTH[1]) || 
            month.equals(MONTH[2]) || month.equals(MONTH[3]) || 
            month.equals(MONTH[4]) || month.equals(MONTH[5]) || 
            month.equals(MONTH[6]) || month.equals(MONTH[7]) || 
            month.equals(MONTH[8]) || month.equals(MONTH[9]) || 
            month.equals(MONTH[10]) || month.equals(MONTH[11])) 
        {
            return true;
        }
        return false;
    }
}
