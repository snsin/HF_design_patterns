package exer.serg.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.Sequencer;

public class BeatModel implements MetaEventListener, BeatModelInterface {
	private Sequencer sequencer = new SequencerStub();
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
		startBeat(); //TODO remove this
	}
	
	@Override
	public void off() {
		setBpm(0);
		sequencer.stop();
	}

	@Override
	public void setBpm(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBpm());
		notifyBpmObservers();
		
	}
	
	@Override
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
		for (BpmObserver bpmObserver : bpmObservers) {
			bpmObserver.updateBpm();
		}
		
	}
	
	public void beatEvent() {
		notifyBeatObservers();
	}

	public void notifyBeatObservers() {
		for (BeatObserver beatObserver : beatObservers) {
			beatObserver.updateBeat();
		}
		
	}

	private void buildTrackAndStart() {
		System.out.println("buildTrackAndStart: stub");
		// TODO Auto-generated method stub
		
	}

	private void setUpMidi() {
		System.out.println("setUpMidi: stub");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void meta(MetaMessage meta) {
		System.out.println("meta: stub");
		// TODO Auto-generated method stub

	}
	
	public void startBeat() { //TODO Remove this method;
		Timer timer = new Timer();
		TimerTask beat = new BeatStub(this);
		timer.schedule(beat, 3000, 60000/bpm);
	}

}
