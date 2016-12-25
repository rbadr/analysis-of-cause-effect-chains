package fr.univlille1.m2iagl.opl.causechaineffect.main;

import fr.univlille1.m2iagl.opl.causechaineffect.challenge.Challenge;
import fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge;

public class LaunchJDBMain<I> {
	
	public static Challenge challenge = new MyFirstChallenge();
	
	public static void main(String[] args){
		int index = Integer.parseInt(args[0]);
		
		challenge.doIt(challenge.getInputs().get(index));
	}

}
