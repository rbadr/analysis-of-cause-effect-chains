package fr.univlille1.m2iagl.opl.causechaineffect.main;

import fr.univlille1.m2iagl.opl.causechaineffect.challenge.Challenge;
import fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge;

public class LaunchJDBMain {
    
    public static final Challenge<String> Challenge = new MyFirstChallenge();
	
    private LaunchJDBMain() {
        throw new IllegalAccessError("LaunchJDBMain class");
    }
    
    public static void main(String[] args){
        int index = Integer.parseInt(args[0]);
        Challenge.doIt(Challenge.getInputs().get(index));}
}