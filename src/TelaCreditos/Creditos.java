package TelaCreditos;

import javax.swing.*;
import java.awt.*;

public class Creditos extends JFrame {
    private JLabel label;
    public Creditos() {
        label = new JLabel("Universidade Federal de Sergipe" +
                "\nDiscente: Igor Terriaga" +
                "Clovijan" +
                "Bruno" +
                "Joan" +
                "\nDocente: Professor Alcides Xavier Benicasa\n" +
                "\nDisciplina: Inteligencia Artificial\n"
        );
        label.setHorizontalTextPosition( SwingConstants.CENTER );
        //label.setVerticalTextPosition( SwingConstants.BOTTOM );
        setLayout(new FlowLayout());// tipo de layout
        setSize(new Dimension(900, 500));// tamanho do Formulario
        setLocationRelativeTo(null);// centralizado
        setTitle("Informacao dos autores");// titulo
        add(label);

    }
}