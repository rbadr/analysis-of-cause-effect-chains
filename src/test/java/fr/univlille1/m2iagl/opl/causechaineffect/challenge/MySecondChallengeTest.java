package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MySecondChallengeTest {
	
private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
		System.setOut(null);
		System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}

    /**
     * Test of getInputFormat method, of class MySecondChallenge.
     */
    @Test
    public void getInputFormat_NewInstance_ShouldReturnIntegerClass() {
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        Class expResult = Integer.class;
        Class result = mysecondChallenge.getInputFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInputs method, of class MySecondChallenge.
     */
    @Test
    public void getInputs_NewInstance_ShouldReturnOneAndTest() {
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        List expResult = new ArrayList();
        expResult.add("1");
        expResult.add("test");
        List result = mysecondChallenge.getInputs();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJavaProgram method, of class MySecondChallenge.
     */
    @Test
    public void getJavaProgram_NewInstance_ShouldReturnDoIt() {
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        String expResult = "public Object doIt(String input){ return Integer.parseInt(input)}";
        String result = mysecondChallenge.getJavaProgram();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDoIt(){
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        Object input = "7";
        mysecondChallenge.challenge(input);
        
        Object expResult = 7;
        Object result = mysecondChallenge.doIt(input);
        assertEquals(expResult, result);

    }
    
    @Test
    public void challengeThrowException() {
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        Set myset = new HashSet();
        
        mysecondChallenge.challenge(myset);
        String expResult = "exception", result = outContent.toString().trim();
	    
	    assertTrue(result.endsWith(expResult));
    }

    /**
     * Test of doIt method, of class MySecondChallenge.
     */
    @Test
    public void doIt_ObjectInput_ShouldReturnIntegerInput() {
        Object input = "7";
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        Object expResult = 7;
        Object result = mysecondChallenge.doIt(input);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of doIt method, of class MySecondChallenge.
     */
    @Test
    public void doIt_InvalidObjectInput_ShouldReturnNull() {
        Object input = "a";
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        Object expResult = null;
        Object result = mysecondChallenge.doIt(input);
        assertEquals(expResult, result);
    }
    
}
