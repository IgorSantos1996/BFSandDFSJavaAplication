package Busca;

import ED.Fila;
import Grafo.Adjacente;
import Grafo.Cidade;
import Grafo.Mapa;


public class Largura {
    private Fila fronteira;
    private Cidade inicio;
    private Cidade objetivo;
    private Cidade ultima;
    private boolean achou;
    private Mapa mapa;
    int cont = 0;

    public Largura(Cidade inicio, Cidade objetivo) {
        this.inicio = inicio;
        this.inicio.setVisitado(true);
        this.objetivo = objetivo;
        //this.mapa = mapa;

        fronteira = new Fila(20);
        fronteira.enfileirar(inicio);
        ultima = inicio;
        achou = false;
    }

    public void buscar01() {
        do {
            Cidade primeiro = fronteira.getPrimeiro();
            primeiro.setVisitado(true);
            System.out.println("Retorno do método desenfileirar:  " + fronteira.desenfileirar().getNome());
            System.out.println("Estado corrente: " + primeiro.getNome());
            for (Adjacente a : primeiro.getAdjacentes()) {
                if (a.getCidade().getNome().equals(objetivo.getNome())) {
                    System.out.println("Goal State: " + objetivo.getNome());
                    return;
                } else {
                    if (!a.getCidade().isVisitado()) {
                        a.getCidade().setVisitado(true);
                        fronteira.enfileirar(a.getCidade());
                    }
                }
            }
            //primeiro.setVisitado(true);
            //fronteira.desenfileirar();
        } while (!fronteira.getPrimeiro().equals(objetivo.getNome()));


    }

    private boolean pesquisaVisitados() {
        for (Cidade c : mapa.getCidades()) {
            if (!c.isVisitado()) {
                return false;
            }
        }
        return true;
    }

    private boolean VerificaTrue(String nome) {
        for (Cidade c : mapa.getCidades()) {
            if (c.getNome().equals(nome)) {
                if (c.isVisitado()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void setTrue(String nome) {
        for (Cidade c : mapa.getCidades()) {
            if (c.getNome().equals(nome)) {
                c.setVisitado(true);
            }
        }
    }

    private Cidade PesquisaCidadeNome(String nome) {
        for (Cidade c : mapa.getCidades()) {
            if (c.getNome().equals(nome)) {
                return c;
            }
        }
        return null;
    }

}
