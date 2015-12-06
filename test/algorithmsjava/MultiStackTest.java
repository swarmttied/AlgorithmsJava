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
 * @author Gio
 */
public class MultiStackTest {
    
    public MultiStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void toArrayTest() {
        
        MultiStack stack = new MultiStack(2);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        int[] values = stack.toArray();
        assertEquals(5, values[0]);
        assertEquals(1, values[1]);
        assertEquals(2, values[2]);
        assertEquals(3, values[3]);
        
        int[] headValues = stack.headsToArray();
        assertEquals(2, headValues.length);
        assertEquals(5, headValues[0]);
        assertEquals(2, headValues[1]);               
    }
    
    @Test
    public void popTest() {
        
        MultiStack stack = new MultiStack(2);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        int[] values = stack.toArray();
        assertEquals(5, values[0]);
        assertEquals(1, values[1]);
        assertEquals(2, values[2]);
        assertEquals(3, values[3]);
        
        int[] headValues = stack.headsToArray();
        assertEquals(2, headValues.length);
        assertEquals(5, headValues[0]);
        assertEquals(2, headValues[1]);     
        
        int popped = stack.pop();
        assertEquals(5, popped);
        values = stack.toArray();
        assertEquals(1, values[0]);
        assertEquals(2, values[1]);
        assertEquals(3, values[2]);
        
        headValues = stack.headsToArray();
        assertEquals(2, headValues.length);
        assertEquals(1, headValues[0]);
        assertEquals(3, headValues[1]);
        
        popped = stack.pop();
        assertEquals(1, popped);
        values = stack.toArray();
        assertEquals(2, values[0]);
        assertEquals(3, values[1]);
        
        
        headValues = stack.headsToArray();
        assertEquals(1, headValues.length);
        assertEquals(2, headValues[0]);        
    }
    
     @Test
    public void popAtTest() {
        
        MultiStack stack = new MultiStack(2);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        int[] values = stack.toArray();
        assertEquals(5, values[0]);
        assertEquals(1, values[1]);
        assertEquals(2, values[2]);
        assertEquals(3, values[3]);
        
        int[] headValues = stack.headsToArray();
        assertEquals(2, headValues.length);
        assertEquals(5, headValues[0]);
        assertEquals(2, headValues[1]);     
        
        int popped = stack.pop(1);
        assertEquals(2, popped);
        values = stack.toArray();
        assertEquals(5, values[0]);
        assertEquals(1, values[1]);
        assertEquals(3, values[2]);
        
        headValues = stack.headsToArray();
        assertEquals(2, headValues.length);
        assertEquals(5, headValues[0]);
        assertEquals(3, headValues[1]);
        
       
    }
     
}
