/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.util.List;
import java.util.Map;
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
        Map<String, Object> firstMap = null;
        Map<String, Object> secondMap = null;
        List<String> expResult = null;
        List<String> result = Helper.getKeysWithDifferentValues(firstMap, secondMap);
        assertEquals(expResult, result);
    }
    
}
