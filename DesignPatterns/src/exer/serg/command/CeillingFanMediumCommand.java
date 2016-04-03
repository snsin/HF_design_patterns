package exer.serg.command;

public class CeillingFanMediumCommand implements Command {
	CeillingFan fan;
	CeillingFan.State prevState;
	
	public CeillingFanMediumCommand(CeillingFan fan) {
		this.fan = fan;
	}	

	@Override
	public void execute() {
		prevState = fan.getState();
		fan.medium();
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
