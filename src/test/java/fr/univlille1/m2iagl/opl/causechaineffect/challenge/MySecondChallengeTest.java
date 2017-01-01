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
    public void getInputFormat_NewInstance_ShouldReturnStringTClass() {
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        Class expResult = String[].class;
        Class result = mysecondChallenge.getInputFormat();
        assertEquals(expResult, result);
    }
    
            /**
     * Test of getInputs method, of class MyThirdChallenge.
     */
    @Test
    public void testGetInputs() {
        MySecondChallenge MySecondChallenge = new MySecondChallenge();
        List<String[]> expResult = new ArrayList<String[]>();
        List result = MySecondChallenge.getInputs();
    }
    
    @Test
    public void testDoIt(){
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        String[] input = new String[]{"azerty", "t"};
        mysecondChallenge.challenge(input);
        
        String expResult = "Char t can be found in azerty at 4";
        Object result = mysecondChallenge.doIt(input);
        assertEquals(expResult, result);

    }
    
    @Test
    public void challengeThrowException() {
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        String[] myset = new String[]{};
        
        mysecondChallenge.challenge(myset);
        String expResult = "exception";
        String result = outContent.toString().trim();
	    
	assertTrue(result.endsWith(expResult));
    }

    /**
     * Test of doIt method, of class MySecondChallenge.
     */
    @Test
    public void doIt_ObjectInput_ShouldReturnIntegerInput() {
        String[] input = new String[]{"azerty", "t"};
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        String expResult = "Char t can be found in azerty at 4";
        Object result = mysecondChallenge.doIt(input);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of doIt method, of class MySecondChallenge.
     */
    @Test
    public void doIt_InvalidObjectInput_ShouldReturnNull() {
        String[] input = new String[]{"azerty", "t"};
        MySecondChallenge mysecondChallenge = new MySecondChallenge();
        String expResult = "Char t can be found in azerty at 4";
        Object result = mysecondChallenge.doIt(input);
        assertEquals(expResult, result);
    }
    
}
