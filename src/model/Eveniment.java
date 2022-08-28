package model;

import java.util.ArrayList;
import java.util.List;

public class Eveniment {

    protected long idEveniment;
    protected String numeEveniment;
    protected List<String> artisti = new ArrayList<String>();
    protected String dataEveniment; //aaaa-ll-zz
    protected String oraEveniment; //oo:mm:ss
    protected Locatie locatie;
    protected long nrBileteRamase;



    public Eveniment(Long idEveniment,
                     String numeEveniment,
                     List<String> artisti,
                     String dataEveniment,
                     String oraEveniment,
                     Locatie locatie,
                     long nrBileteRamase){
        this.idEveniment = idEveniment;
        this.numeEveniment = numeEveniment;
        this.artisti = artisti;
        this.dataEveniment = dataEveniment;
        this.oraEveniment = oraEveniment;
        this.locatie = locatie;
        this.nrBileteRamase = nrBileteRamase;
    }
    public long getIdEveniment() {
        return idEveniment;
    }

    public void setIdEveniment(long idEveniment) {
        this.idEveniment = idEveniment;
    }

    public String getNumeEveniment() {
        return numeEveniment;
    }

    public void setNumeEveniment(String numeEveniment) {
        this.numeEveniment = numeEveniment;
    }

    public List<String> getArtisti() {
        return this.artisti;
    }

    public void setNumeArtist(List<String> artisti) {
        for(String s: artisti){
            if(s!=null){
                this.artisti.add(s);   //sau this.artisiti.addAll(artisti)
            }
        }
    }

    public String getDataEveniment() {
        return dataEveniment;
    }

    public void setDataEveniment(String dataEveniment) {
        this.dataEveniment = dataEveniment;
    }

    public String getOraEveniment() {
        return oraEveniment;
    }

    public void setOraEveniment(String oraEveniment) {
        this.oraEveniment = oraEveniment;
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }
    public String printArtisti(){
        String s = "";
        for(String a:this.artisti){
            s = s + a + " - ";
        }
        return s;
    }

    public long getNrBileteRamase() {
        return this.nrBileteRamase;
    }

    public void setNrBileteRamase(long nrBileteRamase) {
        this.nrBileteRamase = nrBileteRamase;
    }

    @Override
    public String toString() {
        return "Eveniment{" +
                "Nume: " + numeEveniment +
                ", Data: " + dataEveniment +
                ", Ora: " + oraEveniment +
                ", Locatie: " + locatie.toString() +
                ", Invitati: " + this.printArtisti() +
                '\'' +
                '}';
    }
}
