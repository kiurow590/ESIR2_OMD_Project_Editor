import javax.swing.*;


public class CutCommand implements Command{

    private Editor editor;

    public CutCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute() {
        //editor.cut();
        System.out.println("Cut");
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        editor.setCopyBuffer(temp.getSelectedText());
        temp.replaceRange("", temp.getSelectionStart(), temp.getSelectionEnd());
        editor.setTextArea(temp);
    }

}
