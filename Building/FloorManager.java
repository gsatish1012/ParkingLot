package Building;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import Ticket.ChargeType;
import Parking.ParkingSpot;
import Parking.ParkingSpotFactory;
import Parking.ParkingStatus;
import Ticket.VehicleType;

public class FloorManager {
  int floorNumber;
  private final Map<VehicleType, List<ParkingSpot>> parkingSpots;
  private final Map<VehicleType, AtomicInteger> atomicCounter;
  private final Map<VehicleType, AtomicInteger> availableCounts;
  private final ReentrantLock floorLock = new ReentrantLock();
  private final ParkingSpotFactory parkingSpotFactory;
  public FloorManager(int floorNumber, int twoWheelerCount, int fourWheelerCount) {
    this.parkingSpotFactory=new ParkingSpotFactory();
    this.floorNumber = floorNumber;
    this.parkingSpots = new EnumMap<>(VehicleType.class);
    this.atomicCounter = new EnumMap<>(VehicleType.class);
    this.availableCounts = new EnumMap<>(VehicleType.class);

    parkingSpots.put(VehicleType.TWO_WHEELER, new ArrayList<>());
    parkingSpots.put(VehicleType.FOUR_WHEELER, new ArrayList<>());

    atomicCounter.put(VehicleType.TWO_WHEELER, new AtomicInteger(0));
    atomicCounter.put(VehicleType.FOUR_WHEELER, new AtomicInteger(0));

    availableCounts.put(VehicleType.TWO_WHEELER, new AtomicInteger(0));
    availableCounts.put(VehicleType.FOUR_WHEELER, new AtomicInteger(0));

    createParkingSpots(floorNumber,VehicleType.TWO_WHEELER,twoWheelerCount);
    createParkingSpots(floorNumber,VehicleType.FOUR_WHEELER,fourWheelerCount);
  }

  private void createParkingSpots(int floorNumber,VehicleType vehicleType,int count) {
    List<ParkingSpot> spots = parkingSpots.get(vehicleType);
    AtomicInteger counter = atomicCounter.get(vehicleType);
    
    for (int i = 1; i <= count; i++) {
      String spotId = "F-" + this.floorNumber;
      spotId+= vehicleType.equals(VehicleType.TWO_WHEELER) ? "-2W-" : "-4W-";
      spotId+=counter.incrementAndGet();
      ParkingSpot spot = parkingSpotFactory.createParkingSpot(floorNumber,spotId, ParkingStatus.AVAILABLE, ChargeType.HOURLY, vehicleType);
      spots.add(spot);
    }
    availableCounts.get(vehicleType).addAndGet(count);
  }

  public ParkingSpot findandAssignSpot(VehicleType vehicleType) {
    AtomicInteger counter = availableCounts.get(vehicleType);
    if (counter==null || counter.get()<=0)
      return null;
    floorLock.lock();
    try {
      List<ParkingSpot> spots = parkingSpots.get(vehicleType);
      if (spots == null)
        return null;
      for (ParkingSpot spot : spots) {
        if (spot.getParkingStatus().equals(ParkingStatus.AVAILABLE)) {
          spot.setParkingStatus(ParkingStatus.OCCUPIED);
          counter.decrementAndGet();
          return spot;
        }
      }
      return null;
    } finally {
      floorLock.unlock();
    }
  }

  public void releaseSpot(ParkingSpot parkingSpot) {
    AtomicInteger counter = availableCounts.get(parkingSpot.getVehicleType());
    floorLock.lock();
    try {
      parkingSpot.setParkingStatus(ParkingStatus.AVAILABLE);
      counter.incrementAndGet();
    } finally {
      floorLock.unlock();
    }
  }

  public void addParkingSpots(VehicleType vehicleType,int count){
    createParkingSpots(this.floorNumber, vehicleType, count);
  }
  public int getFloorNumber(){
    return this.floorNumber;
  }
}
