import javax.swing.*;
import java.awt.event.*;

public class Editor2 implements ActionListener
{
    JLabel l1, l2;
    JTextArea text;

    Editor2()
    {
        JFrame f = new JFrame();

        l1 = new JLabel();
        l1.setBounds(45,175,100,30);

        l2 = new JLabel();
        l2.setBounds(150,175,100,30);

        text = new JTextArea();
        text.setBounds(15,20,250,150);

        JButton btn = new JButton("Compter les mots");
        btn.setBounds(50,210,180,30);
        btn.addActionListener(this);

        f.add(text);
        f.add(l1);
        f.add(l2);
        f.add(btn);

        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }

    public void autojump(){
        String str = text.getText();
        if(str.length()>300){
            text.setText("");
        }
    }
    public void actionPerformed(ActionEvent e)
    {
        String str = text.getText();
        String mots[] = str.split("\\s");
        l1.setText("Mots: "+ mots.length);
        l2.setText("Caractere: "+ str.length());
    }

    public static void main(String[] args) {
        new Editor2();
    }
}