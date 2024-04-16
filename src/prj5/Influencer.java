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
    // TODO: implement Month class before deciding what to do with this?
    // private SinglyLinkedList<Month> month;
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


    public double getTraditionalEngagementRate(Month month)
    {
        // TODO: Implement with Month class
        return -1;
    }


    public double getTraditionalEngagementRate(Month startMonth, Month endMonth)
    {
        // TODO: Implement with Month class
        return -1;
    }


    public double getReachEngagementRate(Month month)
    {
        // TODO: Implement with Month class
        return -1;
    }


    public double getReachEngagementRate(Month startMonth, Month endMonth)
    {
        // TODO: Implement with Month class
        return -1;
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
