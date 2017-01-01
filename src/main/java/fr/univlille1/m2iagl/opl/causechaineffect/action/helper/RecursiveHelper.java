package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.util.HashMap;
import java.util.Map;

public class RecursiveHelper {
	
	Map<String, Integer> nbTimes;
	
	public RecursiveHelper(){
		nbTimes = new HashMap<String, Integer>();
	}
	
	public int get(String s){
		if(!nbTimes.containsKey(s)){
			nbTimes.put(s, 1);
		} else {
			nbTimes.put(s, nbTimes.get(s) + 1);
		}
		
		return nbTimes.get(s);
		
	}
}
