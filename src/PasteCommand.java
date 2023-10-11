import javax.swing.*;
import java.awt.event.ActionListener;

public final class PasteCommand implements Command {
    private Editor editor;

    private static PasteCommand instance = null;

    private PasteCommand(Editor editor) {
        this.editor = editor;
    }

    public static PasteCommand getInstance(Editor editor) {
        if (instance == null) {
            instance = new PasteCommand(editor);
        }
        return instance;
    }

    @Override
    public void execute() {
        //editor.paste();
        System.out.println("Paste");
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        temp.insert(editor.getCopyBuffer(), position);
        editor.setTextArea(temp);



    }
}