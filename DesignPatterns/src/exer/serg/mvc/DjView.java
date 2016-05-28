package exer.serg.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class DjView implements BpmObserver, BeatObserver, ActionListener {
	private BeatModelInterface model;
	private ControllerInterface controller;
	private JLabel bpmOutLabel = new JLabel(); //TODO remove init
	private BeatBar beatBar = new BeatBar(); //TODO remove init
	
	public DjView(ControllerInterface controller, BeatModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BpmObserver) this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("actionPerformed: stub. Create Action code");
		// TODO Auto-generated method stub

	}

	public void createView() {
		System.out.println("createView: stub");
		// TODO Auto-generated method stub
		
	}

	public void createControls() {
		System.out.println("createControls: stub");
		// TODO Auto-generated method stub
		
	}

	public void disableStopMenuItem() {
		System.out.println("disableStopMenuItem: stub");
		// TODO Auto-generated method stub
		
	}

	public void enableStartMenuItem() {
		System.out.println("enableStartMenuItem: stub");
		// TODO Auto-generated method stub
		
	}

	public void disableStartMenuItem() {
		System.out.println("disableStartMenuItem: stub");
		// TODO Auto-generated method stub
		
	}

	public void enableStopMenuItem() {
		System.out.println("enableStopMenuItem: stub");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBeat() {
		System.out.println("!!! BEAT !!!");
		beatBar.setValue(100);// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBpm() {
		final int bpm = model.getBpm();
		if (bpm == 0) {
			bpmOutLabel.setText("offline");
			System.out.println(">> offline"); //TODO remove this
		} else {
			bpmOutLabel.setText("Current BPM: " + bpm);
			System.out.println(">> Current BPM: " + bpm); //TODO remove this
		}
	}
	
	public void startBeat() { //TODO Remove this method;
		Timer timer = new Timer();
		TimerTask beat = new BeatStub(model);
		timer.schedule(beat, 3000, 500);
	}

}
