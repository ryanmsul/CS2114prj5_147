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
    
    public void addMonthActivity(Month month) {
        monthActivity.add(month);
    }


    public String getUsername()
    {
        return this.username;
    }


    public String getChannelName()
    {
        return this.channelName;
    }


    public String getCountryName()
    {
        return this.countryName;
    }


    public String getPageTopic()
    {
        return this.pageTopic;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the engagement rate for a given specific month
     * @param month The month to be calculated
     * @return The traditional engagement calculation
     */
    public double getTraditionalEngagementRate(Month month)
    {
        double likes = month.getLikes();
        double followers = month.getFollowers();
        double comments = month.getComments();
        
        return ((comments + likes)/ followers) * 100;
        
        
    }


    // ----------------------------------------------------------
    /**
     * Gets traditional engagement rate for first quarter first 3 months)
     * @return The engagement rate calculation
     */
    public double getTraditionalEngagementRate()
    {
        int startIndex = 0;
        int endIndex = 2;
        
        double likes = 0;
        double followers = 0;
        double comments = 0;
        
        
        for(int i = startIndex; i<= endIndex; i++) {
            likes += monthActivity.get(i).getLikes();
            followers += monthActivity.get(i).getFollowers();
            comments += monthActivity.get(i).getComments();
            
        }
        
        return ((comments + likes)/ followers) * 100;
        
    }


    // ----------------------------------------------------------
    /**
     * Calculates the engagement rate for a given specific month
     * @param month The month to be calculated
     * @return The reach engagement calculation
     */
    public double getReachEngagementRate(Month month)
    {
        double likes = month.getLikes();
        double comments = month.getComments();
        double views = month.getViews();
        
        return  ( (comments + likes)/ views) * 100;
    }


    // ----------------------------------------------------------
    /**
     * calculates engagement rate for first quarter (first 3 months)
     * @return The reach engagement rate
     */
    public double getReachEngagementRate()
    {
        int startIndex = 0;
        int endIndex = 2;
        
        double likes = 0;
        double comments = 0;
        double views = 0;
        
        
        for(int i = startIndex; i<= endIndex; i++) {
            likes += monthActivity.get(i).getLikes();
            views += monthActivity.get(i).getViews();
            comments += monthActivity.get(i).getComments();
            
        }
        
        return  ( (comments + likes)/ views) * 100;
    }


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
