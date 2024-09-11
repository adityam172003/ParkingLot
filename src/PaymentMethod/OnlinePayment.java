package PaymentMethod;

public class OnlinePayment implements Payment{

	
	public boolean pay() {
		
		System.out.println("Online Payment Done");
		return true;
		
	}
	
}
