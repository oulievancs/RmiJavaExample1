/**
 *
 * @author oulis
 * @file Call Backs Server Implementation.
 */
 
package RmiServer;

import java.rmi.*;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.ArrayList;
import java.io.Serializable;
import RmiClient.CallBackClientInter;
import java.time.LocalDateTime;

public class CallBackServerImpl extends UnicastRemoteObject
	implements CallBackServerInter, Serializable {
		private static final long serialVersionUID = 3L;
		
		private static ArrayList<CallBackClientInter> clientListA = new ArrayList<>();
		private static ArrayList<CallBackClientInter> clientListB = new ArrayList<>();
		private static ArrayList<CallBackClientInter> clientListC = new ArrayList<>();
		private static ArrayList<CallBackClientInter> clientListCentral = new ArrayList<>();
		private static ArrayList<CallBackClientInter> clientListFrame = new ArrayList<>();
		
		public CallBackServerImpl() throws RemoteException {
			super();
		}
		
		public synchronized void registerForCallBackA(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (! (clientListA.contains (callbackclientObject))) {
					clientListA.add(callbackclientObject);
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Registeres new client for callBacksA.");
					//doCallBacksA();
				}
		}
		
		public synchronized void unregisterForCallBackA(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (clientListA.remove(callbackclientObject)) {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Unregisteres client for callBacksA.");
				}
				else {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "unregister: client wasn't registed for callBacksA.");
				}
		}
		
		public synchronized void registerForCallBackB(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (! (clientListB.contains (callbackclientObject))) {
					clientListB.add(callbackclientObject);
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Registeres new client for callBacksB.");
					//doCallBacksB();
				}
		}
		
		public synchronized void unregisterForCallBackB(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (clientListB.remove(callbackclientObject)) {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Unregisteres client for callBacksB.");
				}
				else {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "unregister: client wasn't registed for callBacksB.");
				}
		}
		
		public synchronized void registerForCallBackC(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (! (clientListC.contains (callbackclientObject))) {
					clientListC.add(callbackclientObject);
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Registeres new client for callBacksC.");
					//doCallBacksC();
				}
		}
		
		public synchronized void unregisterForCallBackC(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (clientListC.remove(callbackclientObject)) {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Unregisteres client for callBacksC.");
				}
				else {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "unregister: client wasn't registed for callBacksC.");
				}
		}
		
		public synchronized void registerForCallBackCentral(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (! (clientListCentral.contains (callbackclientObject))) {
					clientListCentral.add(callbackclientObject);
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Registeres new client for callBacksCentral.");
					//doCallBacksCentral();
				}
		}
		
		public synchronized void unregisterForCallBackCentral(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (clientListCentral.remove(callbackclientObject)) {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Unregisteres client for callBacksCentral.");
				}
				else {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "unregister: client wasn't registed for callBacksCentral.");
				}
		}
		
		public synchronized void registerForCallBackFrame(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (! (clientListFrame.contains (callbackclientObject))) {
					clientListFrame.add(callbackclientObject);
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Registeres new client for callBacksFrame.");
					//doCallBacksFrame();
				}
		}
		
		public synchronized void unregisterForCallBackFrame(CallBackClientInter callbackclientObject)
			throws RemoteException {
				if (clientListFrame.remove(callbackclientObject)) {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "Unregisteres client for callBacksFrame.");
				}
				else {
					System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "unregister: client wasn't registed for callBacksFrame.");
				}
		}
		
		//Notify All Clients Call Back A zone.
		//@Override
		public synchronized void doCallBacksA() throws RemoteException {
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "CallbacksA initiated...");
			final String msg = "There are same changes to Theater (Zone A). Check if you can reserve the seats that you was.";
			for(int i=0; i < clientListA.size(); i++) {
				CallBackClientInter nextClient = (CallBackClientInter) clientListA.get(i);
				nextClient.notifyMe(msg);
			}
		}
		
		//Notify All Clients Call Back B zone.
		//@Override
		public synchronized void doCallBacksB() throws RemoteException {
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "CallbacksB initiated...");
			final String msg = "There are same changes to Theater (Zone B). Check if you can reserve the seats that you was.";
			for(int i=0; i < clientListB.size(); i++) {
				CallBackClientInter nextClient = (CallBackClientInter) clientListB.get(i);
				nextClient.notifyMe(msg);
			}
		}
		
		//Notify All Clients Call Back C zone.
		//@Override
		public synchronized void doCallBacksC() throws RemoteException {
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "CallbacksC initiated...");
			final String msg = "There are same changes to Theater (Zone C). Check if you can reserve the seats that you was.";
			for(int i=0; i < clientListC.size(); i++) {
				CallBackClientInter nextClient = (CallBackClientInter) clientListC.get(i);
				nextClient.notifyMe(msg);
			}
		}
		
		//Notify All Clients Call Back Central zone.
		//@Override
		public synchronized void doCallBacksCentral() throws RemoteException {
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "CallbacksCentral initiated...");
			final String msg = "There are same changes to Theater (Central Balcony). Check if you can reserve the seats that you was.";
			for(int i=0; i < clientListCentral.size(); i++) {
				CallBackClientInter nextClient = (CallBackClientInter) clientListCentral.get(i);
				nextClient.notifyMe(msg);
			}
		}
		
		//Notify All Clients Call Back Frame zone.
		//@Override
		public synchronized void doCallBacksFrame() throws RemoteException {
			System.out.println("[" + LocalDateTime.now().toString() + "]\t" + "CallbacksFrame initiated...");
			final String msg = "There are same changes to Theater (Side Thrones). Check if you can reserve the seats that you was.";
			for(int i=0; i < clientListFrame.size(); i++) {
				CallBackClientInter nextClient = (CallBackClientInter) clientListFrame.get(i);
				nextClient.notifyMe(msg);
			}
		}
}
