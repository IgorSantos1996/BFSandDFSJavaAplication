package Busca;

import ED.Pilha;
import Grafo.Adjacente;
import Grafo.Cidade;
import Grafo.Mapa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Profundidade {

    private Pilha fronteira;
    private Cidade inicio;
    private Cidade objetivo;
    private boolean achou;

    public Profundidade(Cidade inicio, Cidade objetivo) {
        this.inicio = inicio;
        this.inicio.setVisitado(true);
        this.objetivo = objetivo;

        fronteira = new Pilha(21);
        fronteira.empilhar(inicio);
        achou = false;
    }

    public ArrayList<Cidade> buscar(ArrayList<Cidade> cidades) {

        Cidade topo = fronteira.getTopo();
        System.out.println("Topo: " + topo.getNome());
        cidades.add(topo);

        if (topo.equals(objetivo)) {
            achou = true;

        } else {
            if (achou == false) {
                for (Adjacente a : topo.getAdjacentes()) {
                    a.getCidade().setCidadePai(topo);
                    if (!achou) {
                        System.out.println("Verificando se já visitado: " + a.getCidade().getNome());
                        if (a.getCidade().isVisitado() == false) {
                            a.getCidade().setVisitado(true);
                            fronteira.empilhar(a.getCidade());
                            buscar(cidades);
                        }
                    }
                }
            }

        }

        Cidade cityDesempilhada = fronteira.desempilhar();
        System.out.println("Desempilhou: " + cityDesempilhada.getNome());
//        if (cityDesempilhada == objetivo) {
//            ArrayList<Cidade> a = new ArrayList<>();
//            a.add(cityDesempilhada);
//            return a;
//        }
        return cidades;
    }

    public String MostraRota(ArrayList<Cidade> array) {
        int size = array.size() - 1;
        String rota = "Caminhamento da Busca em Profundidade: (PONTOS AZUIS)\n";
        for (int i = 0; i < size + 1; i++) {
            Cidade c = array.get(size - i);
            rota += "  " + (size - i + 1) + "º\t " + c.getNome() + "\n";
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

            if (!cidades.contains(objetivo)) {
                cidades.add(objetivo);
            }
        }
        cidades.add(inicio);
        return cidades;
    }
}
