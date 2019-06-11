package Busca;

import Grafo.Cidade;
import Grafo.Mapa;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class APP implements ActionListener {
    //private JPanel painel = null;
    private JLabel label;
    private JLabel label02;
    private JLabel label03;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnConsultar;
    private JMenuItem miSair, miBotao, miAdjacencias, miCodigoFonte;
    private JButton btlargura;
    private JButton btprofundidade;
    private JFrame frame;
    private static JComboBox cb_cidades;
    private static JComboBox cb_cidades02;
    private Image iconeTitulo;
    private Mapa mapa;
    
    // Componentes para colocar o ponto vermelho na tela

    Thread tponto;
    private JLabel pontoAzul;

    public void ativarPontoAzul() {

  Thread tponto;
    private ArrayList<JLabel> pontoVermelho;
    
    public void ativarPontoVermelho(ArrayList<Cidade> rota) {

        tponto = new Thread() {
            public void run() {
                int x = 0;
                while (true) {
                    x++;
                    if (x % 2 == 0) {
                    	for (int i = 0; i < rota.size(); i++) {
                    		frame.add(pontoVermelho.get(i)).setBounds(rota.get(i).getX(),rota.get(i).getY(), 20, 20);
                    		pontoVermelho.get(i).setVisible(true);
                    	}

                    } else {
                    	for (int i = 0; i < rota.size(); i++)
                    		pontoVermelho.get(i).setVisible(false);
                    }

                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException ex) {
                    	System.out.println("Erro: "+ex);
                    }

                }
            }
        };
        tponto.start();
    }

    public APP() {

        mapa = new Mapa();
        frame = new JFrame("Bike Show");
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivos");
        mnConsultar = new JMenu("Consultar");
        miSair = new JMenuItem("Sair");
        miAdjacencias = new JMenuItem("Matris de Adjacencias");
        miCodigoFonte = new JMenuItem("Consultar código fonte");
        miBotao = new JMenuItem("Botao");
        btlargura = new JButton("Largura");
        btprofundidade = new JButton("Profundidade");
        cb_cidades = new JComboBox();
        cb_cidades02 = new JComboBox();
        label = new JLabel("De");
        label02 = new JLabel("Para");

        inicializarComponentes();
    }

    private void inicializarComponentes() {
        ImageIcon background = new ImageIcon("C:\\Users\\igorb\\Desktop\\6° periodo\\INTELGENCIA ARTIFICIAL\\BuscasIA\\MAPA_SERGIPE.png");
        Image img = background.getImage();
        Image temp = img.getScaledInstance(900, 1100, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);
        back.setBounds(0, 0, 500, 600);
        //pega a altura e largura
        //int altura = img.getIconHeight();
        //int largura = img.getIconWidth();
        label03 = new JLabel(background);
        // setando o mapa de forma que o ponto vermelho possa sobrescrever o mapa
        frame.setContentPane(label03);
        miAdjacencias.addActionListener(this);
        miCodigoFonte.addActionListener(this);
        miSair.addActionListener(this);
        miBotao.addActionListener(this);
        btlargura.addActionListener(this);
        btprofundidade.addActionListener(this);
        cb_cidades.addActionListener(this);
        cb_cidades02.addActionListener(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        mnArquivo.add(miBotao);
        mnConsultar.add(miSair);
        mnConsultar.add(miAdjacencias);
        mnConsultar.add(miCodigoFonte);

        mnBarra.add(mnArquivo);
        mnBarra.add(mnConsultar);

        ArrayList<String> Nome_Cidades = new ArrayList<>();
        mapa.getCidades().forEach(item -> Nome_Cidades.add(item.getNome()));
        cb_cidades.setModel(new javax.swing.DefaultComboBoxModel(Nome_Cidades.toArray()));
        cb_cidades.setName("cb_cidades");
        Nome_Cidades.remove(0);
        cb_cidades02.setModel(new javax.swing.DefaultComboBoxModel(Nome_Cidades.toArray()));
        cb_cidades02.setName("cb_cidades02");
        frame.setJMenuBar(mnBarra);
        frame.add(btlargura);
        frame.add(btprofundidade);
        frame.add(cb_cidades);
        frame.add(label);
        frame.add(cb_cidades02);
        frame.add(label02);
       // frame.add(label03);

        btlargura.setBounds(650, 350, 150, 30);
        btprofundidade.setBounds(650, 300, 150, 30);
        cb_cidades.setBounds(650, 70, 150, 30);
        cb_cidades02.setBounds(650, 100, 150, 30);
        label.setBounds(620, 70, 200, 30);
        label02.setBounds(620, 100, 200, 30);
        label03.setBounds(0, -200, 1100, 1100);

        frame.setPreferredSize(new java.awt.Dimension(1200, 900));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        /** ---------------------------------------------------------------------- 
         * Os códigos dessa região servem ara colocar os pontos vermelhos piscando na tela sobre as cidades
         * Aqui precisamos de uma thread, um arrayList de labels e outro arrayList com a lista das cidades 
         * selecionadas **/
        
        /*Adicionado a quantidade de pontos correspondes a quantodade de ciades (ficticio ate agora)*/
        pontoVermelho = new ArrayList<>();
        for (int i = 0; i < 5;i++)
        	pontoVermelho.add(new JLabel(new ImageIcon("C:\\Users\\igorb\\Desktop\\6° periodo\\INTELGENCIA ARTIFICIAL\\BuscasIA\\pontoAzul.png")));
        
        
        ArrayList<Cidade> c = new ArrayList<>();
        
        c.add(mapa.getNossa_Senhora_da_Gloria());
        c.add(mapa.getCarira());
        c.add(mapa.getNossa_Senhora_aparecida());
        c.add(mapa.getFrei_Paulo());
        c.add(mapa.getPedra_Mole());
        
        // colocando ponto vermelho na tela
        ativarPontoVermelho(c);
        
        /** Finalizando região de efeitos especiais de layout
         *  ----------------------------------------------------------------------- */
        
        //frame.setIconImage(createImage("Busca/dsike.jpg").getImage());
    }
    //private ImageIcon createImage(String path){
    //  return new ImageIcon(java.awt.Toolkit.getDefaultToolkit().getClass().getResource(path));
    //}



    public static void main(String[] args) {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        APP principal = new APP();

        principal.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btlargura)) {
            Largura l = new Largura(PesquisaCidadeNome(cb_cidades.getSelectedItem().toString()),
                    PesquisaCidadeNome(cb_cidades02.getSelectedItem().toString()));
            l.buscar01();

        } else if (e.getSource().equals(btprofundidade)) {
            Profundidade p = new Profundidade(PesquisaCidadeNome(cb_cidades.getSelectedItem().toString()),
                    PesquisaCidadeNome(cb_cidades02.getSelectedItem().toString()));
            p.buscar();
        } else if (e.getSource().equals(cb_cidades)) {
            System.out.println(cb_cidades.getSelectedItem().toString());
            ArrayList<String> Nome_Cidades = new ArrayList<>();
            for (Cidade cidade : mapa.getCidades()) {
                if (!cidade.getNome().equals(cb_cidades.getSelectedItem().toString())) {
                    Nome_Cidades.add(cidade.getNome());
                }
            }
            cb_cidades02.setModel(new javax.swing.DefaultComboBoxModel(Nome_Cidades.toArray()));
            cb_cidades02.setName("cb_cidades02");
        } else if (e.getSource().equals(cb_cidades02)) {
            System.out.println(cb_cidades02.getSelectedItem().toString());
        } else if (e.getSource().equals(miSair)) {
            System.exit(0);
        } else if (e.getSource().equals(miAdjacencias)) {
            String[] opcao = {"fechar"};
            JOptionPane.showOptionDialog(null, "Funcionalidade a ser implementada", "Consultar Matriz Adj", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, opcao, opcao[0]);
            Toolkit.getDefaultToolkit().beep();
        } else if (e.getSource().equals(miCodigoFonte)) {

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