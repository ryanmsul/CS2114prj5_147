package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This is a helper class which implements the Comprator object to sort
 * Influencers by Traditional Engagement Rate.
 * 
 * @author jesse
 * @version Apr 16, 2024
 */
public class CompareTradEngagement
    implements Comparator<Influencer>
{
    @Override
    public int compare(Influencer o1, Influencer o2)
    {
        if (o1.getTraditionalEngagementRate() > o2
            .getTraditionalEngagementRate())
        {
            return 1;
        }
        else if (o1.getTraditionalEngagementRate() < o2
            .getTraditionalEngagementRate())
        {
            return -1;
        }
        return 0;
    }
}
