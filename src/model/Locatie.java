package model;

public class Locatie {
    protected long id;
    protected String oras;
    protected String strada;
    protected String numar;
    protected String cladire;

    public Locatie(long id, String oras, String strada, String numar, String cladire){
        this.id = id;
        this.oras = oras;
        this.strada = strada;
        this.numar = numar;
        this.cladire = cladire;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public String getNumar() {
        return numar;
    }

    public void setNumar(String numar) {
        this.numar = numar;
    }

    public String getCladire() {
        return cladire;
    }

    public void setCladire(String cladire) {
        this.cladire = cladire;
    }

    @Override
    public String toString() {
        return "Locatie{" +
                "Oras: " + oras +
                ", Str: " + strada +
                ", Nr: " + numar +
                ",Cladire: " + cladire +
                '\'' +
                '}';
    }
}
