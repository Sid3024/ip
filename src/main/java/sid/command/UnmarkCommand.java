package sid.command;

import sid.exception.SidException;
import sid.task.Task;
import sid.task.TaskList;
import sid.ui.Dialogue;

/**
 * Unmarks a task object at a specified index in the task list.
 */
public class UnmarkCommand extends Command {
    private final int index;

    /**
     * Creates a UnmarkCommand object.
     * @param index Index of task to be unmarked by the UnmarkCommand object created.
     */
    public UnmarkCommand(int index) {
        this.index = index;
    }

    /**
     * Unmarks a task (whose index is specified in ctor) from the tasklist.
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
        Task task = taskList.setUnmarked(index);
        dialogue.printTaskUnmarked(task);
        return false;
    }

    /**
     * Indicates that executing the unmark command modifies the tasklist.
     * @return false, indicating the task list must be saved after executing the UnmarkCommand.
     */
    @Override
    public boolean requiresSave() {
        return true;
    }
}
