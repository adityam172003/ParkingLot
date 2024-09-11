package tickit;

import java.util.Date;

import PaymentMethod.Payment;
import spots.Level;
import spots.ParkingSpot;

public class Tickit {
		
	private Date issuedAt;
	
	private ParkingSpot spot;
	
	private Level level;
	

	
	private Tickit(Date date , ParkingSpot spot,Level level) {
		
		this.issuedAt = date;
		this.spot 	  = spot;
		this.level	  = level;
		
	}
	
	public static Tickit getTickit(Date date , ParkingSpot spot,Level level) {
		
		return new Tickit(date , spot,level);
	}
	
	public ParkingSpot getParkingSpot() {
		return spot;
	}
	

	public Level pay(Payment payment)
	{
		if(payment ==null)return null;
		int price = spot.spotPrice();
		System.out.println("Price : "+price);
		payment.pay();
		return level;
	}
	 
    
	
		
}
