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
    //private Mapa mapa;
   // int cont = 0;

    public Largura(Cidade inicio, Cidade objetivo) {
        this.inicio = inicio;
        this.inicio.setVisitado(true);
        this.objetivo = objetivo;
        //this.mapa = mapa;

        fronteira = new Fila(20);
        fronteira.enfileirar(inicio);
        //ultima = inicio;
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
                if (a.getCidade().isVisitado() == false) {
                    System.out.println("Visitando: " + a.getCidade().getNome());
                    a.getCidade().setVisitado(true);
                    fronteira.enfileirar(a.getCidade());
                    System.out.println("Enfileira: " + a.getCidade().getNome());
                    System.out.println();
                }
                // achou
//                if(a.getCidade().getNome().equals(objetivo.getNome())){
//                    System.out.println("ACHOU !");
//                }
            }
            if (fronteira.getNumeroElementos() > 0) {
                buscar01();
            }
        }
    }
//        while(!fronteira.filaVazia()){
//            Cidade primeiro = fronteira.desenfileirar();
//            setTrue(primeiro.getNome());
//            System.out.println("Primeira: "+primeiro.getNome());
//            for (Adjacente a: PesquisaCidadeNome(primeiro.getNome()).getAdjacentes()){
//                //System.out.println("Adjacente: "+a.getCidade().getNome());
//                if (!VerificaTrue(a.getCidade().getNome())) {
//                    if (!a.getCidade().getNome().equals(ultima.getNome())) {
//                        fronteira.enfileirar(a.getCidade());
//                    }
//                }
//
//                //setTrue(a.getCidade().getNome());
//
//            }
//
////            for (Cidade cid : mapa.getCidades())
////            {
////                System.out.println("Cidade: "+cid.getNome());
////                System.out.println("Visitada: "+cid.isVisitado());
////            }
//            ultima = primeiro;
//            if (pesquisaVisitados()){
//                break;
//            }
//            cont++;
//            if(cont == 10){
//                break;
//            }
//            System.out.println("quant: "+fronteira.getNumeroElementos());
////            if (primeiro.getNome().equals(objetivo.getNome())){
////                break;
//            }

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


//    }

//    private boolean pesquisaVisitados()
//    {
//        for(Cidade c : mapa.getCidades()){
//            if(!c.isVisitado()){
//                return false;
//            }
//        }
//        return true;
//    }

//    private boolean VerificaTrue(String nome)
//    {
//        for(Cidade c : mapa.getCidades()){
//            if(c.getNome().equals(nome)){
//                if (c.isVisitado()){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    private void setTrue(String nome)
//    {
//        for(Cidade c : mapa.getCidades()){
//            if(c.getNome().equals(nome)){
//                c.setVisitado(true);
//            }
//        }
//    }
//
//    private Cidade PesquisaCidadeNome(String nome)
//    {
//        for(Cidade c : mapa.getCidades()){
//            if(c.getNome().equals(nome)){
//                return c;
//            }
//        }
//        return null;
//    }
    //public static void main(String[] args) {
        /*Mapa mapa = new Mapa();
        Largura l = new Largura(mapa.getItabaiana(), mapa.getAracaju());
        l.buscar01(); */
    //}

