public class Ticket implements Identifizierbar{
    //Die Eigenschaften (Fields)
    private int id;
    private String title;               //String wird in Java großgeschrieben
    private TicketStatus status;        //Unser Enum als Datentyp
    private User bearbeiter;            //EIn Ticket hat jetzt einen Bearbeiter

    //Wird innherlab der Klasse "Ticket" geschrieben:
    public Ticket(int id, String title, TicketStatus status){
        this.id =id;
        this.title = title;
        this.status = status;
    }

    public User getBearbeiter(){
        return this.bearbeiter;
    }

    public void setBearbeiter(User bearbeiter){
        this.bearbeiter = bearbeiter;
    }

    //Getter: Gibt den Wert zurück
    public String getTitle(){
        return this.title;
    }

    //Setter: Ändert den Wert
    public void setStatus(TicketStatus neuerStatus){
        this.status = neuerStatus;
    }

    //Wir müssen getId() anbieten, um den Vertrag zu erfüllen
    public int getId(){
        return this.id;
    }
    //Getter für den Status
    public TicketStatus getStatus(){
        return this.status;
    }
}
