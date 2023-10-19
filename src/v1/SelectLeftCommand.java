package v1;

import javax.swing.*;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public final class SelectLeftCommand implements Command {
    private Editor editor;
    private static SelectLeftCommand instance = null;

    /**
     * constructor of SelectLeftCommand
     * @param editor
     */
    private SelectLeftCommand(Editor editor) {
        this.editor = editor;
    }

    /**
     * Singleton
     * @param editor actual editor
     * @param editor
     * @return
     */
    public static SelectLeftCommand getInstance(Editor editor) {
        if (instance == null) {
            instance = new SelectLeftCommand(editor);
        }
        return instance;
    }

    /**
     * execute the command
     * augmente la selection de 1 caractere vers la gauche
     */
    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        temp.setSelectionStart(temp.getSelectionStart()-1);
    }
}