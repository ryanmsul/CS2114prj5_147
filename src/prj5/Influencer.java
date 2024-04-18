package prj5;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
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
    public double getTraditionalEngagementRate(Month month)
    {
        double likes = month.getLikes();
        double followers = month.getFollowers();
        double comments = month.getComments();

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
                followers += monthActivity.get(i).getFollowers();
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
     * Calculates the engagement rate for a given specific month
     * 
     * @param month
     *            The month to be calculated
     * @return The reach engagement calculation
     */
    public double getReachEngagementRate(Month month)
    {
        double likes = month.getLikes();
        double comments = month.getComments();
        double views = month.getViews();

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

            if (!this.getPageTopic().equals(casted.getPageTopic()))
            {
                return false;
            }

            // Note: equals method DOES not check engagement rates (i think
            // doing this is unnecessary? could be wrong)

            return true;
        }
        return false;
    }
}
