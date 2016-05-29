package exer.serg.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DjView implements BpmObserver, BeatObserver, ActionListener {
	private BeatModelInterface model;
	private ControllerInterface controller;
	private JLabel bpmOutLabel;
	private BeatBar beatBar;
	private JButton setBpmButton;
	private JTextField bpmTextField;
	private JButton increaseBpmButton;
	private JButton decreaseBpmButton;
	private JMenuItem stopMenuItem;
	private JMenuItem startMenuItem;
	private JPanel viewPannel;
	private JFrame viewFrame;
	private JFrame controlFrame;
	private JPanel controlPanel;
	private JMenuBar menuBar;
	private JMenu menu;
	private JLabel bpmLabel;
	
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
		viewPannel = new JPanel(new GridLayout(1, 2));
		viewFrame = new JFrame("Viev");
		viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewFrame.setSize(new Dimension(100, 80));
		bpmOutLabel = new JLabel("offline", SwingConstants.CENTER);
		beatBar = new BeatBar();
		beatBar.setValue(0);
		final JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
		bpmPanel.add(beatBar);
		bpmPanel.add(bpmOutLabel);
		viewPannel.add(bpmPanel);
		viewFrame.getContentPane().add(viewPannel, BorderLayout.CENTER);
		viewFrame.pack();
		viewFrame.setVisible(true);
		
	}

	public void createControls() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		controlFrame = new JFrame("Control");
		controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		controlFrame.setSize(new Dimension(100, 80));
		
		controlPanel = new JPanel(new GridLayout(1, 2));
		
		menuBar = new JMenuBar();
		menu = new JMenu("DJ Control");
		
		startMenuItem = new JMenuItem("Start");
		menu.add(startMenuItem);
		startMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
			}
		});
		
		stopMenuItem = new JMenuItem("Stop");
		menu.add(stopMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
			}
		});
		
		final JMenuItem exit = new JMenuItem("Quit");
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		menu.add(exit);
		
		menuBar.add(menu);
		controlFrame.setJMenuBar(menuBar);
		
		bpmTextField = new JTextField(2);
		bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
		setBpmButton = new JButton("Set");
		setBpmButton.setSize(new Dimension(10, 40));
		increaseBpmButton = new JButton(">>");
		decreaseBpmButton = new JButton("<<");
		setBpmButton.addActionListener(this);
		increaseBpmButton.addActionListener(this);
		decreaseBpmButton.addActionListener(this);
		
		final JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(decreaseBpmButton);
		buttonPanel.add(increaseBpmButton);
		
		final JPanel enterPanel = new JPanel(new GridLayout(1, 2));
		enterPanel.add(bpmLabel);
		enterPanel.add(bpmTextField);
		
		final JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
		insideControlPanel.add(enterPanel);
		insideControlPanel.add(setBpmButton);
		insideControlPanel.add(buttonPanel);
		
		controlPanel.add(insideControlPanel);
		
		bpmLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		bpmOutLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		controlFrame.getRootPane().setDefaultButton(setBpmButton);
		controlFrame.getContentPane().add(controlPanel, BorderLayout.CENTER);
		
		controlFrame.pack();
		controlFrame.setVisible(true);
				
		
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
		beatBar.setValue(100);
		
	}

	@Override
	public void updateBpm() {
		final int bpm = model.getBpm();
		if (bpm == 0) {
			bpmOutLabel.setText("offline");
		} else {
			bpmOutLabel.setText("Current BPM: " + bpm);
		}
	}

}
