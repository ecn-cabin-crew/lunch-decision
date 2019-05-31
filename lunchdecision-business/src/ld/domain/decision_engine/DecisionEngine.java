package ld.domain.decision_engine;

import java.util.List;

import ld.domain.constraint.Constraint;
import ld.domain.venue.Venue;

public interface DecisionEngine {
<<<<<<< HEAD
	public List<Venue> getRecommendation(int numberOfRecommendations);
=======
	public Venue[] getRecommendation(int numberOfRecommendations);
>>>>>>> c0aabe87b29033adb44614e6e73f00c70dbfaaa3
	
	public void addHardContraint(Constraint constraint);
	
	public void addSoftContraint(Constraint constraint);
	
	public void resetConstraints();
	
	public void setVenuePool(List<Venue> venuePool);
}
