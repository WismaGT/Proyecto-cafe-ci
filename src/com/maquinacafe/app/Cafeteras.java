package com.maquinacafe.app;


public class Cafeteras { // El nombre de la clase coincide con tu archivo
    private int cantidadCafe;

    // El constructor debe tener el mismo nombre que la clase: "Cafeteras"
    public Cafeteras(int cantidadCafe) {
        this.cantidadCafe = cantidadCafe;
    }

    public int getCantidadCafe() {
        return this.cantidadCafe;
    }

    public boolean hasCafe(int cantidadCafe) {
        return this.cantidadCafe >= cantidadCafe;
    }

    public void giveCafe(int cantidadCafe) {
        this.cantidadCafe -= cantidadCafe;
    }
}

