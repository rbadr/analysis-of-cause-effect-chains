package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MyFourthChallengeTest {
    
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
     * Test of getInputFormat method, of class MyFourthChallenge.
     */
    @Test
    public void testGetInputFormat() {
        MyFourthChallenge MyFourthChallenge = new MyFourthChallenge();
        Class expResult = (Class<? extends String>) String.class;
        Class result = MyFourthChallenge.getInputFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInputs method, of class MyFourthChallenge.
     */
    @Test
    public void testGetInputs() {
        MyFourthChallenge MyFourthChallenge = new MyFourthChallenge();
        List expResult = new ArrayList();
        expResult.add("azerty");
        expResult.add("QWERTY");
        List result = MyFourthChallenge.getInputs();
        assertEquals(expResult, result);
    }

    /**
     * Test of doIt method, of class MyFourthChallenge.
     */
    @Test
    public void testDoIt() {
        String input = "azerty";
        MyFourthChallenge instance = new MyFourthChallenge();
        String expResult = "OK";
        String result = instance.doIt(input);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of doIt method, of class MyFourthChallenge.
     */
    @Test(expected=RuntimeException.class)
    public void testDoItRuntimeException() {
        String input = "Azorty";
        MyFourthChallenge instance = new MyFourthChallenge();
        instance.doIt(input);
    }
    
    /**
     * Test of challenge method, of class MyFourthChallenge.
     */
    @Test
    public void testChallenge() {
        String input = "azerty";
        MyFourthChallenge instance = new MyFourthChallenge();
        instance.challenge(input);
        
        String expResult = "";
        String result = outContent.toString();
	assertTrue(result.contains(expResult));
    }
    
    /**
     * Test of challenge method, of class MyFourthChallenge.
     */
    @Test
    public void testChallengeException() {
        String input = "";
        MyFourthChallenge instance = new MyFourthChallenge();
        instance.challenge(input);
        
        String expResult = "";
        String result = outContent.toString();
	assertTrue(result.contains(expResult));
    }
    
}
