package exer.serg.somepartterns;

public class QuackCounter implements Quackable {

	private Quackable duck;
	private int numberOfQuacks;
	
	public QuackCounter(Quackable duck) {
		this.duck = duck;
	}

	@Override
	public void quack() {
		duck.quack();
		numberOfQuacks++;
	}
	
	public int getQuacks() {
		return numberOfQuacks;
	}

}
