package fr.univlille1.m2iagl.opl.causechaineffect.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CauseEffectChain {
	
	private List<List<String>> varNames;
	private List<List<Object>> rightValues;
	private List<List<Object>> wrongValues;
	
	private BreakpointArray breakpointArray;
	
	public CauseEffectChain(BreakpointArray breakpointArray){
		this.breakpointArray = breakpointArray;
		
		varNames = new ArrayList<List<String>>();
		rightValues = new ArrayList<List<Object>>();
		wrongValues = new ArrayList<List<Object>>();
	}
	
	@Override
	public String toString(){
	
		String s = "";
		
		for(int i=breakpointArray.length()-1;i>=0;i--){
			s += "At " + breakpointArray.get(i).toString() + " : ";
			
			for(int j=0;j<varNames.get(i).size();j++){
				String varName = varNames.get(i).get(j);
				Object rightValue = rightValues.get(i).get(j);
				Object wrongValue = wrongValues.get(i).get(j);
				
				s += varName + " was " + wrongValue +/* " - type is " + wrongValue.getClass().toString() +*/ "(" + rightValue +/* " - type is " + rightValue.getClass().toString() +*/ " - with a right input), ";
			}
			s += "\n";
		}
		
		s += "Then, the app crashed !\n";
		
		return s;
	}

	public void addEntries(int i, List<String> keys, Map<String, Object> rightVarNamesAndValues, Map<String, Object> wrongVarNamesAndValues) {
		varNames.add(i, new ArrayList<String>(keys));
		
		List<Object> rightValues = new ArrayList<Object>();
		List<Object> wrongValues = new ArrayList<Object>();
		
		for(String key : keys){
			rightValues.add(rightVarNamesAndValues.get(key));
			wrongValues.add(wrongVarNamesAndValues.get(key));
		}
		
		this.rightValues.add(i, rightValues);
		this.wrongValues.add(i, wrongValues);
	}
}
