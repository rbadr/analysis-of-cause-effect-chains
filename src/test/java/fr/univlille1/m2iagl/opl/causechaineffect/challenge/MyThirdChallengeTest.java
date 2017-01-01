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

public class MyThirdChallengeTest {

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
     * Test of getInputFormat method, of class MyThirdChallenge.
     */
    @Test
    public void testGetInputFormat() {
        MyThirdChallenge mythirdChallenge = new MyThirdChallenge();
        Class expResult = String[].class;
        Class result = mythirdChallenge.getInputFormat();
        assertEquals(expResult, result);
    }

        /**
     * Test of getInputs method, of class MyThirdChallenge.
     */
    @Test
    public void testGetInputs() {
        MyThirdChallenge MyThirdChallenge = new MyThirdChallenge();
        List<String[]> expResult = new ArrayList<String[]>();
        List result = MyThirdChallenge.getInputs();
    }
    
    /**
     * Test of challenge method, of class MyThirdChallenge.
     */
    @Test
    public void testChallenge() {
        String[] input = new String[]{"azerty", "t"};
        MyThirdChallenge instance = new MyThirdChallenge();
        String expResult = "";
        instance.challenge(input);
        String result = outContent.toString().trim();
	    
	assertTrue(result.contains(expResult));
    }
    
    @Test
    public void challengeThrowException() {
        MyThirdChallenge MyThirdChallenge = new MyThirdChallenge();
        String[] myset = new String[]{};
        
        MyThirdChallenge.challenge(myset);
        String expResult = "exception";
        String result = outContent.toString().trim();
	    
	assertTrue(result.endsWith(expResult));
    }

    /**
     * Test of doIt method, of class MyThirdChallenge.
     */
    @Test
    public void testDoIt() {
        String[] input = new String[]{"azerty", "t"};
        MyThirdChallenge instance = new MyThirdChallenge();
        String expResult = "Char t can be found in azerty at 4";
        Object result = instance.doIt(input);
        assertEquals(expResult, result);
    }
    
}
