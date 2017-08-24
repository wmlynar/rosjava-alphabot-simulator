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
		simulator.setSpeedMetersPerSecond(1);
		
		simulator.simulateSeconds(1);
		
		int ticksLeft = simulator.getOdometerTicksLeft();
		int ticksRight = simulator.getOdometerTicksRight();
		
		assertEquals(200,ticksLeft);
		assertEquals(200,ticksRight);
	}

}
