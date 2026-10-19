package Ticket;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class TicketManager {
  private final AtomicInteger counter = new AtomicInteger(3000);
  TicketRepository ticketRepository;

  public TicketManager(TicketRepository ticketRepository) {
    this.ticketRepository = ticketRepository;
  }

  public Ticket generateTicket(String vehicleNumber, ParkingSpot parkingSpot) {
    int ticketId = counter.incrementAndGet();
    Ticket ticket = new Ticket(ticketId, vehicleNumber, parkingSpot);
    ticketRepository.saveTicket(ticket);
    System.out.println("Ticket generated for Vehicle: "+vehicleNumber+ " with ID: "+ ticketId);
    return ticket;
  }

  public void printTicketDetails(int ticketId) {
    Optional<Ticket> ticketOpt = ticketRepository.getTicketbyId(ticketId);

    ticketOpt.ifPresentOrElse(
        ticket -> {
          // Executed if the ticket is found
          System.out.println("================================");
          System.out.println("       PARKING TICKET DETAILS   ");
          System.out.println("================================");
          System.out.println("Ticket ID     : " + ticket.getTicketId());
          System.out.println("Vehicle No    : " + ticket.getVehicleNumber());
          System.out.println("Floor Number  : " + ticket.parkingSpot.getFloorNumber());
          System.out.println("Spot ID       : " + ticket.parkingSpot.getSpotId());
          System.out.println("Entry Time    : " + ticket.getEntryTime());
          System.out.println("================================");
        },
        () -> {
          // Executed if the ticket is NOT found
          System.out.println("Error: Ticket with ID " + ticketId + " not found.");
        });
  }
}
