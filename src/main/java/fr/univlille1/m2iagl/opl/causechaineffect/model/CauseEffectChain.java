package fr.univlille1.m2iagl.opl.causechaineffect.model;

import fr.univlille1.m2iagl.opl.causechaineffect.action.helper.ValueFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CauseEffectChain {

	private List<List<String>> varNames;
	private List<List<Object>> rightValues;
	private List<List<Object>> wrongValues;

	private BreakpointArray breakpointArray;

	private String exceptionType;

	public CauseEffectChain(BreakpointArray breakpointArray, String exceptionType){
		this.breakpointArray = breakpointArray;

		varNames = new ArrayList<List<String>>();
		rightValues = new ArrayList<List<Object>>();
		wrongValues = new ArrayList<List<Object>>();

		this.exceptionType = exceptionType;
	}

	@Override
	public String toString(){

		String s = "";

		for(int i=0;i<breakpointArray.length();i++){
			s += "At " + breakpointArray.get(i).toString() + " : ";

			ValueFormatter formatter = new ValueFormatter();
			
			if(varNames.get(i).isEmpty()){
				s += "No variables values differences";
			}

			for(int j=0;j<varNames.get(i).size();j++){
				String varName = varNames.get(i).get(j);

				formatter.format(wrongValues.get(i).get(j));
				s += varName + " was " + formatter.getValueToString() + " - ";

				if(rightValues.get(i).get(j) != null){
					formatter.format(rightValues.get(i).get(j));
					s += formatter.getValueToString() + " with a right input,";
				} else {
					s += "With the right input(s), the program did not reach that point,";
				}
				
				s+= "\n\t";
			}
			s += "\n";
		}

		s += "Then, the app crashed with a '" + exceptionType + "' !\n";

		return s;
	}

	public void addEntries(int i, List<String> keys, Map<String, String> rightVarNamesAndValues, Map<String, String> wrongVarNamesAndValues) {
		varNames.add(i, new ArrayList<String>(keys));

		List<Object> rightValues = new ArrayList<Object>();
		List<Object> wrongValues = new ArrayList<Object>();

		for(String key : keys){
			if(rightVarNamesAndValues != null){
				rightValues.add(rightVarNamesAndValues.get(key));
			} else {
				rightValues.add(null);
			}
			wrongValues.add(wrongVarNamesAndValues.get(key));
		}

		this.rightValues.add(i, rightValues);
		this.wrongValues.add(i, wrongValues);
	}
}
