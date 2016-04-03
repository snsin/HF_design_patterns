package exer.serg.command;

public class NoCommand implements Command {

	@Override
	public void execute() {
		System.out.println("Execute noCommand!");
	}

	@Override
	public void undo() {
		System.out.println("Undo noCommand!");
	}

}
