package com.maquinacafe.test;

import static org.junit.Assert.*;

import com.maquinacafe.app.Azucarero;
import com.maquinacafe.app.Cafeteras;
import com.maquinacafe.app.Vaso;
import org.junit.Before;
import org.junit.Test;
import com.maquinacafe.app.MaquinaCafe;

public class TestMaquinaCafe {
    Cafeteras cafetera; // Usando tu clase Cafeteras
    Vaso vasosPequeno;
    Vaso vasosMediano;
    Vaso vasosGrande;
    Azucarero azucarero;
    MaquinaCafe maquinaDeCafe; // Usando tu clase MaquinaCafe

    @Before
    public void setup() {
        cafetera = new Cafeteras(50);
        vasosPequeno = new Vaso(5, 3); // 5 vasos de 3 Oz
        vasosMediano = new Vaso(5, 5); // 5 vasos de 5 Oz
        vasosGrande = new Vaso(5, 7);  // 5 vasos de 7 Oz
        azucarero = new Azucarero(20);

        maquinaDeCafe = new MaquinaCafe();
        maquinaDeCafe.setCafetera(cafetera);
        maquinaDeCafe.setVasosPequeno(vasosPequeno);
        maquinaDeCafe.setVasosMediano(vasosMediano);
        maquinaDeCafe.setVasosGrande(vasosGrande);
        maquinaDeCafe.setAzucarero(azucarero);
    }

    @Test
    public void deberiaDevolverUnVasoPequeno() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        assertEquals(vasosPequeno, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoMediano() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("mediano");
        assertEquals(vasosMediano, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoGrande() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("grande");
        assertEquals(vasosGrande, vaso);
    }

    @Test
    public void deberiaDevolverNoHayVasos() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 10, 2); // Pide 10, solo hay 5
        assertEquals("No hay Vasos", resultado);
    }

    @Test
    public void deberiaDevolverNoHayCafe() {
        maquinaDeCafe.setCafetera(new Cafeteras(2)); // Pone solo 2 de café
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno"); // Pide un vaso de 3 Oz
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 2);
        assertEquals("No hay Cafe", resultado);
    }

    @Test
    public void deberiaDevolverNoHayAzucar() {
        maquinaDeCafe.setAzucarero(new Azucarero(2)); // Pone solo 2 de azúcar
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3); // Pide 3 de azúcar
        assertEquals("No hay Azucar", resultado);
    }

    @Test
    public void deberiaRestarCafe() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno"); // Vaso de 3 Oz
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals(47, maquinaDeCafe.getCafetera().getCantidadCafe()); // 50 - 3 = 47
    }

    @Test
    public void deberiaRestarVaso() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals(4, maquinaDeCafe.getVasosPequeno().getCantidadVasos()); // 5 - 1 = 4
    }

    @Test
    public void deberiaRestarAzucar() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals(17, maquinaDeCafe.getAzucarero().getCantidadAzucar()); // 20 - 3 = 17
    }

    @Test
    public void deberiaDevolverFelicitaciones() {
        Vaso vaso = maquinaDeCafe.getTipoDeVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals("Felicitaciones", resultado);
    }
}
