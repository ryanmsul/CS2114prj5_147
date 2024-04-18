package prj5;

import java.io.IOException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author ddmat
 * @version Apr 16, 2024
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param args
     * @throws IOException
     * @throws ParseException
     * @throws MonthException
     */
    public static void main(String[] args)
        throws IOException, ParseException, MonthException
    {

        // Changes input file based on passed arguments
        InputFileReader filer;

        if (args.length > 0)
        {
            filer = new InputFileReader(args[0]);
        }
        else
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }

        final boolean showConsole = true;
        final boolean showGUI = !showConsole;

        if (showConsole)
        {
            SinglyLinkedList<Influencer> input = filer.getInput();
            

            
        
            input.insertionSort(new CompareChannelName());
            
            for(int i = input.size()-1; i>=0; i--) {
                System.out.println(input.get(i).getChannelName());
                if(input.get(i).getTraditionalEngagementRate()!= -1) {
                    System.out.printf("traditional: %.1f", input.get(i).getTraditionalEngagementRate());
                }
                else {
                    System.out.print("traditional: n/a");
                }
                System.out.println("\n==========");
                
                
                
            }
            System.out.println("**********\n**********");
            
            
            input.insertionSort(new CompareReachEngagement());
            
            for(int i = input.size()-1; i>=0; i--) {
                System.out.println(input.get(i).getChannelName());
                
                if(input.get(i).getReachEngagementRate()!= -1) {
                    System.out.printf("reach: %.1f", input.get(i).getReachEngagementRate() );
                }
                else {
                    System.out.print("reach: n/a");
                }
                System.out.println("\n==========");
                
                
                
            }
            
            
            
        }
        if (showGUI)
        {
            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
        }

    }
}
