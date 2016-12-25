package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MyFirstChallengeTest {

    /**
     * Test of getInputFormat method, of class MyFirstChallenge.
     */
    @Test
    public void getInputFormat_NewInstance_ShouldReturnIntegerClass() {
        MyFirstChallenge myfirstChallenge = new MyFirstChallenge();
        Class expResult = Integer.class;
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

    /**
     * Test of getJavaProgram method, of class MyFirstChallenge.
     */
    @Test
    public void getJavaProgram_NewInstance_ShouldReturnDoIt() {
        MyFirstChallenge myFirstChallenge = new MyFirstChallenge();
        String expResult = "public Object doIt(String input){ return Integer.parseInt(input)}";
        String result = myFirstChallenge.getJavaProgram();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDoIt(){
        MyFirstChallenge myFirstChallenge = new MyFirstChallenge();
        Object input = "7";
        myFirstChallenge.challenge(input);
        
        Object expResult = 7;
        Object result = myFirstChallenge.doIt(input);
        assertEquals(expResult, result);

    }
    
    @Test
    public void challengeThrowException() {
    MyFirstChallenge myFirstChallenge = new MyFirstChallenge();

    Set myset = new HashSet();
    
    myFirstChallenge.challenge(myset);
  }

    /**
     * Test of doIt method, of class MyFirstChallenge.
     */
    @Test
    public void doIt_ObjectInput_ShouldReturnIntegerInput() {
        Object input = "7";
        MyFirstChallenge myFirstChallenge = new MyFirstChallenge();
        Object expResult = 7;
        Object result = myFirstChallenge.doIt(input);
        assertEquals(expResult, result);
    }
    
}
