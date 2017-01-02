package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.List;

/**
 * Defines a challenge asked to the others
 */
public interface Challenge<I> {
	/** Gives the actual value of I */
	public Class<? extends I> getInputFormat();

	/** Gives a list of inputs */
	public List<I> getInputs();

	/** perform the computation, without any assert */
	public Object doIt(I input);

	/** the core challenge */
	public void challenge(I input);
}
