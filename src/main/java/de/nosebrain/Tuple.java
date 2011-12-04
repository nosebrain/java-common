package de.nosebrain;

/**
 * 
 * @author nosebrain
 *
 * @param <T>
 * @param <S>
 */
public class Tuple<T, S> {

	private T first;
	private S second;

	/**
	 * default constructor
	 */
	public Tuple() {
		// noop
	}

	/**
	 * 
	 * @param first
	 * @param second
	 */
	public Tuple(final T first, final S second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * @return the first
	 */
	public T getFirst() {
		return this.first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(final T first) {
		this.first = first;
	}

	/**
	 * @return the second
	 */
	public S getSecond() {
		return this.second;
	}

	/**
	 * @param second the second to set
	 */
	public void setSecond(final S second) {
		this.second = second;
	}
}
