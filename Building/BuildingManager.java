package Building;

import java.util.HashMap;
import java.util.Map;

import Ticket.ParkingSpot;
import Ticket.TicketRepository;
import Ticket.VehicleType;

public class BuildingManager {
  // private final List<FloorManager> floorManagers;
  private final Map<Integer,FloorManager> floorManagers;
  TicketRepository ticketRepository;
  public BuildingManager(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
    this.floorManagers = new HashMap<>();
  }

  public void addFloor(int floorNumber, int twoWheelerCount, int fourWheelerCount) {
    FloorManager floorManager = new FloorManager(floorNumber, twoWheelerCount, fourWheelerCount);
    floorManagers.put(floorNumber, floorManager);
  }

  public void removeFloor(FloorManager floorManager) {
    floorManagers.values().remove(floorManager);
  }

  public void addParkingSpots(int floorNumber,VehicleType vehicleType,int count){
    FloorManager floorManager = floorManagers.get(floorNumber);
    floorManager.addParkingSpots(vehicleType,count);
  }

  public ParkingSpot parkVehicle(VehicleType vehicleType) {
    ParkingSpot assignedSpot = null;

    for (FloorManager floorManager : floorManagers.values()) {
      assignedSpot = floorManager.findandAssignSpot(vehicleType);
      if(assignedSpot!=null)
        break;
    }
    return assignedSpot;
  }
}
