/**
 *
 * @author oulis
 * @file Call Back CLient Implementation.
 */
 
package RmiClient;

import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CallBackClientImpl extends UnicastRemoteObject
	implements CallBackClientInter, Serializable {
		private static final long serialVersionUID = 3L;
	
		public CallBackClientImpl() throws RemoteException {
			super();
		}
		
		public String notifyMe (String msg) {
			String returnMsg = "!!!Notification: " + msg;
			System.out.println("\n\n[" + LocalDateTime.now().toString() + "]\t" + returnMsg);
			System.out.print("\tOprion:\t");
			return returnMsg;
		}
}
