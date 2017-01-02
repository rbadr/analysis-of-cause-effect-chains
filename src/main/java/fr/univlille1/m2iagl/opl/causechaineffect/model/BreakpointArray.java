package fr.univlille1.m2iagl.opl.causechaineffect.model;

import java.util.Arrays;

public class BreakpointArray {
	
	Breakpoint[] array;
	
	public BreakpointArray(Breakpoint[] array){
		this.array = array;
	}
	
	public void remove(int i){
		Breakpoint[] tmp = new Breakpoint[array.length-1];
		
		Breakpoint[] tmpBegin = Arrays.copyOfRange(array, 0, i);
		Breakpoint[] tmpEnd = Arrays.copyOfRange(array, i+1, array.length);
		System.arraycopy(tmpBegin, 0, tmp, 0, tmpBegin.length);
        System.arraycopy(tmpEnd, 0, tmp, i, tmpEnd.length);
        
        array = tmp;
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
	
        @Override
	public String toString(){
            StringBuilder bld = new StringBuilder();
            bld.append("[");
            for(int i=0;i<array.length - 1;i++){
                bld.append(getFilenameAt(i)).append(":").append(getLineAt(i)).append(", ");
            }
            bld.append(getFilenameAt(array.length - 1)).append(":").append(getLineAt(array.length - 1)).append("]");
            return bld.toString();
	}
	
	public int length(){
		return array.length;
	}

}
