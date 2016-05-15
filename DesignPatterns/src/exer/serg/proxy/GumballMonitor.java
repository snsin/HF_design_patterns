package exer.serg.proxy;

import exer.serg.state.GumballMachine;

public class GumballMonitor {
	GumballMachine machine;
	
	public GumballMonitor(GumballMachine machine) {
		this.machine = machine;
	}
	
	public void report() {
		if (machine != null) {
			System.out.println("Gumball Machine: " + machine.getLocation()); 
			System.out.println("Current inventory: " + machine.getCount());
			System.out.println("Current state: " + machine.getState()); 
			
		}
	}

}
