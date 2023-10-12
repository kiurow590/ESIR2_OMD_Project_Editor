import java.awt.event.ActionListener;
import javax.swing.*;

public interface Command {
    /**
     * Execute the command.
     */
    public void execute();
}
