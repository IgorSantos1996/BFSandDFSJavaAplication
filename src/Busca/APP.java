package Busca;

import Grafo.Mapa;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.event.KeyEvent;

import static java.awt.Transparency.OPAQUE;

public class APP implements ActionListener {
    //private JPanel painel = null;
    private JLabel label;
    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnExemplos;
    private JMenuItem miSair, miBotao;
    private JButton btlargura;
    private JButton btprofundidade;
    private JFrame frame;
    private static JComboBox cb_cidades;

    public APP() {
        frame = new JFrame("Exemplo");
        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivos");
        mnExemplos = new JMenu("Exemplos");
        miSair = new JMenuItem("Sair");
        miBotao = new JMenuItem("Botao");
        btlargura = new JButton("Largura");
        btprofundidade = new JButton("Profundidade");
        cb_cidades = new JComboBox();
        label = new JLabel("De");

        inicializarComponentes();

    }

    private void inicializarComponentes() {
        miSair.addActionListener(this);
        miBotao.addActionListener(this);
        btlargura.addActionListener(this);
        btprofundidade.addActionListener(this);
        cb_cidades.addActionListener(this);
       // frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        mnArquivo.add(miBotao);
        mnExemplos.add(miSair);

        mnBarra.add(mnArquivo);
        mnBarra.add(mnExemplos);

        cb_cidades.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ruim", "Regular", "Médio",  "Bom", "Otimo" }));
        cb_cidades.setName("cb_cidades");

        frame.setJMenuBar(mnBarra);
        frame.add(btlargura);
        frame.add(btprofundidade);
        frame.add(cb_cidades);
        frame.add(label);

        btlargura.setBounds(30, 50, 150, 30);
        btprofundidade.setBounds(50, 100, 150, 30);
        cb_cidades.setBounds(30,120,150, 30);
        label.setBounds(30, 150, 150, 30);

        frame.setPreferredSize(new java.awt.Dimension(500,500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


      /*  setTitle("Bike Show");
        setBounds(0, 0, 1000, 600);
        //label = new JLabel("Painel");
        contentPane = getContentPane();
        //contentPane.setLayout(null);

        btlargura = new JButton("Busca em Largura "); // criação do botão
        btlargura.setBounds(125, 1, 100, 25);
        btprofundidade = new JButton("Busca em Profundidade");
        btprofundidade.setBounds(10, 120, 100, 25); // posição do componente gráfico btlogar
        painel = new JPanel();
        painel.setBackground(Color.ORANGE);
        painel.add(btlargura);
        painel.add(btprofundidade);
        painel.setBounds(40, 1, 200, 50);

        contentPane.add(painel);
        setLocation(100, 50);
        setResizable(false);
        setVisible(true);

        mnBarra = new JMenuBar();
        mnArquivo = new JMenu("Arquivo");
        mnArquivo.setMnemonic('A'); // define uma tecla de acesso rápido ao menu. Alt + A
        mnExemplos = new JMenu("Exemplos");
        mnExemplos.setMnemonic('E'); // define uma tecla de acesso rápido ao menu. Alt + E
        miSair = new JMenuItem("Sair", new ImageIcon("sair.jpg")); // cria o objeto miSair com um texto e um ícone.
        // Assim como o texto, esse ícone também será
        // adicionado ao menu Sair.
        miSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK)); // definem um menu de atalho
        // para o item Sair por meio
        // do método setAccelerator

        //
        miBotao = new JMenuItem("Botao"); // cria o item de menu miBotao
        mnArquivo.add(miSair); // add o item de menu ao menu correspondente.
        mnExemplos.add(miBotao); // add o item de menu ao menu correspondente.
        mnBarra.add(mnArquivo); // add mnArquivo à barra de menus
        mnBarra.add(mnExemplos); // add mnExemplos à barra de menus
        setJMenuBar(mnBarra); // define o objeto mnBarra como sendo a barra de menus do frame.
*/
    }

   /* private void definirEvento() {
        miSair.addActionListener(new ActionListener() { // define o evento clique para o item do menu miSair. Quando o
            // usuário escolher essa opção, a aplicação será encerrada.
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        miBotao.addActionListener(new ActionListener() { // define evento clique para o item de menu miBotao.

            @Override
            public void actionPerformed(ActionEvent e) {
                // esse item de menu será o responsável por carregar a aplicação
            }
        });
    }

    public static void abrir() { // responsável por criar um objeto do tipo GuiMenuPrincipal e mostrá-lo
        APP frame = new APP();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension tela = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }*/


    public static void main(String[] args) {
       /* SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame = new APP();// recebe todas as características definidas no construtor, incluindo a
                // inicialização dos componentes e a definição dos eventos
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // encerrar a aplicação quando a janela for
                // fechada
                Dimension tela = Toolkit.getDefaultToolkit().getScreenSize(); // cria uma objeto tela contendo as
                // dimensões da tela
                frame.setLocation((tela.width - frame.getSize().width) / 2, (tela.height - frame.getSize().height) / 2);
                frame.setVisible(true);
            }
            //Mapa mapa = new Mapa();
            // Profundidade p = new Profundidade(mapa.getItabaiana(), mapa.getAracaju());
            // p.buscar();
            // Largura l = new Largura(mapa.getItabaiana(), mapa.getAracaju());
            // l.buscar01();
        });*/
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
        if(e.getSource().equals(btlargura)) {
             Largura l = new Largura(mapa.getItabaiana(), mapa.getAracaju());
             l.buscar01();

        }else if(e.getSource().equals(btprofundidade)){
            Profundidade p = new Profundidade(mapa.getItabaiana(), mapa.getAracaju());
            p.buscar();
        }else if(e.getSource().equals(cb_cidades)){
            System.out.println(cb_cidades.getSelectedIndex());
        }else if(e.getSource().equals(miSair)){
            System.exit(0);
        }

    }
}
