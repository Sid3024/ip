package sid.command;

import sid.exception.SidException;
import sid.task.Task;
import sid.task.TaskList;
import sid.ui.Dialogue;

public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) throws SidException {
        if (index < 0 || index >= taskList.getMySize()) {
            throw new SidException("User input indicated an index that was out of range");
        }
        Task task = taskList.setUnmarked(index);
        dialogue.printTaskUnmarked(task);
        return false;
    }
}
