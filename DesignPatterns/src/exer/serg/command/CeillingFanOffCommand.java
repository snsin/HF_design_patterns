package exer.serg.command;

public class CeillingFanOffCommand implements Command {
	CeillingFan fan;
	
	public CeillingFanOffCommand(CeillingFan fan) {
		this.fan = fan;
	}

	@Override
	public void execute() {
		fan.off();
	}

}
