package ld.domain.venue;

import geolocation.util.GeoDistCalculator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class Venue {

	@Getter @Setter
	private String name;
	@Getter @Setter
	private String description;
	@Getter @Setter
	private String address;
	@Getter @Setter
	private String postalCode;
	
	@Getter @Setter
	private double latitude;
	@Getter @Setter
	private double longtitude;
	
	public Venue(String name) {
		this.name = name;
	}
	
	public boolean isWithin(Venue venue2, double distanceInKM) {
		double calculatedDist = GeoDistCalculator.distanceInKM(this.latitude, this.longtitude, venue2.latitude, venue2.longtitude);
		return calculatedDist <= distanceInKM;
	}
	
}
