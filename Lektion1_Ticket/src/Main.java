//Strg + Enter
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //1. Map erstellen (Key ist die ID, Value ist das Ticket)
        Map<Integer, Ticket> ticketSpeicher = new HashMap<>();

        //2. Etas in die Map legen (.put)
        Ticket neuesTicket  = new Ticket(1, "Drucker brennt", TicketStatus.OPEN);
        Ticket neuesTicket2 = new Ticket(2, "Drucker hat spaß", TicketStatus.IN_PROGRESS);
        Ticket neuesTicket3 = new Ticket(3, "Drucker hat fertig", TicketStatus.RESOLVED);

        ticketSpeicher.put(1, neuesTicket);
        ticketSpeicher.put(2, neuesTicket2);
        ticketSpeicher.put(3, neuesTicket3);

        //3. Etwas aus der Map herausholen (.get) - geht in Millisekunden!
        Ticket gefunden = ticketSpeicher.get(1);
        Ticket gefunden2 = ticketSpeicher.get(2);

        System.out.println("Ticket Titel: " +gefunden2.getTitle());
    }
}