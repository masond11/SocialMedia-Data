/**
 * 
 */
package prj5;

import student.TestCase;
import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Andrei Zaitsev
 * @version 11/15/22
 */
public class LinkedListTest extends TestCase {

    private LinkedList<String> list1;
    private LinkedList<String> list2;
    private LinkedList<String> list3;
    private LinkedList<String> list4;


    /**
     * setUp method for test class
     */
    public void setUp() {
        list1 = new LinkedList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        list2 = new LinkedList<String>();
        
        list3 = new LinkedList<String>();
        list3.add("A");
        list3.add("B");
        list3.add("D");
        
        list4 = new LinkedList<String>();
        list4.add("A");
        list4.add("B");
        list4.add("C");
    }


    /**
     * test class for size method
     */
    public void testSize() {
        assertEquals(3, list1.size());
    }


    /**
     * test class for add method without given index
     */
    public void testAddNoIndex() {
        Exception thrown = null;
        try {
            list1.add(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        list1.add("D");
        assertEquals(4, list1.size());
        assertEquals("D", list1.get(3));

        list2.add("A");
        assertEquals(1, list2.size());
        assertEquals("A", list1.get(0));
    }


    /**
     * test class for add method with given index
     */
    public void testAddWithIndex() {
        Exception thrown = null;
        try {
            list1.add(0, null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;
        try {
            list1.add(-1, "D");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {
            list1.add(4, "D");
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        list1.add(0, "Front");
        assertEquals(4, list1.size());
        assertEquals("Front", list1.get(0));

        list1.add(3, "Temp");
        assertEquals(5, list1.size());
        assertEquals("Temp", list1.get(3));
        assertEquals("C", list1.get(4));
    }


    /**
     * test method for isEmpty
     */
    public void testIsEmpty() {
        assertTrue(list2.isEmpty());
        assertFalse(list1.isEmpty());
    }


    /**
     * test method for get
     */
    public void testGet() {
        Exception thrown = null;
        try {
            list1.get(-1);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        thrown = null;
        try {
            list1.get(4);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IndexOutOfBoundsException);

        assertEquals("B", list1.get(1));
    }


    /**
     * test method for contains
     */
    public void testContains() {
        assertFalse(list1.contains(null));
        assertTrue(list1.contains("B"));
        assertFalse(list1.contains("entry"));
    }
    
    
    /**
     * test method for clear
     */
    public void testClear() {
        list1.clear();
        assertEquals(0, list1.size());
    }
    
    
    /**
     * test method for lastIndexOf
     */
    public void testLastIndexOf() {
        Exception thrown = null;
        try {
            list1.lastIndexOf(null);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue(thrown instanceof IllegalArgumentException);
        
        assertEquals(1, list1.lastIndexOf("B"));
        
        list1.add("A");
        assertEquals(3, list1.lastIndexOf("A"));
    }
    
    
    /**
     * test method for toString
     */
    public void testToString() {
        assertEquals("{}", list2.toString());
        String s = "{A, B, C}";
        assertEquals(s, list1.toString());
    }
    
    
    /**
     * test method for equals
     */
    public void testEquals() {
        assertTrue(list1.equals(list1));
        assertFalse(list1.equals(null));
        assertFalse(list1.equals(new Object()));
        assertFalse(list1.equals(list2));
        assertFalse(list1.equals(list3));
        assertTrue(list1.equals(list4));
        
    }
    
    
    /**
     * test method for Iterator
     */
    public void testIterator() {
        Iterator<String> iterator = list1.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }
    
    
    /**
     * tests the sort method with an empty list, 
     * a list with one, two, and three elements
     */
    public void testSort()
    {
        LinkedList<Influencer> iList = new LinkedList<Influencer>();
        Comparator comparator = new CompareByReachEngagementMonth("January");
        assertEquals(iList.sortList(comparator, iList), iList);
        Influencer influencer = new Influencer("person", "fk", "fj", "sk");
        Engagement engagement = new Engagement( "January", 1, 1, 1, 1, 1);
        influencer.addEngagement(engagement);
        iList.add(influencer);
        Influencer influencer2 = new Influencer("mason", "fk", "fj", "sk");
        Engagement engagement2 = new Engagement( "January", 10, 10, 10, 10, 1);
        influencer2.addEngagement(engagement2);
        iList.add(influencer2);
        
        LinkedList<Influencer> iList2 = new LinkedList<Influencer>();
        iList2.add(influencer2);
        iList2.add(influencer);
        
        assertEquals(iList.sortList(comparator, iList), iList);
    }
    
    
    /**
     * tests toArray method
     */
    public void testToArray() {
        String[] array = {"A", "B", "C"};
        Object[] list1Arr = list1.toArray();
        for (int i = 0; i < list1Arr.length; i++) {
            assertEquals(array[i], list1Arr[i]);
        }
    }
    
    

}
