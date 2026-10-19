package Building;

import Billing.Bill;
import Billing.BillingManager;
import Payment.Payment;
import Payment.PaymentManager;
import Payment.PaymentMode;
import Ticket.Ticket;
import Ticket.TicketRepository;

public class ExitGate {
  TicketRepository ticketRepository;
  BillingManager billingManager;
  PaymentManager paymentManager;
  public ExitGate(TicketRepository ticketRepository, BillingManager billingManager, PaymentManager paymentManager) {
    this.ticketRepository = ticketRepository;
    this.billingManager = billingManager;
    this.paymentManager = paymentManager;
  }

  public void exitVehicle(int ticketId,PaymentMode paymentMode){
    Ticket ticket = ticketRepository.getTicketbyId(ticketId)
    .orElseThrow(() -> new IllegalArgumentException("Ticket not found: " + ticketId));
    Bill bill= billingManager.generateBill(ticket);
    billingManager.printBillDetails(bill.getBillId());
    Payment payment = paymentManager.processPayment(bill,paymentMode);
    paymentManager.printPaymentDetails(payment.getPaymentId());
  }
}
