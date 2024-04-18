package prj5;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
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
        iB.addMonthActivity(new Month("April", 2, 4, 6, 8, 10));

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
    
    assertEquals(((3.0+3.0)/3.0)*100, iA.getTraditionalEngagementRate(),0.1);
    assertEquals(((32+8)/24.0)*100., iB.getTraditionalEngagementRate(),0.1);
    
    
   
    
    
}
}
