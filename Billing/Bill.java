package Billing;

import java.time.LocalDateTime;

public class Bill {
  int ticketId;
  int billId;
  LocalDateTime entryTime;
  LocalDateTime exitTime;
  double amount;
  String vehicleNumber;
  Status isPaid;

  public Bill(int ticketId, int billId, LocalDateTime entryTime, LocalDateTime exitTime, double amount) {
    this.ticketId = ticketId;
    this.billId = billId;
    this.entryTime = entryTime;
    this.exitTime = exitTime;
    this.amount = amount;
    this.isPaid = Status.PENDING;
  }

  public void setStatus(Status status) {
    this.isPaid = status;
  }

  public int getTicketId() {
    return ticketId;
  }

  public int getBillId() {
    return billId;
  }

  public LocalDateTime getEntryTime() {
    return entryTime;
  }

  public LocalDateTime getExitTime() {
    return exitTime;
  }

  public double getAmount() {
    return amount;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public Status getBillStatus() {
    return this.isPaid;
  }
}
