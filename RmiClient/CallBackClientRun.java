/**
 *
 * @author oulis
 * @file Client Thread Implementation.
 */
 
package RmiClient;

import java.rmi.*;
import RmiServer.CallBackServerInter;
import java.time.LocalDateTime;

public class CallBackClientRun extends Thread {
	private String port;
	private String host;
	private int timeDuration;
	private String list;
	
	public CallBackClientRun(String Host, String Port, int TimeDuration, String List) {
		super();
		this.port = Port;
		this.host = Host;
		this.timeDuration = TimeDuration;
		this.list = List;
	}
	
	@Override
	public void run() {
		try {
			CallBackServerInter h = (CallBackServerInter) Naming.lookup("rmi://" + this.host + ":" + this.port + "/callback");			
			CallBackClientInter callBackObj = new CallBackClientImpl();
			
			switch (this.list) {
				case "ZoneA":
					h.registerForCallBackA (callBackObj);
					Thread.sleep(timeDuration * 1000 * 60);
					h.unregisterForCallBackA (callBackObj);
					break;
				case "ZoneB":
					h.registerForCallBackB (callBackObj);
					Thread.sleep(timeDuration * 1000 * 60);
					h.unregisterForCallBackB (callBackObj);
					break;
				case "ZoneC":
					h.registerForCallBackC (callBackObj);
					Thread.sleep(timeDuration * 1000 * 60);
					h.unregisterForCallBackC (callBackObj);
					break;
				case "ZoneCentral":
					h.registerForCallBackCentral (callBackObj);
					Thread.sleep(timeDuration * 1000 * 60);
					h.unregisterForCallBackCentral (callBackObj);
					break;
				case "ZoneFrame":
					h.registerForCallBackFrame (callBackObj);
					Thread.sleep(timeDuration * 1000 * 60);
					h.unregisterForCallBackFrame (callBackObj);
					break;
				default:
					break;
			}
			
		}
		catch (InterruptedException e) {
			System.err.println("[" + LocalDateTime.now().toString() + "]\t" + "InterruptedException: " + e);
		}
		catch (Exception e) {
			System.err.println("[" + LocalDateTime.now().toString() + "]\t" + "Exception in CallBack Server.");
			System.err.println(e);
		}
	}
}
