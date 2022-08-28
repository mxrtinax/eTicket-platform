package model;

import jdk.jshell.execution.Util;

public class Utilizator {

    protected Long id;
    protected String mail;
    protected String nume;
    protected String prenume;
    protected String parola;

    public Utilizator(Long id, String mail, String nume, String prenume, String parola ){
        this.id = id;
        this.mail = mail;
        this.nume = nume;
        this.prenume = prenume;
        this.parola = parola;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNume(String n){
        this.nume = n;
    }
    public String getNume(){
        return this.nume;
    }
    public void setPrenume(String n){
        this.prenume = n;
    }
    public String getPrenume(){
        return this.prenume;
    }

    public void setMail(String n){
        this.mail = n;
    }
    public String getMail(){
        return this.mail;
    }

    public void setParola(String n){
        this.parola = n;
    }
    public String getParola(){
        return this.parola;
    }
    @Override
    public String toString() {
        return "Utilizator{" +
                "Id: " + id +
                ", Mail: " + mail +
                ", Nume: " + nume + " " + prenume +
                '\'' +
                '}';
    }

}
