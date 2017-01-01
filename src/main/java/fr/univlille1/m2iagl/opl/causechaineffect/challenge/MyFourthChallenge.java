package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.Arrays;
import java.util.List;

public class MyFourthChallenge implements Challenge<String>{

	@Override
	public Class<? extends String> getInputFormat() {
		return (Class<? extends String>) String.class;
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
		if(A(length) && (B(c) || C(d))){
			return "OK";
		} else {
			throw new RuntimeException("The input does not satisfy the given constraints");
		}
	}
	
	private boolean A(int length){
		return length > 2;
	}
	
	private boolean B(char c){
		return c == 'e';
	}

	private boolean C(char d){
		return Character.isLowerCase(d);
		
	}
	

}
