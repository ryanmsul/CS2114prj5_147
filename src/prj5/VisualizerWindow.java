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
    private SinglyLinkedList<Influencer> input;

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
    private String period; // Initial values
    private String engagementType;
    private String sortType;

    // TODO: Figure out these numbers, current ones are placeholders.
    private static final int START_X = 300;
    private static final int START_Y = 600;
    private static final int BAR_WIDTH = 20;

    // These vars are good
    private static final int TEXT_X = 20;
    private static final int TEXT_Y = 20;
    
    private static final Color[] COLORS = {Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN};

    // we do not need textshape list
    private TextShape[] textShapes;

    
    // Do not need these
    private Shape[] tradEngagementBars;
    private Shape[] reachEngagementBars;

    private static final DecimalFormat NUM_FORMATTER = new DecimalFormat("#.#");

    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public VisualizerWindow(SinglyLinkedList<Influencer> input)
    {
        period = "First Quarter (Jan-March)";
        engagementType = "Traditional Engagement Rate";
        sortType = "Sorting by Channel Name";
        
        // create window
        window = new Window("Social Media Visualizer");
        this.input = input;
        this.input.insertionSort(new CompareChannelName());

        // add buttons
        tradEngagementButton = new Button("Traditional Engagement Rate");
        window.addButton(tradEngagementButton, WindowSide.WEST);
        tradEngagementButton.onClick(this, "clickedSortTradEngagementRate");

        reachEngagementButton = new Button("Reach Engagement Rate");
        window.addButton(reachEngagementButton, WindowSide.WEST);
        reachEngagementButton.onClick(this, "clickedSortReachEngagementRate");

        sortChanelNameButton = new Button("Sort by Channel Name");
        window.addButton(sortChanelNameButton, WindowSide.NORTH);
        sortChanelNameButton.onClick(this, "clickedSortByChannelName");

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

        textShapes = new TextShape[3];

        updateText();
        drawBars();

        return;
    }


    // ----------------------------------------------------------
    /**
     * TODO: Add summary
     */
    public void updateText()
    {
        // The textShapes array will have the periodText, engageTypeText, and
        // sortType text in the indexes 0,1,2.
        if (textShapes[0] == null)
        {
            TextShape periodText = addTextShape(period, TEXT_X, TEXT_Y, 0);
            TextShape engagementTypeText =
                addTextShape(engagementType, TEXT_X, TEXT_Y + 15, 1);
            TextShape sortTypeText =
                addTextShape(sortType, TEXT_X, TEXT_Y + 30, 2);
        }
        else
        {
            textShapes[0].setText(period);
            textShapes[1].setText(engagementType);
            textShapes[2].setText(sortType);
        }
    }


    /**
     * Helper method to add a TextShape to the window overloaded to add
     * textShapes to text shape array
     */
    private TextShape addTextShape(String message, int x, int y, int shapeIndex)
    {
        if (message != null)
        {
            TextShape s = new TextShape(x, y, message, Color.black);
            s.setBackgroundColor(Color.white);
            window.addShape(s);

            textShapes[shapeIndex] = s;

            return s;
        }
        return null;
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
    public void drawBars()
    {
        window.removeAllShapes();
        
        int shapeX = START_X;
        int shapeY = START_Y;
        int height = 0;
        int max = 0;
        if (engagementType.equals("Traditional Engagement Rate")) // sortType should not matter, list is already sorted
        {                                               // the bars should only depend on engagment rate vals.
            max = input.get(1).getChannelName().length();
            int heightMax = (input.get(1).getChannelName().length() / max) * 75;
            for (int i = 0; i < input.size(); i++)
            {
                
                
                //This needs to be fixed, not drawing bars correctly
                shapeY = START_Y;
                height = (input.get(i).getChannelName().length() / max) * 75;
                shapeY += heightMax - height;
                //only draws height for first quarter, needs to account for each month. 
                
                //Bars must have common ratio
                
                

                // draw bar text

                int nameY = shapeY + height + 35;
                int dataY = shapeY + height + 60;
                int textX = shapeX;
                double data;
                String name = input.get(i).getUsername();
                String dataText;
                Shape newShape;
                
                if (period.equals("First Quarter (Jan-March)"))
                {
                    data = input.get(i).getTraditionalEngagementRate();
                    newShape =
                        new Shape(shapeX, shapeY, BAR_WIDTH, (int)data, COLORS[i]);
                }
                else 
                {
                    data = input.get(i).getTraditionalEngagementRate(period);
                    newShape =
                        new Shape(shapeX, shapeY, BAR_WIDTH, (int)data, COLORS[i]);
                }
                
                //add bar
                window.addShape(newShape);
                
                // add name
                addTextShape(name, textX, nameY);

                //add data
                
                if(data<0) {
                    dataText = "N/A";
                }
                else {
                    dataText = formatDecimal(data);
                }
                
                addTextShape(dataText, textX, dataY);
                
                
                //move next bar to right
                shapeX += 200;
            }
        }
            
            else // sortType should not matter, list is already sorted
            {                                               // the bars should only depend on engagment rate vals.
                max = input.get(1).getChannelName().length();
                int heightMax = (input.get(1).getChannelName().length() / max) * 75;
                for (int i = 0; i < input.size(); i++)
                {
                    shapeY = START_Y;
                    height = (input.get(i).getChannelName().length() / max) * 75;
                    shapeY += heightMax - height;
                    
                    
                    
                    
                    

                    // draw bar text

                    int nameY = shapeY + height + 30;
                    int dataY = shapeY + height + 55;
                    int textX = shapeX;
                    double data;
                    String name = input.get(i).getUsername();
                    String dataText;
                    Shape newShape;
                    if (period.equals("First Quarter (Jan-March)"))
                    {
                        data = input.get(i).getReachEngagementRate();
                        newShape =
                            new Shape(shapeX, shapeY, BAR_WIDTH, (int)data, COLORS[i]); //implement color array to change colors
                        window.addShape(newShape);
                    }
                    else 
                    {
                        data = input.get(i).getReachEngagementRate(period);
                        newShape =
                            new Shape(shapeX, shapeY, BAR_WIDTH, (int)data, COLORS[i]); //implement color array to change colors
                        window.addShape(newShape);
                    }
                    
                    
                    // add name
                    addTextShape(name, textX, nameY);

                    //add data
                    
                    if(data<0) {
                        dataText = "N/A";
                    }
                    else {
                        dataText = formatDecimal(data);
                    }
                    
                    addTextShape(dataText, textX, dataY);
                    
                    
                    //move next bar to right
                    shapeX += 200;
                }
        }
    }
    
    


    // ----------------------------------------------------------
    /**
     * Closes the Visualization Window.
     * 
     * @param button
     *            references the quitButton object which handles the function.
     */
    public void clickedQuit(Button button)
    {
        System.exit(0);
    }


    // ----------------------------------------------------------
    /**
     * Updates the graph to reflect the data being sorted in order by the
     * channel name order (A -> B -> C, etc)
     * 
     * @param button
     *            The button being referenced
     */
    public void clickedSortByChannelName(Button button)
    {
        if (!sortType.equals("Sorting by Channel Name"))
        {
            sortType = "Sorting by Channel Name";
            updateText();

            sortInfluencers();
            drawBars();
        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the graph to reflect the data being sorted in descending order by
     * the engagement rates.
     * 
     * @param button
     *            The button being referenced
     */
    public void clickedSortByEngagementRate(Button button)
    {
        if (!sortType.equals("Sorting by Engagement Rate"))
        {
            sortType = "Sorting by Engagement Rate";
            updateText();

            sortInfluencers();
            drawBars();

        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the graph to reflect the data being sorted via the traditional
     * engagement formula.
     * 
     * @param button
     *            The button being referenced that executes the traditional
     *            engagement function
     */
    public void clickedSortTradEngagementRate(Button button)
    {
        if (!engagementType.equals("Traditional Engagement Rate"))
        {
            engagementType = "Traditional Engagement Rate";
            updateText();

            sortInfluencers();
            drawBars();

        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the graph to reflect the data being sorted via the reach
     * engagement formula.
     * 
     * @param button
     *            The button being referenced that executes the reach engagement
     *            update function.
     */
    public void clickedSortReachEngagementRate(Button button)
    {
        if (!engagementType.equals("Reach Engagement Rate"))
        {
            engagementType = "Reach Engagement Rate";
            updateText();

            sortInfluencers();
            drawBars();
        }
    }


    // ----------------------------------------------------------
    /**
     * Helper method that sorts influencers whenever a button that changes the
     * order is called.
     */
    
    //does not account for individual month sorting
    private void sortInfluencers()
    {
        if (sortType.equals("Sorting by Channel Name"))
        {
            input.insertionSort(new CompareChannelName());
        }
        else
        {
            if (engagementType.equals("Traditional Engagement Rate"))
            {
                if(period.equals("First Quarter (Jan-March)"))
                    input.insertionSort(new CompareTradEngagement());   
                else
                    input.insertionSort(new CompareTradEngagement(),period);
            }
            else
            {
                if(period.equals("First Quarter (Jan-March)"))
                    input.insertionSort(new CompareReachEngagement());   
                else
                    input.insertionSort(new CompareReachEngagement(),period);
                
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the period field to reference the month of January and updates
     * the graph to display the engagement data of all influencers for the
     * month.
     * 
     * @param button
     *            the button being referenced by the click function.
     */
    public void clickedJanuary(Button button)
    {
        if (!period.equals("January"))
        {
            period = "January";
            updateText();
            
            sortInfluencers();
            drawBars();
        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the period field to reference the month of February and updates
     * the graph to display the engagement data of all influencers for the
     * month.
     * 
     * @param button
     *            the button being referenced by the click function.
     */
    public void clickedFebruary(Button button)
    {
        if (!period.equals("February"))
        {
            period = "February";
            updateText();
            sortInfluencers();
            drawBars();
        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the period field to reference the month of March and updates the
     * graph to display the engagement data of all influencers for the month.
     * 
     * @param button
     *            the button being referenced by the click function.
     */
    public void clickedMarch(Button button)
    {
        if (!period.equals("March"))
        {
            period = "March";
            updateText();
            sortInfluencers();
            drawBars();
        }
    }


    // ----------------------------------------------------------
    /**
     * Updates the period field to reference the full first quarter of the year
     * and updates the graph to display the engagement data of all influencers
     * for that quarter.
     * 
     * @param button
     *            the button being referenced by the click function.
     */
    public void clickedQuarterButton(Button button)
    {
        if (!period.equals("First Quarter (Jan-March)"))
        {
            period = "First Quarter (Jan-March)";
            updateText();
            sortInfluencers();
            drawBars();
        }
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
