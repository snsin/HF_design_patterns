package exer.serg.command;

public class RemoteControl {
	private static final int KEYS_COUNT = 7;
	Command[] onCommands;
	Command[] offCommands;
	Command undoCommand;

	public RemoteControl() {
		onCommands = new Command[KEYS_COUNT];
		offCommands = new Command[KEYS_COUNT];
		Command noCommand = new NoCommand();

		for (int i = 0; i < onCommands.length; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		if (onCommand != null) {
			onCommands[validSlot(slot)] = onCommand;
		}
		
		if (offCommand != null) {
			offCommands[validSlot(slot)] = offCommand;
		}
		
	}
	
	public void onButtonWasPressed(int slot) {
		onCommands[validSlot(slot)].execute();
		undoCommand = onCommands[validSlot(slot)];
	}
	
	public void offButtonWasPressed(int slot) {
		offCommands[validSlot(slot)].execute();
		undoCommand = onCommands[validSlot(slot)];
	}
	
	public void undoButtonWasPressed() {
		undoCommand.undo();
	}

	private boolean isValid(int slot) {
		return slot > -1 && slot < KEYS_COUNT;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n------ Remote Control ------\n");
		for (int i = 0; i < KEYS_COUNT; i++) {
			result.append(slotWithNo(i));
			result.append(onCommandName(i));
			result.append(offCommandName(i));
			result.append("\n");
		}
		result.append(undoCommandName());
		return result.toString();
	}

	private Object undoCommandName() {
		return undoCommand.getClass().getName() + "\t";
	}

	private String offCommandName(int i) {
		String result = "";
		if (isValid(i)) {
			result = offCommands[i].getClass().getSimpleName() + "\t";
		}
		return result;
	}

	private String onCommandName(int i) {
		String result = "";
		if (isValid(i)) {
			result = onCommands[i].getClass().getSimpleName()+ "\t";
		}
		return result;
	}

	private String slotWithNo(int i) {
		return "[slot " + i + "] \t";
	}
	
	private int validSlot(int slot) {
		return slot % KEYS_COUNT;
	}
	
}
