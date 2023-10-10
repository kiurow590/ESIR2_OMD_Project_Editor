public class PasteCommand implements Command {
    private Editor editor;

    public PasteCommand(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void execute() {
        //editor.paste();
        System.out.println("Paste");
    }
}