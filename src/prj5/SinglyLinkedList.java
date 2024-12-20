package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This is a Singly linked list that uses nodes
 * 
 * @author David Mathews (davidm05)
 * @version Apr 16, 2024
 * @param <T>
 *            The generic parameter
 */
public class SinglyLinkedList<T>
    implements LList<T>
{
    private static class Node<D>
    {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d)
        {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n)
        {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next()
        {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData()
        {
            return data;
        }
    }

    private Node<T> head;

    // the size of the linked list
    private int size;

    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList()
    {
        head = null;
        size = 0;

    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    @Override
    public int size()
    {
        return size;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(int index, T obj)
    {
        // check if the object is null
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size()))
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;

        // empty stack case
        if (isEmpty())
        {
            head = new Node<T>(obj);

        }

        // all other cases
        else
        {
            if (index == 0)
            {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else
            {
                int currentIndex = 0;
                while (current != null)
                {
                    if ((currentIndex + 1) == index)
                    {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    current = current.next();
                    currentIndex++;
                }
            }
        }
        size++;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(T obj)
    {
        // check if the object is null
        if (obj == null)
        {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;

        // empty stack case
        if (isEmpty())
        {
            head = new Node<T>(obj);
            head.setNext(null);
        }

        // other cases
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    @Override
    public boolean isEmpty()
    {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    @Override
    public boolean remove(T obj)
    {
        Node<T> current = head;

        // account for obj being null
        if (obj == null)
        {
            return false;
        }

        // account for matching head
        if ((null != head) && (obj.equals(current.data)))
        {
            head = head.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null))
        {
            if ((obj.equals(current.next.data)))
            {
                if (current.next.next != null)
                {
                    current.setNext(current.next.next);
                }
                else
                {
                    current.next = null;
                }
                size--;
                return true;
            }
            current = current.next;
        }

        // this accounts for the isEmpty case or the object does not exist
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    @Override
    public boolean remove(int index)
    {
        // if the index is invalid
        if (index < 0 || head == null)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        Node<T> current = head;
        int currentIndex = 0;

        while (current.next != null)
        {
            if (index == 0)
            {
                head = current.next;
                size--;
                return true;
            }
            else if ((currentIndex + 1) == index)
            {
                Node<T> newNext = current.next.next;
                current.setNext(newNext);
                size--;
                return true;
            }
            current = current.next;
            currentIndex++;
        }

        // if the element was never found, this also handles empty case
        throw new IndexOutOfBoundsException("Index is out of bounds");
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public T get(int index)
    {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        // check if the data was null...
        if (data == null)
        {
            // ... if so throw an exception
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(T obj)
    {
        if (obj != null)
        {
            Node<T> current = head;
            while (current != null)
            {
                if (obj.equals(current.data))
                {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear()
    {
        // make sure we don't call clear on an empty list
        if (head != null)
        {
            head.setNext(null);
            head = null;
            size = 0;

        }

    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    @Override
    public int lastIndexOf(T obj)
    {
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null)
        {
            if (obj.equals(current.data))
            {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString()
    {
        String result = "{";

        Node<T> current = head;
        while (current != null)
        {
            result += "" + current.data;
            current = current.next;
            if (current != null)
            {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list contains A, B,
     * C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray()
    {

        Object[] array = new Object[this.size()];

        Node<T> current = head;
        int count = 0;
        while (current != null)
        {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents in the exact same
     * order
     *
     * @return a boolean of whether two lists have the same contents, item per
     *             item and in the same order
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (this.getClass() == obj.getClass())
        {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<T> other = ((SinglyLinkedList<T>)obj);
            if (other.size() == this.size())
            {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null)
                {
                    if (!current.getData().equals(otherCurrent.getData()))
                    {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;

    }


    // ----------------------------------------------------------
    /**
     * A linked list implementation of insertion sort
     * 
     * @param comparer
     *            The comparator used for the sort
     */
    public void insertionSort(Comparator<? super T> comparer)
    {
        if (size > 1)
        {
            Node<T> unsorted = head.next();
            Node<T> sorted = head;
            sorted.setNext(null);

            while (unsorted != null)
            {
                Node<T> nodeToInsert = unsorted;
                unsorted = unsorted.next();
                insertInOrder(nodeToInsert, comparer);
            }

        }

    }


    // ----------------------------------------------------------
    /**
     * Overloaded method to allow sorting by Months
     * 
     * @param comparer
     *            The comparator used for the sort
     * @param month
     *            The month period to be sorted by.
     */
    public
        void
        insertionSort(CompareEngagement<? super T> comparer, String month)
    {
        if (size > 1)
        {
            Node<T> unsorted = head.next();
            Node<T> sorted = head;
            sorted.setNext(null);

            while (unsorted != null)
            {
                Node<T> nodeToInsert = unsorted;
                unsorted = unsorted.next();
                insertInOrder(nodeToInsert, comparer, month);
            }

        }

    }


    private
        void
        insertInOrder(Node<T> nodeToInsert, Comparator<? super T> comparer)
    {
        T nodeData = nodeToInsert.getData();
        Node<T> current = head;
        Node<T> prev = null;

        // find insertion location
        while ((current != null)
            && (comparer.compare(nodeData, current.getData())) > 0)
        {
            prev = current;
            current = current.next();

        }

        // complete insertion
        if (prev != null)
        {
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(current);
        }
        else
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }


    private void insertInOrder(
        Node<T> nodeToInsert,
        CompareEngagement<? super T> comparer,
        String month)
    {
        T nodeData = nodeToInsert.getData();
        Node<T> current = head;
        Node<T> prev = null;

        // find insertion location
        while ((current != null)
            && (comparer.compare(nodeData, current.getData(), month)) > 0)
        {
            prev = current;
            current = current.next();

        }

        // complete insertion
        if (prev != null)
        {
            prev.setNext(nodeToInsert);
            nodeToInsert.setNext(current);
        }
        else
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }

}
