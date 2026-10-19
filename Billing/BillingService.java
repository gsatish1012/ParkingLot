package Billing;

import java.time.LocalDateTime;

import Parking.ParkingSpot;
import Ticket.Ticket;

public class BillingService {
  BillingStrategyFactory billingStrategyFactory;
  public BillingService(){
    this.billingStrategyFactory=new BillingStrategyFactory();
  }

  public double calculateFee(Ticket ticket, LocalDateTime exitTime){
    ParkingSpot spot= ticket.getParkingSpot();
    BillingStrategy strategy = billingStrategyFactory.generateStrategy(spot.getChargeType());
    double fees= strategy.calculateFee(ticket.getEntryTime(), exitTime, spot.getChargeAmount());
    return fees;
  }
}
