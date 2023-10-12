import javax.swing.*;
import java.awt.event.ActionListener;

public final class PasteCommand implements Command {
    private Editor editor;
    private static PasteCommand instance = null;

    /**
     * constructor
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

    @Override
    public void execute() {
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        temp.replaceRange(editor.getCopyBuffer(), temp.getSelectionStart(), temp.getSelectionEnd());
        editor.setTextArea(temp);
    }
}