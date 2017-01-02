package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.Arrays;
import java.util.List;

public class MyThirdChallenge implements Challenge<String[]> {

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
		return recursive(0, input[0], input[1].charAt(0));
	}
	
	private String recursive(int i, String word, char c){

		if(word.charAt(i) == c)
			return "Char " + c + " can be found in " + word + " at " + i;		
		return recursive(i+1, word, c);
	}
}
