package sid.command;

import sid.task.TaskList;
import sid.ui.Dialogue;


public class AddCommand extends Command {
    private final String task;
    public AddCommand(String task) {
        this.task = task;
    }
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        taskList.addToList(task);
        dialogue.printTaskAdded(task);
        return false;
    }
}
