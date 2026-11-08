public class Ticket {
    //DIe Eigenschaften (Fields)
    private int id;
    private String title;               //String wird in Java großgeschrieben
    private TicketStatus status;        //Unser Enum als Datentyp

    //Wird innherlab der Klasse "Ticket" geschrieben:
    public Ticket(int id, String title, TicketStatus status){
        this.id =id;
        this.title = title;
        this.status = status;
    }

    //Getter: Gibt den Wert zurück
    public String getTitle(){
        return this.title;
    }

    //Setter: Ändert den Wert
    public void setStatus(TicketStatus neuerStatus){
        this.status = neuerStatus;
    }
}
