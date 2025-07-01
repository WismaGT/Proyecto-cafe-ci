package com.maquinacafe.test;

import static org.junit.Assert.*;
import com.maquinacafe.app.Cafeteras;
import org.junit.Test;

public class TestCafetera {

    @Test
    public void deberiaDevolverVerdaderoSiExisteCafe() {
        Cafeteras cafeteras = new Cafeteras (10);
        boolean resultado = cafeteras.hasCafe(5); //
        assertEquals(true, resultado); //
    }

    @Test
    public void deberiaDevolverFalsoSiNoExisteCafe() {
        Cafeteras cafetera = new Cafeteras(10);
        boolean resultado = cafetera.hasCafe(11); //
        assertEquals(false, resultado); //
    }

    @Test
    public void deberiaRestarcafeAlaCafetera() {
        Cafeteras cafetera = new Cafeteras(10);
        cafetera.giveCafe(7); //
        assertEquals(3, cafetera.getCantidadCafe()); //
    }
}