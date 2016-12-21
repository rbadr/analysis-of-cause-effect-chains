package fr.univlille1.m2iagl.opl.causechaineffect.model;

public class BreakpointArray {
	
	Breakpoint[] array;
	
	public BreakpointArray(Breakpoint[] array){
		this.array = array;
	}
	
	public Breakpoint get(int i){
		return array[i];
	}
	
	public int getLineAt(int i){
		return array[i].getLine();
	}
	
	public String getFilenameAt(int i){
		return array[i].getFilename();
	}
	
	public String toString(){
		String s = "[";
		for(int i=0;i<array.length - 1;i++){
			s += getFilenameAt(i) + ":" + getLineAt(i) + ", ";
		}
		
		s += getFilenameAt(array.length - 1) + ":" + getLineAt(array.length - 1) + "]";
		
		
		return s;
	}
	
	public int length(){
		return array.length;
	}

}
