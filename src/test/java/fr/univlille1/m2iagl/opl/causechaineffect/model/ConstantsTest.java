package fr.univlille1.m2iagl.opl.causechaineffect.model;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConstantsTest {
        
    /**
     * Test of init method, of class Constants.
     */
    @Test
    public void init_WindowsOs_ShouldReturnDoubleAntiSlash() {
        String result = "\\";
        Constants newConstants = new Constants();
        
        System.setProperty("os.name","windows");

        newConstants.init();
        String expResult = Constants.SEPARATOR;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void init_LinuxOs_ShouldReturnSlash() {
        String result = "/";
        Constants newConstants = new Constants();
        
        System.setProperty("os.name","linux");

        newConstants.init();
        String expResult = Constants.SEPARATOR;
        
        assertEquals(expResult, result);
    }
    
}
