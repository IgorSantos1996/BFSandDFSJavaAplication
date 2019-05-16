package Busca;

import Grafo.Mapa;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class APP implements ActionListener {
    //private JPanel painel = null;
    private JLabel label;
    private JLabel label02;
    private JLabel label03;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao;
    private JButton btlargura;
    private JButton btprofundidade;
    private JFrame frame;
    private static JComboBox cb_cidades;
    private static JComboBox cb_cidades02;


    public APP() {
        frame = new JFrame("Bike Show");
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivos");
        mnExemplos = new JMenu("Exemplos");
        miSair = new JMenuItem("Sair");
        miBotao = new JMenuItem("Botao");
        btlargura = new JButton("Largura");
        btprofundidade = new JButton("Profundidade");
        cb_cidades = new JComboBox();
        cb_cidades02 = new JComboBox();
        label = new JLabel("De");
        label02 = new JLabel("Para");
        //Image imagem = ImageIO.read(getClass().getResource("dslike.png"));



        inicializarComponentes();

    }


    private void inicializarComponentes() {
        //frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("dslike.jpg")));


        ImageIcon img = new ImageIcon("D:\\6 periodo\\Inteligencia Artificial\\TrabalhoIA\\BuscasSemInformacao\\src\\Busca\\mapa.jpg");
        //pega a altura e largura
        int altura = img.getIconHeight();
        int largura = img.getIconWidth();
        label03 = new JLabel(img);


        miSair.addActionListener(this);
        miBotao.addActionListener(this);
        btlargura.addActionListener(this);
        btprofundidade.addActionListener(this);
        cb_cidades.addActionListener(this);
        cb_cidades02.addActionListener(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);


        mnArquivo.add(miBotao);
        mnExemplos.add(miSair);

        mnBarra.add(mnArquivo);
        mnBarra.add(mnExemplos);

        cb_cidades.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Cidades", "Regular", "Médio", "Bom", "Otimo"}));
        cb_cidades.setName("cb_cidades");
        cb_cidades02.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Cidades", "Regular", "Médio", "Bom", "Otimo"}));
        cb_cidades02.setName("cb_cidades02");
        frame.setJMenuBar(mnBarra);
        frame.add(btlargura);
        frame.add(btprofundidade);
        frame.add(cb_cidades);
        frame.add(label);
        frame.add(cb_cidades02);
        frame.add(label02);
        frame.add(label03);

        btlargura.setBounds(30, 400, 150, 30);
        btprofundidade.setBounds(500, 400, 150, 30);
        cb_cidades.setBounds(60, 20, 150, 30);
        cb_cidades02.setBounds(500, 20, 150,30);
        label.setBounds(30, 20, 200, 30);
        label02.setBounds(470,20,200,30);
        label03.setBounds(20,30, altura,largura);

        frame.setPreferredSize(new java.awt.Dimension(700, 600));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);



    }




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
        Mapa mapa = new Mapa();
        if (e.getSource().equals(btlargura)) {
            Largura l = new Largura(mapa.getItabaiana(), mapa.getAracaju());
            l.buscar01();

        } else if (e.getSource().equals(btprofundidade)) {
            Profundidade p = new Profundidade(mapa.getItabaiana(), mapa.getAracaju());
            p.buscar();
        } else if (e.getSource().equals(cb_cidades)) {
            System.out.println(cb_cidades.getSelectedIndex());
        } else if (e.getSource().equals(miSair)) {
            System.exit(0);
        }

    }
}
