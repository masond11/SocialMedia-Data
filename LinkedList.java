/**
 * 
 */
package prj5;

import java.util.Comparator;
import java.util.Iterator;

/**
 * Class to hold list of Influencers
 * @author Andrei Zaitsev
 * @version 11/15/22
 * @param <T> generic
 * 
 */
public class LinkedList<T> implements LList<T>, Iterable<T> {

    private Node<T> head;
    private Node<T> last;
    private int size;

    /**
     * Constructor for LinkedList
     */
    public LinkedList() {
        size = 0;
        head = new Node<T>(null);
        last = head;
    }


    /** 
     * Returns size of LinkedList
     * 
     * @return size of List
     */
    public int size() {
        return size;
    }


    /**
     * Adds entry to end of list
     * 
     * @param anEntry
     *            entry to be added
     * @throws IllegalArgumentException
     *             if entry is null
     */
    public void add(T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException();
        }
        Node<T> node = new Node<T>(anEntry);
        if (size == 0) {
            head = node;
            last = head;
        }
        else
        {
            last.setNext(node);
            last = node;
        }
        size++;
    }


    /**
     * Adds entry to given index
     * 
     * @param index
     *            index where entry should be added
     * @param anEntry
     *            entry to be added
     * @throws IllegalArgumentException
     *             if entry is null
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     */
    public void add(int index, T anEntry) {
        if (anEntry == null) {
            throw new IllegalArgumentException();
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = new Node<T>(anEntry);
        Node<T> front = head;
        if (index == 0) {
            head = node;
            head.setNext(front);
            size++;
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            front = front.next();
        }
        Node<T> temp = front.next();
        front.setNext(node);
        node.setNext(temp);
        size++;
    }


    /**
     * Checks if List is empty
     * 
     * @return true if List is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns element at given index
     * 
     * @param index
     *            index at which the wanted element is located
     * @return element at given index
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next();
        }
        return temp.getData();
    }


    /**
     * Checks if list contains given object
     * 
     * @param obj
     *            Object we are checking for
     * @return true if object is contained in list
     */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        Node<T> node = head;
        while (node != null) {
            if (node.getData().equals(obj)) {
                return true;
            }
            node = node.next();
        }
        return false;
    }


    /**
     * Removes all elements from list
     */
    public void clear() {
        head = null;
        last = null;
        size = 0;
    }


    /**
     * Returns index of the last instance of given object
     * 
     * @param obj
     *            Object to be searched for
     * @return index of last instance of given object
     *         -1 if not in list
     * @throws IllegalArgumentException
     *             if object is null
     */
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException();
        }
        int index = -1;
        Node<T> temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.getData().equals(obj)) {
                index = i;
            }
            temp = temp.next();
            i++;
        }
        return index;
    }


    /**
     * toString method for LinkedList
     * 
     * @return String representation of List
     *         in form of "{A, B, C}"
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        String str = "{";
        Node<T> temp = head;
        while (temp.next() != null) {
            str += temp.getData().toString();
            str += ", ";
            temp = temp.next();
        }
        str += temp.getData().toString() + "}";
        return str;
    }


    /**
     * equals method for LinkedList
     * 
     * @param obj
     *            Object to compare with
     * @return true if given object is equal to list
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<T> other = ((LinkedList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> curr = head;
                Node<T> otherCurr = other.head;
                while (curr != null) {
                    if (!curr.getData().equals(otherCurr.getData())) {
                        return false;
                    }
                    curr = curr.next();
                    otherCurr = otherCurr.next();
                }
                return true;
            }
        }

        return false;
    }


    /**
     * Returns iterator for LinkedList
     * 
     * @return Iterator for LinkedList
     */
    public Iterator<T> iterator() {
        return new LListIterator<T>(this);
    }

    /**
     * Node class for Linked List
     * 
     * @author Andrei Zaitsev
     * @version 11/14/22
     * @param <D>
     */
    private class Node<D> {

        private D data;
        private Node<D> next;


        /**
         * Constructor for Node class
         * 
         * @param anEntry
         *            value to be put into data
         */
        public Node(D anEntry) {
            data = anEntry;
            next = null;
        }


        /**
         * Sets new Node for value of next
         * 
         * @param Node<D>
         *            Node to be set at next
         */
        public void setNext(Node<D> node) {
            next = node;
        }


        /**
         * Getter method for next Node
         * 
         * @return next Node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Getter method for data in Node
         * 
         * @return data in Node
         */
        public D getData() {
            return data;
        }
    }


    /**
     * Iterator class for LinkedList
     * 
     * @author Andrei Zaitsev
     * @version 11/14/22
     * @param <K>
     */
    public class LListIterator<K> implements Iterator<K> {

        private Node<K> current;

        /**
         * Constructor for Iterator which initializes cursor
         * @param list Will be iterated through
         */
        @SuppressWarnings("unchecked")
        public LListIterator(LinkedList<T> list) {
            current = (LinkedList<T>.Node<K>)list.head;
        }


        /**
         * Checks if next element exists
         * 
         * @return true if next element exists
         */
        public boolean hasNext() {
            return current != null;
        }


        /**
         * Returns next element
         * 
         * @return next element
         */
        public K next() {
            Node<K> temp = current;
            current = current.next();
            return temp.getData();
        }
    }
    
    
    /**
     * sorts the list
     * @param comparator that you want to use
     * @param list that you want to sort
     * @return the sorted list
     */
    public LinkedList<T> sortList(
        Comparator<? super T> comparator, LinkedList<T> list) {

        if (head == null)
        {
            return list;
        }
        else if (head.next() == null)
        {
            return list;
        }
        else
        {
            Node<T> unsorted = head.next();
            Node<T> sorted = head;
            sorted.setNext(null);
            while (unsorted != null)
            {
                Node<T> node = unsorted;
                unsorted = unsorted.next();
                insert(node, comparator);
            }
            
        }
        
        return list;
        
    }
    
    /**
     * Insert a node into the correct spot
     * in the list based on the Comparator
     * 
     * @param node 
     * @param comparator
     */
    private void insert(Node<T> node, Comparator<? super T> comparator)
    {
        T item = node.getData();
        Node<T> currentNode = head;
        Node<T> previousNode = null;
        while ((currentNode != null) &&
            (comparator.compare(currentNode.data, item) > 0))
        {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }
        
        if (previousNode != null)
        {
            previousNode.setNext(node);
            node.setNext(currentNode);
        }
        
        else
        {
            node.setNext(head);
            head = node;
        }
    }
    
    /**
     * Returns an array of the Objects
     * in the LinkedList
     * 
     * @return Object[] list contents
     */
    public Object[] toArray()
    {
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++)
        {
            result[i] = this.get(i);
        }
        
        return result;
    }
    
}
