package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.Arrays;
import java.util.List;


public class MyFirstChallenge implements Challenge<String> {

	@Override
	public Class<? extends String> getInputFormat() {
		return String.class;
	}

	@Override
	public List<String> getInputs() {
		return Arrays.asList(new String[]{"1", "azerty"});
	}

	@Override
	public void challenge(String input) {
		try {
			System.out.println("Do it " + input);
			doIt(input);
		} catch (Exception e) {
			System.out.println("exception");
		}
	}

	@Override
	public Object doIt(String input){
		return Integer.parseInt(input);
	}
}
