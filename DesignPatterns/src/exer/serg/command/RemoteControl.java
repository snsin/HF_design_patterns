package exer.serg.command;

public class RemoteControl {
	private static final int DEFAULT_KEYS_COUNT = 7;
	Command[] onCommands;
	Command[] offCommands;

	public RemoteControl() {
		onCommands = new Command[DEFAULT_KEYS_COUNT];
		offCommands = new Command[DEFAULT_KEYS_COUNT];
		Command noCommand = new NoCommand();

		for (int i = 0; i < onCommands.length; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		if (isValid(slot)) {
			if (onCommand != null) {
				onCommands[slot] = onCommand;
			}
			
			if (offCommand != null) {
				offCommands[slot] = offCommand;
			}
		}
	}
	
	public void onButtonWasPressed(int slot) {
		if (isValid(slot)){
			onCommands[slot].execute();
		}
	}
	
	public void offButtonWasPressed(int slot) {
		if (isValid(slot)){
			offCommands[slot].execute();
		}
	}

	private boolean isValid(int slot) {
		return slot > -1 && slot < DEFAULT_KEYS_COUNT;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n------ Remote Control ------");
		for (int i = 0; i < DEFAULT_KEYS_COUNT; i++) {
			result.append(slotWithNo(i));
			result.append(onCommandName(i));
			result.append(offCommandName(i));
			result.append("\n");
		}
		return result.toString();
	}

	private String offCommandName(int i) {
		String result = "";
		if (isValid(i)) {
			result = onCommands[i].getClass().getName();
		}
		return result;
	}

	private String onCommandName(int i) {
		String result = "";
		if (isValid(i)) {
			result = offCommands[i].getClass().getName();
		}
		return result;
	}

	private String slotWithNo(int i) {
		return "[slot " + i + "]";
	}
	
}
