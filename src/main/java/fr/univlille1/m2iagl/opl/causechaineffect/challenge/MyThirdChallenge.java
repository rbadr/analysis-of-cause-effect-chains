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
			//e.printStackTrace();
		}
	}
	
	@Override
	public Object doIt(String[] input){
		return recursive(0, input);
	}
	
	private String recursive(int i, String[] input){
		String word = input[0];
		char c = input[1].charAt(0);

		if(word.charAt(i) == c)
			return "Char " + c + " can be found in " + word + " at " + i;		
		return recursive(i+1, input);
	}
}
