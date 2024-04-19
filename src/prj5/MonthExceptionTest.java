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
public class MonthExceptionTest extends student.TestCase
{
   
    //~ Fields ................................................................
    /**
     * influencer for testing
     */
    Influencer i;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................

    public void setUp() {
        i = new Influencer("UserName","Channelname", "Serbia", "Ibogaine");
        
    }
    
    // ----------------------------------------------------------
    /**
     * Test month exception 
     */
    public void testMonthException() {
        
        Exception thrown = null;
        
        try {
            i.addMonthActivity(new Month("not real month",1,2,3,4,5));
        }
        catch(Exception e) {
            thrown = e;
        }
        
        assertNotNull(thrown);
        
        assertTrue(thrown instanceof MonthException);
        
        
    }
}
