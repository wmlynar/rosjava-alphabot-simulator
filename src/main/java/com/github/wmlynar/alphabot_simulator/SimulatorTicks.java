package com.github.wmlynar.alphabot_simulator;

public class SimulatorTicks {
	
	public static void main(String[] args) {
		
		double ticksPerMeter = 200;
		
		AlphabotPwmModel model = new AlphabotPwmModel();
		model.setBaseWidth(0.17);
		model.setTicksPerMeter(ticksPerMeter);
		model.setPwmLeft(0);
		model.setPwmRight(0);
		
		DistanceController controllerLeft = new DistanceController();
		DistanceController controllerRight = new DistanceController();
		
		double speed = 1.123;
		double prevt = -1;
		
		double sumErrorLeft = 0;
		double sumErrorRight = 0;
		
		for(double t=0; t<100; t+=0.2) {
			if(prevt==-1) {
				prevt = t;
			}
			double dt = t-prevt;
			prevt = t;
			
			model.update(dt);
			controllerLeft.update(dt);
			controllerRight.update(dt);

			// left
			
			double setpoint = controllerLeft.getDesiredDistance();
			double measured = model.getTicksLeft() / ticksPerMeter;

			double errorLeft = setpoint - measured;
			sumErrorLeft += errorLeft*dt;
			double pwmLeft = errorLeft * 20 + sumErrorLeft*3;
			model.setPwmLeft(20 + pwmLeft);


			// right
			
			setpoint = controllerRight.getDesiredDistance();
			measured = model.getTicksRight() / ticksPerMeter;

			double errorRight = setpoint - measured;
			sumErrorRight += errorRight*dt;
			double pwmRight = errorRight * 30 + sumErrorRight*3;
			model.setPwmRight(20 + pwmRight);
			
			controllerLeft.setDesiredSpeed(speed);
			controllerRight.setDesiredSpeed(speed);
			
			System.out.println("pwmL: " + pwmLeft + " pwmR: " + pwmRight + " x: " + model.getX() + " y: " + model.getY() + " el: " + errorLeft + " er: " + errorRight);
		}
	}

}
