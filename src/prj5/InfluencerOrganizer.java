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


    
    
    // ----------------------------------------------------------
    /**
     * Sorts the influencer list by channel name
     */
    public void sortByName()
    {
        influencers.insertionSort(new CompareChannelName());
    }


    // ----------------------------------------------------------
    /**
     * Sorts the influencer list by traditional engagement rate
     */
    public void sortByTradEngagement()
    {
        influencers.insertionSort(new CompareTradEngagement());
    }


    // ----------------------------------------------------------
    /**
     * Sorts the influencer list by reach engagement rate
     */
    public void sortByReachEngagement()
    {
        influencers.insertionSort(new CompareReachEngagement());
    }
    
    
}
