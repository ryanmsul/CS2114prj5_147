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
public class CompareReachEngagementTest extends student.TestCase
{
    //~ Fields ................................................................

    private Influencer iA;
    private Influencer iB;
    private Influencer iADup;
    private CompareReachEngagement comparer;
    
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    public void setUp() {
        iA = new Influencer("A name",
        "A channel",
        "France",
        "Frogs");
        
        iA.addMonthActivity(new Month("January", 1, 1, 1,1,1));
        iA.addMonthActivity(new Month("February", 1, 1, 1,1,1));
        iA.addMonthActivity(new Month("March", 1, 1, 1,1,1));
        
        iB = new Influencer("B name",
            "B channel",
            "France",
            "Frogs");
        
        iB.addMonthActivity(new Month("January", 2, 4, 6,8,10));
        iB.addMonthActivity(new Month("February", 2, 4, 6,8,10));
        iB.addMonthActivity(new Month("March", 2, 4, 6,8,10));
        
        
         iADup = new Influencer("A name",
             "A channel",
             "France",
             "Frogs");
         iADup.addMonthActivity(new Month("January", 1, 1, 1,1,1));
         iADup.addMonthActivity(new Month("February", 1, 1, 1,1,1));
         iADup.addMonthActivity(new Month("March", 1, 1, 1,1,1));
        
        comparer = new CompareReachEngagement();
        
    }
    
    // ----------------------------------------------------------
    /**
     * tests comparing channel names
     */
    public void testCompareReachEngagement() {
        
        assertEquals(1,comparer.compare(iA,iB));
        assertEquals(-1,comparer.compare(iB,iA));
        assertEquals(0,comparer.compare(iA,iADup));
        
        
    }
}
