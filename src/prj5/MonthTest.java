package prj5;

// -------------------------------------------------------------------------
/**
 *  Tests the method within the Month class.
 * 
 *  @author Appiah Morgan(ajm7243)
 *  @version Apr 16, 2024
 */
public class MonthTest extends student.TestCase
{
    //~ Fields ................................................................
    private Month month;
    //~ Constructors ..........................................................

    //~Public  Methods ........................................................
    /**
     * Sets up initial conditions 
     */
    public void setUp()
    {
        month = new Month("January", 4, 5, 10, 20, 50);
    }
    
    /**
     * Tests that the equals method returns the expected output in
     * all the scenarios.
     */
    public void testEquals()
    {
        Month equivMonth = new Month("January", 4, 5, 10, 20, 50);
        Month differentMonthName = new Month("Noctober", 4, 5, 10, 20, 50);
        Object obj = new Object();
        Month nullMonth = null;
        //Checked against self - True
        assertTrue(month.equals(month));
        //Checked against equivalent object - True
        assertFalse(month.equals(equivMonth));
        //Checked against a null object - False
        assertFalse(month.equals(nullMonth));
        //Checked against a month with a different param value i.e month name -
        //False
        assertFalse(month.equals(differentMonthName));
    }        
}
