package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFifthChallenge implements Challenge<String>{

	@Override
	public Class<? extends String> getInputFormat() {
		return String.class;
	}

	@Override
	public List<String> getInputs() {
		return Arrays.asList(new String[]{"Ceci est un texte ou il faut savoir quelle est la lettre la plus utilisee",
				"Cecî est un texte où il faut savoir quelle est la lettre la plus utilisée"});
	}
	
	@Override
	public void challenge(String input) {
		try {
			doIt(input);
		} catch (Exception e) {
			System.out.println("exception");
		}
	}

	@Override
	public String doIt(String input) {
		Map<Character, Integer> charCpt = new HashMap<>();
		initMap(charCpt);
		
		return recursif(input, charCpt);
	}
	
	private String recursif(String input, Map<Character, Integer> charCpt){
		if(("").equals(input)){
			char c = getCharMostUsed(charCpt);
			return "The most used character is " + c + " with " + charCpt.get(c) + " uses !";
		}
		treatChar(charCpt, input.charAt(0));
		
		return recursif(input.substring(1, input.length()), charCpt);
	}
	
	private void treatChar(Map<Character, Integer> charCpt, char c){
		if(c != ' ')
			incrementsCharCpt(charCpt, c);
	}
	
	private void incrementsCharCpt(Map<Character, Integer> charCpt, char c){
		charCpt.put(c, charCpt.get(c) + 1);
	}
	
	private void initMap(Map<Character, Integer> charCpt){
		for(int i='a';i<'z'+1;i++){
			charCpt.put((char) i, 0);
		}
		for(int i='A';i<'Z'+1;i++){
			charCpt.put((char) i, 0);
		}
	}
	
	private char getCharMostUsed(Map<Character, Integer> charCpt){
		List<Character> keyList = new ArrayList<>(charCpt.keySet());
		
		char c = keyList.get(0);
		int value = charCpt.get(c);
		
		for(int i=1;i<keyList.size();i++){
			char cTmp = keyList.get(i);
			int valueTmp = charCpt.get(cTmp);
			if(valueTmp > value){
				c = cTmp;
				value = valueTmp;
			}
		}
		
		return c;
	}

	



}
