package Building;

import Parking.ParkingSpot;
import Ticket.Ticket;
import Ticket.TicketManager;
import Ticket.VehicleType;

public class EntryGate {
  TicketManager ticketManager;
  BuildingManager buildingManager;
  public EntryGate(TicketManager ticketManager,BuildingManager buildingManager){
    this.buildingManager=buildingManager;
    this.ticketManager=ticketManager;
  }

  public void generateTicket(VehicleType vehicleType,String vehicleNumber){
    ParkingSpot assignedSpot = buildingManager.parkVehicle(vehicleType);
    if (assignedSpot == null) {
      System.out.println("Parking Full! No available spots for " + vehicleType);
      return;
    }
    Ticket ticket = ticketManager.generateTicket(vehicleNumber,assignedSpot);
    ticketManager.printTicketDetails(ticket.getTicketId());
  }
}
