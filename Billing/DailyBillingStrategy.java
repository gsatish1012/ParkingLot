package Billing;

import java.time.Duration;
import java.time.LocalDateTime;

public class DailyBillingStrategy implements BillingStrategy {
  @Override
  public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, double baseRate) {
    long days = Duration.between(entryTime, exitTime).toDays();
    days = Math.max(1, days); // Ensure at least 1 hour is charged
    return days * baseRate;
  }
}