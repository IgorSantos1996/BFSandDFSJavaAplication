package Busca;

import ED.Fila;
import Grafo.Adjacente;
import Grafo.Cidade;
import Grafo.Mapa;


public class Largura {
    private Fila fronteira;
    private Cidade inicio;
    private Cidade objetivo;
    private boolean achou;

    public Largura(Cidade inicio, Cidade objetivo) {
        this.inicio = inicio;
        this.inicio.setVisitado(true);
        this.objetivo = objetivo;

        fronteira = new Fila(20);
        fronteira.enfileirar(inicio);
        achou = false;
    }

    public void buscar01() {
        Cidade primeiro = fronteira.getPrimeiro();
        System.out.println("Primeiro: " + primeiro.getNome());
        if (primeiro.equals(objetivo)) {
            achou = true;

        } else {
            System.out.println("Desenfileirou: " + fronteira.desenfileirar().getNome());
            for (Adjacente a : primeiro.getAdjacentes()) {
                System.out.println("Verificando se já visitado: " + a.getCidade().getNome());
                if (!a.getCidade().isVisitado()) {
                    a.getCidade().setVisitado(true);
                    fronteira.enfileirar(a.getCidade());

                }
            }
            if (fronteira.getNumeroElementos() > 0) {
                buscar01();
            }

        }

    }

    //public static void main(String[] args) {
        /*Mapa mapa = new Mapa();
        Largura l = new Largura(mapa.getItabaiana(), mapa.getAracaju());
        l.buscar01(); */
    //}
}
