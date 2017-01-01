package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MyFirstChallengeTest {
	
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
     * Test of getInputFormat method, of class MyFirstChallenge.
     */
    @Test
    public void getInputFormat_NewInstance_ShouldReturnIntegerClass() {
        MyFirstChallenge myfirstChallenge = new MyFirstChallenge();
        Class expResult = String.class;
        Class result = myfirstChallenge.getInputFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInputs method, of class MyFirstChallenge.
     */
    @Test
    public void getInputs_NewInstance_ShouldReturnOneAzerty() {
        MyFirstChallenge myFirstChallenge = new MyFirstChallenge();
        List expResult = new ArrayList();
        expResult.add("1");
        expResult.add("azerty");
        List result = myFirstChallenge.getInputs();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDoIt() throws IOException{
        MyFirstChallenge myFirstChallenge = new MyFirstChallenge();
        String input = "7";
        myFirstChallenge.challenge(input);
        
        Object expResult = 7;
        Object result = myFirstChallenge.doIt(input);
        assertEquals(expResult, result);

    }
    
    @Test
    public void challengeThrowException() throws IOException {
	    MyFirstChallenge myFirstChallenge = new MyFirstChallenge();
	    String myset = "test";
	    
	    myFirstChallenge.challenge(myset);
	    String expResult = "exception",result = outContent.toString().trim();
	    
	    assertTrue(result.endsWith(expResult));
    }

    /**
     * Test of doIt method, of class MyFirstChallenge.
     */
    @Test
    public void doIt_ObjectInput_ShouldReturnIntegerInput() {
        String input = "7";
        MyFirstChallenge myFirstChallenge = new MyFirstChallenge();
        Object expResult = 7;
        Object result = myFirstChallenge.doIt(input);
        assertEquals(expResult, result);
    }
    
}
