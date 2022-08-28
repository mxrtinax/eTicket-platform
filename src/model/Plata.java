package model;

import java.time.LocalDateTime;

public class Plata {

    protected Client clientPlata;
    protected Eveniment evenimentPlata;
    protected LocalDateTime dataOraPlata;

    public Plata(Client clientPlata, Eveniment evenimentPlata, LocalDateTime dataOraPlata) {
        this.clientPlata = clientPlata;
        this.evenimentPlata = evenimentPlata;
        this.dataOraPlata = dataOraPlata;
    }


    public Client getClientPlata() {
        return clientPlata;
    }

    public void setClientPlata(Client clientPlata) {
        this.clientPlata = clientPlata;
    }

    public Eveniment getEvenimentPlata() {
        return evenimentPlata;
    }

    public void setEvenimentPlata(Eveniment evenimentPlata) {
        this.evenimentPlata = evenimentPlata;
    }

    public LocalDateTime getDataOraPlata() {
        return dataOraPlata;
    }

    public void setDataOraPlata(LocalDateTime dataOraPlata) {
        this.dataOraPlata = dataOraPlata;
    }

}
