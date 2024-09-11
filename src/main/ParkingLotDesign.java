package main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

import mainparkinglot.ParkingLot;
import tickit.Tickit;
import vehicle.FourWeeler;
import vehicle.Transport;
import vehicle.TwoWeeler;
import vehicle.Vehicle;
import vehicle.VehicleType;


/*
 *  
 *  
 *  
 *  This is Basic LLD for Parking Lot System 
 *  
 *  Design patterns used 
 *  
 *  1 ] strategy design pattern 
 *  2 ] Factory design pattern 
 *  3 ] Singleton design pattern 
 *  4 ] Observer design pattern 
 * 
 * 
 * 
 */








public class ParkingLotDesign {
	public static void main(String[] args) {
		
		
		System.out.println("|.... Design Parking Lot ....|");
		
		ParkingLot plt = ParkingLot.createParkingLot(4,3);
		Scanner sc  = new Scanner(System.in);
		Map<Integer,Tickit> booked = new HashMap();
		for(int i =0;i<111;i++) {
			
			System.out.println("Enter operation :");
			int opt = sc.nextInt();
			
			if(opt ==1) {
				
				System.out.println("Choose vehicle type");
				VehicleType  v =null;
				int type = sc.nextInt();
				if(type==1) {
					v = new  TwoWeeler() ;
					
				}
				else if(type==2) {
					v = new  FourWeeler() ;
					
				}
				else  {
					 v = new Transport() ;
					
				}
				
				booked.put(i,plt.bookSlot(Vehicle.getVehicle(v, "MH091234")));
				System.out.println("Your Id : "+i);
			}
			else {
				System.out.println("Please enter your id");
				int id = sc.nextInt();
				Tickit t = booked.get(id);
				if(t==null)continue;
				booked.remove(t);
				plt.releaseSpot(t);
				
			}
			
		}
	}
}
