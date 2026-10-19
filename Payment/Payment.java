package Payment;

public class Payment {
  int paymentId;
  int billId;
  PaymentMode paymentMode;
  double amount;
  PaymentStatus paymentStauts;
  public Payment(int paymentId, int billId, PaymentMode paymentMode, double amount,PaymentStatus paymentStauts) {
    this.paymentId = paymentId;
    this.billId = billId;
    this.paymentMode = paymentMode;
    this.amount = amount;
    this.paymentStauts=paymentStauts;
  }
  public int getPaymentId() {
    return paymentId;
  }
  public int getBillId() {
    return billId;
  }
  public double getAmount() {
    return amount;
  }
  public PaymentMode getPaymentMode() {
    return paymentMode;
  }
  public PaymentStatus getPaymentStauts() {
    return paymentStauts;
  }
  

  
}
