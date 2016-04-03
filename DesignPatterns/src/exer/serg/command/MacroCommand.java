package exer.serg.command;

import java.util.ArrayList;
import java.util.Arrays;

public class MacroCommand implements Command {
	ArrayList<Command> commands;
	
	public MacroCommand(Command[] commands) {
		this.commands.addAll(Arrays.asList(commands));
	}

	@Override
	public void execute() {
		for (Command command : commands) {
			command.execute();
		}
	}

	@Override
	public void undo() {
		for (Command command : commands) {
			command.undo();
		}
	}

}
