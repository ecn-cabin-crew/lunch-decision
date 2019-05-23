package statistics.util;

public class Sampler {
	
	private Sampler() {}
	
	/**
	 * 
	 * @param array - An array of weights
	 * @return normalisedArray - A normalised weight array (sum == 1)
	 */
	public double[] normalise(double[] weightArray) {
		double[] normalisedArray = new double[weightArray.length];
		
		double sum = sumArray(weightArray);
		
		for (int i=0; i<weightArray.length; i++) {
			normalisedArray[i] = weightArray[i]/sum;
		}
		return normalisedArray;
	}
	
	/**
	 * 
	 * @param array - An array of doubles
	 * @return sum - Sum of all the values in the array
	 */
	public double sumArray(double[] array) {
		double sum = 0;
		for (double value: array) {
			sum+= value;
		}
		return sum;
	}
}
