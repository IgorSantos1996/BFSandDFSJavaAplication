package TelaCreditos;

import javax.swing.*;
import java.awt.*;

public class Creditos extends JFrame {

    public Creditos() {

        String[] opcao = {"OK"};
        JOptionPane.showOptionDialog(null, "Universidade Federal de Sergipe\n Docente: Alcides\n Discente: Joan Vitor", "Sobre", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcao, opcao[0]);
        Toolkit.getDefaultToolkit().beep();

    }
}