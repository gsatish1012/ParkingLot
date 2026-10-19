package Parking;

import Ticket.ChargeType;
import Ticket.VehicleType;

public interface ParkingSpot {
  public String getSpotId();
  public int getFloorNumber();
  public VehicleType getVehicleType();

  public ParkingStatus getParkingStatus();

  public ChargeType getChargeType();

  public double getChargeAmount();

  public void setParkingStatus(ParkingStatus parkingStatus);

}
