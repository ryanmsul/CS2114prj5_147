package prj5;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author stark
 *  @version Apr 16, 2024
 */
public class MonthTest
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
        
    }        
}
