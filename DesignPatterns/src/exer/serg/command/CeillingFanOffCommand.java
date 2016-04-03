package exer.serg.command;

public class CeillingFanOffCommand implements Command {
	CeillingFan fan;
	CeillingFan.State previousState;
	
	public CeillingFanOffCommand(CeillingFan fan) {
		this.fan = fan;
		previousState = fan.getState();
	}

	@Override
	public void execute() {
		previousState = fan.getState();
		fan.off();
	}

	@Override
	public void undo() {
		switch (previousState) {
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
