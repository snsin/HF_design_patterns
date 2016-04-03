package exer.serg.command;

public class RemoteControlTest {

	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light lt = new Light();
		LightOnCommand ightOn = new LightOnCommand(lt);
		remote.setCommand(ightOn);
		remote.buttonWasPressed();

	}

}
