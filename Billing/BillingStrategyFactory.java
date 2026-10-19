package Billing;

import Ticket.ChargeType;

public class BillingStrategyFactory {
  public BillingStrategy generateStrategy(ChargeType chargeType){
    return switch(chargeType){
    case DAILY -> new DailyBillingStrategy();
    case HOURLY -> new HourlyBillingStrategy();
    default ->null;
    };
  }
}
