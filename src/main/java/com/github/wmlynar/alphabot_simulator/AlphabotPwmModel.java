package com.github.wmlynar.alphabot_simulator;

import static org.hamcrest.CoreMatchers.containsString;

public class AlphabotPwmModel {

	private OdometerWithDirection odometerLeft = new OdometerWithDirection();
	private OdometerWithDirection odometerRight = new OdometerWithDirection();

	private double x = 0;
	private double y = 0;
	private double alpha = 0;
	
	private double speedRight = 0;
	private double speedLeft = 0; 
	private double prevt = -1;
	
	private double rightDeadZone = 25;
	private double leftDeadZone = 20;
	private double maxSpeed = 2;
	private double baseWidth = 1;

	public void setTicksPerMeter(double d) {
		odometerLeft.setTicksPerMeter(d);
		odometerRight.setTicksPerMeter(d);
	}
	
	public void setPwmLeft(double pwm0To100) {
		if(pwm0To100<=leftDeadZone) {
			speedLeft = 0;
			return;
		}
		speedLeft = maxSpeed * (pwm0To100 - leftDeadZone)/(100-leftDeadZone);
	}
	
	public void setPwmRight(double pwm0To100) {
		if(pwm0To100<=rightDeadZone) {
			speedRight = 0;
			return;
		}
		speedRight = maxSpeed * (pwm0To100 - rightDeadZone)/(100-rightDeadZone);
	}
	
	public int getTicksLeft() {
		return odometerLeft.getTicks();
	}
	
	public int getTicksRight() {
		return odometerRight.getTicks();
	}
	
	public void update(double dt) {
		odometerLeft.driveDistance(speedLeft * dt);
		odometerRight.driveDistance(speedRight * dt);
		
		double speed = (speedLeft + speedRight) / 2;
		double rotation = (speedLeft - speedRight) / (baseWidth / 2);
		
		alpha += rotation * dt;
		x += speed * Math.cos(alpha) * dt;
		y += speed * Math.sin(alpha) * dt;
	}

	public void setBaseWidth(double d) {
		this.baseWidth  = d;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
}

