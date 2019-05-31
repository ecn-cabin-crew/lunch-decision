package ld.domain.decision_engine;

import java.util.List;

import ld.domain.constraint.Constraint;
import ld.domain.venue.Venue;

public interface DecisionEngine {
	public List<Venue> getRecommendation(int numberOfRecommendations);
	
	public void addHardContraint(Constraint constraint);
	
	public void addSoftContraint(Constraint constraint);
	
	public void resetConstraints();
	
	public void setVenuePool(List<Venue> venuePool);
}
