package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.Arrays;
import java.util.List;


public class MyFirstChallenge<I> implements Challenge<I> {

	public Class<? extends I> getInputFormat() {
		return (Class<? extends I>) Integer.class;
	}

	public List getInputs() {
		return Arrays.asList(new String[]{"test"});
	}

	public String getJavaProgram() {
		return "public Object doIt(String input){ return Integer.parseInt(input)}";
	}

	public void challenge(I input) {
		try {
			System.out.println("Do it " + input);
			doIt(input);
		} catch (Exception e) {
			System.out.println("exception");
			//e.printStackTrace();
		}
	}

	public Object doIt(I input){
		String inputToParse = (String) input;
		return Integer.parseInt(inputToParse);
	}
}
