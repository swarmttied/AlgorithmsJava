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
public class TowerOfHanoiTest {
    
    public TowerOfHanoiTest() {
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

    /**
     * Test of isMovePossible method, of class TowerOfHanoi.
     */
    @Test
    public void testIsMovePossible() {
        System.out.println("isMovePossible");
        int sourceTower = 0;
        int targetTower = 0;
        TowerOfHanoi instance = null;
        Boolean expResult = null;
        Boolean result = instance.isMovePossible(sourceTower, targetTower);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveDisk method, of class TowerOfHanoi.
     */
    @Test
    public void testMoveDisk_EmptyToNonEmpty() throws Exception {
        try {
            TowerOfHanoi target = new TowerOfHanoi(5);
            Boolean possible = target.isMovePossible(1, 0);           
            assertFalse(possible);
        }
        catch (Exception ex) {
            
        }
    }
    
    @Test
     public void testMoveDisk_EmptyToEmpty() throws Exception {
        try {
            TowerOfHanoi target = new TowerOfHanoi(5);
            Boolean possible = target.isMovePossible(1, 2);           
            assertFalse(possible);
        }
        catch (Exception ex) {
            
        }
    }
     
     
    @Test
    public void testMoveDisk_NonEmptyToEmpty() throws Exception {
        try {
            TowerOfHanoi target = new TowerOfHanoi(5);
            Boolean possible = target.isMovePossible(0, 2);           
            assertTrue(possible);
        }
        catch (Exception ex) {
            
        }
    }
    
    @Test
    public void testMove() {
        try {
            TowerOfHanoi target = new TowerOfHanoi(5);
            target.moveDisk(0, 1);
            assertEquals(4, target.getTower0Disks().length);
            assertEquals(1, target.getTower0Disks()[0].intValue());
            assertEquals(1, target.getTower1Disks().length);
            assertEquals(0, target.getTower1Disks()[0].intValue());
            
            target.moveDisk(0,1);
            assertEquals(3, target.getTower0Disks().length);
            assertEquals(2, target.getTower0Disks()[0].intValue());
            assertEquals(2, target.getTower1Disks().length);
            assertEquals(1, target.getTower1Disks()[0].intValue());
            
            /*
           target.moveDisk(0,2);
            assertEquals(3, target.getTower0Disks().length);
            assertEquals(2, target.getTower0Disks()[0].intValue());
            assertEquals(1, target.getTower2Disks().length);
            assertEquals(1, target.getTower2Disks()[0].intValue());
            
           assertFalse(target.isMovePossible(0, 1));
           assertFalse(target.isMovePossible(0, 2));
                    */
        }
        catch (Exception ex)
        {
            
        }
    }
    
}
