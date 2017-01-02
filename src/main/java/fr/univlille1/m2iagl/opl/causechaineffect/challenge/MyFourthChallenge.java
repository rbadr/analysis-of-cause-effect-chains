package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.Arrays;
import java.util.List;

public class MyFourthChallenge implements Challenge<String>{

	@Override
	public Class<? extends String> getInputFormat() {
		return String.class;
	}

	@Override
	public List<String> getInputs() {
		return Arrays.asList(new String[]{"azerty", "QWERTY"});
	}
	
	@Override
	public void challenge(String input) {
		try {
			doIt(input);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public String doIt(String input){
		return checkString(input.length(), input.charAt(2), input.charAt(0));
	}
	
	private String checkString(int length, char c, char d){
		if(lenghtSuperiorToTwo(length) && (charEqualE(c) || runTime(d))){
			return "OK";
		} else {
			return "Wrong";
		}
	}
	
	private boolean lenghtSuperiorToTwo(int length){
		return length > 2;
	}
	
	private boolean charEqualE(char c){
		return c == 'e';
	}

	private boolean runTime(char d){
		throw new RuntimeException("The input does not satisfy the given constraints");
		
	}
}
