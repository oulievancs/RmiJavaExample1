/**
 *
 * @author oulis
 * @file Client Thread Implementation.
 */
 
package RmiServer;

import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.net.*;
import java.time.LocalDateTime;

public class CallBackServerRun extends Thread {
	private String port;
	
	public CallBackServerRun(String Port) {
		super();
		this.port = Port;
	}
	
	@Override
	public void run() {
		try {
			startRegistry(this.port);
			CallBackServerImpl exportedObj = new CallBackServerImpl();
			
			Naming.rebind("rmi://localhost:" + this.port + "/callback", exportedObj);
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "CallBack server ready...");
		}
		catch (Exception e) {
			System.err.println("[" + LocalDateTime.now().toString() + "]\t" + "Exception in CallBack Server.");
			System.err.println(e);
			System.exit(2);
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
			System.exit(2);
		}
	}
}
