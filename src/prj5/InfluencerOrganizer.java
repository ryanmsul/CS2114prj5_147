package prj5;

import java.util.Collections;

// -------------------------------------------------------------------------
/**
 * This is a wrapper class that allows easy sorting of our influencers.
 * 
 * @author jesse
 * @version Apr 16, 2024
 */
public class InfluencerOrganizer
{
    private SinglyLinkedList<Influencer> influencers;

    // ----------------------------------------------------------
    /**
     * Constructor for InfluencerOrganizer object, takes an SLL parameter.
     * 
     * @param influencers
     *            The SLL of influencers which is sorted using this class.
     */
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
