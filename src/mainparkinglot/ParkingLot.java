package mainparkinglot;


import java.util.*;

import PaymentMethod.CashPayment;
import PaymentMethod.OnlinePayment;
import PaymentMethod.Payment;
import monitor.BoardObserver;
import spots.Level;
import spots.ParkingSpot;
import tickit.Tickit;
import vehicle.Vehicle;

public class ParkingLot {
	
	private List<Level>levels;
	
	private int totalLevels ;
	private int spotsEachLevel;
	
	private BoardObserver observer;
	
	
	private ParkingLot(int totalLevels,int spots) {
		this.totalLevels=totalLevels;
		this.spotsEachLevel=spots;
		
		this.observer = new BoardObserver(totalLevels, spots);
		levels = new ArrayList();
		
		for(int i=0;i<totalLevels;i++) {
			
			levels.add(Level.getLevel(spots, i, observer));
			
		}
		
		
	}
	
	public static ParkingLot createParkingLot(int totalLevels,int spots)
	{
		return new ParkingLot(totalLevels,spots);
	}
	
	
	public Tickit bookSlot(Vehicle v)
	{
		
		ParkingSpot spot=null;
		int level=0;
		
		for(int i=0;i<totalLevels;i++) {
			spot = levels.get(i).bookSpot(v);
			if(spot!=null)
			{
				level =i;
				break;
			}
		}
		if(spot==null)return null;
		
		Date date = new Date();
		
		Tickit tickit = Tickit.getTickit(date, spot,levels.get(level));
		
		return tickit;
		
		
	}
	
	
	
	private Level payBill(Tickit tickit) {
		
		Payment method=null;
		System.out.println("Please enter payment method");
		int n=1;
		Scanner sc = new Scanner(System.in); 
		n = sc.nextInt();
		switch(n) {
		
		case 1: {
			method = new OnlinePayment();
			break;
		}
		case 2:{
			method = new CashPayment();
			break;
		}
		default:
		{
			method = new CashPayment();
		}
				
		}
		
		return tickit.pay(method);
	}
	
	
	public boolean releaseSpot(Tickit tickit) {
		
		
		Level level = payBill(tickit);
	
		level.freeSpot(tickit.getParkingSpot());
		
		return true;
	}
	
	
	
	
}
