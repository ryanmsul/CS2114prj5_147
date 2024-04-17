package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import student.IOHelper;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author ddmat
 * @version Apr 16, 2024
 */
public class InputFileReader
{
    // ~ Fields ................................................................
    private SinglyLinkedList<Influencer> input;

    // ~ Constructors ..........................................................
    /**
     * Create a new InputFileReader object.
     * 
     * @param fileName
     *            the file that will be read through the constructor
     * @throws ParseException
     *             if an error has been reached while parsing the input file.
     * @throws FileNotFoundException
     *             if the input file is inaccessible or does not exist.
     * @throws MonthException
     *             if the month is not a valid month of the year
     */
    public InputFileReader(String fileName)
        throws ParseException,
        FileNotFoundException,
        MonthException
    {
        input = readAllPosts(fileName);
    }


    // ~ Public Methods ........................................................
    /**
     * reads the posts file to to populate the linkedList full of month object
     * 
     * @param postsFile
     *            reads a file of posts and puts them in a linkedlist
     * @return a SinglyLinkedList of month objects
     * @throws MonthException 
     *              throws when the month passed is not a valid month
     * @throws FileNotFoundException 
     *              if the file is not a valid file
     */
    public SinglyLinkedList<Influencer> readAllPosts(String postsFile) 
        throws MonthException, FileNotFoundException
    {
        SinglyLinkedList<Influencer> parsedList =
            new SinglyLinkedList<Influencer>();

        Scanner inStream = IOHelper.createScanner(postsFile);
        inStream.nextLine();// skip header
        while (inStream.hasNextLine()) {


            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);


            // TODO : Populate the Classes created to store the data

            if (!isAValidMonth(month))
            {
                throw new MonthException(
                    "month given is not a valid month of " + "the week");
            }
            
            Influencer newInfluencer =
                new Influencer(username, channel, country, mainTopic);
            
            if(!parsedList.contains(newInfluencer)) {
                
                newInfluencer.addMonthActivity(
                    readSinglePosts(
                        month,
                        likes,
                        posts,
                        followers,
                        comments,
                        views));

                parsedList.add(newInfluencer);

            }
            else {
                int influencerIndex = parsedList.lastIndexOf(newInfluencer);
                
                parsedList.get(influencerIndex).addMonthActivity(
                    readSinglePosts(
                        month,
                        likes,
                        posts,
                        followers,
                        comments,
                        views));
            }
           

        }
        inStream.close();
        return parsedList;
    }

    /**
     *  help convert the string data to an integer 
     *  
     *  @return the number of the string
     *  
     *  @param num
     *          the string / number being passed in
     */
    private int toInt(String num)
    {
        try{
            return Integer.parseInt(num);
        }
        catch(Exception e){
            return 0;
        }
    }


    /**
     * reads a single posts given the variables from above an adds turns it into
     * a month object
     */
    private Month readSinglePosts(
        String month,
        int likes,
        int posts,
        int followers,
        int comments,
        int views)
    {
        Month newMonth =
            new Month(month, likes, posts, followers, comments, views);
        return newMonth;
    }


    /**
     * checks to see if the month is a valid month of the year
     * 
     * @param month
     *            the month being checked
     * @return whether the month is a valid month or not
     */
    private boolean isAValidMonth(String month)
    {
        month = month.toUpperCase();
        if (month.equals("JANUARY") || month.equals("FEBRUARY")
            || month.equals("MARCH") || month.equals("APRIL")
            || month.equals("MAY") || month.equals("JUNE")
            || month.equals("JULY") || month.equals("AUGUST")
            || month.equals("SEPTEMBER") || month.equals("OCTOBER")
            || month.equals("NOVEMBER") || month.equals("DECEMBER"))
        {
            return true;
        }
        return false;
    }
}
