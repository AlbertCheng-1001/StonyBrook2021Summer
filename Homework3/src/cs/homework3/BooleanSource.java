package cs.homework3;
/**
 * Creates a probability to see if a random request will be created
 * 
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class BooleanSource {
	private double probability;

	/**
	 * Checks to see if probability is valid or not
	 * @param probability
	 * 		percentage to see if a request gets added
	 * @throws IllegalArgumentException
	 * 		probability is not between 0 and 1
	 */
	public BooleanSource(double probability) throws IllegalArgumentException {
		if (probability > 1 || probability < 0) {
			throw new IllegalArgumentException("not within range");
		} else {
			setProbability(probability);
		}

	}

	/**
	 * To see if a random request will be added
	 * @return
	 * 		if true a random request will be added
	 */
	public boolean requestArrived() {
		return Math.random() < this.probability;
	}

	/**
	 * Retrieves the probability of source
	 * @return
	 * 		the probability of source
	 */
	public double getProbability() {
		return probability;
	}

	/**
	 * Sets probability of source
	 * @param probability
	 * 		sets probability
	 */
	public void setProbability(double probability) {
		this.probability = probability;
	}
}
