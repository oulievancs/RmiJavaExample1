/**
 *
 * @author oulis
 * @file Server Main Code.
 */

package RmiServer;

public class RmiServer {
	public static void main(String []args) {
		if (args.length != 1) {
			System.err.println("Usage: java RmiServer <port>");
			System.exit(1);
		}
		
		RmiServerRun ser = new RmiServerRun (args[0]);
		ser.start();
		CallBackServerRun callBackServer = new CallBackServerRun (args[0]);
		callBackServer.start();
	}
}
