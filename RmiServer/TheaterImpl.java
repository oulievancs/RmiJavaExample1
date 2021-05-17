/**
 *
 * @author oulis
 * @file Implementation of Rmi Methods
 */

package RmiServer;

import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class TheaterImpl
	extends UnicastRemoteObject
	implements TheaterInter {
		private static final long serialVersionUID = 1L;
		
		private static Theater t;
		private static ArrayList<Reservation> reservations;
		
		public TheaterImpl()
			throws RemoteException {
				super();
				t = new Theater();
				reservations = new ArrayList<>();
		}
		
		public synchronized Theater checkTheater()
			throws RemoteException {
				return t;
		}
		
		public synchronized float book (String userId, String type, int number, String name)
			throws RemoteException {
				float amount = 0;
				Reservation r;
				switch (type) {
					case "ZoneA":
						amount = t.reservationA (number);
						break;
					case "ZoneB":
						amount = t.reservationB (number);
						break;
					case "ZoneC":
						amount = t.reservationC (number);
						break;
					case "ZoneCentral":
						amount = t.reservationCentral (number);
						break;
					case "ZoneFrame":
						amount = t.reservationFrame (number);
						break;
					default:
						break;
				}
				
				if (amount > 0) {
					r = new Reservation(userId, name, type, number, LocalDateTime.now().toString());
					reservations.add(r);
				}
				
				return amount;
			}
			
		public synchronized ArrayList<Reservation> guests ()
			throws RemoteException {
				return reservations;
			}
			
		public synchronized float cancel (String userId, String type, int number, String name)
			throws RemoteException {
				float amount = 0;
				Reservation tmp = new Reservation (userId, name, type, number);
				int position = -1;
				
				for(int j=0; j < reservations.size(); j++) {
					if (reservations.get(j).equals (tmp) && reservations.get(j).canCancel (tmp)) {
						position = j;
						break;
					}
				}
				if (position != -1) {
				
					//Call Back object initialize.
					CallBackServerImpl callback = new CallBackServerImpl();
					
					//Update the position index of reservations.
					reservations.get(position).sub(tmp);
					
					//Remove the reservations object if the seats of reservation
					//is less than 0.
					if (reservations.get(position).getNumber() <= 0) {
						reservations.remove(position);
					}
					
					switch (type) {
						case "ZoneA":
							amount = t.cancelA (number);
							callback.doCallBacksA();
							break;
						case "ZoneB":
							amount = t.cancelB (number);
							callback.doCallBacksB();
							break;
						case "ZoneC":
							amount = t.cancelC (number);
							callback.doCallBacksC();
							break;
						case "ZoneCentral":
							amount = t.cancelCentral (number);
							callback.doCallBacksCentral();
							break;
						case "ZoneFrame":
							amount = t.cancelFrame (number);
							callback.doCallBacksFrame();
							break;
						default:
							break;
					}
				}
				
				return amount;
			}
				
}
