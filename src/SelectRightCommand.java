import javax.swing.*;

public class SelectRightCommand implements Command {
    private Editor editor;


    public SelectRightCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        //editor.setSelectionStart(5);
        /*
        //pasteCommand
        //editor.paste();
        System.out.println("Paste");
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        temp.insert(editor.getCopyBuffer(), position);
        editor.setTextArea(temp);
*/

   // editor.getTextArea().select(editor.getTextArea().getSelectionStart(),editor.getTextArea().getSelectionEnd() + 1);

    System.out.println("SelectRight");

    JTextArea temp = editor.getTextArea();

    //temp.selectAll();


    temp.setSelectionEnd(temp.getSelectionEnd()+1);

    //// get selection start
    //int start = temp.getSelectionStart();
//
    //// get selection end
    //int end = temp.getSelectionEnd();
//
    //// create new selection
    //temp.select(start, end + 1);

    }
}