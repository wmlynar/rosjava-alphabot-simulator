package com.github.wmlynar.alphabot_simulator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlphabotSpeedModelTest {
	
	private AlphabotSpeedModel simulator;

	@Before
	public void setUp() {
		simulator = new AlphabotSpeedModel();
		simulator.setTicksPerMeter(200); // 1/.2*40
		simulator.setBaseWidth(0.17);
		simulator.initializeTime(0);
	}

	@Test
	public void testForward() {
		//given
		simulator.setSpeedMetersPerSecond(1);
		simulator.setRotationRightHandRadiansPerSecond(0);
		
		//when
		simulator.simulateSeconds(1);
		
		//then
		assertEquals(200,simulator.getOdometerTicksLeft());
		assertEquals(200,simulator.getOdometerTicksRight());
	}
	
	@Test
	public void testRotateRight() {
		//given
		simulator.setSpeedMetersPerSecond(0);
		simulator.setRotationRightHandRadiansPerSecond(Math.PI/2);
		
		//when
		simulator.simulateSeconds(1);
		
		//then
		assertEquals(26,simulator.getOdometerTicksLeft());
		assertEquals(-27,simulator.getOdometerTicksRight());
	}

	@Test
	public void testRotateLeft() {
		//given
		simulator.setSpeedMetersPerSecond(0);
		simulator.setRotationRightHandRadiansPerSecond(-Math.PI/2);
		
		//when
		simulator.simulateSeconds(1);
		
		//then
		assertEquals(-27,simulator.getOdometerTicksLeft());
		assertEquals(26,simulator.getOdometerTicksRight());
	}

	@Test
	public void testForwardAndRotateRight() {
		//given
		simulator.setSpeedMetersPerSecond(1);
		simulator.setRotationRightHandRadiansPerSecond(-Math.PI/2);
		
		//when
		simulator.simulateSeconds(1);
		
		//then
		assertEquals(200-27,simulator.getOdometerTicksLeft());
		assertEquals(200+26,simulator.getOdometerTicksRight());
	}

}
