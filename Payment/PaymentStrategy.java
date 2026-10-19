package Payment;

public interface PaymentStrategy {
  public PaymentStatus processPayment(double amount);
}
