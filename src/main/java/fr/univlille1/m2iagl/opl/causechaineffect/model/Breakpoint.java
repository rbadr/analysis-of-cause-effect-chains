package fr.univlille1.m2iagl.opl.causechaineffect.model;

public class Breakpoint {
	
	private int line;
	private String filename;
	
	public Breakpoint(int line, String filename){
		this.line = line;
		this.filename = filename;
	}
	
	public int getLine(){
		return line;
	}
	
	public String getFilename(){
		return filename;
	}
	
	@Override
	public String toString(){
		return filename + ":" + line;
	}

}
