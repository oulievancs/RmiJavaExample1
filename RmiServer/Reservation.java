/**
 *
 * @author oulis
 * @file Reservation class.
 */
 
package RmiServer;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reservation implements Serializable {
	private static final long serialVersionUID = 4L;
	
	private String userId;
	private String name;
	private String type;
	private int number;
	private String time;
	
	public Reservation() {
		this.userId = "N/A";
		this.name = "N/A";
		this.type = "N/A";
		this.number = 0;
		this.time = "N/A";
	}
	
	public Reservation (String UserId, String Name, String Type, int Number) {
		this.userId = UserId;
		this.name = Name;
		this.type = Type;
		this.number = Number;
	}
	
	public Reservation (String UserId, String Name, String Type, int Number, String Time) {
		this.userId = UserId;
		this.name = Name;
		this.type = Type;
		this.number = Number;
		this.time = Time;
	}
	
	public void print() {
		System.out.println("Name: " + this. name + ", Seats Type: " + this.type + ", Seats Number: " + this.number + ", Time: " + this.time);
	}
	
	protected String getUserId () {
		return this.userId;
	}
	
	protected int getNumber () {
		return this.number;
	}
	
	protected String getName () {
		return this.name;
	}
	
	protected String getType() {
		return this.type;
	}
	
	protected void sub (Reservation a) {
		if (a.equals(this)) {
			this.number = this.number - a.getNumber();
			this.time = LocalDateTime.now().toString();
		}
	}
	
	public boolean equals (Reservation a) {
		boolean areEqual = false;
		if (a.getUserId().equals(this.userId) && a.getName().equals(this.name) && a.getType().equals(this.type))
			areEqual = true;
		return areEqual;
	}
	
	public boolean canCancel (Reservation a) {
		boolean canCancel = false;
		if (a.getNumber() <= this.number)
			canCancel = true;
		return canCancel;
	}
}
