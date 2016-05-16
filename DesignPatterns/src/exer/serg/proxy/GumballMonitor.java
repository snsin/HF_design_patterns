package exer.serg.proxy;

import java.rmi.RemoteException;

import exer.serg.state.GumballMachine;

public class GumballMonitor {
	GumballMachineRemote machine;
	
	public GumballMonitor(GumballMachineRemote machine) {
		this.machine = machine;
	}
	
	public void report() {
		if (machine != null) {
			try {
				System.out.println("Gumball Machine: " + machine.getLocation()); 
				System.out.println("Current inventory: " + machine.getCount());
				System.out.println("Current state: " + machine.getState());
			} catch (RemoteException e) {
				e.printStackTrace();
			} 
		}
	}

}	
