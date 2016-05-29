package exer.serg.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class BeatModel implements MetaEventListener, BeatModelInterface {
	private Sequencer sequencer;
	private List<BeatObserver> beatObservers = new ArrayList<>();
	private List<BpmObserver> bpmObservers = new ArrayList<>();
	private int bpm = 90;
	private Sequence sequence;
	private Track track;
	
	@Override
	public void initialize() {
		setUpMidi();
		buildTrackAndStart();
	}
	
	@Override
	public void on() {
		sequencer.start();
		setBpm(10);
		//startBeat();
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
	
	public void beatEvent() {
		notifyBeatObservers();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}

	public void notifyBeatObservers() {
		for (BeatObserver beatObserver : beatObservers) {
			beatObserver.updateBeat();
		}
		
	}

	@Override
	public void registerObserver(BpmObserver o) {
		bpmObservers.add(o);
	}

	public void notifyBpmObservers() {
		for (BpmObserver bpmObserver : bpmObservers) {
			bpmObserver.updateBpm();
		}
		
	}

	@Override
	public void removeObserver(BeatObserver o) {
		beatObservers.remove(o);
	}

	@Override
	public void removeObserver(BpmObserver o) {
		bpmObservers.remove(o);
	}
	
	@Override
	public void meta(MetaMessage meta) {
		if (meta.getType() == 47) {
			beatEvent();
			sequencer.start();
			setBpm(getBpm());
		}
	
	}

	private void setUpMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBpm());
			
		} catch (MidiUnavailableException | InvalidMidiDataException e) {
			e.printStackTrace();
		}
	}

	private void buildTrackAndStart() {
		final int[] trackList = {35, 0, 46, 0};
		
		sequence.deleteTrack(null);
		track = sequence.createTrack();
		makeTracks(trackList);
		
		track.add(makeEvent(192,9,1,0,4));
		try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
	}

	private void makeTracks(int[] trackList) {
		for (int i = 0; i < trackList.length; i++) {
			int key = trackList[i];
			if (key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i+1));
			}
		}
	
	}

	private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			final ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		return event;
	}
	
}
