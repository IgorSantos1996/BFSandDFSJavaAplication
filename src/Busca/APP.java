package Busca;

import GerarPDF.GerarPdf;
import Grafo.Adjacente;
import Grafo.Cidade;
import Grafo.Mapa;
import TelaBoasVindas.BoasVindas;
import TelaCreditos.Creditos;
import TelaMatriz.telaMatriz;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

public class APP implements ActionListener {
    private JLabel label;
    private JLabel label02;
    private JLabel label03;
    private JMenuBar mnBarra;
    private JMenu mnConsultar, mnSalvar, mnSobre;
    private int contador = 0;

    private boolean maisConsultas = false;

    private JMenuItem miSair, miBotao, miAdjacencias, miCodigoFonte, miAutores, miGerarPDFLargura, miGerarPDFProfundidade;
    private JButton btlargura;
    private JButton btprofundidade;
    private JFrame frame;
    private JButton novaBusca = new JButton("Nova Busca");
    private static JComboBox cb_cidades;
    private static JComboBox cb_cidades02;
    private Image iconeTitulo;
    private Mapa mapa;
    private ArrayList<Cidade> cidades;
    private ArrayList<Cidade> CaminhoPercorrido;

    // Componentes para colocar o ponto azul na tela
    Thread tAzul;
    Thread tVerde;
    private ArrayList<JLabel> pontoAzul;
    private ArrayList<JLabel> pontoVerde;

    public void ativarPonto(ArrayList<Cidade> rota) {
        tAzul = new Thread() {
            public void run() {
                int x = 0;
                while (true) {
                    x++;
                    if (x % 2 == 0) {
                        for (int i = 0; i < rota.size(); i++) {
                            frame.add(pontoAzul.get(i)).setBounds(rota.get(i).getX(), rota.get(i).getY(), 20, 20);
                            pontoAzul.get(i).setVisible(true);
                        }

                    } else {
                        for (int i = 0; i < rota.size(); i++) {
                            pontoAzul.get(i).setVisible(false);
                        }
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        System.out.println("Erro: " + ex);
                    }

                }
            }
        };
        tAzul.start();
    }

