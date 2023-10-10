public class CopyCommand implements Command{
    private Editor editor;

    public CopyCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute() {
        //editor.copy();
        System.out.println("Copy");
        editor.setCopyBuffer(editor.getTextArea().getSelectedText());
    }
}
