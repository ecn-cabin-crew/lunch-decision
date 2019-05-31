package ld.domain.decision_engine;

import java.util.ArrayList;
import java.util.List;

import ld.domain.constraint.Constraint;
import ld.domain.constraint.LocationConstraint;
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
	public List<Venue> getRecommendation(int numberOfRecommendations) {
		// TODO
		List<Venue> recomendations = new ArrayList<>();
		
		List<Venue> tempVenuePool = applyHardConstraints(this.venuePool);
		for (int i=0; i<numberOfRecommendations; i++) {
			if (tempVenuePool.size() == 0) break;
			int index = (int)Math.floor(Math.random() * tempVenuePool.size());
			recomendations.add(tempVenuePool.remove(index));
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

	private List<Venue> applyHardConstraints(List<Venue> venuePool) {
		
		List<Venue> prunedVenuePool = new ArrayList<>(venuePool);
		for (Venue venue : venuePool) {
			for (Constraint constraint : hardConstraints) {
				if (constraint instanceof LocationConstraint) {
					LocationConstraint loc = (LocationConstraint)constraint;
					Venue venue2 = new Venue("", loc.getLatitude(), loc.getLongitude());
					if (!venue.isWithin(venue2, loc.getRadius())) {
						prunedVenuePool.remove(venue);
					}
				}
			}
		}
		return prunedVenuePool;
	}

}
