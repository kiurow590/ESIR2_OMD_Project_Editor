import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class SelectLeftCommand implements Command {
    private Editor editor;

    public SelectLeftCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        System.out.println("SelectLeft");

        JTextArea temp = editor.getTextArea();

        //temp.selectAll();
        temp.setSelectionStart(temp.getSelectionStart()-1);
        //temp.setSelectionEnd(temp.getSelectionEnd()+1);

    }
}