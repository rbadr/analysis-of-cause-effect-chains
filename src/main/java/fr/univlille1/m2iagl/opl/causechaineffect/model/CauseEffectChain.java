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

		varNames = new ArrayList<>();
		rightValues = new ArrayList<>();
		wrongValues = new ArrayList<>();

		this.exceptionType = exceptionType;
	}

	@Override
	public String toString(){
            StringBuilder bld = new StringBuilder();
            for(int i=0;i<breakpointArray.length();i++){
                bld.append("At ").append(breakpointArray.get(i).toString()).append(" : \n\t");
                if(varNames.get(i).isEmpty()){
                    bld.append("No variables values differences");
                }
                
                for(int j=0;j<varNames.get(i).size();j++){
                    String varName = varNames.get(i).get(j);
                    bld.append(varName).append(" was ").append(ValueFormatter.format(wrongValues.get(i).get(j))).append(" - ");
                    if(rightValues.get(i).get(j) != null){
                        bld.append(ValueFormatter.format(rightValues.get(i).get(j))).append(" with a right input,");
                    } 
                    else {
                        bld.append("With the right input(s), the program did not reach that point,");
                    }
                    bld.append("\n\t");
                }
                bld.append("\n");
            }
            bld.append("Then, the app crashed with a ").append(exceptionType).append("\n");
            return bld.toString();
        }

	public void addEntries(int i, List<String> keys, Map<String, String> rightVarNamesAndValues, Map<String, String> wrongVarNamesAndValues) {
		varNames.add(i, new ArrayList<>(keys));

		List<Object> rValues = new ArrayList<>();
		List<Object> wValues = new ArrayList<>();

		for(String key : keys){
			if(rightVarNamesAndValues != null){
				rValues.add(rightVarNamesAndValues.get(key));
			} else {
				rValues.add(null);
			}
			wValues.add(wrongVarNamesAndValues.get(key));
		}

		this.rightValues.add(i, rValues);
		this.wrongValues.add(i, wValues);
	}
}
