//Strg + Enter
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateiManager dateiManager = new DateiManager();
        Speicher<Ticket> ticketSpeicher = new Speicher<>();

        //1. Beim Programmstart alle bestehendenTickets aus der CSV laden
        for (Ticket t : dateiManager.ladeTickets()){
            ticketSpeicher.speichern(t);
        }

        boolean laueft = true;

        //2. Hauptschleife des Programms
        while (laueft) {
            System.out.println("\n=== ISSUE TRACKER MENÜ ===");
            System.out.println("1 - Neues Ticket anlegen");
            System.out.println("2 - Alle Tickets anzeigen");
            System.out.println("3 - Ticket nach ID suchen");
            System.out.println("4 - Speichern & Beenden");
            System.out.print("Deine Wahl: ");

            String wahl = scanner.nextLine();

            switch (wahl) {
                case "1" ->{
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Titel: ");
                    String titel = scanner.nextLine();
                    Ticket neuesTicket = new Ticket(id, titel, TicketStatus.OPEN);
                    ticketSpeicher.speichern(neuesTicket);
                    System.out.println("Ticket #" + id + " angelegt!");
                }
                case "2" ->{
                    System.out.println("\n--- Alle Tickets ---");
                    for(Ticket t : ticketSpeicher.holeAlle()){
                        System.out.println("#" + t.getId() + " | " + t.getTitle() + " [" + t.getStatus() + "]");
                    }
                }
                case "3" ->{
                    System.out.print("ID: ");
                    try{
                        int id = Integer.parseInt(scanner.nextLine());
                        Ticket gesuchtesTicket = ticketSpeicher.finden(id);
                        System.out.println("Titel: " + gesuchtesTicket.getTitle());

                    }catch (ObjektNichtGefundenException e){
                        System.out.println("Nicht geklappt: " + e.getMessage());
                    }catch (NumberFormatException e){
                        System.out.println("Bitte gib eine gültige Zahl als ID ein!");
                    }
                }
                case "4" ->{
                    //3. Beim beenden alles sicher auf die Festplatte schreiben
                    dateiManager.speicherTickets(ticketSpeicher.holeAlle());
                    laueft = false;
                    System.out.println("Programm beendet. Bis zum nächsten Mal!");
                }
                default -> System.out.println("Ungültige Eingabe, bitte 1-4 wählen!");
            }
        }
        scanner.close();
    }
}