/**
 *
 * @author oulis
 * @file Server Thread Implementation.
 */
 
package RmiServer;

import java.rmi.Naming;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.time.LocalDateTime;

public class RmiServerRun extends Thread {
	private String port;
	
	RmiServerRun(final String Port) {
		super();
		this.port = Port;
	}
	
	@Override
	public void run() {
		try {
			startRegistry(this.port);
			
			TheaterInter t = new TheaterImpl();
			Naming.rebind("rmi://localhost:" + this.port + "/TheaterService", t);
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "RMI Registry TheaterService started.");
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Waits for requests...");
		}
		catch (Exception e) {
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Trouble: " + e);
			System.exit(1);
		}
	}
	
	/*This method starts an RMI registry on the local host, if
	it does not already exists at the specified port number.*/
	private static void startRegistry(String portNum)
		throws RemoteException {
		
		int portNumber = Integer.parseInt(portNum);
		try {			
			Registry registry = LocateRegistry.getRegistry(portNumber);
			registry.list();
		}
		catch (RemoteException e) {
			Registry registry = LocateRegistry.createRegistry(portNumber);
		}
		catch (Exception e) {
			System.err.println("[" + LocalDateTime.now().toString() + "]\t" + "Exception:\t" + e);
			System.exit(1);
		}
	}
	
}
