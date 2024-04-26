package prj5;

// -------------------------------------------------------------------------
/**
 * A test class for the CompareReachEngagement helper class, tests all methods
 * and instructions possible in the class.
 * 
 * @author David Mathews (davidm05)
 * @version Apr 18, 2024
 */
public class CompareReachEngagementTest
    extends student.TestCase
{
    private Influencer iA;
    private Influencer iB;
    private Influencer iADup;
    private CompareReachEngagement comparer;

    // ----------------------------------------------------------
    /**
     * Creates some influencers which are used to test the
     * CompareReachEngagement.
     * 
     * @throws MonthException
     */
    public void setUp()
        throws MonthException
    {
        iA = new Influencer("A name", "A channel", "France", "Frogs");

        iA.addMonthActivity(new Month("January", 1, 1, 1, 1, 1));
        iA.addMonthActivity(new Month("February", 1, 1, 1, 1, 1));
        iA.addMonthActivity(new Month("March", 1, 1, 1, 1, 1));

        iB = new Influencer("B name", "B channel", "France", "Frogs");

        iB.addMonthActivity(new Month("January", 2, 4, 6, 8, 10));
        iB.addMonthActivity(new Month("February", 2, 4, 6, 8, 10));
        iB.addMonthActivity(new Month("March", 2, 4, 6, 8, 10));

        iADup = new Influencer("A name", "A channel", "France", "Frogs");
        iADup.addMonthActivity(new Month("January", 1, 1, 1, 1, 1));
        iADup.addMonthActivity(new Month("February", 1, 1, 1, 1, 1));
        iADup.addMonthActivity(new Month("March", 1, 1, 1, 1, 1));

        comparer = new CompareReachEngagement();

    }


    // ----------------------------------------------------------
    /**
     * tests comparing reach engagement for first quarter
     */
    public void testCompareReachEngagement()
    {

        assertEquals(1, comparer.compare(iA, iB));
        assertEquals(-1, comparer.compare(iB, iA));
        assertEquals(0, comparer.compare(iA, iADup));

    }


    /**
     * tests comparing reach engagement for single month
     */
    public void testCompareReachEngagementMonth()
    {

        assertEquals(1, comparer.compare(iA, iB, "March"));
        assertEquals(-1, comparer.compare(iB, iA, "February"));
        assertEquals(0, comparer.compare(iA, iADup, "January"));

    }
}
