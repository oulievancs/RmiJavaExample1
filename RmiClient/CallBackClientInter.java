/**
 *
 * @author oulis
 * @file CLient Call Back Inteface
 *
 *This remote method is invoked by a callback
 *	server to make a callback to an client whitch
 *	imlements this interface.
 *	@param msg - a string containing information for the
 *	client to process upon being call back.
 */
 
package RmiClient;

import java.rmi.*;

public interface CallBackClientInter
	extends Remote {
		public String notifyMe (String msg)
			throws RemoteException;
}
