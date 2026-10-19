package Payment;

public class PaymentStrategyFactory {
  public PaymentStrategy generateStrategy(PaymentMode paymentMode){
    return switch(paymentMode){
      case CASH -> new CashPaymentStrategy();
      case UPI -> new UpiPaymentStrategy();
      case CARD -> new CardPaymentStrategy();
      default -> null;
    };
  }
}
