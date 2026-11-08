public class Main {
    public static void main(String[] args) {
        //Hier startet das Programm!
        //Mit 'new' erschaffen wir ein Objekt aus unserer Klasse
        Ticket meinTicket  = new Ticket(1, "Drucker brennt", TicketStatus.OPEN);

        //KOnsolenausgabe
        System.out.println("Ticket Titel: " + meinTicket.getTitle());
    }
}