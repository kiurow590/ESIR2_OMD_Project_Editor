package v2;

import javax.swing.*;

public final class SelectLeftCommand implements Command {
    private Editor editor;
    private static SelectLeftCommand instance = null;

    /**
     * constructor
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

    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        temp.setSelectionStart(temp.getSelectionStart()-1);
    }
}