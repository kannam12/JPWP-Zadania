package com.company;

public class Pole {
    int x;
    int y;
    int waga;
    boolean obecnosc;
    String znak;
    int idWagi;

    public int getIdWagi() {
        return idWagi;
    }

    public void setIdWagi(int idWagi) {
        this.idWagi = idWagi;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public boolean isObecnosc() {
        return obecnosc;
    }

    public void setObecnosc(boolean obecnosc) {
        this.obecnosc = obecnosc;
    }

    public String getZnak() {
        return znak;
    }

    public void setZnak(String znak) {
        this.znak = znak;
    }

    public Pole(int x,int y,int waga,boolean obecnosc,int idWagi){
        this.x = x;
        this.y = y;
        this.waga = waga;
        this.obecnosc = obecnosc;
        this.idWagi = idWagi;
    }
}

