package Ticket;

import java.time.LocalDateTime;

import Parking.ParkingSpot;

public class Ticket {
  private int ticketId;
  private String vehicleNumber;
  private LocalDateTime entryTime;
  VehicleType vehicleType;
  ParkingSpot parkingSpot;

  public Ticket(int ticketId,String vehicleNumber,ParkingSpot parkingSpot){
    this.ticketId=ticketId;
    this.vehicleNumber=vehicleNumber;
    this.vehicleType=parkingSpot.getVehicleType();
    this.parkingSpot=parkingSpot;
    this.entryTime=LocalDateTime.now();
  }

  public int getTicketId() {
    return ticketId;
  }

  public String getVehicleNumber() {
    return vehicleNumber;
  }

  public LocalDateTime getEntryTime() {
    return entryTime;
  }

  public VehicleType getVehicleType() {
    return vehicleType;
  }

  public ParkingSpot getParkingSpot() {
    return parkingSpot;
  }

  

}
