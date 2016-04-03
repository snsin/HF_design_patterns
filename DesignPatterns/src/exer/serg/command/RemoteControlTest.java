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
		CeillingFanOnCommand ceillingFanOnCommand = new CeillingFanOnCommand(ceillingFan);
		
		GarageDoorUpCommand garageDoorUpCommand = new GarageDoorUpCommand(door);
		GarageDoorDownCommand garageDoorDownCommand = new GarageDoorDownCommand(door);
		
		StereoOnWithCDCCommand stereoOnWithCDCCommand = new StereoOnWithCDCCommand(stereo);
		StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
		
		remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remote.setCommand(1, kitchenLightOn, kitchenLightOff);
		remote.setCommand(2, ceillingFanOnCommand, ceillingFanOff);
		remote.setCommand(3, stereoOnWithCDCCommand, stereoOffCommand);
		remote.setCommand(4, garageDoorUpCommand, garageDoorDownCommand);
		
		System.out.println(remote);
		
		remote.onButtonWasPressed(0);
		remote.offButtonWasPressed(0);
		System.out.println(remote);
		remote.undoButtonWasPressed();
		
		remote.onButtonWasPressed(1);
		remote.offButtonWasPressed(1);
		System.out.println(remote);
		remote.undoButtonWasPressed();
		
		
		remote.onButtonWasPressed(2);
		remote.offButtonWasPressed(2);
		System.out.println(remote);
		remote.undoButtonWasPressed();
		
		remote.onButtonWasPressed(3);
		remote.offButtonWasPressed(3);
		System.out.println(remote);
	}

}
