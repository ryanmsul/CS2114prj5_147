package prj5;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Appiah Morgan(ajm7243)
 * @version Apr 16, 2024
 */
public class Month
{
    // ~ Fields ................................................................
    private String month;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    // ~ Constructors ..........................................................
    // ----------------------------------------------------------
    /**
     * Create a new Month object.
     * 
     * @param month
     *            input month of the year.
     * @param likes
     *            the amount of likes recieved in that month.
     * @param posts
     *            the number of posts made for that month.
     * @param followers
     *            the amount of followers gained during a month.
     * @param comments
     *            the number of comment received in a month.
     * @param views
     *            the number of views for a month.
     */
    public Month(
        String month,
        int likes,
        int posts,
        int followers,
        int comments,
        int views)
    {
        this.month = month;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }


    // ~Public Methods .......................................................
    /**
     * Gets the name of the month.
     * 
     * @return String returns a string variable
     */
    public String getMonth()
    {
        return month;
    }


    /**
     * Returns the number of likes an influncer got during a given month.
     * 
     * @return int returns an int value representing the number of likes an
     *             influencer has gotten that month.
     */
    public int getLikes()
    {
        return likes;
    }


    /**
     * Returns the number of posts an influncer got during a given month.
     * 
     * @return int returns an int value representing the number of posts an
     *             influencer has gotten that month.
     */
    public int getPosts()
    {
        return posts;
    }


    /**
     * Returns the number of followers an influncer got during a given month.
     * 
     * @return int returns an int value representing the number of followers an
     *             influencer has gotten that month.
     */
    public int getFollowers()
    {
        return followers;
    }


    /**
     * Returns the number of comments an influncer got during a given month.
     * 
     * @return int returns an int value representing the number of comments an
     *             influencer has gotten that month.
     */
    public int getComments()
    {
        return comments;
    }


    /**
     * Returns the number of views an influncer got during a given month.
     * 
     * @return int returns an int value representing the number of views an
     *             influencer has gotten that month.
     */
    public int getViews()
    {
        return views;
    }


    /**
     * Checks that a month is equivalent to whatever its being checked against.
     * 
     * @param obj
     *            represents the object that the month is being checked against.
     * @return boolean returns a true or false value depending on whether or not
     *             the month is equal to checked object.
     */
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass().equals(obj.getClass()))
        {
            if (month.equals(((Month)obj).getMonth())
                && likes == ((Month)obj).getLikes()
                && posts == ((Month)obj).getPosts()
                && followers == ((Month)obj).getFollowers()
                && comments == ((Month)obj).getComments()
                && views == ((Month)obj).getViews())
            {
                return true;
            }
        }
        return false;
    }
}
