package Payment;

public class CardPaymentStrategy implements PaymentStrategy {
  @Override 
  public PaymentStatus processPayment(double amount){
    System.out.println("CARD payment has been received for amount :"+amount);
    return PaymentStatus.SUCCESS;
  }
}
