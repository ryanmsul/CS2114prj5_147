package prj5;

// -------------------------------------------------------------------------
/**
 * A test class for the MonthException.
 * 
 * @author David Mathews (davidm05)
 * @version Apr 18, 2024
 */
public class MonthExceptionTest
    extends student.TestCase
{

    // ~ Fields ................................................................
    /**
     * influencer for testing
     */
    private Influencer i;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * runs before test method
     */
    public void setUp()
    {
        i = new Influencer("UserName", "Channelname", "Serbia", "Ibogaine");

    }


    // ----------------------------------------------------------
    /**
     * Test month exception
     */
    public void testMonthException()
    {

        Exception thrown = null;

        try
        {
            i.addMonthActivity(new Month("Movember", 1, 2, 3, 4, 5));
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertNotNull(thrown);

        assertTrue(thrown instanceof MonthException);

    }
}
