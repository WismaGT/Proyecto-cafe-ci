package com.maquinacafe.app;

public class Vaso {
    private int cantidadVasos;
    private int contenido;

    // 1. Añadimos el constructor que la prueba necesita
    public Vaso(int cantidadVasos, int contenido) {
        this.cantidadVasos = cantidadVasos;
        this.contenido = contenido;
    }

    public int getCantidadVasos() {
        return this.cantidadVasos;
    }

    // 2. Añadimos el método hasVasos que la prueba necesita
    public boolean hasVasos(int cantidad) {
        return this.cantidadVasos >= cantidad;
    }

    // 3. Añadimos el método giveVasos que la prueba necesita
    public void giveVasos(int cantidad) {
        this.cantidadVasos -= cantidad;
    }

    // Lo necesitarás más adelante para la MaquinaDeCafe
    public int getContenido() {
        return this.contenido;
    }
}
