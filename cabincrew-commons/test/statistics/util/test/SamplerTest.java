package statistics.util.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import statistics.util.Sampler;

public class SamplerTest {
	
	@Test
	public void sumOfArrayIsTen() {
		double[] array = {1, 2, 3, 4};
		double sum = Sampler.sumArray(array);
		
		assertTrue(sum==10.0);
	}
	
	@Test
	public void sumOfNormaliseArrayIsOne() {
		double[] array = {1, 2, 3, 4};
		double[] normalisedArray = Sampler.normalise(array);
		
		double sumNormalisedArray = Sampler.sumArray(normalisedArray);
		
		assertTrue(sumNormalisedArray == 1.0);
	}
	
	@Test
	public void lastElementOfCdfIsOne() {
		double[] normalisedArray = {0.2, 0.2, 0.2, 0.2, 0.2};
		double[] cdfArray = Sampler.generateCdf(normalisedArray);
		
		assertTrue(cdfArray[cdfArray.length-1]==1.0);
	}
	
	@Test
	public void sampleResultIsWithinRange() {
		double[] cdfArray = {0.25, 0.50, 0.75, 1.0};
		int resultIndex = Sampler.sample(cdfArray);
		
		assertTrue(0 <= resultIndex && resultIndex < cdfArray.length);
	}
}
