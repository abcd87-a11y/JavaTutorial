//Strg + Enter
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Unser einziger Ansprechpartner für die Logik
        TicketService service = new TicketService();

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
                    System.out.println("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Titel: ");
                    String titel = scanner.nextLine();

                    service.erstelleTicket(id, titel);
                    System.out.println("Ticket #" + id + " angelegt!");
                }
                case "2" ->{
                    System.out.println("\n--- Alle Tickets ---");
                    for(Ticket t : service.alleTickets()){
                        System.out.println("#" + t.getId() + " | " + t.getTitle() + " [" + t.getStatus() + "]");
                    }
                }
                case "3" ->{
                    System.out.print("ID: ");
                    try{
                        int id = Integer.parseInt(scanner.nextLine());
                        Ticket gesuchtesTicket = service.sucheTicket(id);
                        System.out.println("Titel: " + gesuchtesTicket.getTitle());

                    }catch (ObjektNichtGefundenException e){
                        System.out.println("Nicht geklappt: " + e.getMessage());
                    }catch (NumberFormatException e){
                        System.out.println("Bitte gib eine gültige Zahl als ID ein!");
                    }
                }
                case "4" ->{
                    service.allesSpeichern();
                    laueft = false;
                    System.out.println("Programm beendet. Bis zum nächsten Mal!");
                }
                default -> System.out.println("Ungültige Eingabe, bitte 1-4 wählen!");
            }
        }
        scanner.close();
    }
}