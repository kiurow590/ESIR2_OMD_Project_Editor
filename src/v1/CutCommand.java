package v1;

import javax.swing.*;
/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public final class CutCommand implements Command{

    private Editor editor;

    private static CutCommand instance = null;

    /**
     * constructor of CutCommand
     * @param editor
     */
    private CutCommand(Editor editor){
        this.editor = editor;
    }

    /**
     * Singleton
     * @param editor actual editor
     * @return return Instance
     */
    public static CutCommand getInstance(Editor editor){
        if(instance == null){
            instance = new CutCommand(editor);
        }
        return instance;
    }

    /**
     * execute the command
     * cut the selected text and put it in the copy buffer
     */
    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        editor.setCopyBuffer(temp.getSelectedText());
        temp.replaceRange("", temp.getSelectionStart(), temp.getSelectionEnd());
        editor.setTextArea(temp);
    }

}
