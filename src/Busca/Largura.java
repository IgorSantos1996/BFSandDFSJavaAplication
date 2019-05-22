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
    private Mapa mapa;

    public Largura(Cidade inicio, Cidade objetivo, Mapa mapa) {
        this.inicio = inicio;
        this.inicio.setVisitado(true);
        this.objetivo = objetivo;
        this.mapa = mapa;

        fronteira = new Fila(20);
        fronteira.enfileirar(inicio);
        achou = false;
    }

    public void buscar01() {
        while(!fronteira.filaVazia()){
            Cidade primeiro = fronteira.desenfileirar();
            System.out.println(primeiro.getNome());
            for (Adjacente a: PesquisaCidadeNome(primeiro.getNome()).getAdjacentes()){
                a.getCidade().setVisitado(true);

                fronteira.enfileirar(a.getCidade());
            }

            if (primeiro.getNome().equals(objetivo.getNome())){
                break;
            }

        }
//
//        System.out.println("Primeiro: " + primeiro.getNome());
//        if (primeiro.getNome().equals(objetivo.getNome())) {
//            achou = true;
//
//        } else {
//            System.out.println("Desenfileirou: " + fronteira.desenfileirar().getNome());
//            for (Adjacente a : PesquisaCidadeNome(primeiro.getNome()).getAdjacentes()) {
//                System.out.println("Verificando se já visitado: " + a.getCidade().getNome());
//                //System.out.println("Status: "+a.getCidade().isVisitado());
//                if (!a.getCidade().isVisitado()) {
//                    a.getCidade().setVisitado(true);
//                    fronteira.enfileirar(a.getCidade());
//
//                }
//            }
//            if (fronteira.getNumeroElementos() > 0) {
//                buscar01();
//            }
//
//        }

    }

    private Cidade PesquisaCidadeNome(String nome)
    {
        for(Cidade c : mapa.getCidades()){
            if(c.getNome().equals(nome)){
                return c;
            }
        }
        return null;
    }
    //public static void main(String[] args) {
        /*Mapa mapa = new Mapa();
        Largura l = new Largura(mapa.getItabaiana(), mapa.getAracaju());
        l.buscar01(); */
    //}
}
