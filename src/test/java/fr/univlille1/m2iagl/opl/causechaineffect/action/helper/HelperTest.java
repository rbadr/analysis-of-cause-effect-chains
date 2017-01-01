package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class HelperTest {
    
    /**
     * Test of getKeysWithDifferentValues method, of class Helper.
     */
    @Test
    public void getKeysWithDifferentValues_AllKeysWithSameValues_ShouldReturnEmptyList() {
        Map<String, String> firstMap = new HashMap<>();
        Map<String, String> secondMap = new HashMap<>();
        List<String> expResult = new ArrayList<String>();
        Helper newHelper = new Helper();
        
        firstMap.put("a","test");
        firstMap.put("b","test"); 
        secondMap.put("a","test");
        secondMap.put("b","test");
        
        List<String> result = newHelper.getKeysWithDifferentValues(firstMap, secondMap);
        assertEquals(expResult, result);
    }
    
    @Test
    public void getKeysWithDifferentValues_SomeKeysWithSameValues_ShouldReturnList() {
        Map<String, String> firstMap = new HashMap<>();
        Map<String, String> secondMap = new HashMap<>();
        List<String> expResult = new ArrayList<String>();
        Helper newHelper = new Helper();
        
        firstMap.put("a","test");
        firstMap.put("c","test"); 
        secondMap.put("a","test");
        secondMap.put("b","test");
        
        List<String> result = newHelper.getKeysWithDifferentValues(firstMap, secondMap);
        expResult.add("c");
        assertEquals(expResult, result);
    }
    
}
