import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SpeicherTest {

    @Test
    void speichereUndFindeTicket_sollteRichtigesTicketZurueckgeben(){
        //1. Arrange (Vorbereiten)
        Speicher<Ticket> speicher = new Speicher<>();
        Ticket testTicket = new Ticket(1, "WLAN kaputt", TicketStatus.OPEN);

        //2. Act (Ausführen)
        speicher.speichern(testTicket);
        Ticket gefunden = speicher.finden(1);

        //3. Assert (überprüfen)
        assertEquals("WLAN kaputt", gefunden.getTitle());
        assertEquals(TicketStatus.OPEN, gefunden.getStatus());
    }

    @Test
    void finden_sollteExceptionWerfen_wennIdNichtExistiert(){
        //1. Arrange
        Speicher<Ticket> speicher = new Speicher<>();

        //2. Act & 3. Assert kombiniert: Wir erwarten, dass dieser Aufruf crasht!
        assertThrows(ObjektNichtGefundenException.class, () ->{
           speicher.finden(999);
        });
    }

    @Test
    void holeAlle_sollteAlleGespeichertenEintrageZurueckgeben(){
        //1. Arrange (Vorbereiten)
        Speicher<Ticket> speicher = new Speicher<>();
        Ticket ticket1 = new Ticket(1, "Monitor flackert", TicketStatus.OPEN);
        Ticket ticket2 = new Ticket(2, "Maus defekt", TicketStatus.IN_PROGRESS);

        //2. Act (Ausführen)
        speicher.speichern(ticket1);
        speicher.speichern(ticket2);
        List<Ticket> ergebnis = speicher.holeAlle();

        //3. Assert (Überprüfen)
        assertEquals(2, ergebnis.size());
    }
}
