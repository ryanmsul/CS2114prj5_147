package prj5;

// -------------------------------------------------------------------------
/**
 * This is a helper class which implements the Comprator object to sort
 * Influencers by ReachEngagement.
 * 
 * @author jesse
 * @version Apr 16, 2024
 */
public class CompareReachEngagement
    implements CompareEngagement<Influencer>
{

    @Override
    public int compare(Influencer o1, Influencer o2)
    {
        if (o1.getReachEngagementRate() > o2.getReachEngagementRate())
        {
            return 1;
        }
        else if (o1.getReachEngagementRate() < o2.getReachEngagementRate())
        {
            return -1;
        }
        return 0;

    }


    // needs testing
    @Override
    public int compare(Influencer o1, Influencer o2, String month)
    {
        if (o1.getReachEngagementRate(month) > o2.getReachEngagementRate(month))
        {
            return 1;
        }
        else if (o1.getReachEngagementRate(month) < o2
            .getReachEngagementRate(month))
        {
            return -1;
        }
        return 0;
    }
}
