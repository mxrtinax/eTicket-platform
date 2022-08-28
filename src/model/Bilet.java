package model;

public class Bilet {
    protected String numeEveniment;
    protected long numar;
    protected String zona;
    protected String mailProprietar;
    protected double pret;

    public Bilet(String numeEveniment, long numar, String zona, String mail, double pret){
        this.numeEveniment = numeEveniment;
        this.numar = numar;
        this.zona = zona;
        this.mailProprietar = mail;
        this.pret = pret;
    }


    public String getNumeEveniment() {
        return numeEveniment;
    }

    public void setNumeEveniment(String numeEveniment) {
        this.numeEveniment = numeEveniment;
    }
    public long getNumar() {
        return numar;
    }

    public void setNumar(long numar) {
        this.numar = numar;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }


    public String getProprietar() {
        return mailProprietar;
    }

    public void setProprietar(String proprietar) {
        this.mailProprietar = proprietar;
    }


    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }




    @Override
    public String toString() {
        return "Bilet{" +
                "Nume Eveniment: " + numeEveniment +
                ", Numar: " + numar +
                ", Zona: " + zona +
                '\'' +
                '}';
    }
}
