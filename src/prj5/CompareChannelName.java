package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This is a helper class which implements the Comprator object to sort
 * Influencers by ChannelName.
 * 
 * @author jesse
 * @version Apr 16, 2024
 */
public class CompareChannelName
    implements Comparator<Influencer>
{

    @Override
    public int compare(Influencer o1, Influencer o2)
    {
        return o1.getUsername().toUpperCase()
            .compareTo(o2.getUsername().toUpperCase());
    }
}
