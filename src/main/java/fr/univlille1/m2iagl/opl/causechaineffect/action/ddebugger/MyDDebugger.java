package fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger;

import fr.univlille1.m2iagl.opl.causechaineffect.action.helper.Helper;
import fr.univlille1.m2iagl.opl.causechaineffect.action.helper.RecursiveHelper;
import fr.univlille1.m2iagl.opl.causechaineffect.challenge.Challenge;
import fr.univlille1.m2iagl.opl.causechaineffect.jdb.JDBHelper;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Breakpoint;
import fr.univlille1.m2iagl.opl.causechaineffect.model.BreakpointArray;
import fr.univlille1.m2iagl.opl.causechaineffect.model.CauseEffectChain;
import fr.univlille1.m2iagl.opl.causechaineffect.model.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyDDebugger implements DDebugger<String> {
	
	private int rightInputIndex, wrongInputIndex;
	private BreakpointArray breakpointArray;
	private String exceptionType;
	

        @Override
	public <I> CauseEffectChain debug(Challenge<I> challenge) {
		computeRightAndWrongInput(challenge);
		
		if(rightInputIndex == -1 || wrongInputIndex == -1){
			System.out.println("There is a problem about the input. The program cannot found a correct AND an incorrect input. Please check the inputs of the challenge");
			System.exit(1);
		}
		

		
		return internalDebug(challenge, rightInputIndex, wrongInputIndex, breakpointArray);
	}
	
	private <I> void computeRightAndWrongInput(Challenge<I> challenge){
		rightInputIndex = -1;
		wrongInputIndex = -1;

		for(int i=0;i<challenge.getInputs().size();i++){
			I input = challenge.getInputs().get(i);
			
			BreakpointArray tmpBreakpointArray = getCauseEffectChain(challenge, input);
			if(tmpBreakpointArray != null && breakpointArray == null){
				breakpointArray = tmpBreakpointArray;
				wrongInputIndex = i;
			} else if(tmpBreakpointArray == null && rightInputIndex == -1){
				rightInputIndex = i;
			}
		}
		
	}

	private <I> CauseEffectChain internalDebug(Challenge<I> challenge, int rightInputIndex, int wrongInputIndex, BreakpointArray breakpointArray) {

		// On lance les 2 programmes pour chaque élément de la chaine de cause à effet pour faire la différence entre toutes les variables locales
		CauseEffectChain causeEffectChain = new CauseEffectChain(breakpointArray, exceptionType);
		
		for(int i=0;i<breakpointArray.length();i++){
			Map<String, String> rightVars = getVarsAtBreakpoint(challenge, rightInputIndex, breakpointArray.get(i));
			Map<String, String> wrongVars = getVarsAtBreakpoint(challenge, wrongInputIndex, breakpointArray.get(i));

			
			List<String> keys;
			if(rightVars != null)
				keys = Helper.getKeysWithDifferentValues(rightVars, wrongVars);
			else 
				keys = new ArrayList<String>(wrongVars.keySet());
			
			
			causeEffectChain.addEntries(i, keys, rightVars, wrongVars);
		
			//System.exit(1);
		}
		
		return causeEffectChain;
	}
	
	private <I> Map<String, String> getVarsAtBreakpoint(Challenge<I> challenge, int index, Breakpoint breakpoint){
		
		JDBHelper jdbHelper = new JDBHelper(Constants.JDB_MAIN, breakpoint, index);
		jdbHelper.launch();

		return jdbHelper.getVars();
	}

	// Return the BreakpointArray corresponding if the challenge crashed with this input
	// Return null otherwise
	private <I> BreakpointArray getCauseEffectChain(Challenge<I> challenge, I input){
		try {
			challenge.doIt(input);
			return null;
		} catch(Exception e){
			RecursiveHelper recursiveHelper = new RecursiveHelper();
			
			// Dans le catch, sauvegarde de la pile d'exécution
			StackTraceElement[] array =  e.getStackTrace();
			exceptionType = e.getMessage();

			List<Breakpoint> causeChainElements = new ArrayList<Breakpoint>();
			for(int i=array.length-1;i>=0;i--){
				StackTraceElement stackTraceElement = array[i];
				String className = stackTraceElement.getClassName();
				String methodName = stackTraceElement.getMethodName();

				if(className.startsWith(Constants.PACKAGE_NAME_START) &&
						!className.startsWith(Constants.PACKAGE_MAIN) &&
						!className.startsWith(Constants.PACKAGE_DEBUGGER)){
					causeChainElements.add(new Breakpoint(array[i].getLineNumber(), className, recursiveHelper.get(className + ":" + methodName)));
				}
			}
			
			return new BreakpointArray((Breakpoint[]) causeChainElements.toArray(new Breakpoint[causeChainElements.size()]));		
		}
	}
}
