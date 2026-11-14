//Strg + Enter
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Lektion 3. Den Universal-Speicher für Tickets erschaffen
        Speicher<Ticket> ticketSpeicher = new Speicher<>();
        Speicher<User> userSpeicher = new Speicher<>();

        User max = new User(101, "Max Mustermann");
        User erika = new User(102, "Erika Musterfrau");

        //Lektion 1. Tickets erschaffen
        Ticket neuesTicket = new Ticket(1, "Drucker brennt", TicketStatus.OPEN);
        Ticket neuesTicket2 = new Ticket(2, "Drucker hat spaß", TicketStatus.IN_PROGRESS);
        Ticket neuesTicket3 = new Ticket(3, "Drucker hat fertig", TicketStatus.RESOLVED);

        //Lektion 3. Tickets speichern (ohne ID-Übergabe!)
        ticketSpeicher.speichern(neuesTicket);
        ticketSpeicher.speichern(neuesTicket2);
        ticketSpeicher.speichern(neuesTicket3);

        userSpeicher.speichern(max);
        userSpeicher.speichern(erika);

        neuesTicket.setBearbeiter(max);

        //Lektion 4: Filtern mit Streams und Lambdas
        List<Ticket> offeneTickets = ticketSpeicher.holeAlle().stream()
                .filter(t -> t.getStatus() == TicketStatus.OPEN)
                .toList();
        System.out.println("Anzahl offener Tickets: " + offeneTickets.size());
        System.out.println("-------------------------------------------");
        try{
            System.out.println("Suche nach Ticket 99...");
            Ticket fehlerTicket = ticketSpeicher.finden(99);
            System.out.println("Gefunden: " + fehlerTicket.getTitle());
        }catch(ObjektNichtGefundenException e){
            //Das Programm stürzt nicht ab, sondern landet hier im "Sicherheitsnetz"
            System.out.println("Hoppla, Fehler abgefangen: " + e.getMessage());
        }
        System.out.println("Das Programm läuft normal weiter");
        System.out.println("Bearbeiter von Ticket 1: " + neuesTicket.getBearbeiter().getName());
    }
}