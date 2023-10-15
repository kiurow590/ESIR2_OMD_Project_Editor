package v2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */
public class Editor {

    private JPanel panel_1 = new JPanel();
    private JPanel panel_2 = new JPanel();
    private JTextArea textArea;

    private static HistoryCommand historyCommand = HistoryCommand.getInstance();

    private String copyBuffer = "";

    /**
     * Constructeur de l'editeur
     *
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws UnsupportedLookAndFeelException
     */
    public Editor() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        // ###############################################
        // ############## INITIALISAITON #################
        // ###############################################

        JFrame window = new JFrame("Editeur de texte");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel_2.setBackground(Color.lightGray);
        panel_1.setBackground(Color.lightGray);
        window.add(BorderLayout.NORTH, panel_1);

        // ########################################################
        // ############## INITIALISAITON TextArea #################
        // ########################################################

        final JScrollPane lowerScroll = new JScrollPane(panel_1, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        textArea = new JTextArea(10, 10);
        textArea.setBounds(10, 10, 500, 500);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); // Le retour à la ligne ne se fait qu'à l'espace entre les mots
        panel_1.add(textArea);

        // ########################################################
        // ############## INITIALISAITON Button ###################
        // ########################################################
        final JScrollPane upperScroll = new JScrollPane(panel_2, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        Editor editor = this;

        JButton btnSelectRight = new JButton("->");
        btnSelectRight.setBounds(50, 210, 180, 30);
        btnSelectRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command SelectRight = SelectRightCommand.getInstance(editor);
                SelectRight.execute();
                btnSelectRight.transferFocusBackward();
            }
        });

        JButton btnSelectLeft = new JButton("<-");
        btnSelectLeft.setBounds(50, 210, 180, 30);
        btnSelectLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command SelectLeft = SelectLeftCommand.getInstance(editor);
                SelectLeft.execute();
                btnSelectLeft.transferFocusBackward();
            }
        });

        JButton btnCopy = new JButton("Copy");
        btnCopy.setBounds(50, 210, 180, 30);
        btnCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command copy = CopyCommand.getInstance(editor);
                copy.execute();
            }
        });


        JButton btnPaste = new JButton("Paste");
        btnPaste.setBounds(50, 210, 180, 30);
        btnPaste.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command paste = PasteCommand.getInstance(editor);
                historyCommand.push(paste);
                paste.execute();
            }
        });

        JButton btnCut = new JButton("Cut");
        btnCut.setBounds(50, 210, 180, 30);
        btnCut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command cut = CutCommand.getInstance(editor);
                cut.execute();
            }
        });

        JButton btnReplay = new JButton("Replay");
        btnReplay.setBounds(50, 210, 180, 30);
        btnReplay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Command last = historyCommand.replay();
                if(!textArea.getText().isEmpty()){
                    last.execute();
                }
                
            }
        });
        // Ajour des bouton à l'interface
        panel_2.add(btnSelectLeft);
        panel_2.add(btnSelectRight);
        panel_2.add(btnCopy);
        panel_2.add(btnPaste);
        panel_2.add(btnCut);
        panel_2.add(btnReplay);

        textArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
                CharacterReleaseCommand charKey = new CharacterReleaseCommand(editor, e.getKeyChar(), e.getKeyCode());
                historyCommand.push(charKey);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        GridLayout griddy = new GridLayout(2, 0);
        window.setLayout(griddy);
        window.add(BorderLayout.SOUTH, upperScroll);

        window.add(BorderLayout.NORTH, lowerScroll);
        window.setSize(900, 580);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }

    /**
     * mets a jour le buffer
     *
     * @param copyBuffer le nouveau buffer
     */
    public void setCopyBuffer(String copyBuffer) {
        this.copyBuffer = copyBuffer;
    }

    /**
     * Recupere le contenu du buffer
     *
     * @return le buffer
     */
    public String getCopyBuffer() {
        return this.copyBuffer;
    }

    /**
     * renvoie le texte selectionné
     *
     * @return le texte selectionné
     */
    public String getSelectedTextText() {
        return textArea.getSelectedText();
    }

    /**
     * renvoie le texte de l'editeur
     *
     * @return le texte de l'editeur
     */
    public JTextArea getTextArea() {
        return textArea;
    }

    /**
     * @param text le nouveau texte
     */
    public void setTextArea(JTextArea text) {
        textArea = text;
    }

}

