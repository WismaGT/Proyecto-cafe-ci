package com.maquinacafe.app;

public class Azucarero {
    private int cantidadDeAzucar; //

    public Azucarero(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public int getCantidadAzucar() { //
        return this.cantidadDeAzucar;
    }

    public boolean hasAzucar(int cantidadDeAzucar) { //
        return this.cantidadDeAzucar >= cantidadDeAzucar;
    }

    public void giveAzucar(int cantidadDeAzucar) { //
        this.cantidadDeAzucar -= cantidadDeAzucar;
    }
}