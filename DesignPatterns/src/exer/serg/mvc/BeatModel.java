package exer.serg.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;

public class BeatModel implements MetaEventListener, BeatModelInterface {
	private Sequencer sequencer;
	private List<BeatObserver> beatObservers = new ArrayList<>();
	private List<BpmObserver> bpmObservers = new ArrayList<>();
	private int bpm = 90;
	
	@Override
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}
	
	@Override
	public void on() {
		sequencer.start();
		setBpm(90);
	}
	
	@Override
	public void off() {
		setBpm(0);
		sequencer.stop();
	}

	public void setBpm(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBpm());
		notifyBpmObservers();
		
	}
	
	public int getBpm() {
		return bpm;
	}
	
	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		beatObservers.remove(o);
	}

	@Override
	public void registerObserver(BpmObserver o) {
		bpmObservers.add(o);
	}
	
	@Override
	public void removeObserver(BpmObserver o) {
		bpmObservers.remove(o);
	}
	
	public void notifyBpmObservers() {
		// TODO Auto-generated method stub
		
	}
	
	public void beatEvent() {
		notifyBeatObservers();
	}

	public void notifyBeatObservers() {
		// TODO Auto-generated method stub
		
	}

	private void buildTrackAndStart() {
		// TODO Auto-generated method stub
		
	}

	private void setUpMidi() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void meta(MetaMessage meta) {
		// TODO Auto-generated method stub

	}

}
