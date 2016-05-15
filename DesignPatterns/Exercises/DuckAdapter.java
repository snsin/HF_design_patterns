import expl.serg.strategy.Duck;

public class DuckAdapter implements Turkey {
	private Duck duck;
	public DuckAdapter(Turkey duck) {
		this.turkey = duck;
	}
	
	public void goggle() {
		duck.performQuack();
	}
	
	public void fly() {
		duck.performFly();
	}
	
}