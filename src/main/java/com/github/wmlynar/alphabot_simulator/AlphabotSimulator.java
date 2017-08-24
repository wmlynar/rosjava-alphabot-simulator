package com.github.wmlynar.alphabot_simulator;

public class AlphabotSimulator {

	private double ticksPerMeter;
	private double baseWidth;
	private double time;
	private double speed;
	private double odometerTickCountLeft = 0;
	private double odometerTickCountRight = 0;

	public void setTicksPerMeter(double d) {
		this.ticksPerMeter=d;
	}

	public void setBaseWidth(double d) {
		this.baseWidth=d;
	}

	public void initializeTime(double t) {
		this.time=t;
	}

	public void setSpeedMetersPerSecond(double speed) {
		this.speed = speed;
	}

	public void simulateSeconds(double dt) {
		odometerTickCountLeft += speed * dt * ticksPerMeter;
		odometerTickCountRight += speed * dt * ticksPerMeter;
	}

	public int getOdometerTicksLeft() {
		return (int) Math.floor(odometerTickCountLeft);
	}

	public int getOdometerTicksRight() {
		return (int)Math.floor(odometerTickCountRight);
	}
}
