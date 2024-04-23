package prj5;

import cs2.*;
import java.awt.Color;
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

    private Button janButton;
    private Button febButton;
    private Button marButton;
    private Button firstQuarterButton;

    // Strings that hold values for top left text display,
    // updated when new buttons are clicked
    private String period = "First Quarter (Jan-March)"; // Initial values
    private String engagementType = "Traditional Engagement Rate" ;
    private String sortType = "Sorting by Channel Name";

    // TODO: Figure out these numbers, current ones are placeholders.
    private static final int START_X = 0;
    private static final int START_Y = 0;
    private static final int BAR_WIDTH = 0;
    
    
    //These vars are good
    private static final int TEXT_X = 20;
    private static final int TEXT_Y = 20;
    
  

    private Shape[] tradEngagementBars;
    private Shape[] reachEngagementBars;

    private static final DecimalFormat NUM_FORMATTER = new DecimalFormat("#.#");

    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public VisualizerWindow()
    {
        // create window
        window = new Window("Social Media Visualizer");

        // add buttons
        tradEngagementButton = new Button("Traditional Engagement Rate");
        window.addButton(tradEngagementButton, WindowSide.WEST);
        tradEngagementButton.onClick(this, "clickedSortTradEngagement");

        reachEngagementButton = new Button("Reach Engagement Rate");
        window.addButton(reachEngagementButton, WindowSide.WEST);
        reachEngagementButton.onClick(this, "clickedSortReachEngagement");

        sortChanelNameButton = new Button("Sort by Channel Name");
        window.addButton(sortChanelNameButton, WindowSide.NORTH);
        sortChanelNameButton.onClick(this, "clickedSortChannelName");

        sortEngagementRateButton = new Button("Sort by Engagement Rate");
        window.addButton(sortEngagementRateButton, WindowSide.NORTH);
        sortEngagementRateButton.onClick(this, "clickedSortByEngagementRate");

        quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.NORTH);
        quitButton.onClick(this, "clickedQuit");

        janButton = new Button("January");
        window.addButton(janButton, WindowSide.SOUTH);
        janButton.onClick(this, "clickedJanuary");

        febButton = new Button("February");
        window.addButton(febButton, WindowSide.SOUTH);
        febButton.onClick(this, "clickedFebruary");

        marButton = new Button("March");
        window.addButton(marButton, WindowSide.SOUTH);
        marButton.onClick(this, "clickedMarch");

        firstQuarterButton = new Button("First Quarter (Jan-March)");
        window.addButton(firstQuarterButton, WindowSide.SOUTH);
        firstQuarterButton.onClick(this, "clickedQuarterButton");

        updateText();
        
        return;
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateText()
    {
        TextShape periodText = addTextShape(period, TEXT_X, TEXT_Y);
        TextShape engagementTypeText = addTextShape(engagementType, TEXT_X, TEXT_Y+15);
        TextShape sortTypeText = addTextShape(sortType, TEXT_X, TEXT_Y+30);
    }
    
    /**
     * Helper method to add a TextShape to the window 
     */
    private TextShape addTextShape(String message, int x, int y)
    {
        if (message != null)
        {
            TextShape s = new TextShape(x, y, message, Color.black);
            s.setBackgroundColor(Color.white);
            window.addShape(s);
            return s;
        }
        return null;
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
    public void clickedQuit(Button button)
    {
        System.exit(0);
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
    public void clickedJanuary(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedFebruary(Button button)
    {
        // TODO: Implement this method.
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void clickedMarch(Button button)
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
