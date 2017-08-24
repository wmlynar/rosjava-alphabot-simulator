package com.github.wmlynar.alphabot_simulator;

public class OdometerWithDirection {

	private double ticksPerMeter = 0;
	private double distanceTravelled = 0;
	private int countedTicks = 0;

	public void setTicksPerMeter(double d) {
		this.ticksPerMeter=d;
	}

	public void driveDistance(double d) {
		distanceTravelled += d;
		
		countedTicks = (int)Math.floor(distanceTravelled*ticksPerMeter);
	}

	public int getTicks() {
		return countedTicks;
	}

}
