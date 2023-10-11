public final class CopyCommand implements Command {
    private Editor editor;

    private static CopyCommand instance = null;

    private CopyCommand(Editor editor) {
        this.editor = editor;
    }

    public static CopyCommand getInstance(Editor editor) {
        if (instance == null) {
            instance = new CopyCommand(editor);
        }
        return instance;
    }

    @Override
    public void execute() {
        //editor.copy();
        System.out.println("Copy");
        editor.setCopyBuffer(editor.getTextArea().getSelectedText());
    }
}
