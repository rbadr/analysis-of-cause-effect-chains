package fr.univlille1.m2iagl.opl.causechaineffect.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BreakpointTest {
    
    Breakpoint instance = new Breakpoint(5,"testfilename");

    /**
     * Test of getLine method, of class Breakpoint.
     */
    @Test
    public void getLine_ValideLineNumber_ShouldReturn5() {
        int expResult = 5;
        int result = instance.getLine();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFilename method, of class Breakpoint.
     */
    @Test
    public void getFileName_ValideFileName_ShouldReturnTestFileName() {
        String expResult = "testfilename";
        String result = instance.getFilename();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Breakpoint.
     */
    @Test
    public void toString_ValideFileNameAndLineNumber_ShouldReturnTestFileNameLineNumber() {
        String expResult = "testfilename:5";
        String result = instance.toString();
        assertEquals(expResult, result);
    }
    
}
