package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Helper {
    
     private Helper() {
         throw new IllegalAccessError("Helper class");
     }
	
     public static List<String> getKeysWithDifferentValues(Map<String, String> firstMap, Map<String, String> secondMap){
         List<String> keys = new ArrayList<>();
         for(String key : firstMap.keySet()){
             if(!firstMap.get(key).equals(secondMap.get(key)))
                 keys.add(key);
         }
         return keys;
     }
}
