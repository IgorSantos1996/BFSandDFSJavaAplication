package Busca;

import ED.Fila;
import Grafo.Adjacente;
import Grafo.Cidade;
import Grafo.Mapa;
import java.util.ArrayList;

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

    public ArrayList<Cidade> buscar01() {
        ArrayList<Cidade> array = new ArrayList<>();
        
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
                    
                    array = CaminhoPercorrido(inicio, objetivo);
                    
//                    System.out.println("TESTE");
//                    for(Cidade c : array){
//                        System.out.println(c.getNome());
//                    }
                    
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
    
    private ArrayList<Cidade> CaminhoPercorrido(Cidade inicio, Cidade objetivo){
        ArrayList<Cidade> cidades = new ArrayList<>();
        cidades.add(objetivo);
        while( ! objetivo.getCidadePai().getNome().equals(inicio.getNome())){
            objetivo = objetivo.getCidadePai();
            
            if(!cidades.contains(objetivo))
                cidades.add(objetivo);
        }
        cidades.add(inicio);
        return cidades;
    }

}
