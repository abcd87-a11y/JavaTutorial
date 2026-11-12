import java.util.HashMap;
import java.util.List;
import java.util.Map;

//T muss das Interface Identifizierbar implementieren
public class Speicher<T extends Identifizierbar>{
    private Map<Integer, T> map = new HashMap<>();

    //Wir übergeben nur das Objekt. Der Speicher holt sich die ID selbst!
    public void speichern(T objekt){
        //Weil T "Identifizierbar" ist, weiß Java zu 100%, dass es .getId() gibt.
        this.map.put(objekt.getId(), objekt);
    }

    public T finden(int id){
        T ergebnis = this.map.get(id);

        if(ergebnis == null){
            throw new ObjektNichtGefundenException("Kein Eintrag mit ID " + id + " gefunden!");
        }
        return ergebnis;
    }

    public List<T> holeAlle(){
        return this.map.values().stream().toList();
    }

}
