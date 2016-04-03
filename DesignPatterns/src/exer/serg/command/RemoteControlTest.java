package exer.serg.command;

public class RemoteControlTest {

	public static void main(String[] args) {
		RemoteControl remote = new RemoteControl();
		
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeillingFan ceillingFan = new CeillingFan("Living Room");
		GarageDoor door = new GarageDoor();
		Stereo stereo = new Stereo("Living Room");
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		
		CeillingFanOffCommand ceillingFanOff = new CeillingFanOffCommand(ceillingFan);
		CeillingFanHighCommand ceillingFanHighCommand = new CeillingFanHighCommand(ceillingFan);
		CeillingFanMediumCommand ceillingFanMediumCommand = new CeillingFanMediumCommand(ceillingFan);
		
		GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(door);
		GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(door);
		
		StereoOnWithCDCCommand stereoOnWithCDCCommand = new StereoOnWithCDCCommand(stereo);
		StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
		Command[] partyOn = new Command[] {livingRoomLightOn, stereoOnWithCDCCommand, ceillingFanMediumCommand};
		Command[] partyOff = new Command[] {livingRoomLightOff, stereoOffCommand, ceillingFanOff};
		
		MacroCommand partyOnCommand = new MacroCommand(partyOn);
		MacroCommand partyOffCommand = new MacroCommand(partyOff);
		
		remote.setCommand(0, partyOnCommand, partyOffCommand);
		
		
		
		System.out.println(remote);
		System.out.println("\n--- Pushing Macro On ---\n");
		remote.onButtonWasPressed(0);
		System.out.println("\n--- Pushing Macro Off ---\n");
		remote.offButtonWasPressed(0);
		
		System.out.println("\n--- Pushing Macro On ---\n");
		remote.onButtonWasPressed(0);
		System.out.println(remote);
		System.out.println("\n--- Pushing Undo ---\n");
		remote.undoButtonWasPressed();
		
		remote.onButtonWasPressed(1);
		remote.offButtonWasPressed(1);
		System.out.println(remote);
		remote.undoButtonWasPressed();
		
	}

}
