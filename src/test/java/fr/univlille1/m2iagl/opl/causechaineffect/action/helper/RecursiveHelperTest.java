package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RecursiveHelperTest {

    /**
     * Test of get method, of class RecursiveHelper.
     */
    @Test
    public void testGet() {
        String s = "a";
        RecursiveHelper instance = new RecursiveHelper();
        int expResult = 1;
        int result = instance.get(s);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of get method, of class RecursiveHelper.
     */
    @Test
    public void testGetContains() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, Exception {
        String s = "a";
        Map<String, Integer> test = new HashMap<String, Integer>();
        test.put(s, 1);
        
        RecursiveHelper instance = new RecursiveHelper();
        instance.nbTimes = test;

   
        int expResult = 2;
        int result = instance.get(s);
        assertEquals(expResult, result);
    }
    
}
