package Billing;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import Ticket.Ticket;

public class BillingManager {
  private BillingService billingService;
  private Map<Integer, Bill> bills = new ConcurrentHashMap<>();
  private final AtomicInteger counter = new AtomicInteger(5000);

  public BillingManager(BillingService billingService) {
    this.billingService = billingService;
  }

  public Bill generateBill(Ticket ticket) {
    LocalDateTime exitTime = LocalDateTime.now();
    double amount = billingService.calculateFee(ticket, exitTime);
    Bill bill = new Bill(ticket.getTicketId(), counter.incrementAndGet(),ticket.getVehicleNumber(), ticket.getEntryTime(), exitTime, amount);
    bills.put(bill.getBillId(), bill);
    System.out.println("Billid: "+bill.getBillId()+" generated for ticket id : "+bill.getTicketId());
    return bill;
  }

  public void printBillDetails(int billId) {
    Bill bill = bills.get(billId);
    System.out.println("================================");
    System.out.println("       BILL DETAILS   ");
    System.out.println("================================");
    System.out.println("BILL ID     : " + bill.getBillId());
    System.out.println("Ticket ID     : " + bill.getTicketId());
    System.out.println("Vehicle No    : " + bill.getVehicleNumber());
    System.out.println("Entry Time    : " + bill.getEntryTime());
    System.out.println("Exit Time    : " + bill.getExitTime());
    System.out.println("Total Amount    : " + bill.getAmount());
    System.out.println("Bill status    : " + bill.getBillStatus());
    System.out.println("================================");
  }
}
