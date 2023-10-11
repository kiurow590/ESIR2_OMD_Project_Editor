public class SelectLeftCommand implements Command {
    private Editor editor;

    public SelectLeftCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
       // editor.setSelectionStart(5);
        /*
        //pasteCommand
        //editor.paste();
        System.out.println("Paste");
        JTextArea temp = editor.getTextArea();
        int position = temp.getCaretPosition();
        temp.insert(editor.getCopyBuffer(), position);
        editor.setTextArea(temp);
*/


    }
}