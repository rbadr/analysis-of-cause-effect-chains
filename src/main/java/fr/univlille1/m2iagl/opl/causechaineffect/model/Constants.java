package fr.univlille1.m2iagl.opl.causechaineffect.model;

public class Constants {
    
    public static String separator = "/";
    public static String folder = System.getProperty("user.dir") + Constants.separator + "target" + Constants.separator + "classes";
    
    private Constants() {
         throw new IllegalAccessError("Constants class");
    }

    public static final String PACKAGE_NAME_START = "fr.univlille1.m2iagl.opl.causechaineffect";
	
    public static final  String PACKAGE_MAIN = "fr.univlille1.m2iagl.opl.causechaineffect.main";
    public static final  String PACKAGE_DEBUGGER = "fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger";
    public static final  String JDB_MAIN = "fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBMain";
	
    public static final  long MS_BETWEEN_COMMAND = 500;
	
    public static final  String METHOD_ARGUMENTS = "Method arguments";
    public static final  String LOCAL_VARIABLES = "Local variables";
    public static final  String MAIN = "main";
	
    public static final  String CANAL_MESSAGE = "Le canal de communication est sur le point d'être fermé";
    public static final  String INSTANCE_OF = "instance of";
    
    public static void init(){
        String os = System.getProperty("os.name").toLowerCase();
        if(os.startsWith("win"))
            separator = "\\";
        else
            separator = "/";
    }
}
