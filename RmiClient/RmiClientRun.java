/**
 *
 * @author oulis
 * @file Client Thread Implementation.
 */
 
package RmiClient;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import RmiServer.TheaterInter;
import RmiServer.Theater;
import RmiServer.TheaterZone;
import RmiServer.Reservation;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class RmiClientRun extends Thread {
	
	private String host;
	private String port;
	
	public RmiClientRun(String Host, String Port) {
		super();
		this.host = Host;
		this.port = Port;
	}
	
	@Override
	public void run() {
		try {
			TheaterInter th = (TheaterInter) Naming.lookup("rmi://" + this.host + ":" + this.port + "/TheaterService");
			Theater theater;
			CallBackClientRun notifications;
			
			int selection;
			float balance = 0;
			Scanner in = new Scanner(System.in);
			do {				
				System.out.println("\n\n=============MENU==============");
				System.out.println("1. Show the Current Status Of Theater.");
				System.out.println("2. Make a reservation.");
				System.out.println("3. Keep Call Back Notification for a time (in minutes).");
				System.out.println("4. Show all Reservations.");
				System.out.println("5. Cancel a Reservation.");
				System.out.println("0. Exit.");
				System.out.println("Your balance is:\t" + balance + "$");
				System.out.print("\tOption:\t");
				selection = in.nextInt();
				in.nextLine();
				
				switch (selection) {
					case 1:
						theater = th.checkTheater();
						theater.check();
						break;
					case 2:
						String name, type, userId;
						int number;
						
						System.out.println("=======RESERVATION=======");
						
						System.out.print("\nGive a Username:\t");
						userId = in.nextLine();
						
						System.out.print("\nGive your name:\t");
						name = in.nextLine();
						
						System.out.println("\nGive the type of sets to reserve.");
						System.out.print("(\"ZoneA\", \"ZoneB\", \"ZoneC\", \"ZoneCenstral\", \"ZoneFrame\"):\t");
						type = in.nextLine();
						
						System.out.print("\nGive the number of seats you want:\t");
						number = in.nextInt();
						in.nextLine();
						
						float tmp;
						if ( (tmp = th.book(userId, type, number, name)) <= 0) {
							System.out.println("!!!!Warning: You couldn't reserve seats!");
							System.out.print("Do you want to notify you when some seats of this zone free? (y/n):\t");
							
							String ans = in.nextLine();
							
							if (ans.equals("y")) {
								System.out.print("Give the to keep Call Back Notifications (in minutes):\t");
								int time = in.nextInt();
								in.nextLine();
								
								if ( !(type.equals("ZoneA") || type.equals("ZoneB") || type.equals("ZoneC") || type.equals("ZoneCentral") || type.equals("ZoneFrame")) )
									System.out.println("!!!!WARNING: You gave false callBack Service. Try again with selection!");
								notifications = new CallBackClientRun(this.host, this.port, time, type);
								notifications.start();
								System.out.println("\n****Notification Call Back started...\n");
							}
						}
						else {
							System.out.println("Reservation success.");
						}
						balance += tmp;
						break;
					case 3:
						System.out.print("Give the time to keep Call Back Notifications (in minutes):\t");
						int time = in.nextInt();
						in.nextLine();
						
						System.out.println("\nGive the type of sets you want to notify.");
						System.out.print("(\"ZoneA\", \"ZoneB\", \"ZoneC\", \"ZoneCentral\", \"ZoneFrame\"):\t");
						type = in.nextLine();
						
						if ( !(type.equals("ZoneA") || type.equals("ZoneB") || type.equals("ZoneC") || type.equals("ZoneCentral") || type.equals("ZoneFrame")) )
							System.out.println("!!!!WARNING: You gave false callBack Service. Try again with selection!");
						notifications = new CallBackClientRun(this.host, this.port, time, type);
						notifications.start();
						System.out.println("\n****Notification Call Back started...\n");
						break;
					case 4:
						ArrayList<Reservation> tmp1 = th.guests();
						
						if (tmp1.size() <= 0) {
							System.out.println("\tEmpty Vector!!!");
						}
						else {
							System.out.println("=========ALL RESERVATIONS=========");
							for (int j=0; j < tmp1.size(); j++) {
								tmp1.get(j).print();
							}
						}
						break;
					case 5:						
						System.out.println("=======CANCEL RESERVATION=======");
						
						System.out.print("\nGive your Username:\t");
						userId = in.nextLine();
						
						System.out.print("\nGive your name:\t");
						name = in.nextLine();
						
						System.out.println("\nGive the type of sets to cancel.");
						System.out.print("(\"ZoneA\", \"ZoneB\", \"ZoneC\", \"ZoneCenstral\", \"ZoneFrame\"):\t");
						type = in.nextLine();
						
						System.out.print("\nGive the number of seats you want to cancel:\t");
						number = in.nextInt();
						in.nextLine();
						
						if ( (tmp = th.cancel(userId, type, number, name)) >= 0) {
							System.out.println("!!!!Warning: You couldn't cancel seats!");
						}
						else {
							System.out.println("Cancel reservation success.");
						}
						balance += tmp;
						break;
					case 0:
						System.out.println("Bye!");
						break;
					default:
						System.out.println("!!!!FALSE SELECTION!!!!");
						break;
				}
			
			} while (selection != 0);
			
			in.close();
			System.exit(0);
		}
		catch (MalformedURLException e) {
			System.err.println("\n\n[" + LocalDateTime.now().toString() + "]\t" + "MalformedURLException:");
			System.err.println(e);
		}
		catch (RemoteException e) {
			System.err.println("\n\n" + "[" + LocalDateTime.now().toString() + "]\t" + "RemoteException:");
			System.err.println(e);
		}
		catch (NotBoundException e) {
			System.err.println("\n\n" + "[" + LocalDateTime.now().toString() + "]\t" + "NotBoundException:");
			System.err.println(e);
		}
		catch (Exception e) {
			System.err.println("\n\n" + "[" + LocalDateTime.now().toString() + "]\t" + "Exception:");
			System.err.println(e);
		}
	}
}
