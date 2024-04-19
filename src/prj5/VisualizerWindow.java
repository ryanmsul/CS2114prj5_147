package prj5;

import cs2.*;
import java.text.DecimalFormat;

// -------------------------------------------------------------------------
/**
 * The main class which will display the expected output and allow the user to
 * view different time period statistics.
 * 
 * @author jesse
 * @version Apr 19, 2024
 */
public class VisualizerWindow
{
    private Window window;

    private Button sortChanelNameButton;
    private Button sortEngagementRateButton;
    private Button quitButton;

    private Button tradEngagementButton;
    private Button reachEngagementButton;

    private Button[] monthButtons;
    private Button firstQuarterButton;

    // TODO: Figure out these numbers, current ones are placeholders.
    private static final int START_X = 0;
    private static final int START_Y = 0;
    private static final int BAR_WIDTH = 0;
    private static final int SORTING_TYPE_X = 0;
    private static final int SORTING_TYPE_Y = 0;
    // TODO: Not sure if these are changing or not.
    private int RATE_X = 0;
    private int RATE_Y = 0;
    private int MONTH_X = 0;
    private int MONTH_Y = 0;

    private Shape[] tradEngagementBars;
    private Shape[] reachEngagementBars;

    private static final DecimalFormat NUM_FORMATTER = new DecimalFormat("#.#");

    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public VisualizerWindow()
    {
        // TODO: Implement this constructor.
        return;
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateText()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateButtons()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void drawBars()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedSortByChannelName(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedSortByEngagementRate(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedSortTradEngagementRate(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedSortReachEngagementRate(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedMonth(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedQuarterButton(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateMonthText()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateUserText()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateRateText()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateSortingTypeText()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void exitVisualizerWindow()
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * Private method to easily format decimal numbers to strings in expected
     * format.
     */
    private String formatDecimal(double num)
    {
        return NUM_FORMATTER.format(num);
    }
}
