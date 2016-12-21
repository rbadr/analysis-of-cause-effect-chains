package fr.univlille1.m2iagl.opl.causechaineffect.main;

import fr.univlille1.m2iagl.opl.causechaineffect.challenge.Challenge;
import fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge;

public class LaunchJDBWrongInputMain {
	
	public static Challenge challenge = new MyFirstChallenge();
	public static Object input = "azerty";
	
	public static void main(String[] args){
		System.out.println("Input : " + input);
		challenge.doIt(input);
	}

}
