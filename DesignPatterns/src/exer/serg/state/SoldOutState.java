package exer.serg.state;

public class SoldOutState implements State {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private transient GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
		
	}	

	@Override
	public void insertQuarter() {
		System.out.println("You can't insert a coin. Machine is sold out!");

	}

	@Override
	public void ejectQuarter() {
		System.out.println("You didn't insert a quarter!");

	}

	@Override
	public void turnCrank() {
		System.out.println("You turned but machine is sold out!");

	}

	@Override
	public void dispense() {
		System.out.println("No more gumballs!");

	}

}
