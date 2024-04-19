package prj5;
//-------------------------------------------------------------------------
/**
*  a new type of exception specific to the Month class which will throw an 
*  exception when the month isn't a valid month
* 
*  @author ryanmsul12
*  @version Apr 7, 2024
*/
public class MonthException
    extends Exception
{
    // ~ Constructors ..........................................................
    /**
     * Creates a unique exception that is thrown in scenarios where
     * a month is not valid.
     * 
     * @param exception
     *          the name of the exception being thrown
     */
    public MonthException(String exception) 
    {
        super(exception);
    }
}
