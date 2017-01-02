package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.Arrays;
import java.util.List;


public class MySecondChallenge implements Challenge<String[]> {

	@Override
	public Class<? extends String[]> getInputFormat() {
		return String[].class;
	}

	@Override
	public List<String[]> getInputs() {
		return Arrays.asList(new String[][]{new String[]{"azerty", "t"}, new String[]{"azerty", "c"}});
	}

	@Override
	public void challenge(String[] input) {
		try {
			doIt(input);
		} catch (Exception e) {
			System.out.println("exception");
		}
	}

	@Override
	public Object doIt(String[] input){
		String word = input[0];
		char c = input[1].charAt(0);
		
		int i=0;
		
		while(word.charAt(i) != c){
			i++;
		}
		return "Char " + c + " can be found in " + word + " at " + i;
	}
}
