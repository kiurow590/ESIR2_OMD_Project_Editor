import javax.swing.*;
import java.awt.*;

public class FenetreSaisie extends JFrame {

    //...

    public static JPanel buildContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JTextArea textField = new JTextArea(10,30);
        textField.setBounds(10,100,300,300);
        //textField.setColumns(50);
        //On lui donne un nombre de colonnes à afficher

        panel.add(textField);

        return panel;
    }
}
