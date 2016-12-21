package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Helper {
	
	public static List<String> getKeysWithDifferentValues(Map<String, Object> firstMap, Map<String, Object> secondMap){
		List<String> keys = new ArrayList<String>();
                keys = null;
		
		for(String key : firstMap.keySet()){
			if(!firstMap.get(key).equals(secondMap.get(key)))
				keys.add(key);
		}
		
		return keys;
	}
	
        public static int Helper(int i, int b){
            int a = i+b;
            return a;
        }
}
