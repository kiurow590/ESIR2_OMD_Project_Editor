package v1;

public final class CopyCommand implements Command {
    private Editor editor;

    private static CopyCommand instance = null;

    /**
     * Constructor
     * @param editor
     */
    private CopyCommand(Editor editor) {
        this.editor = editor;
    }

    /**
     * Singleton
     * @param editor actual editeur
     * @return get instance of command
     */
    public static CopyCommand getInstance(Editor editor) {
        if (instance == null) {
            instance = new CopyCommand(editor);
        }
        return instance;
    }

    @Override
    public void execute() {
        editor.setCopyBuffer(editor.getTextArea().getSelectedText());
    }
}
