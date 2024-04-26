package prj5;

import java.util.Arrays;

// -------------------------------------------------------------------------
/**
 * A test class for the SinglyLinkedList class, tests all methods and
 * instructions possible in the SLL class.
 * 
 * @author ddmat
 * @version April 17, 2024
 */
public class SinglyLinkedListTest
    extends student.TestCase
{
    private SinglyLinkedList<String> list1;
    private SinglyLinkedList<String> otherList1;
    private SinglyLinkedList<String> list2;
    private SinglyLinkedList<String> emptyList;

    /**
     * initializes declared singly linked lists.
     */
    public void setUp()
    {
        list1 = new SinglyLinkedList<String>();
        list1.add("apple");
        list1.add("banana");
        list1.add("mango");
        list1.add("kiwi");

        otherList1 = new SinglyLinkedList<String>();
        otherList1.add("apple");
        otherList1.add("banana");
        otherList1.add("mango");
        otherList1.add("kiwi");

        list2 = new SinglyLinkedList<String>();
        list2.add("strawberry");
        list2.add("watermelon");
        list2.add("pineapple");
        list2.add("blueberry");

        emptyList = new SinglyLinkedList<String>();
    }


    // ----------------------------------------------------------
    /**
     * Test insertion sort method
     */
    public void testInsertionSort()
    {
        SinglyLinkedList<String> insertionSortedList =
            new SinglyLinkedList<String>();
        insertionSortedList.add("B");
        insertionSortedList.add("D");
        insertionSortedList.add("C");
        insertionSortedList.add("A");
        insertionSortedList.add("E");

        assertEquals("{B, D, C, A, E}", insertionSortedList.toString());

        insertionSortedList.insertionSort(new CompareString());

        assertEquals("{A, B, C, D, E}", insertionSortedList.toString());

    }


// ----------------------------------------------------------
    /**
     * Tests size method
     */
    public void testSize()
    {
        assertEquals(4, list1.size());
        assertEquals(0, emptyList.size());

    }


// ----------------------------------------------------------
    /**
     * tests generic add method
     */
    public void testAdd()
    {

        assertEquals(0, emptyList.size());
        emptyList.add("new head");
        assertEquals(1, emptyList.size());
        assertEquals("new head", emptyList.get(0));

        assertEquals(4, list1.size());
        list1.add("5th");
        assertEquals(5, list1.size());
        assertEquals("5th", list1.get(4));

    }


    // ----------------------------------------------------------
    /**
     * Tests adding a null value to list
     */
    public void testAddNullException()
    {
        Exception thrown = null;
        try
        {
            list1.add(null);
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
    }


// ----------------------------------------------------------
    /**
     * tests adding at specific index
     */
    public void testAddAtIndex()
    {
        // test adding null object
        Exception thrown = null;
        try
        {
            list1.add(0, null);
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        // adding negative index
        Exception thrown2 = null;
        try
        {
            list1.add(-1, "negative index");
        }
        catch (Exception e)
        {
            thrown2 = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown2 instanceof IndexOutOfBoundsException);

        // adding too large index
        Exception thrown3 = null;
        try
        {
            list1.add(list1.size() + 1, "larger than size");
        }
        catch (Exception e)
        {
            thrown3 = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown3 instanceof IndexOutOfBoundsException);

        assertEquals(0, emptyList.size());
        emptyList.add(0, "new head");
        assertEquals(1, emptyList.size());
        assertEquals("new head", emptyList.get(0));

        assertEquals(4, list1.size());
        list1.add(0, "new head");
        assertEquals(5, list1.size());
        assertEquals("new head", list1.get(0));

        assertEquals(5, list1.size());
        list1.add(3, "5th");
        assertEquals(6, list1.size());
        assertEquals("5th", list1.get(3));
    }


// ----------------------------------------------------------
    /**
     * tests is empty method
     */
    public void testIsEmpty()
    {
        assertTrue(emptyList.isEmpty());
        assertFalse(list1.isEmpty());
    }


// ----------------------------------------------------------
    /**
     * tests remove method
     */
    public void testRemove()
    {
        // remove head
        assertTrue(list1.remove("apple"));

        // not in list
        assertFalse(list1.remove("not in list"));

        // remove middle/end
        assertTrue(list1.remove("mango"));

        // remove null

        assertFalse(list1.remove(null));

        assertFalse(emptyList.remove("not in list"));

        emptyList.add("first elem");
        assertTrue(emptyList.remove("first elem"));

        emptyList.add("first elem");
        emptyList.add("second elem");
        assertTrue(emptyList.remove("second elem"));

    }


// ----------------------------------------------------------
    /**
     * tests remove for a specific index
     */
    public void testRemoveIndex()
    {

        // negative index
        Exception thrown = null;
        try
        {
            list1.remove(-1);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        // null head
        Exception thrown2 = null;
        try
        {
            emptyList.remove(5);
        }
        catch (Exception e)
        {
            thrown2 = e;
        }

        assertNotNull(thrown2);
        assertTrue(thrown2 instanceof IndexOutOfBoundsException);

        // too large
        Exception thrown3 = null;
        try
        {
            list1.remove(5);
        }
        catch (Exception e)
        {
            thrown3 = e;
        }

        assertNotNull(thrown3);
        assertTrue(thrown3 instanceof IndexOutOfBoundsException);

        // remove head
        assertTrue(list1.remove(0));

        // remove middle
        assertTrue(list1.remove(1));

        // remove end
        assertTrue(list1.remove(1));

    }


// ----------------------------------------------------------
    /**
     * test get method
     */
    public void testGet()
    {
        // negative index
        Exception thrown = null;
        try
        {
            list1.get(4);
        }
        catch (Exception e)
        {
            thrown = e;
        }

        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertEquals("apple", list1.get(0));

    }


// ----------------------------------------------------------
    /**
     * test contains method
     */
    public void testContains()
    {
        assertTrue(list1.contains("apple"));
        assertFalse(list1.contains("not in list"));
    }


// ----------------------------------------------------------
    /**
     * tests clear method
     */
    public void testClear()
    {
        assertFalse(list1.isEmpty());
        assertEquals("{apple, banana, mango, kiwi}", list1.toString());
        list1.clear();
        assertTrue(list1.isEmpty());
        assertEquals("{}", list1.toString());

        assertEquals("{}", emptyList.toString());
        emptyList.clear();
        assertEquals("{}", emptyList.toString());

    }


// ----------------------------------------------------------
    /**
     * tests last index of method
     */
    public void testLastIndexOf()
    {
        assertEquals(-1, list1.lastIndexOf("not in list"));
        assertEquals(0, list1.lastIndexOf("apple"));
        list1.add("apple");
        assertEquals(4, list1.lastIndexOf("apple"));
    }


// ----------------------------------------------------------
    /**
     * tests to string method
     */
    public void testToString()
    {
        assertEquals("{apple, banana, mango, kiwi}", list1.toString());
        list1.clear();
        assertEquals("{}", list1.toString());
    }


    // ----------------------------------------------------------
    /**
     * Tests the toArray method of the SLL class.
     */
    public void testToArray()
    {
        Object[] l1Array = list1.toArray();
        Object[] expected = { "apple", "banana", "mango", "kiwi" };

        assertEquals(Arrays.toString(l1Array), Arrays.toString(expected));

    }


    // ----------------------------------------------------------
    /**
     * Tests the equals method of the SLL class
     */
    public void testEquals()
    {
        assertTrue(list1.equals(list1));
        assertTrue(list1.equals(otherList1));
        assertFalse(list1.equals(emptyList));
        assertFalse(list1.equals(null));
        assertFalse(list1.equals(new Object()));
        assertFalse(list1.equals(list2));
    }
}
