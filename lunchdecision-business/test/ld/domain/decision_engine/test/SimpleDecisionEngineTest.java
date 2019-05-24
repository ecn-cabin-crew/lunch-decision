package ld.domain.decision_engine.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ld.domain.decision_engine.DecisionEngine;
import ld.domain.decision_engine.SimpleDecisionEngine;
import ld.domain.venue.Venue;

public class SimpleDecisionEngineTest {

	private DecisionEngine decisionEngine;
	
	@Before
	public void init() {
		decisionEngine = new SimpleDecisionEngine();
		List<Venue> venuePool = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			venuePool.add(new Venue("BMC" + i));
		}
		decisionEngine.setVenuePool(venuePool);
	}
	
	@Test
	public void CanGetRecommendation() {
		int expectedNumberOfRecommendation = 10;
		Venue[] recommendation = decisionEngine.getRecommendation(expectedNumberOfRecommendation);
		assertNotNull(recommendation);
		assertEquals(expectedNumberOfRecommendation, recommendation.length);
	}
	
}
