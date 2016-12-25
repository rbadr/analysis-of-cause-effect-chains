package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.lang.reflect.Field;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValueFormatterTest {

    /**
     * Test of format method, of class ValueFormatter.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testFormat_Object() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Object value = "this is a string";
        ValueFormatter instance = new ValueFormatter();
        instance.format(value);
        
        Field valueToString = ValueFormatter.class.getDeclaredField("valueToString");
        Field typeName = ValueFormatter.class.getDeclaredField("typeName");
        
        valueToString.setAccessible(true);
        typeName.setAccessible(true);
        
        String valueToStringResult = valueToString.get(instance).toString();
        String typeNameResult = typeName.get(instance).toString();
        
        
        String valueToStringExpResult= value + "";
        String typeNameExpResult= "java.lang.String";
        
        assertEquals(valueToStringExpResult, valueToStringResult);
        assertEquals(typeNameExpResult, typeNameResult);  


    }

    /**
     * Test of format method, of class ValueFormatter.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testFormat_char() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        char value = ' ';
        ValueFormatter instance = new ValueFormatter();
        instance.format(value);
        
        Field valueToString = ValueFormatter.class.getDeclaredField("valueToString");
        Field typeName = ValueFormatter.class.getDeclaredField("typeName");
        
        valueToString.setAccessible(true);
        typeName.setAccessible(true);
        
        String valueToStringResult = valueToString.get(instance).toString();
        String typeNameResult = typeName.get(instance).toString();
        
        
        String valueToStringExpResult= value + "";
        String typeNameExpResult= "char";
        
        assertEquals(valueToStringExpResult, valueToStringResult);
        assertEquals(typeNameExpResult, typeNameResult);  

    }

    /**
     * Test of format method, of class ValueFormatter.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testFormat_short() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        short value = 0;
        ValueFormatter instance = new ValueFormatter();
        instance.format(value);
        
        Field valueToString = ValueFormatter.class.getDeclaredField("valueToString");
        Field typeName = ValueFormatter.class.getDeclaredField("typeName");
        
        valueToString.setAccessible(true);
        typeName.setAccessible(true);
        
        String valueToStringResult = valueToString.get(instance).toString();
        String typeNameResult = typeName.get(instance).toString();
        
        
        String valueToStringExpResult= value + "";
        String typeNameExpResult= "short";
        
        assertEquals(valueToStringExpResult, valueToStringResult);
        assertEquals(typeNameExpResult, typeNameResult);  
    }

    /**
     * Test of format method, of class ValueFormatter.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testFormat_int() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        int value = 0;
        ValueFormatter instance = new ValueFormatter();
        instance.format(value);
        
        Field valueToString = ValueFormatter.class.getDeclaredField("valueToString");
        Field typeName = ValueFormatter.class.getDeclaredField("typeName");
        
        valueToString.setAccessible(true);
        typeName.setAccessible(true);
        
        String valueToStringResult = valueToString.get(instance).toString();
        String typeNameResult = typeName.get(instance).toString();
        
        
        String valueToStringExpResult= value + "";
        String typeNameExpResult= "int";
        
        assertEquals(valueToStringExpResult, valueToStringResult);
        assertEquals(typeNameExpResult, typeNameResult);  
    }

    /**
     * Test of format method, of class ValueFormatter.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testFormat_long() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        long value = 0L;
        ValueFormatter instance = new ValueFormatter();
        instance.format(value);
        
        Field valueToString = ValueFormatter.class.getDeclaredField("valueToString");
        Field typeName = ValueFormatter.class.getDeclaredField("typeName");
        
        valueToString.setAccessible(true);
        typeName.setAccessible(true);
        
        String valueToStringResult = valueToString.get(instance).toString();
        String typeNameResult = typeName.get(instance).toString();
        
        
        String valueToStringExpResult= value + "";
        String typeNameExpResult= "long";
        
        assertEquals(valueToStringExpResult, valueToStringResult);
        assertEquals(typeNameExpResult, typeNameResult);  
    }

    /**
     * Test of format method, of class ValueFormatter.
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchFieldException
     */
    @Test
    public void testFormat_float() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        float value = 0.0F;
        ValueFormatter instance = new ValueFormatter();
        instance.format(value);
        
        Field valueToString = ValueFormatter.class.getDeclaredField("valueToString");
        Field typeName = ValueFormatter.class.getDeclaredField("typeName");
        
        valueToString.setAccessible(true);
        typeName.setAccessible(true);
        
        String valueToStringResult = valueToString.get(instance).toString();
        String typeNameResult = typeName.get(instance).toString();
        
        
        String valueToStringExpResult= value + "";
        String typeNameExpResult= "float";
        
        assertEquals(valueToStringExpResult, valueToStringResult);
        assertEquals(typeNameExpResult, typeNameResult);  
    }

    /**
     * Test of format method, of class ValueFormatter.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testFormat_double() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        double value = 0.0;
        ValueFormatter instance = new ValueFormatter();
        instance.format(value);
        
        Field valueToString = ValueFormatter.class.getDeclaredField("valueToString");
        Field typeName = ValueFormatter.class.getDeclaredField("typeName");
        
        valueToString.setAccessible(true);
        typeName.setAccessible(true);
        
        String valueToStringResult = valueToString.get(instance).toString();
        String typeNameResult = typeName.get(instance).toString();
        
        
        String valueToStringExpResult= value + "";
        String typeNameExpResult= "double";
        
        assertEquals(valueToStringExpResult, valueToStringResult);
        assertEquals(typeNameExpResult, typeNameResult);       
    }

    /**
     * Test of getValueToString method, of class ValueFormatter.
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchFieldException
     */
    @Test
    public void testGetValueToString() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        ValueFormatter valueFormatter = new ValueFormatter();
        
        //use reflexion to access private field
        Field field = ValueFormatter.class.getDeclaredField("valueToString");
        field.setAccessible(true);
        field.set(valueFormatter, "testValueToString");
        
        String expResult = "testValueToString";
        String result = valueFormatter.getValueToString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTypeName method, of class ValueFormatter.
     * @throws java.lang.NoSuchFieldException
     * @throws java.lang.IllegalAccessException
     */
    @Test
    public void testGetTypeName() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        ValueFormatter valueFormatter = new ValueFormatter();
        
        //use reflexion to access private field
        Field field = ValueFormatter.class.getDeclaredField("typeName");
        field.setAccessible(true);
        field.set(valueFormatter, "testTypeName");
        
        String expResult = "testTypeName";
        String result = valueFormatter.getTypeName();
        assertEquals(expResult, result);
    }
    
}
