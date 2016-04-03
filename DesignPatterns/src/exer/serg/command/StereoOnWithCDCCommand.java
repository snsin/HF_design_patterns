package exer.serg.command;

public class StereoOnWithCDCCommand implements Command {
	
	Stereo stereo;
	
	public StereoOnWithCDCCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(Stereo.DEFAULT_VOLUME_LEVEL);
	}

	@Override
	public void undo() {
		stereo.off();
	}

}
