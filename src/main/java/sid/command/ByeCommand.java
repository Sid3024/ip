package sid.command;

import sid.task.TaskList;
import sid.ui.Dialogue;

/**
 * Prints bye message.
 * Signals program to quit.
 */
public class ByeCommand extends Command {
    /**
     * Prints bye message and tells program to quit.
     * @param taskList The current taskList.
     * @param dialogue Handles user facing output.
     * @return true, indicating that the program should quit.
     */
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        dialogue.bye();
        return true;
    }

    /**
     * Indicates that executing the bye command does not modify the tasklist.
     * @return false, indicating the task list does not need to be saved after executing the ByeCommand.
     */
    @Override
    public boolean requiresSave() {
        return false;
    }
}
