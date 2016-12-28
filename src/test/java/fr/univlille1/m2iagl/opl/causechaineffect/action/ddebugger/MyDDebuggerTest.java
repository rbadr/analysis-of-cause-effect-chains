package fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge;
import fr.univlille1.m2iagl.opl.causechaineffect.model.CauseEffectChain;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;

public class MyDDebuggerTest {
	@Test
    public void testDebugChallenge() {
		MyDDebugger mdebugger = new MyDDebugger();
		MyFirstChallenge myfirstChallenge = new MyFirstChallenge();

		 System.setProperty("os.name","linux");
         Constants.init();
		
		String expResult = "At fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge:33 :";
		CauseEffectChain result = mdebugger.debug(myfirstChallenge);
        
        assertTrue(result.toString().trim().startsWith(expResult));
    }
}
