package com.github.wmlynar.alphabot_simulator;

import static org.junit.Assert.*;

import org.junit.Test;

public class OdometerWithDirectionTest {

	@Test
	public void testCountForwardOneTickPerMeter() {
		OdometerWithDirection odometer = new OdometerWithDirection();
		odometer.setTicksPerMeter(1);
		
		odometer.driveDistance(0.1);
		assertEquals(0,odometer.getTicks());
		
		odometer.driveDistance(1);
		assertEquals(1,odometer.getTicks());
		
		odometer.driveDistance(-1);
		assertEquals(0,odometer.getTicks());
	}

	@Test
	public void testCountForwardTwoTicksPerMeter() {
		OdometerWithDirection odometer = new OdometerWithDirection();
		odometer.setTicksPerMeter(2);
		
		odometer.driveDistance(0.1);
		assertEquals(0,odometer.getTicks());
		
		odometer.driveDistance(0.5);
		assertEquals(1,odometer.getTicks());
		
		odometer.driveDistance(0.5);
		assertEquals(2,odometer.getTicks());
		
		odometer.driveDistance(-1);
		assertEquals(0,odometer.getTicks());
	}
	
	@Test
	public void testBackwardOneTickPerMeter() {
		OdometerWithDirection odometer = new OdometerWithDirection();
		odometer.setTicksPerMeter(1);
		
		odometer.driveDistance(-0.1);
		assertEquals(-1,odometer.getTicks());
	}

}
