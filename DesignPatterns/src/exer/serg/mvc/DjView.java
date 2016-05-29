package exer.serg.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class DjView implements BpmObserver, BeatObserver, ActionListener {
	private BeatModelInterface model;
	private ControllerInterface controller;
	private JLabel bpmOutLabel = new JLabel(); //TODO remove init
	private BeatBar beatBar = new BeatBar(); //TODO remove init
	private JButton setBpmButton;
	private JTextField bpmTextField;
	private JButton increaseBpmButton;
	private JButton decreaseBpmButton;
	private JMenuItem stopMenuItem;
	private JMenuItem startMenuItem;
	
	public DjView(ControllerInterface controller, BeatModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver) this);
		model.registerObserver((BpmObserver) this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();
		if (source == setBpmButton) {
			final int bpm = Integer.parseInt(bpmTextField.getText());
			controller.setBpm(bpm);
		} else if (source == increaseBpmButton) {
			controller.increaseBpm();			
		} else if (source == decreaseBpmButton) {
			controller.decreaseBpm();			
		}
	}

	public void createView() {
		System.out.println("createView: stub");
		// TODO Auto-generated method stub
		
	}

	public void createControls() {
		System.out.println("createControls: stub");
		// TODO Auto-generated method stub
		
	}

	public void enableStopMenuItem() {
		stopMenuItem.setEnabled(true);
	}


	public void disableStopMenuItem() {
		stopMenuItem.setEnabled(false);
	}

	public void enableStartMenuItem() {
		startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
		startMenuItem.setEnabled(false);
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

}
