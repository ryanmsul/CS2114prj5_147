package prj5;

// -------------------------------------------------------------------------
/**
 * The influencer class represents the influencer itself which will hold the
 * channels name and the views and likes each influencer has for each month
 * 
 * @author jesse
 * @version Apr 16, 2024
 */
public class Influencer
{
    private SinglyLinkedList<Month> monthActivity;
    private String username;
    private String channelName;
    private String countryName;
    private String pageTopic;

    // ----------------------------------------------------------
    /**
     * Creates a new Influencer object with instance variable parameters
     * 
     * @param username
     *            The username of the influencer.
     * @param channelName
     *            The channelName of the influencer.
     * @param countryName
     *            The countryName of the influencer.
     * @param pageTopic
     *            the pageTopic of the influencer.
     */
    public Influencer(
        String username,
        String channelName,
        String countryName,
        String pageTopic)
    {
        this.username = username;
        this.channelName = channelName;
        this.countryName = countryName;
        this.pageTopic = pageTopic;
        this.monthActivity = new SinglyLinkedList<Month>();
    }


    // ----------------------------------------------------------
    /**
     * This method stores a Month object to a SLL, so an influencer's statistics
     * can be calculated.
     * 
     * @param month
     *            The month's activity to be added.
     */
    public void addMonthActivity(Month month)
    {
        monthActivity.add(month);
    }


    // ----------------------------------------------------------
    /**
     * Getter for the Influencer's username
     * 
     * @return The influencer's username.
     */
    public String getUsername()
    {
        return this.username;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the Influencer's channelName
     * 
     * @return The influencer's channelName.
     */
    public String getChannelName()
    {
        return this.channelName;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the Influencer's countryName
     * 
     * @return The influencer's countryName.
     */
    public String getCountryName()
    {
        return this.countryName;
    }


    // ----------------------------------------------------------
    /**
     * Getter for the Influencer's pageTopic
     * 
     * @return The influencer's pageTopic
     */
    public String getPageTopic()
    {
        return this.pageTopic;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the engagement rate for a given specific month
     * 
     * @param month
     *            The month to be calculated
     * @return The traditional engagement calculation
     */
    public double getTraditionalEngagementRate(String month)
    {
        double likes = 0;
        double followers = 0;
        double comments = 0;

        for (int i = 0; i < monthActivity.size(); i++)
        {

            String curMonth = monthActivity.get(i).getMonth().toUpperCase();
            if (curMonth.equals(month.toUpperCase()))

            {

                followers += monthActivity.get(i).getFollowers();
                likes += monthActivity.get(i).getLikes();
                comments += monthActivity.get(i).getComments();
            }
        }

        if (followers == 0)
        {
            return -1;
        }

        return ((comments + likes) / followers) * 100;

    }


    // ----------------------------------------------------------
    /**
     * Gets traditional engagement rate for first quarter first 3 months)
     * 
     * @return The engagement rate calculation
     */
    public double getTraditionalEngagementRate()
    {

        double likes = 0;
        double followers = 0;
        double comments = 0;

        for (int i = 0; i < monthActivity.size(); i++)
        {

            String curMonth = monthActivity.get(i).getMonth().toUpperCase();
            if (curMonth.equals("JANUARY") || curMonth.equals("FEBRUARY")
                || curMonth.equals("MARCH"))
            {

                likes += monthActivity.get(i).getLikes();
                comments += monthActivity.get(i).getComments();
            }
        }

        for (int i = 0; i < monthActivity.size(); i++)
        {

            String curMonth = monthActivity.get(i).getMonth().toUpperCase();
            if (curMonth.equals("MARCH"))
            {

                followers = monthActivity.get(i).getFollowers();
            }
        }

        if (followers == 0)
        {
            return -1;
        }

        return ((comments + likes) / followers) * 100;

    }


    // ----------------------------------------------------------
    /**
     * Calculates the engagement rate for a given specific month
     * 
     * @param month
     *            The month to be calculated
     * @return The reach engagement calculation
     */
    public double getReachEngagementRate(String month)
    {
        double likes = 0;
        double comments = 0;
        double views = 0;

        for (int i = 0; i < monthActivity.size(); i++)
        {

            String curMonth = monthActivity.get(i).getMonth().toUpperCase();
            if (curMonth.equals(month.toUpperCase()))

            {

                likes += monthActivity.get(i).getLikes();
                views += monthActivity.get(i).getViews();
                comments += monthActivity.get(i).getComments();
            }
        }

        if (views == 0)
        {
            return -1;
        }

        return ((comments + likes) / views) * 100;
    }


    // ----------------------------------------------------------
    /**
     * calculates engagement rate for first quarter (first 3 months)
     * 
     * @return The reach engagement rate
     */
    public double getReachEngagementRate()
    {
        double likes = 0;
        double comments = 0;
        double views = 0;

        for (int i = 0; i < monthActivity.size(); i++)
        {

            String curMonth = monthActivity.get(i).getMonth().toUpperCase();
            if (curMonth.equals("JANUARY") || curMonth.equals("FEBRUARY")
                || curMonth.equals("MARCH"))
            {

                likes += monthActivity.get(i).getLikes();
                views += monthActivity.get(i).getViews();
                comments += monthActivity.get(i).getComments();
            }
        }

        if (views == 0)
        {
            return -1;
        }

        return ((comments + likes) / views) * 100;
    }


    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass().equals(obj.getClass()))
        {
            Influencer casted = (Influencer)obj;

            if (!this.getUsername().equals(casted.getUsername()))
            {
                return false;
            }

            if (!this.getChannelName().equals(casted.getChannelName()))
            {
                return false;
            }

            return this.getPageTopic().equals(casted.getPageTopic());

            // Note: equals method DOES not check engagement rates (i think
            // doing this is unnecessary? could be wrong)
        }
        return false;
    }
}
