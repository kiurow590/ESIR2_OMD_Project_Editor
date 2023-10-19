package v2;

import javax.swing.*;

public class CharacterReleaseCommand implements Command{

    private Editor editor;
    private char character;
    private int codeChar;

    public CharacterReleaseCommand(Editor editor, char character, int codeChar){
        //System.out.println("COUCOU C NOUS");
        this.character = character;
        this.editor=editor;
        this.codeChar = codeChar;
    }

    @Override
    public void execute() {
        System.out.println("COUCOU C MOI");
        JTextArea temp = editor.getTextArea();
        //ajout du caractère à la fin du texteArea
        if (codeChar == 8){

            temp.replaceRange("", temp.getCaretPosition()-1, temp.getCaretPosition());
        }else{
            temp.insert(String.valueOf(character), temp.getCaretPosition());

        }
    }

    @Override
    public String toString(){
        return "CharacterReleaseCommand : " + character;
    }
}
