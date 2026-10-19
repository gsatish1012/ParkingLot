package Billing;

import java.time.Duration;
import java.time.LocalDateTime;

public class HourlyBillingStrategy implements BillingStrategy {
  @Override
  public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, double hourlyRate) {
    long hours = Duration.between(entryTime, exitTime).toHours();
    hours = Math.max(1, hours); // Ensure at least 1 hour is charged
    return hours * hourlyRate;
  }
}

// package Billing;

// import java.time.Duration;
// import java.time.LocalDateTime;

// public class HourlyBillingStrategy implements BillingStrategy {
//   @Override
//   public double calculateFee(LocalDateTime entryTime, LocalDateTime exitTime, double hourlyRate) {
//     long hours = Duration.between(entryTime, exitTime).toHours();
//     hours = Math.max(1, hours); // Ensure at least 1 hour is charged
//     return hours * hourlyRate;
//   }
// }