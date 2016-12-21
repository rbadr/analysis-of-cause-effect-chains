package fr.univlille1.m2iagl.opl.causechaineffect.main;

import fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger.DDebugger;
import fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger.MyDDebugger;
import fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;
	
public class Main {

	public static void main(String[] args) {
		
		Constants.init();
		
		DDebugger<?> d = new MyDDebugger();
		System.out.println(d.debug(new MyFirstChallenge()));	
	}
}
