package Payment;

public class PaymentService {
  PaymentStrategyFactory paymentStrategyFactory;

  public PaymentService(){
    this.paymentStrategyFactory=new PaymentStrategyFactory();
  }

  public PaymentStatus processPayment(PaymentMode paymentMode,double amount){
    PaymentStrategy strategy = paymentStrategyFactory.generateStrategy(paymentMode);
    return strategy.processPayment(amount);
  }
}
