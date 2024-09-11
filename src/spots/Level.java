package spots;

import java.util.*;

import monitor.BoardObserver;
import vehicle.Vehicle;

public class Level {
	
	
	
	private int floorNo;
	
	private Queue<ParkingSpot> freeSpots;
	private Map<ParkingSpot,String> occupied;
	private BoardObserver boardObserver;
	
	
	private Level(int spotseachlevel,int floorNo,BoardObserver obs) {
		
		
		boardObserver = obs;
		
		occupied  = new HashMap();
		 
		freeSpots = new LinkedList();
		
		this.floorNo = floorNo;
		
		for(int i =0;i<spotseachlevel;i++) {
			
			freeSpots.add(ParkingSpot.getParkingSpot(i, floorNo));
		}

		
	}
	
	
	public static Level getLevel(int spotseachlevel,int floorNo,BoardObserver obs) {
		
		return new Level(spotseachlevel,floorNo,obs);
	}
	
	public int getFreeSpots() {
		
	
		return freeSpots.size();
	}
	
	public ParkingSpot bookSpot(Vehicle v) {
		
		ParkingSpot spot = freeSpots.poll();
		if(spot==null)return null;
		
		String hash = getHash(occupied.size()+1);
		boardObserver.update(floorNo, spot.getSpotNo(), false);
		occupied.put(spot,hash );
		spot.bookSpot(v,hash);
		return spot;
		
	}
	
	public String freeSpot(ParkingSpot spot) {
		
		
		String id =this.occupied.get(spot);
		this.occupied.remove(spot);
		spot.freeSpot();
		boardObserver.update(floorNo, spot.getSpotNo(), true);
		freeSpots.add(spot);
		
		return id;
	}
	

	private String getHash(int i) {
		
		String hash = floorNo+"@"+i;
		
		return hash;
	}
	
}
