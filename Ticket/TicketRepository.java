package Ticket;


import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class TicketRepository {
  private final Map<Integer,Ticket> tickets;

  public TicketRepository(){
    tickets= new ConcurrentHashMap<>();
  }

  public void saveTicket(Ticket ticket){
    tickets.put(ticket.getTicketId(),ticket);
  }

  public void removeTicket(int ticketId){
    tickets.remove(ticketId);
  }
  public Optional<Ticket> getTicketbyId(int ticketId){
    return Optional.ofNullable(tickets.get(ticketId));
  }

  public Map<Integer,Ticket> getAllTickets(){
    return tickets;
  }
} 
