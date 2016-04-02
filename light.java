import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;

public class light implements Behavior {
	private LightSensor light = new LightSensor(SensorPort.S3);
	private DifferentialPilot pilot = new DifferentialPilot(2.25, 4.25, Motor.A, Motor.B);
	private boolean suppress = false;
	private int value;
	private int lightlvl = 50;

	public void action(){
		suppress = false;
		
		//Stop moving
		pilot.stop();
		
		//Turn 90 degrees to the left and then move forward.
		pilot.rotate(-90);
		pilot.forward();
	}

	public void suppress (){
		suppress = true;
	}

	public boolean takeControl(){
		//Store the light level in a variable
		value = light.getLightValue();
		
		//Check to see if light level is above 50, if it is, return true
		if (value > lightlvl){
			return true;
		}
		else{
			return false;
		}
	}
}

