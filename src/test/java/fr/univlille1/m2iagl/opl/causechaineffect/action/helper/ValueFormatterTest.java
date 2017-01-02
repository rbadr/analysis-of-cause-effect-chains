package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValueFormatterTest {
    
    /**
     * Test of format method, of class ValueFormatter.
     */
    @Test
    public void testFormat_Object() {
        Object object = "azert\ny or \nqwerty";
        String expResult = "azerty or qwerty";
        String result = ValueFormatter.format(object);
        assertEquals(expResult, result);

    }

    /**
     * Test of format method, of class ValueFormatter.
     */
    @Test
    public void testFormat_char() {
        char c = 'a';
        String expResult = "a";
        String result = ValueFormatter.format(c);
        assertEquals(expResult, result);

    }

    /**
     * Test of format method, of class ValueFormatter.
     */
    @Test
    public void testFormat_short() {
        short s = 0;
        String expResult = "0";
        String result = ValueFormatter.format(s);
        assertEquals(expResult, result);

    }

    /**
     * Test of format method, of class ValueFormatter.
     */
    @Test
    public void testFormat_int() {
        int i = 0;
        String expResult = "0";
        String result = ValueFormatter.format(i);
        assertEquals(expResult, result);

    }

    /**
     * Test of format method, of class ValueFormatter.
     */
    @Test
    public void testFormat_long() {
        long l = 0L;
        String expResult = "0";
        String result = ValueFormatter.format(l);
        assertEquals(expResult, result);

    }

    /**
     * Test of format method, of class ValueFormatter.
     */
    @Test
    public void testFormat_float() {
        float f = 0.0F;
        String expResult = "0.0";
        String result = ValueFormatter.format(f);
        assertEquals(expResult, result);

    }

    /**
     * Test of format method, of class ValueFormatter.
     */
    @Test
    public void testFormat_double() {
        double d = 0.0;
        String expResult = "0.0";
        String result = ValueFormatter.format(d);
        assertEquals(expResult, result);

    }
    
    @Test(expected=InvocationTargetException.class)
    public void getConstructorException() throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
        Constructor<ValueFormatter> constructor = ValueFormatter.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ValueFormatter valueFormatter = constructor.newInstance();
        System.out.println(valueFormatter);
    }
    
}
