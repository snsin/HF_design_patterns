package exer.serg.command;

public class RemoteControlTest {

	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light lt = new Light();
		GarageDoor door = new GarageDoor();
		LightOnCommand ightOn = new LightOnCommand(lt);
		GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(door);
		
		
		remote.setCommand(ightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageOpen);
		remote.buttonWasPressed();

	}

}
