package Payment;

public class UpiPaymentStrategy implements PaymentStrategy {
  @Override 
  public PaymentStatus processPayment(double amount){
    System.out.println("UPI payment has been received for amount "+amount);
    return PaymentStatus.SUCCESS;
  }
}
