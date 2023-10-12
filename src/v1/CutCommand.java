package v1;

import javax.swing.*;


public final class CutCommand implements Command{

    private Editor editor;

    private static CutCommand instance = null;

    /**
     * constructor
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

    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        editor.setCopyBuffer(temp.getSelectedText());
        temp.replaceRange("", temp.getSelectionStart(), temp.getSelectionEnd());
        editor.setTextArea(temp);
    }

}
