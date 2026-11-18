import java.util.List;

public class TicketService {
    private Speicher<Ticket> ticketSpeicher = new Speicher<>();
    private DateiManager dateiManager = new DateiManager();

    //Konstruktor: Wird automatisch aufgerufen wenn wir "New TicketService() machen!
    public TicketService() {
        for(Ticket t : dateiManager.ladeTickets()){
            this.ticketSpeicher.speichern(t);
        }
    }

    public void erstelleTicket(int id, String titel){
        //Geschäftsregel: Ein neues Ticket startet IMMEr als OPEN
        Ticket neuesTicket = new Ticket(id, titel, TicketStatus.OPEN);
        this.ticketSpeicher.speichern(neuesTicket);
    }

    public List<Ticket> alleTickets(){
        return this.ticketSpeicher.holeAlle();
    }

    public Ticket sucheTicket(int id){
        //Gib das Ticket zurück - oder wirft unsere Exception weiter an den Aufurufer!
        return this.ticketSpeicher.finden(id);
    }

    public void allesSpeichern(){
        this.dateiManager.speicherTickets(this.ticketSpeicher.holeAlle());
    }
}
