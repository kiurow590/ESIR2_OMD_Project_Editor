import javax.swing.*;
import java.awt.event.ActionListener;

public class PasteCommand implements Command {
    private Editor editor;

    public PasteCommand(Editor editor) {
        this.editor = editor;
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