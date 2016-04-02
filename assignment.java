import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.util.Delay;
import lejos.nxt.NXTMotor;
import lejos.nxt.MotorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.TouchSensor;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.nxt.LightSensor;
import lejos.nxt.*;
import lejos.robotics.subsumption.*;


public class assignment {

	public static void main(String[] args) throws Exception {

		//Print Assignment 1 to screen and wait for button press
		LCD.drawString("Assignment 1", 0, 0);
		Button.waitForAnyPress();
		LCD.clear();
		
		//Declare behaviors
		Behavior claps = new claps();
		Behavior touch = new touch();
		Behavior light = new light();
		Behavior sonar = new sonar();
		
		//Store created behaviors in a array
		Behavior [] behaviorArray = {claps, touch, light, sonar};
		
		//Create and arbitrator and place the behavior array in it
		Arbitrator arbit = new Arbitrator(behaviorArray);
		arbit.start();

		System.exit(0);
	}
}
