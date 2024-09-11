package PaymentMethod;

public class CashPayment implements Payment {

	@Override
	public boolean pay() {
		
		System.out.println("Cash Paymet method");
		return true;
	}
		
	
	

}
