package v2;

/**
 * @author Aubry TONNERRE && Thibault GUERINEL
 */

public final class CopyCommand implements Command {
    private Editor editor;

    private static CopyCommand instance = null;

    /**
     * Constructor of CopyCommand
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

    /**
     * Execute the command
     * Copy the selected text in the copy buffer
     */
    @Override
    public void execute() {
        editor.setCopyBuffer(editor.getTextArea().getSelectedText());
    }
}
