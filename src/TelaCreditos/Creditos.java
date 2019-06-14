package TelaCreditos;

import javax.swing.*;
import java.awt.*;

public class Creditos extends JFrame {

    public Creditos() {

        String[] opcao = {"OK"};
        JOptionPane.showOptionDialog(null,
                "Universidade Federal de Sergipe\n" +
                        "Departamento de Sistemas de Informação - DSI\n" +
                        "Docente: Dr. Alcides Xavier Benicasa\n" +
                        "Disciplina: Inteligência Artificial\n" +
                        "Discentes:" +
                        "\n Bruno Santana Santos\n" +
                        " Clovijan Bispo Rocha\n" +
                        " Igor Terriaga Santos\n" +
                        " Joan Vitor Mendonça de Jesus\n",
                "Sobre", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opcao, opcao[0]);

        Toolkit.getDefaultToolkit().beep();

    }
}