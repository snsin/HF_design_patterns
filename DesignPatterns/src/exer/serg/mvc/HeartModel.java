package exer.serg.mvc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class HeartModel implements Runnable, HeartModelInterface {

	private Random random = new Random();
	private int time = 1000;
	private Collection<BeatObserver> beatObservers = new ArrayList<>();
	private Collection<BpmObserver> bpmObservers = new ArrayList<>();
	

	@Override
	public void run() {
		int lastrate = -1;
		for (;;) {
			int change = random.nextInt(10);
			if (random.nextBoolean()) {
				change = 0 - change;
			}
			int rate = 60000/(time  + change);
			if (50 < rate && rate < 120) {
				time += change;
				notifyBeatObservers();
				if (rate != lastrate) {
					lastrate = rate;
					notifyBpmObservers();
				}
			}
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public int getHeartRate() {
		return 60000 / time;
	}
	
	@Override
	public void registerObserver(BeatObserver o) {
		beatObservers.add(o);
	}
	
	@Override
	public void removeObserver(BeatObserver o) {
		beatObservers.remove(o);
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
	
	@Override
	public void removeObserver(BpmObserver o) {
		bpmObservers.remove(o);
	}
	
	public void notifyBpmObservers() {
		for (BpmObserver bpmObserver : bpmObservers) {
			bpmObserver.updateBpm();
		}
	}



}
