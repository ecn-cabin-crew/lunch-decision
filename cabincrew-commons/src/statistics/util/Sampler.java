package statistics.util;

public class Sampler {
	
	private Sampler() {}
	
	/**
	 * 
	 * @param normalisedArray - A normalised Array of weights (pdf)
	 * @return cdfArray - the cumulative distribution function
	 */
	public static double[] generateCdf(double[] normalisedArray) {
		double[] cdfArray = new double[normalisedArray.length];
		cdfArray[0] = normalisedArray[0];
		for (int i=1; i<normalisedArray.length; i++) {
			cdfArray[i] = cdfArray[i-1] + normalisedArray[i];
		}
		return cdfArray;
	}
	
	/**
	 * 
	 * @param array - An array of weights
	 * @return normalisedArray - A normalised weight array (sum == 1)
	 */
	public static double[] normalise(double[] weightArray) {
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
	public static double sumArray(double[] array) {
		double sum = 0;
		for (double value: array) {
			sum+= value;
		}
		return sum;
	}

	public static int sample(double[] cdfArray) {
		// TODO Auto-generated method stub
		return 0;
	}
}
