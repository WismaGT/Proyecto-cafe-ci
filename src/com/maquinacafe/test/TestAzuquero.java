package com.maquinacafe.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import com.maquinacafe.app.Azucarero;

public class TestAzuquero {
    private Azucarero azucarero;

    @Before
    public void setup() {
        azucarero = new Azucarero(10); //
    }

    @Test
    public void deberiadevolverVerdaderoSiHaySuficienteAzucarEnElAzuquero() {
        boolean resultado = azucarero.hasAzucar(5); //
        assertEquals(true, resultado); //

        resultado = azucarero.hasAzucar(10); //
        assertEquals(true, resultado); //
    }

    @Test
    public void deberiadevolverFalsoPorqueNoHaySuficienteAzucarEnElAzuquero() {
        boolean resultado = azucarero.hasAzucar(15); //
        assertEquals(false, resultado); //
    }

    @Test
    public void deberiaRestarAzucarAlAzuquero() {
        azucarero.giveAzucar(5); //
        assertEquals(5, azucarero.getCantidadAzucar()); //

        azucarero.giveAzucar(2); //
        assertEquals(3, azucarero.getCantidadAzucar()); //
    }
}