package com.maquinacafe.app;

public class MaquinaCafe {
    private Cafeteras cafetera; //
    private Vaso vasosPequeno; //
    private Vaso vasosMediano; //
    private Vaso vasosGrande; //
    private Azucarero azucarero; //

    // Métodos 'set' para inicializar la máquina (usados en @Before)
    public void setCafetera(Cafeteras cafetera) { this.cafetera = cafetera; }
    public void setVasosPequeno(Vaso vasosPequeno) { this.vasosPequeno = vasosPequeno; }
    public void setVasosMediano(Vaso vasosMediano) { this.vasosMediano = vasosMediano; }
    public void setVasosGrande(Vaso vasosGrande) { this.vasosGrande = vasosGrande; }
    public void setAzucarero(Azucarero azucarero) { this.azucarero = azucarero; }

    // Métodos 'get' para que las pruebas puedan verificar los resultados
    public Cafeteras getCafetera() { return this.cafetera; }
    public Vaso getVasosPequeno() { return this.vasosPequeno; }
    public Azucarero getAzucarero() { return this.azucarero; }

    public Vaso getTipoDeVaso(String tipoDeVaso) { //
        if ("pequeno".equals(tipoDeVaso)) {
            return this.vasosPequeno;
        }
        if ("mediano".equals(tipoDeVaso)) {
            return this.vasosMediano;
        }
        if ("grande".equals(tipoDeVaso)) {
            return this.vasosGrande;
        }
        return null;
    }

    public String getVasoDeCafe(Vaso tipoDeVaso, int cantidadDeVasos, int cantidadDeAzucar) { //
        int cafeNecesario = tipoDeVaso.getContenido(); // El contenido del vaso son las Oz de café

        if (!tipoDeVaso.hasVasos(cantidadDeVasos)) {
            return "No hay Vasos"; //
        }
        if (!this.cafetera.hasCafe(cafeNecesario)) {
            return "No hay Cafe"; //
        }
        if (!this.azucarero.hasAzucar(cantidadDeAzucar)) {
            return "No hay Azucar"; //
        }

        // Si todo está disponible, se descuentan los insumos
        tipoDeVaso.giveVasos(cantidadDeVasos);
        this.cafetera.giveCafe(cafeNecesario);
        this.azucarero.giveAzucar(cantidadDeAzucar);

        return "Felicitaciones";
    }
}
