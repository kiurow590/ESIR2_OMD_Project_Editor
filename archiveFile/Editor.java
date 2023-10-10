import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Editor {

    public static void main(String[] args) {
        JFrame window = new JFrame("Editeur de texte");

        JLabel text = new JLabel("Je suis un simple editeur, jouons ensemble !");
        text.setBounds(10,-110,300,300);

        window.add(text);

        JTextArea textArea = new JTextArea("Je suis un simple éditeur, jouons ensemble !");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true); // Le retour à la ligne ne se fait qu'à l'espace entre les mots
        JScrollPane scrollPane = new JScrollPane(textArea);
        //scrollPane.setPreferredSize(new Dimension(10, 20)); // Définir la taille préférée de la JScrollPane
        //scrollPane.setBounds(10,10,10,10);


        window.add(scrollPane);
        window.setSize(1200,400);
        window.setLocation(700, 540);




        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);



    }

    // possibilité de rajouter du texte
   /* public void actionPerformed(ActionEvent e){
        String str = text.getText();

        /*if(str.length()>300){
            text.setText();
        }*/

            /*String mots[] = str.split("\\s");
            l1.setText("Mots: "+ mots.length);
            l2.setText("Caractere: "+ str.length());*/
    //}


}


