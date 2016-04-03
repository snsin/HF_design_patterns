package exer.serg.command;

public class RemoteControl {
	private static final int DEFAULT_KEYS_COUNT = 7;
	Command[] onCommands;
	Command[] offCommands;
	
	public RemoteControl() {
		onCommands = new Command[DEFAULT_KEYS_COUNT];
		offCommands = new Command[DEFAULT_KEYS_COUNT];
		
		for (int i = 0; i < onCommands.length; i++) {
			Command noCommand = new NoCommand();
			onCommands[i] = noCommand ;
			offCommands[i] = noCommand;
		}
		// TODO Auto-generated constructor stub
	}

}
