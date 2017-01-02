package fr.univlille1.m2iagl.opl.causechaineffect.main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.Test;

public class LaunchJDBMainTest {
    
    /**
     * Test of main method, of class LaunchJDBMain.
     */
    @Test(expected=NumberFormatException.class)
    public void testMain() {
        String[] args = new String[1];
        args[0]="1";
        LaunchJDBMain.main(args);
    }
    
        /**
     * Test of main method, of class LaunchJDBMain.
     */
    @Test(expected=InvocationTargetException.class)
    public void testMainException() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Constructor<LaunchJDBMain> constructor = LaunchJDBMain.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        LaunchJDBMain launchJDBMain = constructor.newInstance();
        System.out.println(launchJDBMain);

    }
    
}
