package v1;

import javax.swing.*;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public final class SelectRightCommand implements Command {
    private Editor editor;
    private static SelectRightCommand instance = null;

    /**
     * constructor of SelectRightCommand
     * @param editor
     */
    private SelectRightCommand(Editor editor) {
        this.editor = editor;
    }


    /**
     * Singleton
     * @param editor actual editor
     * @return
     */
    public static SelectRightCommand getInstance(Editor editor) {
        if (instance == null) {
            instance = new SelectRightCommand(editor);
        }
        return instance;
    }

    /**
     * execute the command
     * augmente la selection de 1 caractere vers la droite
     */
    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        temp.setSelectionEnd(temp.getSelectionEnd()+1);
    }
}