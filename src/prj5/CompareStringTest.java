package prj5;

// -------------------------------------------------------------------------
/**
 * * A test class for the CompareString helper class, tests all methods and
 * instructions possible in the class.
 * 
 * @author ddmat
 * @version Apr 18, 2024
 */
public class CompareStringTest
    extends student.TestCase
{

    private CompareString comparer;

    // ----------------------------------------------------------
    /**
     * Creates a comparer which is tested in the testCompare class.
     */
    public void setUp()
    {
        comparer = new CompareString();
    }


    // ----------------------------------------------------------
    /**
     * tests compare()
     */
    public void testCompare()
    {
        assertEquals(-1, comparer.compare("A", "B"));
        assertEquals(1, comparer.compare("B", "A"));
        assertEquals(0, comparer.compare("A", "A"));

    }
}
