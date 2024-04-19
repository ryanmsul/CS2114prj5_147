package prj5;

// -------------------------------------------------------------------------
/**
 * A test class for the Influencer class, tests all methods and instructions
 * possible in the class.
 * 
 * @author ddmat
 * @version Apr 18, 2024
 */
public class InfluencerTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private Influencer iA;
    private Influencer iB;
    private Influencer iADup;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    public void setUp()
    {
        iA = new Influencer("A name", "A channel", "France", "Frogs");

        iA.addMonthActivity(new Month("January", 1, 1, 1, 1, 1));
        iA.addMonthActivity(new Month("February", 1, 1, 1, 1, 1));
        iA.addMonthActivity(new Month("March", 1, 1, 1, 1, 1));

        iB = new Influencer("B name", "B channel", "France", "Frogs");

        iB.addMonthActivity(new Month("January", 2, 4, 6, 8, 10));
        iB.addMonthActivity(new Month("February", 2, 4, 6, 8, 10));
        iB.addMonthActivity(new Month("March", 2, 4, 6, 8, 10));
        iB.addMonthActivity(new Month("April", 1, 200, 3, 45, 65));

        iADup = new Influencer("A name", "A channel", "France", "Frogs");
        iADup.addMonthActivity(new Month("January", 1, 1, 1, 1, 1));
        iADup.addMonthActivity(new Month("February", 1, 1, 1, 1, 1));
        iADup.addMonthActivity(new Month("March", 1, 1, 1, 1, 1));
    }


// ----------------------------------------------------------

/**
 * testGetTradititonalEngagementRate for first quarter
 */
public void testGetTraditionalEngagementRate() {
    
    assertEquals(((3.0+3.0)/1.0)*100, iA.getTraditionalEngagementRate(),0.1);
    assertEquals(((24+6)/6.0)*100.0, iB.getTraditionalEngagementRate(),0.1);
    

}

}
