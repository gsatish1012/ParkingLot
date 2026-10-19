package Billing;

import java.time.LocalDateTime;

public interface BillingStrategy {
  public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, double baseRate);
}
