package prj5;

// -------------------------------------------------------------------------
/**
 * Tests the method within the Month class.
 * 
 * @author Appiah Morgan(ajm7243)
 * @version Apr 16, 2024
 */
public class MonthTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private Month month;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Sets up initial conditions
     */
    public void setUp()
    {
        month = new Month("January", 4, 5, 10, 20, 50);
    }


    /**
     * Tests that the equals method returns the expected output in all the
     * scenarios.
     */
    public void testEquals()
    {
        // Name, Likes, Posts, Followers, Comments, Views
        Month equivMonth = new Month("January", 4, 5, 10, 20, 50);
        Month differentMonthName = new Month("Noctober", 4, 5, 10, 20, 50);
        Month differentMonthLikes = new Month("January", 20, 5, 10, 20, 50);
        Month differentMonthPosts = new Month("January", 4, 20, 10, 20, 50);
        Month differentMonthFollowers = new Month("January", 4, 5, 15, 24, 50);
        Month differentMonthComments = new Month("January", 4, 5, 10, 25, 50);
        Month differentMonthViews = new Month("January", 4, 5, 10, 20, 5);
        Object obj = new Object();
        Month nullMonth = null;
        // Checked against self - True
        assertTrue(month.equals(month));
        // Checked against equivalent object - True
        assertTrue(month.equals(equivMonth));
        // Checked against a null object - False
        assertFalse(month.equals(nullMonth));
        // Checked against a month with a different param value i.e month name -
        // False
        assertFalse(month.equals(differentMonthName));
        // Checked against obj of a different class.
        assertFalse(month.equals(obj));
        // Checked against a month with a different param value(likes)- False
        assertFalse(month.equals(differentMonthLikes));
        // Checked against a month with a different param value(comments)- False
        assertFalse(month.equals(differentMonthComments));
        // Checked against a month with a different param value(posts)- False
        assertFalse(month.equals(differentMonthPosts));
        // Checked against a month with a different param value(views)- False
        assertFalse(month.equals(differentMonthViews));
        // Checked against a month with a different param value(followers)-
        // False
        assertFalse(month.equals(differentMonthFollowers));

    }
}
