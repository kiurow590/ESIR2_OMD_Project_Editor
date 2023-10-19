package v2;

import javax.swing.*;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public class CharacterReleaseCommand implements Command{

    private Editor editor;
    private char character; //caractère
    private int codeChar; //code du caractère

    /**
     * Constructor of CharacterReleaseCommand
     * @param editor
     * @param character
     * @param codeChar
     */
    public CharacterReleaseCommand(Editor editor, char character, int codeChar){
        this.character = character;
        this.editor=editor;
        this.codeChar = codeChar;
    }

    /**
     * Execute the command
     * Ajoute le caractère au niveau du curseur
     */
    @Override
    public void execute() {
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
