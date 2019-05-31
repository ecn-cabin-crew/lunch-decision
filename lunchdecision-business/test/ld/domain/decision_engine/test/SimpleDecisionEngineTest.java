package ld.domain.decision_engine.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ld.domain.constraint.Constraint;
import ld.domain.constraint.LocationConstraint;
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
			venuePool.add(new Venue("BMC" + i, 1, 2));
		}
		
		decisionEngine.setVenuePool(venuePool);
	}
	
	@Test
	public void CanGetRecommendation() {
		int expectedNumberOfRecommendation = 10;
		List<Venue> recommendation = decisionEngine.getRecommendation(expectedNumberOfRecommendation);
		assertNotNull(recommendation);
		assertEquals(expectedNumberOfRecommendation, recommendation.size());
	}
	
	@Test
	public void CanApplyLocationConstraint() {
		Constraint locationConstraint = new LocationConstraint(1, 2, 1);
		
		List<Venue> venuePool = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			venuePool.add(new Venue("BMC" + i, 1, 2));
		}
		
		for (int i = 0; i < 5; i++) {
			venuePool.add(new Venue("BMC2" + i, 1, 6));
		}
		
		decisionEngine.setVenuePool(venuePool);
		decisionEngine.addHardContraint(locationConstraint);
		
		List<Venue> recommendation = decisionEngine.getRecommendation(10);
		
		assertEquals(5, recommendation.size());
	}
}
