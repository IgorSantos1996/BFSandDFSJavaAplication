package TelaBoasVindas;

import javax.swing.*;
import java.awt.*;

public class BoasVindas extends JWindow {
    private int duration;
    private static JProgressBar progressBar;
    private JLabel textoCarregando;

    public BoasVindas(int d) {
        duration = d;
    }

// Este é um método simples para mostrar uma tela de apresentção

// no centro da tela durante a quantidade de tempo passada no construtor

    public void showSplash() {
        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.white);
        progressBar = new JProgressBar();
        progressBar.setForeground(Color.GREEN);
        progressBar.setPreferredSize(new java.awt.Dimension(10, 50));
        progressBar.setBounds(0, 400, 600, 100);
        progressBar.setBorderPainted(true);
        progressBar.setIndeterminate(true);
        getContentPane().add(progressBar);


        // Configura a posição e o tamanho da janela
        int width = 450;
        int height = 405;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

        // Constrói o splash screen
        JLabel label = new JLabel(new ImageIcon(ClassLoader.getSystemResource(
                "Imagens/giphy.gif")));
        JLabel copyrt = new JLabel
                ("Busca em Largura e profundidade", JLabel.CENTER);
        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        content.add(label, BorderLayout.CENTER);
        content.add(copyrt, BorderLayout.SOUTH);
        Color oraRed = new Color(255, 231, 238, 255);
        content.setBorder(BorderFactory.createLineBorder(oraRed, 5));
        // Torna visível
        setVisible(true);

        // Espera ate que os recursos estejam carregados
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
        setVisible(true);
    }

    public void showSplashAndExit() {
        showSplash();
        dispose();

    }

}