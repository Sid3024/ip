package sid.command;

import sid.exception.SidException;
import sid.task.Task;
import sid.task.TaskList;
import sid.ui.Dialogue;

/**
 * Deletes a task at a specified index from the task list.
 */
public class DeleteCommand extends Command {
    private final int index;

    /**
     * Creates a DeleteCommand object.
     * @param index Index of task to be deleted by the DeleteCommand object created.
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Deletes a task (whose index is specified in ctor) from the tasklist.
     * @param taskList The current taskList.
     * @param dialogue Handles user facing output.
     * @return false, indicating that the program should not quit after this function.
     * @throws SidException If specified index is out of range of the available list indices (from 1 to len(list) inclusive).
     */
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) throws SidException {
        if (index < 0 || index >= taskList.getSize()) {
            throw new SidException("User input indicated an index that was out of range");
        }
        Task task = taskList.deleteFromList(index);
        dialogue.printTaskDeleted(task, taskList.getSize());
        return false;
    }

    /**
     * Indicates that executing the delete command modifies the tasklist.
     * @return false, indicating the task list must be saved after executing the DeleteCommand.
     */
    @Override
    public boolean requiresSave() {
        return true;
    }
}
