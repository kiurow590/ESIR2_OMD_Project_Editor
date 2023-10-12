import javax.swing.*;

public final class SelectRightCommand implements Command {
    private Editor editor;
    private static SelectRightCommand instance = null;

    /**
     * constructor
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
    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        temp.setSelectionEnd(temp.getSelectionEnd()+1);
    }
}