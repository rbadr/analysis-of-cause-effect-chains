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

public class MyFifthChallengeTest {
    
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
     * Test of getInputFormat method, of class MyFifthChallenge.
     */
    @Test
    public void testGetInputFormat() {
        MyFifthChallenge instance = new MyFifthChallenge();
        Class<? extends String> expResult = String.class;
        Class<? extends String> result = instance.getInputFormat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInputs method, of class MyFifthChallenge.
     */
    @Test
    public void testGetInputs() {
        MyFifthChallenge instance = new MyFifthChallenge();
        List expResult = new ArrayList();
        expResult.add("Ceci est un texte ou il faut savoir quelle est la lettre la plus utilisee");
        expResult.add("Cecî est un texte où il faut savoir quelle est la lettre la plus utilisée");
        List<String> result = instance.getInputs();
        assertEquals(expResult, result);
    }

    /**
     * Test of doIt method, of class MyFifthChallenge.
     */
    @Test
    public void testDoIt() {
        String input = "thisisonlyatest";
        MyFifthChallenge instance = new MyFifthChallenge();
        String expResult = "The most used character is s with 3 uses !";
        String result = instance.doIt(input);
        assertEquals(expResult, result);
    }
    
        @Test
    public void testDoItNull() {
        String input = "";
        MyFifthChallenge instance = new MyFifthChallenge();
        String expResult = "The most used character is A with 0 uses !";
        String result = instance.doIt(input);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of challenge method, of class MyFifthChallenge.
     */
    @Test
    public void testChallenge() {
        String input = "azerty";
        MyFifthChallenge instance = new MyFifthChallenge();
        instance.challenge(input);
        
        String expResult = "";
        String result = outContent.toString();
	assertTrue(result.contains(expResult));
    }
    
    /**
     * Test of challenge method, of class MyFifthChallenge.
     */
    @Test
    public void testChallengeException() {
        String input = null;
        MyFifthChallenge instance = new MyFifthChallenge();
        instance.challenge(input);
        
        String expResult = "";
        String result = outContent.toString();
	assertTrue(result.contains(expResult));
    }
    
}
