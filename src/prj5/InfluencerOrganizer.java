package prj5;

import java.util.Collections;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author jesse
 * @version Apr 16, 2024
 */
public class InfluencerOrganizer
{
    private SinglyLinkedList<Influencer> influencers;

    public InfluencerOrganizer(SinglyLinkedList<Influencer> influencers)
    {
        this.influencers = influencers;
    }


    public void sortByName()
    {
        Collections.sort(influencers, new CompareChannelName());
    }


    public void sortByTradEngagement()
    {
        Collections.sort(influencers, new CompareTradEngagement());
    }


    public void sortByReachEngagement()
    {
        Collections.sort(influencers, new CompareReachEngagement());
    }
}
