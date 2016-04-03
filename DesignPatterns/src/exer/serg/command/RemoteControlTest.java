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
		
		remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		remote.setCommand(1, kitchenLightOn, kitchenLightOff);
		remote.setCommand(2, ceillingFanHighCommand, ceillingFanOff);
		remote.setCommand(3, stereoOnWithCDCCommand, stereoOffCommand);
		remote.setCommand(4, garageDoorUpCommand, garageDoorDownCommand);
		
		remote.setCommand(0, ceillingFanMediumCommand, ceillingFanOff);
		remote.setCommand(1, ceillingFanHighCommand, ceillingFanOff);
		
		System.out.println(remote);
		
		remote.onButtonWasPressed(0);
		remote.offButtonWasPressed(0);
		System.out.println(remote);
		remote.undoButtonWasPressed();
		
		remote.onButtonWasPressed(1);
		remote.offButtonWasPressed(1);
		System.out.println(remote);
		remote.undoButtonWasPressed();
		
	}

}
