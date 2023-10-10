public class CutCommand implements Command{

    private Editor editor;

    public CutCommand(Editor editor){
        this.editor = editor;
    }

    @Override
    public void execute() {
        //editor.cut();
        System.out.println("Cut");
    }

}
