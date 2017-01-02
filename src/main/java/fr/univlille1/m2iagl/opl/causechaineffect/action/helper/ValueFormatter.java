package fr.univlille1.m2iagl.opl.causechaineffect.action.helper;

public class ValueFormatter {

	public static String format(Object object){
		
		return object.toString().replaceAll("\n", "").replaceAll("\\v", "");
	}

	public static String format(char c){
		return Character.toString(c);
	}

	public static String format(short s){
		return Short.toString(s);
	}

	public static String format(int i){
		return Integer.toString(i);
	}

	public static String format(long l){
		return Long.toString(l);
	}

	public static String format(float f){
		return Float.toString(f);
	}

	public static String format(double d){
		return Double.toString(d);
	}
}
