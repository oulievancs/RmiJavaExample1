/**
 *
 * @author oulis
 * @file Zone Implementation.
 */

package RmiServer;

import java.io.Serializable;

public class TheaterZone implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private String typeZone;
	private int free;
	private float cost;
	
	public TheaterZone() {
		this.typeZone = "N/A";
		this.free = 0;
		this.cost = 0;
	}
	
	public TheaterZone(String TypeZone, int Free, float Cost) {
		this.typeZone = TypeZone;
		this.free = Free;
		this.cost = Cost;
	}
	
	public float reservation (int count) {
		float amount = 0;
		if (this.free >= count) {
			this.free -= count;
			amount += count * this.cost;
		}
		return amount;
	}
	
	public float cancel (int count) {
		float amount = 0;
		this.free += count;
		amount -= count * this.cost;
		return amount;
	}
	
	public void print() {
		System.out.print("Gia tis theseis typou " + this.typeZone);
		System.out.print(", " + this.free + " Theseis diathsimes");
		System.out.println(", Pou kostizoun " + this.cost + "$ .");
	}
}
