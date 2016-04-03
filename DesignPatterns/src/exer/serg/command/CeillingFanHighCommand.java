package exer.serg.command;

public class CeillingFanHighCommand implements Command {
	CeillingFan fan;
	
	public CeillingFanHighCommand(CeillingFan fan) {
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
