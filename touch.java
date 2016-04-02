import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.robotics.navigation.DifferentialPilot;

public class touch implements Behavior {
	private TouchSensor touch = new TouchSensor(SensorPort.S1);
	private DifferentialPilot pilot = new DifferentialPilot(2.25, 4.25, Motor.A, Motor.B);
	private boolean suppress = false;

	public void action(){
		suppress = false;
		
		//Stop moving and print Stop to the screen
		pilot.stop();
		LCD.drawString("Stop",0,0);
		
	}

	public void suppress (){
		LCD.drawString("Stop",0,0);
		suppress = true;
	}

	public boolean takeControl(){
		
		//If the button sensor is pressed, return true
		if (touch.isPressed()){
			return true;
		}
		else{
			return false;
		}
	}
}
