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
            System.out.print(filer);
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
