package prj5;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author ddmat
 *  @version Apr 17, 2024
 */
public class CompareChannelNameTest extends student.TestCase
{
    //~ Fields ................................................................

    private Influencer iA;
    private Influencer iB;
    private Influencer iADup;
    private CompareChannelName comparer;
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public void setUp() {
        iA = new Influencer("A name",
        "A channel",
        "France",
        "Frogs");
        
        iB = new Influencer("B name",
            "B channel",
            "France",
            "Frogs");
        
         iADup = new Influencer("A name",
             "A channel",
             "France",
             "Frogs");
        
        comparer = new CompareChannelName();
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests comparing channel names
     */
    public void testCompareChannelName() {
        
        assertEquals(-1,comparer.compare(iA,iB));
        assertEquals(1,comparer.compare(iB,iA));
        assertEquals(0,comparer.compare(iA,iADup));
        
        
    }
    
    
}