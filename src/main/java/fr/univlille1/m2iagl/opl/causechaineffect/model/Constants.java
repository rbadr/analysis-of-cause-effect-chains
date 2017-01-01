package fr.univlille1.m2iagl.opl.causechaineffect.model;

public class Constants {
	
	public final static String PACKAGE_NAME_START = "fr.univlille1.m2iagl.opl.causechaineffect";
	
	public final static String PACKAGE_MAIN = "fr.univlille1.m2iagl.opl.causechaineffect.main";
	public final static String PACKAGE_DEBUGGER = "fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger";
	public final static String JDB_MAIN = "fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain";
	
	public static String SEPARATOR = "/";
	
	public final static long MS_BETWEEN_COMMAND = 500;
	
	public final static String METHOD_ARGUMENTS = "Method arguments";
	public final static String LOCAL_VARIABLES = "Local variables";
	public final static String MAIN = "main";
	
	public final static String CANAL_MESSAGE = "Le canal de communication est sur le point d'être fermé";
	
	public final static String INSTANCE_OF = "instance of";
	
	public static String FOLDER = System.getProperty("user.dir") + Constants.SEPARATOR + "target" + Constants.SEPARATOR + "classes";

	public static void init(){
		String os = System.getProperty("os.name").toLowerCase();
		
		if(os.startsWith("win"))
			SEPARATOR = "\\";
		else
			SEPARATOR = "/";
	}
}
