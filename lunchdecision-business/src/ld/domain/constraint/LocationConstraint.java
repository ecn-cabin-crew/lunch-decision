package ld.domain.constraint;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class LocationConstraint extends Constraint{
	
	@Getter @Setter
	private double latitude;
	
	@Getter @Setter
	private double longitude;
	
	@Getter @Setter
	private double radius;

	public LocationConstraint(double latitude, double longitude, double radius) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}
	
}
