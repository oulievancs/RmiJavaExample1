/**
 *
 * @author oulis
 * @file Interface of Rmi Methods
 */

package RmiServer;

import java.rmi.*;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TheaterInter
	extends java.rmi.Remote {
		public Theater checkTheater()
			throws RemoteException;
			
		public float book (String UserId, String type, int number, String name)
			throws RemoteException;
			
		public ArrayList<Reservation> guests ()
			throws RemoteException;
			
		public float cancel (String UserId, String type, int number, String name)
			throws RemoteException;
}
