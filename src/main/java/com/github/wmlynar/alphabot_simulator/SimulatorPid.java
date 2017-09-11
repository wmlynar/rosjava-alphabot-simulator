package com.github.wmlynar.alphabot_simulator;

public class SimulatorPid {
	
	public static void main(String[] args) {
		
		double ticksPerMeter = 200;
		
		AlphabotPwmModel model = new AlphabotPwmModel();
		model.setBaseWidth(0.17);
		model.setTicksPerMeter(ticksPerMeter);
		model.setPwmLeft(0);
		model.setPwmRight(0);
		
		double speed = 1;
		double prevt = -1;
		
		double leftTicks = 0;
		double rightTicks = 0;
		
		double sumErrorLeft = 0;
		double sumErrorRight = 0;
		
		for(double t=0; t<100; t+=0.2) {
			if(prevt==-1) {
				prevt = t;
			}
			double dt = t-prevt;
			prevt = t;
			
			if(dt<=0) {
				continue;
			}
			
			model.update(dt);
			
			double speedLeft = (model.getTicksLeft() - leftTicks)/ticksPerMeter/dt;
			leftTicks = model.getTicksLeft();
			
			double speedRight = (model.getTicksRight() - rightTicks)/ticksPerMeter/dt;
			rightTicks = model.getTicksRight();

			double errorLeft = speed - speedLeft;
			double errorRight = speed - speedRight;

			sumErrorLeft += errorLeft * dt;
			sumErrorRight += errorRight * dt;
			
			double pwmLeft = errorLeft * 0 + sumErrorLeft * 20;
			model.setPwmLeft(pwmLeft);

			double pwmRight = errorRight * 0 + sumErrorRight * 20;
			model.setPwmRight(pwmRight);
			
			System.out.println("pwmL: " + pwmLeft + " pwmR: " + pwmRight + " x: " + model.getX() + " y: " + model.getY());
		}
	}

}
