import lejos.nxt.*;
import lejos.robotics.subsumption.*;
import lejos.nxt.SensorPort;
import lejos.nxt.SoundSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class claps implements Behavior {
	private SoundSensor sound = new SoundSensor(SensorPort.S2);
	private DifferentialPilot pilot = new DifferentialPilot(2.25, 4.25, Motor.A, Motor.B);
	private boolean suppress = false;
	private int value;
	private int soundlvl = 50;
	
	public void action(){
		suppress = false;
		
		//Drive forward
		pilot.forward();
		
		//Print Clap to the screen
		LCD.drawString("Clap",0,0);

	}

	public void suppress (){
		LCD.clear();
		pilot.stop();
		suppress = true;
	}

	public boolean takeControl(){
		//Store the sound level in a variable
		value = sound.readValue();	
		
		//Check to see if sound level is above a set variable, if it is, return true
		if(value > soundlvl){
			return true;
		}
		else{
			return false;
		}
	}
}
