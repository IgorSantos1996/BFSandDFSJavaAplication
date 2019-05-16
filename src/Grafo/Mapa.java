package Grafo;

//import java.awt.geom.Area;

public class Mapa {
    private Cidade Itabaiana;
    private Cidade Aracaju;
    private Cidade Areia_Branca;
    private Cidade Ribeiropolis;
    private Cidade Frei_Paulo;
    private Cidade Laranjeiras;
    private Cidade Malhador;
    private Cidade Lagarto;
    private Cidade Estancia;
    private Cidade Gloria;
    private Cidade Moita_Bonita;
    private Cidade BarraDosCoqueiros;
    private Cidade Itaporanga;

    public Mapa() {
        Itabaiana = new Cidade("Itabaiana");
        Aracaju = new Cidade("Aracaju");
        Areia_Branca = new Cidade("Areia Branca");
        Ribeiropolis = new Cidade("Ribeiropolis");
        Frei_Paulo = new Cidade("Frei Paulo");
        Laranjeiras = new Cidade("Laranjeiras");
        Malhador = new Cidade("Malhador");
        Lagarto = new Cidade("Lagarto");
        Estancia = new Cidade("Estancia");
        Gloria = new Cidade("Gloria");
        Moita_Bonita = new Cidade("Moita Bonita");
        BarraDosCoqueiros = new Cidade("Barra dos Coqueiros");
        Itaporanga = new Cidade("Itaporanga");

        Itabaiana.addCidadeAdjacente(new Adjacente(Areia_Branca));
        //Itabaiana.addCidadeAdjacente(new Adjacente(Aracaju));
        Itabaiana.addCidadeAdjacente(new Adjacente(Moita_Bonita));
        Itabaiana.addCidadeAdjacente(new Adjacente(Ribeiropolis));
        Itabaiana.addCidadeAdjacente(new Adjacente(Lagarto));
        Aracaju.addCidadeAdjacente(new Adjacente(Areia_Branca));
        Aracaju.addCidadeAdjacente(new Adjacente(BarraDosCoqueiros));


    }

    public void setCidade(String cidade){
        if (cidade.equals("itabaiana")){
            getItabaiana();
        }
    }

    public Cidade getItabaiana() {
        return Itabaiana;
    }

    public void setItabaiana(Cidade itabaiana) {
        Itabaiana = itabaiana;
    }

    public Cidade getAracaju() {
        return Aracaju;
    }

    public void setAracaju(Cidade aracaju) {
        Aracaju = aracaju;
    }

    public Cidade getAreia_Branca() {
        return Areia_Branca;
    }

    public void setAreia_Branca(Cidade areia_Branca) {
        Areia_Branca = areia_Branca;
    }

    public Cidade getRibeiropolis() {
        return Ribeiropolis;
    }

    public void setRibeiropolis(Cidade ribeiropolis) {
        Ribeiropolis = ribeiropolis;
    }

    public Cidade getFrei_Paulo() {
        return Frei_Paulo;
    }

    public void setFrei_Paulo(Cidade frei_Paulo) {
        Frei_Paulo = frei_Paulo;
    }

    public Cidade getLaranjeiras() {
        return Laranjeiras;
    }

    public void setLaranjeiras(Cidade laranjeiras) {
        Laranjeiras = laranjeiras;
    }

    public Cidade getMalhador() {
        return Malhador;
    }

    public void setMalhador(Cidade malhador) {
        Malhador = malhador;
    }

    public Cidade getLagarto() {
        return Lagarto;
    }

    public void setLagarto(Cidade lagarto) {
        Lagarto = lagarto;
    }

    public Cidade getEstancia() {
        return Estancia;
    }

    public void setEstancia(Cidade estancia) {
        Estancia = estancia;
    }

    public Cidade getGloria() {
        return Gloria;
    }

    public void setGloria(Cidade gloria) {
        Gloria = gloria;
    }

    public Cidade getMoita_Bonita() {
        return Moita_Bonita;
    }

    public void setMoita_Bonita(Cidade moita_Bonita) {
        Moita_Bonita = moita_Bonita;
    }

    public Cidade getBarraDosCoqueiros() {
        return BarraDosCoqueiros;
    }

    public void setBarraDosCoqueiros(Cidade barraDosCoqueiros) {
        BarraDosCoqueiros = barraDosCoqueiros;
    }

    public Cidade getItaporanga() {
        return Itaporanga;
    }

    public void setItaporanga(Cidade itaporanga) {
        Itaporanga = itaporanga;
    }


}
