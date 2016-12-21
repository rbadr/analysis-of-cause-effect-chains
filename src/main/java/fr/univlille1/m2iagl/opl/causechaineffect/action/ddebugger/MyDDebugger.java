package fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.univlille1.m2iagl.opl.causechaineffect.action.helper.Helper;
import fr.univlille1.m2iagl.opl.causechaineffect.challenge.Challenge;
import fr.univlille1.m2iagl.opl.causechaineffect.jdb.JDBHelper;
import fr.univlille1.m2iagl.opl.causechaineffect.main.LaunchJDBRightInputMain;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Breakpoint;
import fr.univlille1.m2iagl.opl.causechaineffect.model.BreakpointArray;
import fr.univlille1.m2iagl.opl.causechaineffect.model.CauseEffectChain;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;

public class MyDDebugger implements DDebugger<String> {



	public <I> CauseEffectChain debug(Challenge<I> challenge) {
		I rightInput = null;
		I wrongInput = null;
		BreakpointArray breakpointArray = null;


		for (I input: challenge.getInputs()) {
			BreakpointArray tmpBreakpointArray = getCauseEffectChain(challenge, input);
			if(tmpBreakpointArray != null && breakpointArray == null){
				breakpointArray = tmpBreakpointArray;
				wrongInput = input;
			} else if(tmpBreakpointArray == null && rightInput == null){
				rightInput = input;
			}
			
		}
		
		return internalDebug(challenge, rightInput, wrongInput, breakpointArray);
	}

	private <I> CauseEffectChain internalDebug(Challenge<I> challenge, I rightInput, I wrongInput, BreakpointArray breakpointArray) {

		// On lance les 2 programmes pour chaque élément de la chaine de cause à effet pour faire la différence entre toutes les variables locales
		CauseEffectChain causeEffectChain = new CauseEffectChain(breakpointArray);
		
		for(int i=0;i<breakpointArray.length();i++){
			Map<String, Object> rightVars = getVarsAtBreakpoint(Constants.JDB_MAIN_RIGHT_INPUT, challenge, rightInput, breakpointArray.get(i));
			Map<String, Object> wrongVars = getVarsAtBreakpoint(Constants.JDB_MAIN_WRONG_INPUT, challenge, wrongInput, breakpointArray.get(i));
			
			List<String> keys = Helper.getKeysWithDifferentValues(rightVars, wrongVars);
						
			causeEffectChain.addEntries(i, keys, rightVars, wrongVars);
		}
		
		return causeEffectChain;
	}
	
	private <I> Map<String, Object> getVarsAtBreakpoint(String mainToLaunch, Challenge<I> challenge, I input, Breakpoint breakpoint){
		LaunchJDBRightInputMain.challenge = challenge;
		LaunchJDBRightInputMain.input = input;
		
		JDBHelper jdbHelper = new JDBHelper(mainToLaunch, breakpoint);
		jdbHelper.launch();

		return  jdbHelper.getVars();
	}

	// Return true if the challenge crashed with this input
	private <I> BreakpointArray getCauseEffectChain(Challenge<I> challenge, I input){
		try {
			challenge.doIt(input);
			return null;
		} catch(Exception e){
			// Dans le catch, sauvegarde de la pile d'exécution
			StackTraceElement[] array =  e.getStackTrace();

			List<Breakpoint> causeChainElements = new ArrayList<Breakpoint>();
			for(int i=0;i<array.length;i++){
				String className = array[i].getClassName();

				if(className.startsWith(Constants.PACKAGE_NAME_START) &&
						!className.startsWith(Constants.PACKAGE_MAIN) &&
						!className.startsWith(Constants.PACKAGE_DEBUGGER)){
					causeChainElements.add(new Breakpoint(array[i].getLineNumber(), className));
				}
			}
			
			return new BreakpointArray((Breakpoint[]) causeChainElements.toArray(new Breakpoint[causeChainElements.size()]));		
		}
	}


}
