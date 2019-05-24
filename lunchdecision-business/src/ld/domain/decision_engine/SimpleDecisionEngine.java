package ld.domain.decision_engine;

import java.util.ArrayList;
import java.util.List;

import ld.domain.constraint.Constraint;
import ld.domain.venue.Venue;

public class SimpleDecisionEngine implements DecisionEngine {
	
	private List<Constraint> hardConstraints;
	private List<Constraint> softConstraints;
	private List<Venue> venuePool;

	public SimpleDecisionEngine() {
		super();
		hardConstraints = new ArrayList<>();
		softConstraints = new ArrayList<>();
	}

	@Override
	public Venue[] getRecommendation(int numberOfRecommendations) {
		// TODO
		Venue[] recomendations = new Venue[numberOfRecommendations];
		
		List<Venue> tempVenuePool = new ArrayList<>(venuePool);
		for (int i=0; i<numberOfRecommendations; i++) {
			int index = (int)Math.floor(Math.random() * tempVenuePool.size());
			recomendations[i] = tempVenuePool.remove(index);
		}
		
		return recomendations;
	}

	@Override
	public void addHardContraint(Constraint constraint) {
		hardConstraints.add(constraint);
	}

	@Override
	public void addSoftContraint(Constraint constraint) {
		softConstraints.add(constraint);
	}

	@Override
	public void resetConstraints() {
		hardConstraints.clear();
		softConstraints.clear();
	}

	@Override
	public void setVenuePool(List<Venue> venuePool) {
		this.venuePool = venuePool;
	}

}
