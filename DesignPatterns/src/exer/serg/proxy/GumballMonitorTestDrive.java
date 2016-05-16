package exer.serg.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GumballMonitorTestDrive {

	public static void main(String[] args) {
		String[] location = { "rmi://:1100/gumballmachine",
				"rmi://:1101/gumballmachine",
				"rmi://:1102/gumballmachine"
		};
		
		GumballMonitor[] monitor = new GumballMonitor[location.length];
		
		for (int i = 0; i < location.length; i++) {
			try {
				GumballMachineRemote machine = (GumballMachineRemote) Naming.lookup(location[i]);
				monitor[i] = new GumballMonitor(machine);
				System.out.println(monitor[i]);
			} catch (RemoteException | MalformedURLException | NotBoundException e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < monitor.length; i++) {
			monitor[i].report();
		}
	}

}
