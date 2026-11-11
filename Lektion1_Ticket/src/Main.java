//Strg + Enter
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Lektion 3. Den Universal-Speicher für Tickets erschaffen
        Speicher<Ticket> ticketSpeicher = new Speicher<>();

        //Lektion 1. Tickets erschaffen
        Ticket neuesTicket = new Ticket(1, "Drucker brennt", TicketStatus.OPEN);
        Ticket neuesTicket2 = new Ticket(2, "Drucker hat spaß", TicketStatus.IN_PROGRESS);
        Ticket neuesTicket3 = new Ticket(3, "Drucker hat fertig", TicketStatus.RESOLVED);

        //Lektion 3. Tickets speichern (ohne ID-Übergabe!)
        ticketSpeicher.speichern(neuesTicket);
        ticketSpeicher.speichern(neuesTicket2);
        ticketSpeicher.speichern(neuesTicket3);

        //Lektion 4: Filtern mit Streams und Lambdas
        List<Ticket> offeneTickets = ticketSpeicher.holeAlle().stream()
                .filter(t -> t.getStatus() == TicketStatus.OPEN)
                .toList();
        System.out.println("Anzahl offener Tickets: " + offeneTickets.size());
        System.out.println("-------------------------------------------");
    }
}