package exer.serg.state;

import java.rmi.RemoteException;

public class GumballMachineTestDrive {

	public static void main(String[] args) throws RemoteException {
		GumballMachine gumballMachine = new GumballMachine(5);
		System.out.println(gumballMachine);
		gumballMachine.insertQuarter();
		gumballMachine.turnCrunk();
		
		System.out.println(gumballMachine);
		
		gumballMachine.insertQuarter();
		gumballMachine.turnCrunk();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrunk();
		
		System.out.println(gumballMachine);
		

	}

}
