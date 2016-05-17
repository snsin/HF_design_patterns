package exer.serg.state;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import exer.serg.proxy.remote.GumballMachineRemote;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private State soldOutState;
	private State noQuarterState;
	private State hasQuarterState;
	private State soldState;
	private State winnerState;
	
	private String location;

	private State state  = soldState;
	private int count = 0;
	
	public GumballMachine(int numberGumballs) throws RemoteException {
		statesInit();

		this.count = numberGumballs;
		if (numberGumballs > 0) {
			state = noQuarterState;
		}
	}


	public GumballMachine(String location, int count) throws RemoteException {
		this.location = location;
		statesInit();
		this.count = count;
		if (count > 0) {
			state = noQuarterState;
		}
		
	}
	
	private void statesInit() {
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		winnerState = new WinnerState(this);
	}


	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrunk() {
		state.turnCrank();
		state.dispense();
	}
	
	public void setState(State state) {
		if (state != null) {
			this.state = state;
		}
	}
	
	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getWinnerState() {
		return winnerState;
	}
	
	@Override
	public int getCount() {
		return count;
	}

	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count > 0) {
			count--;
		}
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}

	@Override
	public String getLocation() {
		return location;
	}

	@Override
	public State getState() {
		return state;
	}
}
