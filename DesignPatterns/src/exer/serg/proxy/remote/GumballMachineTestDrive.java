package exer.serg.proxy.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import exer.serg.state.GumballMachine;

public class GumballMachineTestDrive {

	private static final int NOT_ENOUGH_ARGUMENTS = 1;
	private static final int BAD_ARGUMENT = 0;

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("GumballMachine <name> <inventory>");
			System.exit(NOT_ENOUGH_ARGUMENTS);
		}
		int count = 0;
		try {
			count = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Second argument must be an integer number.");
			System.exit(BAD_ARGUMENT);
		}
		GumballMachine gumballMachine = null;
		try {
			gumballMachine = new GumballMachine(args[0], count);
			Naming.rebind("//:" + args[0] + "/gumballmachine", gumballMachine);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}
		
		GumballMonitor monitor = new GumballMonitor(gumballMachine);
		monitor.report();

	}

}
