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

public class MyDDebugger<I> implements DDebugger<I> {

	private int rightInputIndex;
        private int wrongInputIndex;
	private BreakpointArray breakpointArray;
	private String exceptionType;
	
	private boolean verbose;
        private boolean allVars;
	
	public MyDDebugger(boolean verbose, boolean allVars){
		this.verbose = verbose;
		this.allVars = allVars;
	}


        @Override
	public <I> CauseEffectChain debug(Challenge<I> challenge) {
		computeRightAndWrongInput(challenge);

		if(rightInputIndex == -1 || wrongInputIndex == -1){
			System.out.println("There is a problem about the input. The program cannot found a correct AND an incorrect input. Please check the inputs of the challenge");
			System.exit(1);
		}



		return internalDebug(rightInputIndex, wrongInputIndex, breakpointArray);
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

	private <I> CauseEffectChain internalDebug(int rightInputIndex, int wrongInputIndex, BreakpointArray breakpointArray) {

		// On lance les 2 programmes pour chaque élément de la chaine de cause à effet pour faire la différence entre toutes les variables locales
		CauseEffectChain causeEffectChain = new CauseEffectChain(breakpointArray, exceptionType);

		int cpt=0;
		for(int i=0;i<breakpointArray.length();i++){
			if(breakpointArray.get(i).getLine() != 1){
				Map<String, String> rightVars = getVarsAtBreakpoint(rightInputIndex, breakpointArray.get(i));
				Map<String, String> wrongVars = getVarsAtBreakpoint(wrongInputIndex, breakpointArray.get(i));
				
				List<String> keys;
				if(rightVars == null || allVars)
					keys = new ArrayList<>(wrongVars.keySet());
				else
					keys = Helper.getKeysWithDifferentValues(rightVars, wrongVars);

				
				causeEffectChain.addEntries(cpt, keys, rightVars, wrongVars);
				cpt++;
			}
		}
		
		if(verbose)
			System.out.println("*************************************************");
		return causeEffectChain;
	}

	private <I> Map<String, String> getVarsAtBreakpoint(int index, Breakpoint breakpoint){

		JDBHelper jdbHelper = new JDBHelper(verbose, Constants.JDB_MAIN, breakpoint, index);
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
			exceptionType = e.getClass().toString() + " " + e.getMessage();

			List<Breakpoint> breakpoints = new ArrayList<>();
			for(int i=array.length-1;i>=0;i--){
				StackTraceElement stackTraceElement = array[i];
				String className = stackTraceElement.getClassName();
				String methodName = stackTraceElement.getMethodName();
				int lineNb = stackTraceElement.getLineNumber();

				if(className.startsWith(Constants.PACKAGE_NAME_START) &&
						!className.startsWith(Constants.PACKAGE_MAIN) &&
						!className.startsWith(Constants.PACKAGE_DEBUGGER) &&
						lineNb != 1){
					breakpoints.add(new Breakpoint(array[i].getLineNumber(), className, recursiveHelper.get(className + ":" + methodName)));
				}
			}

			return new BreakpointArray((Breakpoint[]) breakpoints.toArray(new Breakpoint[breakpoints.size()]));		
		}
	}
}