    public void ativarPontoVerde(ArrayList<Cidade> rota) {
        tVerde = new Thread() {
            public void run() {
                int x = 0;
                while (true) {
                    x++;
                    if (x % 2 == 0) {
                        for (int i = 0; i < rota.size(); i++) {
                            frame.add(pontoVerde.get(i)).setBounds(rota.get(i).getX(), rota.get(i).getY(), 20, 20);
                            pontoVerde.get(i).setVisible(true);
                        }

                    } else {
                        for (int i = 0; i < rota.size(); i++) {
                            pontoVerde.get(i).setVisible(false);
                        }
                    }

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        System.out.println("Erro: " + ex);
                    }

                }
            }
        };
        tVerde.start();
    }

    public APP() {

        mapa = new Mapa();
        frame = new JFrame("Busca em Largura e Profundidade");
        mnBarra = new JMenuBar();
        //mnArquivo = new JMenu("Arquivos");
        mnSalvar = new JMenu("Salvar");
        mnConsultar = new JMenu("Consultar");
        mnSobre = new JMenu("Sobre");
        miSair = new JMenuItem("Sair");
        miAdjacencias = new JMenuItem("Matris de Adjacencias");
        miCodigoFonte = new JMenuItem("Consultar código fonte");
        miGerarPDFLargura = new JMenuItem("Gerar PDF da Busca em largura");
        miGerarPDFProfundidade = new JMenuItem("Gerar PDF da Busca em profundidade");
        miBotao = new JMenuItem("Botao");
        miAutores = new JMenuItem("Info autores");
        btlargura = new JButton("Largura");
        btprofundidade = new JButton("Profundidade");
        novaBusca = new JButton("Nova Busca");
        cb_cidades = new JComboBox();
        cb_cidades02 = new JComboBox();
        label = new JLabel("De");
        label02 = new JLabel("Para");
        //cidades = new ArrayList<>();

        inicializarComponentes();

    }

    private void inicializarComponentes() {
        ImageIcon background = new ImageIcon(ClassLoader.getSystemResource("Imagens/MAPA-800x600.png"));
        Image img = background.getImage();

        Image temp = img.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp);
        JLabel back = new JLabel(background);
        back.setLayout(null);

        //back.setBackground(Color.ORANGE);
        back.setBounds(0, 0, 500, 600);
        URL url = ClassLoader.getSystemResource("Imagens/800px-Petersen_graph_3-coloring.svg.png");
        Image iconetitulo = Toolkit.getDefaultToolkit().getImage(url);
        frame.setIconImage(iconetitulo);

        label03 = new JLabel(background);
        // setando o mapa de forma que o ponto vermelho possa sobrescrever o mapa
        frame.setContentPane(label03);


        miAdjacencias.addActionListener(this);
        miCodigoFonte.addActionListener(this);
        miSair.addActionListener(this);
        miBotao.addActionListener(this);
        miGerarPDFLargura.addActionListener(this);
        miGerarPDFProfundidade.addActionListener(this);
        miAutores.addActionListener(this);
        btlargura.addActionListener(this);
        btprofundidade.addActionListener(this);
        cb_cidades.addActionListener(this);
        cb_cidades02.addActionListener(this);
        novaBusca.addActionListener(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setBackground(Color.GREEN);
        frame.getContentPane().setLayout(null);
        //frame.getContentPane().setBackground(new java.awt.Color(204, 166, 166));

        //mnArquivo.add(miBotao);
        mnBarra.add(mnConsultar);
        mnBarra.add(mnSalvar);
        mnBarra.add(mnSobre);
        mnSalvar.add(miGerarPDFLargura);
        mnSalvar.add(miGerarPDFProfundidade);
        mnConsultar.add(miSair);
        mnConsultar.add(miAdjacencias);
        mnConsultar.add(miCodigoFonte);
        mnSobre.add(miAutores);
        //mnBarra.add(mnArquivo);


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
        frame.add(novaBusca);

        miGerarPDFProfundidade.setEnabled(false);
        miGerarPDFLargura.setEnabled(false);

        novaBusca.setBounds(100, 500, 150, 30);
        btlargura.setBounds(650, 40, 150, 30);
        btprofundidade.setBounds(650, 100, 150, 30);
        cb_cidades.setBounds(70, 40, 200, 30);
        cb_cidades02.setBounds(70, 100, 200, 30);
        label.setBounds(70, 10, 200, 30);
        label02.setBounds(70, 70, 200, 30);
        label03.setBounds(0, -200, 1100, 1100);

        frame.setPreferredSize(new java.awt.Dimension(900, 650));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        /**
         * ----------------------------------------------------------------------
         * Os códigos dessa região servem ara colocar os pontos vermelhos
         * piscando na tela sobre as cidades Aqui precisamos de uma thread, um
         * arrayList de labels e outro arrayList com a lista das cidades
         * selecionadas *
         */

        /*Adicionado a quantidade de pontos correspondes a quantodade de ciades (ficticio ate agora)*/
        pontoAzul = new ArrayList<>();
        pontoVerde = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            pontoAzul.add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Imagens/pontoAzul.png"))));
            pontoVerde.add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("Imagens/pontoVerde.png"))));
        }

        ArrayList<Cidade> c = new ArrayList<>();

        c.add(mapa.getItabaiana());
        c.add(mapa.getFrei_Paulo());
        c.add(mapa.getMoita_Bonita());
        c.add(mapa.getLagarto());
        c.add(mapa.getLaranjeiras());
        c.add(mapa.getMacambira());
        c.add(mapa.getMalhador());
        c.add(mapa.getNossa_Senhora_aparecida());
        c.add(mapa.getNossa_Senhora_da_Gloria());
        c.add(mapa.getNossa_Senhora_das_Dores());
        c.add(mapa.getNossa_Senhora_do_Socorro());
        c.add(mapa.getPedra_Mole());
        c.add(mapa.getPinhao());
        c.add(mapa.getRiachuelo());
        c.add(mapa.getRibeiropolis());
        c.add(mapa.getSao_Cristovao());
        c.add(mapa.getSao_Domingos());
        c.add(mapa.getCarira());
        c.add(mapa.getAreia_Branca());
        c.add(mapa.getAracaju());
        c.add(mapa.getSimao_Dias());
        c.add(mapa.getCampo_do_Brito());

        // colocando ponto vermelho na tela
        //ativarPonto(c);

        /**
         * Finalizando região de efeitos especiais de layout
         * -----------------------------------------------------------------------
         */
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

        BoasVindas b = new BoasVindas(3000);
        b.showSplashAndExit();

        APP principal = new APP();

        principal.frame.setVisible(true);
    }

    public void DesativarPontoAzul(ArrayList<Cidade> cities) {
        for (int i = 0; i < cities.size(); i++) {
            frame.add(pontoAzul.get(i)).setBounds(cities.get(i).getX(), cities.get(i).getY(), 20, 20);
            pontoAzul.get(i).setVisible(false);
        }
    }

    public void DesativarPontoVerde(ArrayList<Cidade> cities) {
        for (int i = 0; i < cities.size(); i++) {
            frame.add(pontoVerde.get(i)).setBounds(cities.get(i).getX(), cities.get(i).getY(), 20, 20);
            pontoVerde.get(i).setVisible(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btlargura)) {
//            if(maisConsultas == true){
//                tponto.suspend();
//                DesativarPontoAzul(cidades);
//                DesativarPontoVerde(CaminhoPercorrido);
//            }
            miGerarPDFLargura.setEnabled(true);
            Cidade inicio = PesquisaCidadeNome(cb_cidades.getSelectedItem().toString());
            Cidade objetivo = PesquisaCidadeNome(cb_cidades02.getSelectedItem().toString());
            Largura l = new Largura(inicio, objetivo);
            cidades = new ArrayList<>();
            CaminhoPercorrido = new ArrayList<>();
            cidades = l.buscaLargura();
            ativarPonto(cidades);
            CaminhoPercorrido = cidades;
            CaminhoPercorrido = l.CaminhoPercorrido(inicio, objetivo);
            ativarPontoVerde(CaminhoPercorrido);
            btlargura.setEnabled(false);
            btprofundidade.setEnabled(false);
            JOptionPane.showMessageDialog(null, l.MostraRota(cidades), "Caminho Percorrido", JOptionPane.DEFAULT_OPTION);
            maisConsultas = true;
        } else if (e.getSource().equals(btprofundidade)) {
            miGerarPDFProfundidade.setEnabled(true);
            Cidade inicio = PesquisaCidadeNome(cb_cidades.getSelectedItem().toString());
            Cidade objetivo = PesquisaCidadeNome(cb_cidades02.getSelectedItem().toString());
            Profundidade p = new Profundidade(inicio, objetivo);
            cidades = new ArrayList<>();
            CaminhoPercorrido = new ArrayList<>();
            cidades = p.buscaEmProfundidade(cidades);
            ativarPonto(cidades);
            CaminhoPercorrido = cidades;
            CaminhoPercorrido = p.CaminhoPercorrido(inicio, objetivo);
            ativarPontoVerde(CaminhoPercorrido);
            btprofundidade.setEnabled(false);
            btlargura.setEnabled(false);

            JOptionPane.showMessageDialog(null, p.MostraRota(cidades), "Caminho Percorrido", JOptionPane.DEFAULT_OPTION);
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
            new telaMatriz().setVisible(true);
        } else if (e.getSource().equals(miCodigoFonte)) {

            ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Imagens/github.png"));
            //Image iconetitulo = Toolkit.getDefaultToolkit().getImage(url);
            String[] opcao = {"Acessar", "fechar"};
           Integer a = JOptionPane.
                    showOptionDialog(null,
                            "Clique para acessar o repositorio",
                           "Consultar codigo Fonte", JOptionPane.DEFAULT_OPTION , JOptionPane.WARNING_MESSAGE,
                           img, opcao, opcao[0]);
            System.out.println(a);
           if(a==0) {
               String url = "https://github.com/IgorSantos1996/BuscasIA";

               try {
                   Desktop.getDesktop().browse(java.net.URI.create(url));
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
           }


            Toolkit.getDefaultToolkit().beep();
        } else if (e.getSource().equals(miGerarPDFLargura)) {
            Cidade inicio = PesquisaCidadeNome(cb_cidades.getSelectedItem().toString());
            Cidade objetivo = PesquisaCidadeNome(cb_cidades02.getSelectedItem().toString());
            Largura l = new Largura(inicio, objetivo);

            String rota = l.MostraRota(cidades);

            GerarPdf pdf = new GerarPdf(rota, "Largura");
        } else if (e.getSource().equals(miGerarPDFProfundidade)) {
            Cidade inicio = PesquisaCidadeNome(cb_cidades.getSelectedItem().toString());
            Cidade objetivo = PesquisaCidadeNome(cb_cidades02.getSelectedItem().toString());

            Profundidade p = new Profundidade(inicio, objetivo);

            //É aqui onde a porca torceu o rabo, mas não torce mais KKKKKKKKKKKKKK
            String rota = p.MostraRota(cidades);

            GerarPdf pdf = new GerarPdf(rota, "Profundidade");
        } else if (e.getSource().equals(miAutores)) {
            new Creditos();
        } else if (e.getSource().equals(novaBusca)) {
            btlargura.setEnabled(true);
            btprofundidade.setEnabled(true);
            miGerarPDFLargura.setEnabled(false);
            miGerarPDFProfundidade.setEnabled(false);
            resetar();
        }
    }

    // metodo para resetar a consulta
    public void resetar() {
        tAzul.suspend();
        DesativarPontoAzul(cidades);
        tVerde.suspend();
        DesativarPontoVerde(CaminhoPercorrido);

        for (Cidade c : cidades) {
            c.setVisitado(false);
            for (Adjacente a : c.getAdjacentes()) {
                a.getCidade().setVisitado(false);
            }
        }

        for (Cidade c : CaminhoPercorrido) {
            c.setVisitado(false);
            for (Adjacente a : c.getAdjacentes()) {
                a.getCidade().setVisitado(false);
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
