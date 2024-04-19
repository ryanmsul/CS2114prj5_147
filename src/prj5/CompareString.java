package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This a helper class that allows the SSL to compare the string output of 
 * two comparator objects.
 * 
 * @author jesse
 * @version Apr 16, 2024
 */
public class CompareString
    implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2)
    {
        return o1.compareTo(o2);
    }
    
    
    
}
