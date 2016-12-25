package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

import java.util.Arrays;

public class ValueFormatter {
	
	private String valueToString;
	private String typeName;
	
	public void format(Object value){
		valueToString = value.toString().replaceAll("[\n|\r]*", "");
		typeName = value.getClass().getName();
	}
	
	public void format(char value){
		valueToString = value + "";
		typeName = "char";
	}
	
	public void format(short value){
		valueToString = value + "";
		typeName = "short";
	}
	
	public void format(int value){
		valueToString = value + "";
		typeName = "int";
	}
	
	public void format(long value){
		valueToString = value + "";
		typeName = "long";
	}
	
	public void format(float value){
		valueToString = value + "";
		typeName = "float";
	}
	
	public void format(double value){
		valueToString = value + "";
		typeName = "double";
	}
	
	public String getValueToString(){
		return valueToString;
	}
	
	public String getTypeName(){
		return typeName;
	}
}
