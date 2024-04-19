package prj5;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author ddmat
 *  @version Apr 18, 2024
 */
public class CompareStringTest extends student.TestCase
{
    
    //~ Fields ................................................................
    /**
     * comparer object for testing
     */
    CompareString comparer;
    
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

    public void setUp() {
        comparer = new CompareString();
    }
    
    // ----------------------------------------------------------
    /**
     * tests compare()
     */
    public void testCompare() {
        assertEquals(-1,comparer.compare("A","B"));
        assertEquals(1,comparer.compare("B","A"));
        assertEquals(0,comparer.compare("A","A"));
        
        
    }
}
