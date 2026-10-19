package Payment;

public class CashPaymentStrategy implements PaymentStrategy {
  @Override 
  public PaymentStatus processPayment(double amount){
    System.out.println("CASH has been received for amount: "+amount);
    return PaymentStatus.SUCCESS;
  }
}
