package vehicle;


// you can say strategy design pattern but not actual use of it 



public class Vehicle {
	
	private VehicleType type;
	
	private String vehicleLicence;
	
	
	private Vehicle( VehicleType vt,String lisc )
	{
		type = vt;
		vehicleLicence =lisc;
	}
	
	
	public static Vehicle getVehicle(VehicleType vt , String lisc) {
			
//		System.out.println("Please specify vehicle type : ");
//		System.out.println("1. Private 2 weelers");
//		System.out.println("2. Private 4 weelers");
//		System.out.println("3. Transport cars ");
		
		return new Vehicle(vt,lisc);
		
	}
	
	
	public VehicleType getType()
	{
		return type;
	}
	
	public int getPrice() {
		
		return type.price();
	}
	

}
