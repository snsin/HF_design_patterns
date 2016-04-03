package exer.serg.command;

public class CeillingFanOnCommand implements Command {
	CeillingFan fan;
	
	public CeillingFanOnCommand(CeillingFan fan) {
		this.fan = fan;
	}	

	@Override
	public void execute() {
		fan.high();
	}

	@Override
	public void undo() {
		fan.off();
	}

}
