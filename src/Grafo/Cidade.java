package Grafo;

import java.util.ArrayList;
import java.util.List;
import java.awt.geom.*;

public class Cidade {
    private String nome;
    private boolean visitado;
    private List<Adjacente> adjacenteList;
    private int x; // coordenadas do layout
    private int y; 	


     public Cidade(String nome,int x,int y) {
        this.nome = nome;
        this.x = x;
        this.y = y;
        visitado = false;
        adjacenteList = new ArrayList<Adjacente>();
    }

    public Cidade() {
    }

    public Cidade(String nome2) {
    	this.nome = nome2;
        visitado = false;
        adjacenteList = new ArrayList<Adjacente>();
    }

    public void addCidadeAdjacente(Adjacente cidade) {
//        Cidade c = new Cidade();
//        c.setNome(cidade.getCidade().getNome());
//        c.setVisitado(cidade.getCidade().isVisitado());
//        cidade.setCidade(c);
        adjacenteList.add(cidade);
    }

    
    
    
    public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<Adjacente> getAdjacentes() {
        return adjacenteList;
    }
}
