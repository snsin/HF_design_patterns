package exer.serg.mvc;

import javax.swing.JProgressBar;

public class BeatBar extends JProgressBar implements Runnable {

	private static final long serialVersionUID = 7695678551001316652L;
	private Thread thread;

	public BeatBar() {
		thread = new Thread(this);
		setMaximum(100);
		thread.start();
	}

	@Override
	public void run() {
		for(;;) {
			int value = getValue();
			value = (int)(value * .75);
			setValue(value);
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
