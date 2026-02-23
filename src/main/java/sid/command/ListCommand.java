package sid.command;

import sid.task.TaskList;
import sid.ui.Dialogue;

public class ListCommand extends Command {
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        dialogue.printList(taskList);
        return false;
    }

    @Override
    public boolean requiresSave() {
        return false;
    }
}
