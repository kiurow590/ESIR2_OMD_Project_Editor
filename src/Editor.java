import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */
public class Editor {

    private JPanel panel_1;
    private JPanel panel_2;
    JLabel l1;
    private JTextArea textArea;


    String copyBuffer = "";

    public Editor() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFrame window = new JFrame("Editeur de texte");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_1 = new JPanel();
        panel_2 = new JPanel();
        panel_2.setBackground(Color.lightGray);
        panel_1.setBackground(Color.lightGray);
        window.add(BorderLayout.NORTH, panel_1);
        final JScrollPane lowerScroll = new JScrollPane(panel_1, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        textArea = new JTextArea(10, 10);
        textArea.setBounds(10, 10, 500, 500);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); // Le retour à la ligne ne se fait qu'à l'espace entre les mots
        // textArea.bounds(new Rectangle(10,10));
        panel_1.add(textArea);
        final JScrollPane upperScroll = new JScrollPane(panel_2, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Editor editor = this;
        JButton btnCopy = new JButton("Copy");
        btnCopy.setBounds(50, 210, 180, 30);
            btnCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions specific to Button 1
                // You can identify it based on its label: "Button 1"
                // For example:
                //setCopyBuffer(textArea.getSelectedText());
                Command copy = CopyCommand.getInstance(editor);
                copy.execute();
                System.out.println("BOUTON COPY CLICK");
            }
        });


        panel_2.add(btnCopy);

        l1 = new JLabel();
        l1.setBounds(45, 175, 100, 30);

        panel_2.add(l1);


        JButton btnPaste = new JButton("Paste");
        btnPaste.setBounds(50, 210, 180, 30);
        btnPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions specific to Button 1
                // You can identify it based on its label: "Button 1"
                // For example:
                //l1.setText(getCopyBuffer());
                //textArea.append(getCopyBuffer());
                Command paste = PasteCommand.getInstance(editor);
                paste.execute();
                System.out.println("BOUTON Paste CLICK");
            }
        });
        panel_2.add(btnPaste);


        JButton btnCut = new JButton("Cut");
        btnCut.setBounds(50, 210, 180, 30);
        btnCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions specific to Button 1
                // You can identify it based on its label: "Button 1"
                // For example:
                //l1.setText(textArea.getSelectedText());
                //String test textArea.getText();
                Command paste = CutCommand.getInstance(editor);
                paste.execute();
                System.out.println("BOUTON Cut CLICK");
            }
        });
        panel_2.add(btnCut);

        final JButton btnSelectRight = new JButton("->");
        btnSelectRight.setBounds(50, 210, 180, 30);
        //JTextField selection = new JTextField();


        btnSelectRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform actions specific to Button 1
                // You can identify it based on its label: "Button 1"
                // For example:
                //l1.setText(textArea.getSelectedText());
                //String test textArea.getText();
                //textArea.selectAll();
                /*Command selectRight = new SelectRightCommand(editor);
                selectRight.execute();*/

                //textArea.selectAll();

                // Transfer focus to JTextArea to show the selected
                // text.
                //btnSelectRight.transferFocusBackward();
                //int currentRows = textArea.getRows();
                //int currentColumns = textArea.getColumns();
                //textArea.setRows(currentRows + 1);
                //textArea.setColumns(currentColumns + 10);
                textArea.selectAll();

                // Transfer focus to JTextArea to show the selected
                // text.
                btnSelectRight.transferFocusBackward();
                System.out.println("BOUTON SelectRight CLICK");
            }
        });
        panel_2.add(btnSelectRight);

        GridLayout griddy = new GridLayout(2, 0);
        window.setLayout(griddy);
        window.add(BorderLayout.SOUTH, upperScroll);

        window.add(BorderLayout.NORTH, lowerScroll);
        window.setSize(900, 580);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    public void setCopyBuffer(String copyBuffer) {
        this.copyBuffer = copyBuffer;
    }

    public String getCopyBuffer() {
        return this.copyBuffer;
    }

    public String getSelectedTextText() {
        return textArea.getSelectedText();
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea text) {
        textArea = text;
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("Event :" + e);
    }
}