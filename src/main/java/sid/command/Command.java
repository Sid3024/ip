package sid.command;

import sid.exception.SidException;
import sid.task.TaskList;
import sid.ui.Dialogue;

/**
 * Represents a command that can be executed by the Sid Chatbot.
 */
public abstract class Command {
    /**
     * Returns a boolean indicating whether the execution of this command alters the list (and hence list must be saved).
     * @return true if the list has been altered/must be saved again, false otherwise.
     */
    public abstract boolean requiresSave();

    /**
     * Executes a command.
     * @param taskList The current taskList.
     * @param dialogue Handles user facing output.
     * @return true if the program should exit after executing this command.
     * @throws SidException If the command cannot be executed due to invalid user input.
     */
    public abstract boolean execute(TaskList taskList, Dialogue dialogue) throws SidException;
}
