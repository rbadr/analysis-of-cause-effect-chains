package fr.univlille1.m2iagl.opl.causechaineffect.main;

import fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger.DDebugger;
import fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger.MyDDebugger;
import fr.univlille1.m2iagl.opl.causechaineffect.challenge.MyFirstChallenge;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;

public class Main {
    
    private Main() { throw new IllegalAccessError("Main class");}
    
    public static void main(String[] args) {
        Constants.init();
        boolean verbose = false;
        boolean allVars = false;
        for (String arg : args) {
            if (("-v").equals(arg)) 
            {verbose = true;} 
            else if (("-a").equals(arg)) 
            {allVars = true;}}
        
        DDebugger<String> d = new MyDDebugger<>(verbose, allVars);
        System.out.println(d.debug(new MyFirstChallenge()));}
}