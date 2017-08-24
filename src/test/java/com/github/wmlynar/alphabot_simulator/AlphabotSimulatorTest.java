package com.github.wmlynar.alphabot_simulator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlphabotSimulatorTest {
	
	private AlphabotSimulator simulator;

	@Before
	public void setUp() {
		simulator = new AlphabotSimulator();
		simulator.setTicksPerMeter(200); // 1/.2*40
		simulator.setBaseWidth(0.17);
		simulator.initializeTime(0);
	}

	@Test
	public void testForward() {
		//given
		simulator.setSpeedMetersPerSecond(1);
		simulator.setRotationRightRadiansPerSecond(0);
		
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
		simulator.setRotationRightRadiansPerSecond(Math.PI/2);
		
		//when
		simulator.simulateSeconds(1);
		
		//then
		assertEquals(26,simulator.getOdometerTicksLeft());
		assertEquals(-26,simulator.getOdometerTicksRight());
	}

	@Test
	public void testRotateLeft() {
		//given
		simulator.setSpeedMetersPerSecond(0);
		simulator.setRotationRightRadiansPerSecond(-Math.PI/2);
		
		//when
		simulator.simulateSeconds(1);
		
		//then
		assertEquals(-26,simulator.getOdometerTicksLeft());
		assertEquals(26,simulator.getOdometerTicksRight());
	}

}
