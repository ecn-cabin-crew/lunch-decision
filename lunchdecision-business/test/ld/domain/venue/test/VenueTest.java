package ld.domain.venue.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import ld.domain.venue.Venue;

public class VenueTest {

	@Test
	public void venueIsWithinOneKilometer() {
		Venue venue1 = new Venue();
		venue1.setLatitude(1);
		venue1.setLongtitude(2);
		
		Venue venue2 = new Venue();
		venue2.setLatitude(1);
		venue2.setLongtitude(2);
		
		boolean isWithin = venue1.isWithin(venue2, 1);
		
		assertTrue(isWithin);
	}
	
	@Test
	public void venueIsNotWithinOneKilometer() {
		Venue venue1 = new Venue();
		venue1.setLatitude(1);
		venue1.setLongtitude(2);
		
		Venue venue2 = new Venue();
		venue2.setLatitude(1);
		venue2.setLongtitude(6);
		
		boolean isWithin = venue1.isWithin(venue2, 1);
		
		assertFalse(isWithin);
	}
	
}
