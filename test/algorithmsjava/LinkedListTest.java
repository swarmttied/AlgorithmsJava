/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithmsjava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author the-r
 */
public class LinkedListTest {
    
    public LinkedListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    LinkedList _target;
    
    @Before
    public void setUp() {
        _target = new LinkedList();
    }
    
    @After
    public void tearDown() {        
    }

    /**
     * Test of getSize method, of class LinkedList.
     */
    @Test
    public void ctor_default_size_test() {       
       LinkedList target = new LinkedList();    
       assertEquals("Default size must be 1 if now supplied in ctor.", 1, target.getSize());
    }
    
    /**
     * Test of getSize() after ctor(size)
     */
    @Test
    public void ctor_with_size_test() {
        int size = 2;
        LinkedList target = new LinkedList(size);
        assertEquals("Size is not correct after ctor call", size, target.getSize());
    }
    
    /**
     * Test creation of array which also includes creation of 
     * the linked list itself inside
     */
    @Test
    public void toArray_test() {
        int size = 5;
        LinkedList target = new LinkedList(size);
        int[] values = target.toArray();        
        assertEquals( "Array size not correct",size, values.length);        
        assertEquals( "LinkedList size not correct",size, target.getSize());  
    }
    
    @Test
    public void append_test() {
        LinkedList target = new LinkedList();
        int newValue = 1;
        int expectedSize = target.getSize() + 1;
        target.append(newValue);
        assertEquals("Size not correct", 2, target.getSize());
        
        int[] values = target.toArray();
        assertEquals("toArray() size not correct", expectedSize, values.length);
        assertEquals("New value not appended in the tail", newValue, 
                values[expectedSize-1]);        
    }
    
    @Test
    public void prepend_test() {
        LinkedList target = new LinkedList();
        int newValue = 1;
        int expectedSize = target.getSize() + 1;
        target.prepend(newValue);
        assertEquals("Size not correct", 2, target.getSize());
        
        int[] values = target.toArray();
        assertEquals("toArray() size not correct", expectedSize, values.length);
        assertEquals("New value not prepended in the head", newValue, 
                values[0]);     
    }
    
    @Test
    public void removeHead_one_item_test() {
        int value = _target.removeHead();
        assertEquals("Head value not correct", 0, value);                
        assertEquals("toArray() size not correct after removal", 0, _target.toArray().length);
        assertEquals("Size not correct after removal", 0, _target.getSize());
    }
    
    @Test
    public void removeHead_more_than_one_items_test() {
        _target.append(1);
        int expectedCount  = 1;
        int value = _target.removeHead();
        assertEquals("Head value not correct", 0, value);                
        assertEquals("toArray() size not correct after removal", expectedCount, _target.toArray().length);
        assertEquals("Size not correct after removal", expectedCount, _target.getSize());
    }
    
    @Test
    public void distinct_test() {
        _target.append(1);
        _target.append(0);
        _target.append(2);
        _target.distinct();
        int[] values = _target.toArray();
        assertEquals("toArray() size not correct after removal", 3, _target.toArray().length);        
    }
    
    @Test
    public void getNthFromEnd_test() {
        _target.append(1);
        _target.append(2);
        _target.append(3);
        _target.append(4);
        _target.append(5);
        
        int data = _target.getNthFromEnd(2);
        assertEquals("2nd Element from end not correct", 4, data);
    }
    
    @Test
    public void deleteNthFromEnd_test() {
        _target.append(1);
        _target.append(2);
        _target.append(3);
        _target.append(4);
        _target.append(5);
        
        int expectedSize = _target.getSize() -1;
        
        _target.deleteNthFromEnd(2);
        assertEquals("Size not correct after delete", expectedSize, _target.getSize());
    }
    
    @Test 
    public void deleteFirstNNodes_test() {
        _target.append(1);
        _target.append(2);
        _target.append(3);
        int expectedSize = _target.getSize() - 4;  
        _target.deleteFirstNNodes(5);
        assertEquals("Size not correct after delete", expectedSize, _target.getSize());
    }
    
    @Test
    public void pivotAt_test() {
        //0
        _target.append(5);
        _target.append(6);
        _target.append(7);
        _target.append(8);
        _target.append(4);
        _target.append(3);
        _target.append(2);
        _target.append(1);
        
        _target.pivotAt(4);
        
        int[] values = _target.toArray();
       
        assertEquals(3,values[0]);
        assertEquals(2,values[1]);
        assertEquals(1,values[2]);
        assertEquals(0,values[3]);        
        assertEquals(4,values[4]);
        assertEquals(5,values[5]);
        assertEquals(6,values[6]);
        assertEquals(7,values[7]);
        assertEquals(8,values[8]);     
    }
    
    @Test
    public void addReverse_test() {
        LinkedList a = new LinkedList();
        a.setInitialValue(7);
        a.append(1);
        a.append(6);
        
        //592
        LinkedList b = new LinkedList();
        b.setInitialValue(5);
        b.append(9);
        b.append(2);
        
        LinkedList.Node sum = a.addReverse(b.getHead());       
        
        assertEquals(2,sum.data);
        assertEquals(1,sum.next.data);
        assertEquals(9,sum.next.next.data);

    }
    
}
