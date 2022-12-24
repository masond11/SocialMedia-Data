/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author Andrei Zaitsev
 * @version 11/14/22
 * @param <E>
 */
public interface LList<E> {
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public abstract int size();


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
    public abstract void add(int index, E anEntry);


    /**
     * Adds entry to end of list
     * 
     * @param anEntry
     *            entry to be added
     * @throws IllegalArgumentException
     *             if entry is null
     */
    public abstract void add(E anEntry);


    /**
     * Checks if List is empty
     * 
     * @return true if List is empty
     */
    public abstract boolean isEmpty();


    /**
     * Returns element at given index
     * 
     * @param index
     *            index at which the wanted element is located
     * @return element at given index
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     */
    public abstract E get(int index);


    /**
     * Checks if list contains given object
     * 
     * @param obj
     *            Object we are checking for
     * @return true if object is contained in list
     */
    public abstract boolean contains(E obj);


    /**
     * Removes all elements from list
     */
    public abstract void clear();


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
    public abstract int lastIndexOf(E obj);


    /**
     * toString method for LinkedList
     * 
     * @return String representation of List
     *         in form of "{A, B, C}"
     */
    public abstract String toString();
    
    
    /**
     * Returns iterator for LinkedList
     * 
     * @return Iterator for LinkedList
     */
    public Iterator<E> iterator();
}
