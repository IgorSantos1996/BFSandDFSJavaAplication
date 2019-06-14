package Busca;

import ED.Fila;
import Grafo.Adjacente;
import Grafo.Cidade;
import Grafo.Mapa;

import java.util.ArrayList;
import javax.swing.JOptionPane;

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

        fronteira = new Fila(21);
        fronteira.enfileirar(inicio);
        ultima = inicio;
        achou = false;
    }

    public ArrayList<Cidade> buscaLargura() {
        ArrayList<Cidade> array = new ArrayList<>();

        array.add(inicio);

        do {
            Cidade primeiro = fronteira.getPrimeiro();
            primeiro.setVisitado(true);
            System.out.println("Retorno do método desenfileirar:  " + fronteira.desenfileirar().getNome());
            System.out.println("Estado corrente: " + primeiro.getNome());
            for (Adjacente a : primeiro.getAdjacentes()) {
                if (a.getCidade().getNome().equals(objetivo.getNome())) {
                    System.out.println("Goal State: " + objetivo.getNome());

                    a.getCidade().setCidadePai(primeiro);
                    array.add(a.getCidade());

                    //array = CaminhoPercorrido(inicio, objetivo);
                    return array;
                } else {
                    if (!a.getCidade().isVisitado()) {
                        a.getCidade().setCidadePai(primeiro);
                        a.getCidade().setVisitado(true);
                        fronteira.enfileirar(a.getCidade());

                        array.add(a.getCidade());
                    }
                }
            }
            //primeiro.setVisitado(true);
            //fronteira.desenfileirar();
        } while (!fronteira.getPrimeiro().equals(objetivo.getNome()));

        return null;
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

    // Mostra o caminhamento da busca como do caminho a ser seguido
    public String MostraRota(ArrayList<Cidade> array) {
        int size = array.size() - 1;
        String rota = "Caminhamento da Busca em Largura: (PONTOS AZUIS) \n";
        for (int i = 0; i < size + 1; i++) {
            Cidade c = array.get(i);
            rota += "  " + (i + 1) + "º " + c.getNome() + "\n";
        }

        array = CaminhoPercorrido(inicio, objetivo);
        rota += "\nRota a ser seguida: (PONTOS VERDES)\n";
        int cont = 1;
        for (int i = array.size() - 1; i > -1; i--) {
            Cidade c = array.get(i);
            rota += "  " + cont + "º " + c.getNome() + "\n";
            cont++;
        }
        return rota;
    }

    // caminhamento dos pais
    public ArrayList<Cidade> CaminhoPercorrido(Cidade inicio, Cidade objetivo) {
        ArrayList<Cidade> cidades = new ArrayList<>();
        cidades.add(objetivo);
        while (!objetivo.getCidadePai().getNome().equals(inicio.getNome())) {
            objetivo = objetivo.getCidadePai();

            if (!cidades.contains(objetivo))
                cidades.add(objetivo);
        }
        cidades.add(inicio);
        return cidades;
    }

}
