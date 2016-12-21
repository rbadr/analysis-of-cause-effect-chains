package fr.univlille1.m2iagl.opl.causechaineffect.action.ddebugger;

import fr.univlille1.m2iagl.opl.causechaineffect.challenge.Challenge;
import fr.univlille1.m2iagl.opl.causechaineffect.model.CauseEffectChain;

public interface DDebugger<I> {
	<I> CauseEffectChain debug(Challenge<I> c);
}

