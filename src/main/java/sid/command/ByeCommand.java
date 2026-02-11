package sid.command;

import sid.task.TaskList;
import sid.ui.Dialogue;

public class ByeCommand extends Command {
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        dialogue.bye();
        return true;
    }
}
