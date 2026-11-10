//Strg + Enter
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        //1. Den Universal-Speicher für Tickets erschaffen
        Speicher<Ticket> ticketSpeicher = new Speicher<>();

        //2. Tickets erschaffen
        Ticket neuesTicket = new Ticket(1, "Drucker brennt", TicketStatus.OPEN);
        Ticket neuesTicket2 = new Ticket(2, "Drucker hat spaß", TicketStatus.IN_PROGRESS);
        Ticket neuesTicket3 = new Ticket(3, "Drucker hat fertig", TicketStatus.RESOLVED);

        //3. Tickets speichern
        ticketSpeicher.speichern(neuesTicket);
        ticketSpeicher.speichern(neuesTicket2);
        ticketSpeicher.speichern(neuesTicket3);

        //4. Ticket suchen und in einer Variable auffangen
        Ticket gefunden = ticketSpeicher.finden(2);

        //5. Titel ausgeben
        System.out.println("Gefunden: " + gefunden.getTitle());
    }
}