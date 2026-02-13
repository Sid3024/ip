package sid.command;

import sid.task.Task;
import sid.task.TaskList;
import sid.ui.Dialogue;


public class AddCommand extends Command {
    private final Task task;
    public AddCommand(Task task) {
        this.task = task;
    }
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        taskList.addToList(task);
        dialogue.printTaskAdded(task, taskList.getSize());
        return false;
    }
}
