package fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger;

import fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge;
import fr.univlille1.m2iagl.opl.causechaineffect.model.CauseEffectChain;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MyDDebuggerTest {
	
    @Test
    public void testDebugChallenge() throws InterruptedException {
        MyDDebugger mdebugger = new MyDDebugger(true,false);
	MyFirstChallenge MyFirstChallenge = new MyFirstChallenge();
		
        String expResult = "At fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge:7 :";
	CauseEffectChain result = mdebugger.debug(MyFirstChallenge);
        
        assertTrue(result.toString().trim().startsWith(expResult));
    }
}
