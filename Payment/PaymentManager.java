package Payment;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import Billing.Bill;

public class PaymentManager {
  PaymentService paymentService;
  Map<Integer,Payment> payments= new ConcurrentHashMap<>();
  private final AtomicInteger counter = new AtomicInteger(6000);
  
  public PaymentManager(PaymentService paymentService){
    this.paymentService=paymentService;
  }

  public Payment processPayment(Bill bill,PaymentMode paymentMode){
    PaymentStatus paymentStatus = paymentService.processPayment(paymentMode, bill.getAmount());
    int paymentId=counter.incrementAndGet();
    Payment payment = new Payment(paymentId, bill.getBillId(), paymentMode, bill.getAmount(), paymentStatus);
    payments.put(paymentId, payment);
    return payment;
  }

  public void printPaymentDetails(int paymentId) {
    Payment payment = payments.get(paymentId);
    System.out.println("================================");
    System.out.println("       PAYMENT DETAILS   ");
    System.out.println("================================");
    System.out.println("Payment ID     : " + payment.getPaymentId());
    System.out.println("BILL ID     : " + payment.getBillId());
    System.out.println("Amount   : " + payment.getAmount());
    System.out.println("Payment Mode    : " + payment.getPaymentMode());
    System.out.println("Payment status    : " + payment.getPaymentStauts());
    System.out.println("================================");
  }
}
