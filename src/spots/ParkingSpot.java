package spots;

import vehicle.Vehicle;

public class ParkingSpot {
	
	private int spotNo;
	
	private String spotId;

	private int spotFloorNO;
	
	private Vehicle vehicle;
	
	private boolean isFree;
	
	
	private ParkingSpot(int spotNo,int spotFloorNo) {
		
		this.spotNo = spotNo;
		this.spotFloorNO = spotFloorNo;
		this.vehicle  = null;
		this.isFree   = true;
		this.spotId	  = null;
		
	}
	
	
	
	public static ParkingSpot getParkingSpot(int spotNo,int spotFloorNo)
	{
		return new ParkingSpot(spotNo, spotFloorNo);
		
	}
	
	
	public boolean isFreeSpot() {
		
		return isFree;
	}
	
	public void bookSpot(Vehicle v,String spotId) {
		this.vehicle=v;
		this.spotId=spotId;
		this.isFree = false;
	}
	
	public String getSpotId()
	{
		return spotId;
	}
	
	public int getSpotNo() {
		return spotNo;
	}
	
	public void freeSpot() {
		this.spotId=null;
		this.vehicle=null;
		this.isFree=true;
	}
	
	public int spotPrice() {
		
		return  vehicle.getPrice();
	}
	
	
	
}
