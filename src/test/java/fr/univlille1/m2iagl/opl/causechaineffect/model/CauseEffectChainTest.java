package fr.univlille1.m2iagl.opl.causechaineffect.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CauseEffectChainTest {

    /**
     * Test of toString method, of class CauseEffectChain.
     */
    @Test
    public void testToString() {
        Breakpoint[] br = new Breakpoint[0];
        BreakpointArray breakPointArray = new BreakpointArray(br);
        CauseEffectChain causeEffectChain = new CauseEffectChain(breakPointArray);
        
        String expResult = "Then, the app crashed !";
        String result = causeEffectChain.toString().trim();
        assertEquals(expResult, result);
    }

    /**
     * Test of addEntries method, of class CauseEffectChain.
     */
    @Test
    public void testAddEntries() {
        int i = 0;
        List<String> keys = new ArrayList<String>();
        keys.add("test");
        Map<String, Object> rightVarNamesAndValues = new HashMap<String, Object>();
        rightVarNamesAndValues.put("a","test1");
        Map<String, Object> wrongVarNamesAndValues = new HashMap<String, Object>();
        rightVarNamesAndValues.put("b","test2");
        
        Breakpoint[] br;
        br = new Breakpoint[2];
        br[0]= new Breakpoint(7,"firstTestFileName");
        br[1]= new Breakpoint(4,"secondTestFileName");
        BreakpointArray breakPointArray = new BreakpointArray(br);
        CauseEffectChain causeEffectChain = new CauseEffectChain(breakPointArray);
        
        causeEffectChain.addEntries(i, keys, rightVarNamesAndValues, wrongVarNamesAndValues);
    }
    
}
