package sid.command;

import sid.exception.SidException;
import sid.task.TaskList;
import sid.ui.Dialogue;

public abstract class Command {
    /**
     * Executes a command.
     * @param taskList The current taskList.
     * @param dialogue Handles user facing output.
     * @return true if the program should exit after executing this command.
     * @throws SidException If the command cannot be executed due to invalid user input.
     */
    public abstract boolean execute(TaskList taskList, Dialogue dialogue) throws SidException;
}
