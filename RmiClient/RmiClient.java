/**
 *
 * @author oulis
 * file RMI Client Main Code.
 */
 
package RmiClient;

public class RmiClient {
	public static void main(String []args) {
		if (args.length != 2) {
			System.err.println("Usage: java RmiClient <host> <port>");
			System.exit(1);
		}
		
		RmiClientRun cli = new RmiClientRun (args[0], args[1]);
		cli.start();
	}
}
