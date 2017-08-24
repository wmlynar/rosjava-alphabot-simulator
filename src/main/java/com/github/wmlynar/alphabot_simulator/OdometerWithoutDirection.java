package com.github.wmlynar.alphabot_simulator;

public class OdometerWithoutDirection {

	private double ticksPerMeter = 0;
	private double distanceTravelled = 0;
	private int countedTicks = 0;

	public void setTicksPerMeter(double d) {
		this.ticksPerMeter=d;
	}

	public void driveDistance(double d) {
		double newDistanceTravelled = distanceTravelled + d;
		countedTicks+=(int)(Math.abs(Math.floor(newDistanceTravelled*this.ticksPerMeter)-Math.floor(distanceTravelled*this.ticksPerMeter)));
		distanceTravelled = newDistanceTravelled;
	}

	public int getTicks() {
		return countedTicks;
	}

}
