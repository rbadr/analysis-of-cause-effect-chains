package fr.univlille1.m2iagl.opl.causechaineffect.model;

public class Breakpoint {
	
	private int line;
	private String filename;
	private int nb;
	
	public Breakpoint(int line, String filename, int nb){
		this.line = line;
		this.filename = filename;
		this.nb = nb;
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
	
	public int getNb(){
		return nb;
	}

}
