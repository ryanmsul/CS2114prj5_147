package prj5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

// -------------------------------------------------------------------------
/**
 * The ProjectRunner class allows us to run specific input files and check our
 * output, which is useful to finding errors between expected and actual output.
 * 
 * @author ddmat
 * @version Apr 16, 2024
 */
public class ProjectRunner
{

    // ----------------------------------------------------------
    /**
     * Main method for running specified input file (can be specified with args)
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException
    {

        // Changes input file based on passed arguments
        InputFileReader filer = null;

        if (args.length > 0)
        {
            try
            {
                filer = new InputFileReader(args[0]);
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (MonthException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try
            {
                filer = new InputFileReader("SampleInput3_2023.csv");
            }
            catch (FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (MonthException e)
            {
                e.printStackTrace();
            }
        }

        final boolean showConsole = false;
        final boolean showGUI = !showConsole;

        SinglyLinkedList<Influencer> input = filer.getInput();
        input.insertionSort(new CompareChannelName());

        if (showConsole)
        {
            // Outputs the expected output for console.
            for (int i = input.size() - 1; i >= 0; i--)
            {
                System.out.println(input.get(i).getChannelName());
                if (input.get(i).getTraditionalEngagementRate() != -1)
                {
                    System.out.printf(
                        "traditional: %.1f",
                        input.get(i).getTraditionalEngagementRate());
                }
                else
                {
                    System.out.print("traditional: n/a");
                }
                System.out.println("\n==========");

            }
            System.out.println("**********\n**********");

            input.insertionSort(new CompareReachEngagement());

            for (int i = input.size() - 1; i >= 0; i--)
            {
                System.out.println(input.get(i).getChannelName());

                if (input.get(i).getReachEngagementRate() != -1)
                {
                    System.out.printf(
                        "reach: %.1f",
                        input.get(i).getReachEngagementRate());
                }
                else
                {
                    System.out.print("reach: n/a");
                }
                System.out.println("\n==========");

            }

        }
        if (showGUI)
        {
            VisualizerWindow vWindow = new VisualizerWindow(input);

            /*
             * TODO: For final Submission - Should have the GUI display for the
             * input data
             */
        }

    }
}
