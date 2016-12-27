package fr.univlille1.m2iagl.opl.causechaineffect.model;

public class Constants {
	
	public final static String PACKAGE_NAME_START = "fr.univlille1.m2iagl.opl.causechaineffect";
	
	public final static String PACKAGE_MAIN = "fr.univlille1.m2iagl.opl.causechaineffect.main";
	public final static String PACKAGE_DEBUGGER = "fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger";
	public final static String JDB_MAIN = "fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain";
	
	public static String SEPARATOR = "/";
	
	public final static long MS_BETWEEN_COMMAND = 300;
	
	public final static String METHOD_ARGUMENTS = "Method arguments";
	public final static String LOCAL_VARIABLES = "Local variables";
	public final static String MAIN = "main";

	public static void init(){
		String os = System.getProperty("os.name").toLowerCase();
		
		if(os.startsWith("win"))
			SEPARATOR = "\\";
		else
			SEPARATOR = "/";
	}
}
