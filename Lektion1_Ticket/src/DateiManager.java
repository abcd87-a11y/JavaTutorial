import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DateiManager {
    //Speicherort der Datei im Projektverzeichnis
    private static final Path DATEI_PFAD = Path.of("tickets.csv");

    //1. METHODE ZUM SPEICHERN
    public void speicherTickets(List<Ticket>tickets){
        List<String> zeilen = new ArrayList<>();

        //Wir wandeln jedes Ticket-Objekt in eine Textzeile um
        for(Ticket t : tickets){
            String zeile = t.getId() + ";" + t.getTitle() + ";" + t.getStatus();
            zeilen.add(zeile);
        }

        try{
            //Schreibt alle Zeilen auf einmal in die Datei
            Files.write(DATEI_PFAD, zeilen);
            System.out.println("Erfoglreich in " + DATEI_PFAD + " gespeichert");
        }catch(IOException e){
            System.out.println("Fehler beim Speichern der Datei: " + e.getMessage());
        }
    }

    //2. Methoden zum Laden
    public List<Ticket> ladeTickets(){
        List<Ticket> geladeneTickets = new ArrayList<>();

        //Prüfen, ob die Datei überhaupt schon existiert
        if(!Files.exists(DATEI_PFAD)){
            System.out.println("Noch keine Speicherdatei vorhanden. Starte leer.");
            return geladeneTickets;
        }

        try{
            List<String> zeilen = Files.readAllLines(DATEI_PFAD);

            for(String zeile : zeilen){
                //Zeile am Semikolon in 3 Teile zerschneiden
                String[] teile = zeile.split(";");

                int id = Integer.parseInt(teile[0]);
                String title = teile[1];
                TicketStatus status = TicketStatus.valueOf(teile[2]);   //Text zurück zu Enum!

                geladeneTickets.add(new Ticket(id, title, status));
            }
            System.out.println(geladeneTickets.size() + " Tickets aus Datei geladen!");
        }catch (IOException e){
            System.out.println("Fehler beim Speichern der Datei: " + e.getMessage());
        }
        return geladeneTickets;
    }
}
