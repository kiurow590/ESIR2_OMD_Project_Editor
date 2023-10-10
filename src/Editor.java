import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author Vincent
 */
public class Editor {

    private static JPanel panel_1;
    private static JPanel panel_2;

    private static JTextArea textArea;

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame window = new JFrame("Editeur de texte");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_1 = new JPanel();
        panel_2 = new JPanel();
        panel_2.setBackground(Color.lightGray);
        panel_1.setBackground(Color.lightGray);
        window.add(BorderLayout.NORTH, panel_1);
        final JScrollPane scroll_1 = new JScrollPane(panel_1, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        textArea = new JTextArea(10,10);
        textArea.setBounds(10, 10, 500, 500);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); // Le retour à la ligne ne se fait qu'à l'espace entre les mots
        // textArea.bounds(new Rectangle(10,10));
        panel_1.add(textArea);
        final JScrollPane scroll_2 = new JScrollPane(panel_2, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        panel_2.add((new JButton("Copy")));


        panel_2.add(new JButton("Paste"));
        panel_2.add(new JButton("Cut"));
        GridLayout griddy = new GridLayout(2, 0);
        window.setLayout(griddy);
        window.add(BorderLayout.SOUTH,scroll_2);

        window.add(BorderLayout.NORTH,scroll_1);
        window.setSize(900, 580);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    public String getText(){
        return textArea.getText();
    }

    public void actionPerformed(ActionEvent e)
    {

    }
}