package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
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
        if(o1.getTraditionalEngagementRate()>o2.getTraditionalEngagementRate() ) {
            return 1;
        }
        else if(o1.getTraditionalEngagementRate()<o2.getTraditionalEngagementRate() ) {
            return -1;
        }
        return 0;
    }
}
