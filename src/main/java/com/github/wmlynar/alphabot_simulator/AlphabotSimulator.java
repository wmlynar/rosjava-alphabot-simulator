package com.github.wmlynar.alphabot_simulator;

public class AlphabotSimulator {

	private double time;
	
	private double baseWidth;
	
	private double speed;
	private double rotationRightRadiansPerSecond;
	
	
	private OdometerWithDirection odometerLeft = new OdometerWithDirection();
	private OdometerWithDirection odometerRight = new OdometerWithDirection();

	public void simulateSeconds(double dt) {
		double distanceLeft = speed * dt + rotationRightRadiansPerSecond*baseWidth/2*dt;
		double distanceRight = speed * dt - rotationRightRadiansPerSecond*baseWidth/2*dt;

		odometerLeft.driveDistance(distanceLeft);
		odometerRight.driveDistance(distanceRight);
	}

	public int getOdometerTicksLeft() {
		return odometerLeft.getTicks();
	}

	public int getOdometerTicksRight() {
		return odometerRight.getTicks();
	}

	public void setTicksPerMeter(double d) {
		odometerLeft.setTicksPerMeter(d);
		odometerRight.setTicksPerMeter(d);
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
