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
    private Influencer iAZero;
    private Month month;
    private Month monthZero;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    public void setUp()
    {
        iA = new Influencer("A name", "A channel", "France", "Frogs");

        iA.addMonthActivity(new Month("January", 1, 1, 1, 1, 1));
        iA.addMonthActivity(new Month("February", 1, 1, 1, 1, 1));
        iA.addMonthActivity(new Month("March", 1, 1, 1, 1, 1));

        iB = new Influencer("B name", "B channel", "France", "Frogs");

        month = new Month("January", 2, 4, 6, 8, 10);
        
        iB.addMonthActivity(month);
        iB.addMonthActivity(new Month("February", 2, 4, 6, 8, 10));
        iB.addMonthActivity(new Month("March", 2, 4, 6, 8, 10));
        iB.addMonthActivity(new Month("April", 1, 200, 3, 45, 65));

        monthZero = new Month("March", 0, 0, 0, 0, 0);
        iAZero = new Influencer("A name", "A channel", "France", "Frogs");
        iAZero.addMonthActivity(new Month("January", 1, 1, 1, 1, 1));
        iAZero.addMonthActivity(new Month("February", 1, 1, 1, 1, 1));
        iAZero.addMonthActivity(monthZero);
    }

// ----------------------------------------------------------
    
    /**
     * test the getter methods of the influencer class
     */
    public void testGetters() 
    {
        assertEquals("A name", iA.getUsername());
        assertEquals("A channel", iA.getChannelName());
        assertEquals("France", iA.getCountryName());
        assertEquals("Frogs", iA.getPageTopic());
    }
    
    /**
     * test the getTraditionalEngagmentRate for the influencer class with a 
     * month parameter, should return the engagment rate of that month
     */
    public void testGetTraditionalEngagementRateParameter() 
    {
        assertEquals(((2.0 + 8.0) / 6) * 100.0, 
            iB.getTraditionalEngagementRate(month), 0.1);
        assertEquals(-1, 
            iAZero.getTraditionalEngagementRate(monthZero), 0.1);
    }
    /**
     * testGetTradititonalEngagementRate with no parameter
     */
   public void testGetTraditionalEngagementRate() {
    
    assertEquals(((3.0 + 3.0) / 1.0) * 100.0, 
        iA.getTraditionalEngagementRate(), 0.1);
    assertEquals(-1, 
        iAZero.getTraditionalEngagementRate(), 0.1);
    assertEquals(((24 + 6) / 6.0) * 100.0, 
        iB.getTraditionalEngagementRate(), 0.1);
    
    }
   
   /**
    * test the getReachEngagementRate with no parameter to see if it returns 
    * the correct reach engagment rate or returns -1 if there is no views
    */
   public void testGetReachEngagementRate() 
   {
       Influencer iAZero2 = new 
           Influencer("A name", "A channel", "France", "Frogs");
       
       iAZero2.addMonthActivity(monthZero);
       
       assertEquals(((3.0 + 3.0) / 3.0) * 100.0, 
           iA.getReachEngagementRate(), 0.1);
       assertEquals(-1, 
           iAZero2.getReachEngagementRate(), 0.1);
       assertEquals(((24 + 6) / 30.0) * 100.0, 
           iB.getReachEngagementRate(), 0.1);
   }
   
   /**
    * test the getReachEngagementRate with a month parameter to see if it 
    * returns the correct reach engagment rate or returns -1 if there is no 
    * views
    */
    public void testGetReachEngagementRateParameter() 
    {
        assertEquals(((2.0 + 8.0) / 10.0) * 100.0, 
            iB.getReachEngagementRate(month), 0.1);
        assertEquals(-1, 
            iAZero.getReachEngagementRate(monthZero), 0.1);
   }
    
    /**
     * test the equals method to see if two influencer objects are equal to each
     * other
     */
    public void testEquals() 
    {
        assertTrue(iA.equals(iA));
        
        assertFalse(iA.equals(null));
        
        Object notInfluencer = new Object();
        assertFalse(iA.equals(notInfluencer));
        
        assertFalse(iA.equals(iB));
        
        Influencer iADup = new 
            Influencer("A name", "A channel", "France", "Frogs");

        iADup.addMonthActivity(new Month("January", 1, 1, 1, 1, 1));
        iADup.addMonthActivity(new Month("February", 1, 1, 1, 1, 1));
        iADup.addMonthActivity(new Month("March", 1, 1, 1, 1, 1));
        
        assertTrue(iA.equals(iADup));
        
        Influencer iADiffChannelName = new 
            Influencer("A name", "A diffChannel", "France", "Frogs");
        
        assertFalse(iA.equals(iADiffChannelName));
        
        Influencer iADiffPageTopic = new 
            Influencer("A name", "A channel", "France", "Bears");
        
        assertFalse(iA.equals(iADiffPageTopic));
    }
}
