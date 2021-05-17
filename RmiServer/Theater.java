/**
 *
 * @author oulis
 */
 
package RmiServer;

import java.io.Serializable;

public class Theater implements Serializable {
	private static final long serialVersionUID = 2L;
	
	private static final int zoneAThesis = 200;
	private static final int zoneBThesis = 300;
	private static final int zoneCThesis = 500;
	private static final int zoneCentralZoneThesis = 100;
	private static final int zoneFThesis = 50;
	
	private static final float zoneACost = 50;
	private static final float zoneBCost = 40;
	private static final float zoneCCost = 30;
	private static final float zoneCentralZoneCost = 25;
	private static final float zoneFCost = 20;
	
	private TheaterZone zoneA;
	private TheaterZone zoneB;
	private TheaterZone zoneC;
	private TheaterZone centralZone;
	private TheaterZone frameZone;
	
	public Theater() {
		this.zoneA = new TheaterZone ("A: PLATEIA", zoneAThesis, zoneACost);
		this.zoneB = new TheaterZone ("B: PLATEIA", zoneBThesis, zoneBCost);
		this.zoneC = new TheaterZone ("C: PLATEIA", zoneCThesis, zoneCCost);
		this.centralZone = new TheaterZone ("CENTRAL ZONE", zoneCentralZoneThesis, zoneCentralZoneCost);
		this.frameZone = new TheaterZone ("FRAME ZONE", zoneFThesis, zoneFCost);
	}
	
	public float reservationA (int  count) {
		float amount = this.zoneA.reservation (count);
		return amount;
	}
	
	public float reservationB (int count) {
		float amount = this.zoneB.reservation (count);
		return amount;
	}
	
	public float reservationC (int count) {
		float amount = this.zoneC.reservation (count);
		return amount;
	}
	
	public float reservationCentral (int count) {
		float amount = this.centralZone.reservation (count);
		return amount;
	}
	
	public float reservationFrame (int count) {
		float amount = this.frameZone.reservation (count);
		return amount;
	}
	
	public float cancelA (int count) {
		float amount = this.zoneA.cancel (count);
		return amount;
	}
	
	public float cancelB (int count) {
		float amount = this.zoneB.cancel (count);
		return amount;
	}
	
	public float cancelC (int count) {
		float amount = this.zoneC.cancel (count);
		return amount;
	}
	
	public float cancelCentral (int count) {
		float amount = this.centralZone.cancel (count);
		return amount;
	}
	
	public float cancelFrame (int count) {
		float amount = this.frameZone.cancel (count);
		return amount;
	}
	
	public void check() {
		System.out.println("----------------------------------------");
		this.zoneA.print();
		this.zoneB.print();
		this.zoneC.print();
		this.centralZone.print();
		this.frameZone.print();
		System.out.println("----------------------------------------");
	}
}
