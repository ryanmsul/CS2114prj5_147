package prj5;

// -------------------------------------------------------------------------
/**
 * A test class for the CompareChannelName helper class, tests all methods and
 * instructions possible in the class.
 * 
 * @author ddmat
 * @version Apr 17, 2024
 */
public class CompareChannelNameTest
    extends student.TestCase
{
    private Influencer iA;
    private Influencer iB;
    private Influencer iADup;
    private CompareChannelName comparer;

    // ----------------------------------------------------------
    /**
     * Creates some influencers which are used to test the CompareChannelName.
     */
    public void setUp()
    {
        iA = new Influencer("A name", "A channel", "France", "Frogs");

        iB = new Influencer("B name", "B channel", "France", "Frogs");

        iADup = new Influencer("A name", "A channel", "France", "Frogs");

        comparer = new CompareChannelName();

    }


    // ----------------------------------------------------------
    /**
     * tests comparing channel names
     */
    public void testCompareChannelName()
    {
        assertEquals(-1, comparer.compare(iA, iB));
        assertEquals(1, comparer.compare(iB, iA));
        assertEquals(0, comparer.compare(iA, iADup));

    }

}
