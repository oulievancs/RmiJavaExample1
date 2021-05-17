/**
 *
 * @author oulis
 * @file Call Back Server Interface.
 */
 
package RmiServer;

import java.rmi.*;
import java.rmi.RemoteException;
import RmiClient.CallBackClientInter;

public interface CallBackServerInter
	extends Remote {
	
	public void registerForCallBackA(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void unregisterForCallBackA(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void registerForCallBackB(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void unregisterForCallBackB(CallBackClientInter callbackclientObject)
		throws RemoteException;
	
	public void registerForCallBackC(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void unregisterForCallBackC(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void registerForCallBackCentral(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void unregisterForCallBackCentral(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void registerForCallBackFrame(CallBackClientInter callbackclientObject)
		throws RemoteException;
		
	public void unregisterForCallBackFrame(CallBackClientInter callbackclientObject)
		throws RemoteException;
}
