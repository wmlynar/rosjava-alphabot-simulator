package com.github.wmlynar.alphabot_simulator;

public class AlphabotSimulator {

	private double ticksPerMeter;
	private double baseWidth;
	private double time;
	private double speed;
	private double odometerTickCountLeft = 0;
	private double odometerTickCountRight = 0;
	private double rotationRightRadiansPerSecond;
	
	public void simulateSeconds(double dt) {
		odometerTickCountLeft += speed * dt * ticksPerMeter + rotationRightRadiansPerSecond*baseWidth/2*dt*ticksPerMeter;
		odometerTickCountRight += speed * dt * ticksPerMeter - rotationRightRadiansPerSecond*baseWidth/2*dt*ticksPerMeter;
	}

	public int getOdometerTicksLeft() {
		return roundTicks(odometerTickCountLeft);
	}

	public int getOdometerTicksRight() {
		return roundTicks(odometerTickCountRight);
	}

	private int roundTicks(double odometerTickCountRight) {
		return (int)(Math.floor(Math.abs(odometerTickCountRight))*Math.signum(odometerTickCountRight));
	}

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

	public void setRotationRightRadiansPerSecond(double d) {
		this.rotationRightRadiansPerSecond = d;
	}
	
}
