package Ticket;

public class FourWheelerSpot implements ParkingSpot {
  String spotId;
  int floorNumber;
  ParkingStatus parkingStatus;
  ChargeType chargeType;
  double chargeAmount;

  public FourWheelerSpot(int floorNumber,String spotId,ParkingStatus parkingStatus,ChargeType chargeType,double chargeAmount){
    this.spotId=spotId;
    this.floorNumber=floorNumber;
    this.parkingStatus=parkingStatus;
    this.chargeAmount=chargeAmount;
    this.chargeType=chargeType;
  }

  @Override 
  public int getFloorNumber() {
    return floorNumber;
  }
  @Override 
  public String getSpotId() {
    return spotId;
  }
  @Override
  public VehicleType getVehicleType() {
    return VehicleType.FOUR_WHEELER;
  }
  @Override
  public ParkingStatus getParkingStatus() {
    return parkingStatus;
  }
  @Override
  public ChargeType getChargeType() {
    return chargeType;
  }
  @Override
  public double getChargeAmount() {
    return chargeAmount;
  }
  @Override 
  public void setParkingStatus(ParkingStatus parkingStatus){
    this.parkingStatus=parkingStatus;
  }
}
