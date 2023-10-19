package v2;

import javax.swing.*;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public final class PasteCommand implements Command {
    private Editor editor;
    private static PasteCommand instance = null;

    /**
     * constructor of PasteCommand
     * @param editor
     */
    private PasteCommand(Editor editor) {
        this.editor = editor;
    }

    /**
     * Singleton
     * @param editor actual editor
     * @return return Instance
     */
    public static PasteCommand getInstance(Editor editor) {
        if (instance == null) {
            instance = new PasteCommand(editor);
        }
        return instance;
    }

    /**
     * execute the command
     * replace the selected text by the copy buffer
     */
    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        temp.replaceRange(editor.getCopyBuffer(), temp.getSelectionStart(), temp.getSelectionEnd());
        editor.setTextArea(temp);
    }
}