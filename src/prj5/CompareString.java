package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
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
