package fr.univlille1.m2iagl.opl.causechaineffect.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ConstantsTest {
        
    /**
     * Test of init method, of class Constants.
     */
    @Test
    public void init_WindowsOs_ShouldReturnDoubleAntiSlash() {
        String result = "\\";
        System.setProperty("os.name","windows");

        Constants.init();
        String expResult = Constants.separator;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void init_LinuxOs_ShouldReturnSlash() {
        String result = "/";
        System.setProperty("os.name","linux");

        Constants.init();
        String expResult = Constants.separator;
        
        assertEquals(expResult, result);
    }
    
    @Test(expected=InvocationTargetException.class)
    public void getConstructorException() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Constructor<Constants> constructor = Constants.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Constants constants = constructor.newInstance();
        System.out.println(constants);
    }
    
}
