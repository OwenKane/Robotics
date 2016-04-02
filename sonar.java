import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;

public class sonar implements Behavior {
	private UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S4);
	private DifferentialPilot pilot = new DifferentialPilot(2.25, 4.25, Motor.A, Motor.B);
	private boolean suppress = false;
	private int distance = 30;
	private int value;
	
	public void action(){
		suppress = false;
		
		//Stop moving and turn 180 degrees
		pilot.stop();
		pilot.rotate(-180);
		
		//Move forward 20 units and turn 90 degrees to the right
		pilot.travel(20);
		pilot.rotate(90);

	}

	public void suppress (){
		suppress = true;
	}

	public boolean takeControl(){
		
		//Store distance from objects in a variable 
		value = sonic.getDistance();
		
		//If the distance is less that a set amount, return true
		if(value < distance) {
			return true;
		}
		else {
			return false;
		}
	}
}
