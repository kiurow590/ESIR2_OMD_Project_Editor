import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaSelectAll extends JPanel {
    public TextAreaSelectAll() {
        initializeUI();
    }

    public static void showFrame() {
        JPanel panel = new TextAreaSelectAll();
        panel.setOpaque(true);

        JFrame frame = new JFrame("JTextArea Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextAreaSelectAll::showFrame);
    }

    private void initializeUI() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500, 200));

        final JTextArea textArea = new JTextArea(
                "The quick brown fox jumps over the lazy dog.");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane pane = new JScrollPane(textArea);
        pane.setPreferredSize(new Dimension(500, 200));
        pane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        final JButton button3 = new JButton("Select All 2");
        button3.addActionListener(e -> {
            textArea.selectAll();

            // Transfer focus to JTextArea to show the selected
            // text.
            button3.transferFocusBackward();
        });
        final JButton button2 = new JButton("Get Selected Text");
        button2.addActionListener(e -> {
            String text = textArea.getSelectedText();
            System.out.println("Text = " + text);
        });

        //---------------------------------------------------------------------
        final JButton button1 = new JButton("Select All 1");
        button1.addActionListener(e -> {
            textArea.selectAll();

            // Transfer focus to JTextArea to show the selected
            // text.
            button1.transferFocusBackward();
        });
        //---------------------------------------------------------------------

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);

        this.add(pane, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}