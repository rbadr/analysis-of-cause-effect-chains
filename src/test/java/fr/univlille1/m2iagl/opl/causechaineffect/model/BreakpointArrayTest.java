package fr.univlille1.m2iagl.opl.causechaineffect.model;

import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BreakpointArrayTest {
    
    /**
     * Test of get method, of class BreakpointArray.
     */
    @Test
    public void get_SecondeBreakpointInArray_ShouldReturnSecondTestFileName() {
        Breakpoint[] br;
        br = new Breakpoint[2];
        br[0]= new Breakpoint(7,"firstTestFileName",1);
        br[1]= new Breakpoint(4,"secondTestFileName",2);
        BreakpointArray breakPointArray = new BreakpointArray(br);
        int i = 1;
        Breakpoint expResult = new Breakpoint(4,"secondTestFileName",2);
        Breakpoint result = breakPointArray.get(i);
        assertEquals(expResult.toString(), result.toString());
    }
    
    @Test
    public void testArrayFieldValue() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Breakpoint[] br;
        br = new Breakpoint[2];
        br[0]= new Breakpoint(7,"firstTestFileName",1);
        br[1]= new Breakpoint(4,"secondTestFileName",2);
        BreakpointArray breakPointArray = new BreakpointArray(br);
        
        Field field = BreakpointArray.class.getDeclaredField("array");
        String typeNameResult = field.get(breakPointArray).toString();
        assertEquals(br.toString(), typeNameResult);
    }

    /**
     * Test of getLineAt method, of class BreakpointArray.
     */
    @Test
    public void getLineAt_BreakPointWithLineNumber7_ShouldReturn7() {
        Breakpoint[] br;
        br = new Breakpoint[2];
        br[0]= new Breakpoint(7,"firstTestFileName",1);
        br[1]= new Breakpoint(4,"secondTestFileName",2);
        BreakpointArray breakPointArray = new BreakpointArray(br);
        int i = 0;
        int expResult = 7;
        int result = breakPointArray.getLineAt(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFilenameAt method, of class BreakpointArray.
     */
    @Test
    public void getFilenameAt_BreakpointWithFileNameFirstTest_ShoudReturnFirstTestFileName() {
        Breakpoint[] br;
        br = new Breakpoint[2];
        br[0]= new Breakpoint(7,"firstTestFileName",1);
        br[1]= new Breakpoint(4,"secondTestFileName",2);
        BreakpointArray breakPointArray = new BreakpointArray(br);
        int i = 0;
        String expResult = "firstTestFileName";
        String result = breakPointArray.getFilenameAt(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class BreakpointArray.
     */
    @Test
    public void toString_ValideFileNameAndLineNumber_ShouldReturnFileNameAndLineNumber() {
        Breakpoint[] br;
        br = new Breakpoint[2];
        br[0]= new Breakpoint(7,"firstTestFileName",1);
        br[1]= new Breakpoint(4,"secondTestFileName",2);
        BreakpointArray breakPointArray = new BreakpointArray(br);
        String result = breakPointArray.toString();
        String expResult = "[firstTestFileName:7, secondTestFileName:4]";
        
        assertEquals(expResult, result);
    }

    /**
     * Test of length method, of class BreakpointArray.
     */
    @Test
    public void length_TwoBreakpoints_ShouldReturnTwo() {
        Breakpoint[] br;
        br = new Breakpoint[2];
        br[0]= new Breakpoint(7,"firstTestFileName",1);
        br[1]= new Breakpoint(4,"secondTestFileName",2);
        BreakpointArray breakPointArray = new BreakpointArray(br);
        int expResult = 2;
        int result = breakPointArray.length();
        assertEquals(expResult, result);
    }

        /**
     * Test of remove method, of class BreakpointArray.
     */
    @Test
    public void testRemove() {
        int i = 3;
        Breakpoint[] br;
        br = new Breakpoint[5];
        br[0]= new Breakpoint(7,"firstTestFileName",1);
        br[1]= new Breakpoint(4,"secondTestFileName",2);
        br[2]= new Breakpoint(6,"thirdTestFileName",3);
        br[3]= new Breakpoint(9,"fourthTestFileName",4);
        br[4]= new Breakpoint(3,"fifthTestFileName",5);
        BreakpointArray breakPointArray = new BreakpointArray(br);
        breakPointArray.remove(i);
        assertEquals(4,breakPointArray.array.length);
        assertEquals(br[4],breakPointArray.array[3]);
    }
    
}
