import Billing.BillingManager;
import Billing.BillingService;
import Building.BuildingManager;
import Building.EntryGate;
import Building.ExitGate;
import Payment.PaymentManager;
import Payment.PaymentMode;
import Payment.PaymentService;
import Ticket.TicketManager;
import Ticket.TicketRepository;
import Ticket.VehicleType;

public class App {
  public static void main(String[] args) {
    System.out.println("Welcome to Parking LOT");
    TicketRepository ticketRepository = new TicketRepository();
    BillingService billingService = new BillingService();
    PaymentService  paymentService = new PaymentService();
    BuildingManager buildingManager = new BuildingManager();
    TicketManager ticketManager = new TicketManager(ticketRepository);
    BillingManager billingManager = new BillingManager(billingService);
    PaymentManager paymentManager = new PaymentManager(paymentService);

    buildingManager.addFloor(1, 2, 1);
    buildingManager.addFloor(2, 0, 2);

    EntryGate entryGate1 = new EntryGate(ticketManager, buildingManager);
    EntryGate entryGate2 = new EntryGate(ticketManager, buildingManager);
    entryGate1.generateTicket(VehicleType.TWO_WHEELER, "AP051526");
    entryGate1.generateTicket(VehicleType.TWO_WHEELER, "AP051527");
    entryGate1.generateTicket(VehicleType.FOUR_WHEELER, "AP059323");

    entryGate2.generateTicket(VehicleType.TWO_WHEELER, "AP051528");
    entryGate2.generateTicket(VehicleType.FOUR_WHEELER, "AP059324");

    buildingManager.addParkingSpots(2, VehicleType.TWO_WHEELER, 2);
    entryGate2.generateTicket(VehicleType.TWO_WHEELER, "AP051528");
  

    ExitGate exitGate1= new ExitGate(ticketRepository, billingManager, paymentManager,buildingManager);
    ExitGate exitGate2= new ExitGate(ticketRepository, billingManager, paymentManager,buildingManager);

    exitGate1.exitVehicle(3001, PaymentMode.CASH);
    exitGate2.exitVehicle(3003, PaymentMode.CARD);

    entryGate2.generateTicket(VehicleType.TWO_WHEELER, "AP051529");
  }
}
