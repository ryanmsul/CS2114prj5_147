package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Extends comparator and adds a new overloaded method to implement, which
 * allows Month comparing in influencers. While it is generic, this will only be
 * used by Influencer.
 * 
 * @param <T>
 * @author jesse
 * @version Apr 23, 2024
 */
public interface CompareEngagement<T>
    extends Comparator<T>
{
    // ----------------------------------------------------------
    /**
     * Compares two objects, with a third parameter specifying the month.
     * 
     * @param o1
     *            Object 1
     * @param o2
     *            Object 2
     * @param month
     *            The month object
     * @return Returns an int based on whether o2 is > o1.
     */
    public int compare(T o1, T o2, String month);
}
