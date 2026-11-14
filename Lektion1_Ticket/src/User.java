public class User implements Identifizierbar {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override   //@Override zeigt an: "Ich erfülle hier eine Methode aus dem Interface!"
    public int getId() {
        return id;
    }

    public String getName(){
        return this.name;
    }
}
