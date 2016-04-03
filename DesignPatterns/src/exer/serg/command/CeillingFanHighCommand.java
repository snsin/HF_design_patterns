package exer.serg.command;

public class CeillingFanHighCommand implements Command {
	CeillingFan fan;
	CeillingFan.State prevState;
	
	public CeillingFanHighCommand(CeillingFan fan) {
		this.fan = fan;
	}	

	@Override
	public void execute() {
		prevState = fan.getState();
		fan.high();
	}

	@Override
	public void undo() {
		switch (prevState) {
		case OFF:
			fan.off();
			break;
		case LOW:
			fan.low();
			break;
		case MEDIUM:
			fan.medium();
			break;
		case HIGH:
			fan.high();
			break;
		}
	}
}
