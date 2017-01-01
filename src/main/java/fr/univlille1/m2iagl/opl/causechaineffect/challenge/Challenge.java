package fr.univlille1.m2iagl.opl.causechaineffect.challenge;

import java.util.List;

/**
 * Defines a challenge asked to the others
 * @param <I>
 */
public interface Challenge<I> {
	/** Gives the actual value of I
     * @return  */
	public Class<? extends I> getInputFormat();

	/** Gives a list of inputs
     * @return  */
	public List<I> getInputs();

	/** perform the computation, without any assert
     * @param input
     * @return  */
	public Object doIt(I input);

	/** the core challenge
     * @param input */
	public void challenge(I input);
}
