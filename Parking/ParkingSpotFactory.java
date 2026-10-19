package Parking;

import Ticket.ChargeType;
import Ticket.VehicleType;

public class ParkingSpotFactory {
  public ParkingSpot createParkingSpot(int floorNumber,String spotId,ParkingStatus parkingStatus,ChargeType chargeType ,VehicleType vehicleType){
    return switch(vehicleType){
      case TWO_WHEELER -> new TwoWheelerSpot(floorNumber,spotId,parkingStatus,chargeType,20);
      case FOUR_WHEELER -> new FourWheelerSpot(floorNumber,spotId,parkingStatus,chargeType,50);
      default -> null;
    };

  }
}
