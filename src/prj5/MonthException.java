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
     * the constructor of the DailyMixDataException class
     * 
     * @param exception
     *          the name of the exception being thrown
     */
    public MonthException(String exception) 
    {
        super(exception);
    }
}
