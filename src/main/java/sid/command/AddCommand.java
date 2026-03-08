package sid.command;

import sid.exception.SidException;
import sid.task.Task;
import sid.task.TaskList;
import sid.ui.Dialogue;

/**
 * Adds a task to the task list.
 */
public class AddCommand extends Command {
    private final Task task;

    /**
     * Creates an AddCommand object.
     * @param task Task to be added by the AddCommand object created.
     */
    public AddCommand(Task task) {
        this.task = task;
    }

    /**
     * Adds a task (specified in ctor) to the tasklist.
     * @param taskList The current taskList.
     * @param dialogue Handles user facing output.
     * @return false, indicating that the program should not quit after this function.
     */
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        taskList.addToList(task);
        dialogue.printTaskAdded(task, taskList.getSize());
        return false;
    }

    /**
     * Indicates that executing the add command modifies the tasklist.
     * @return false, indicating the task list must be saved after executing the AddCommand.
     */
    @Override
    public boolean requiresSave() {
        return true;
    }
}
