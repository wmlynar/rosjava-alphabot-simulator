package com.github.wmlynar.alphabot_simulator;

public class DistanceController {

	private double distance = 0;
	private double speed;

	public void setDesiredSpeed(double d) {
		speed = d;
	}

	public void update(double dt) {
		distance += speed * dt;
	}

	public double getDesiredDistance() {
		return distance;
	}

}
