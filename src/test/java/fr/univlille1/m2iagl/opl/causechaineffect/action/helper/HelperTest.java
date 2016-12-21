/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rahal Badr
 */
public class HelperTest {
    
    public HelperTest() {
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
     * Test of getKeysWithDifferentValues method, of class Helper.
     */
    @Test
    public void testGetKeysWithDifferentValues() {
        int a = 5;
        int b = 4;
        int expResult = 9;
        int result = Helper.Helper(a, b);
        assertEquals(expResult, result);
    }
    
}
