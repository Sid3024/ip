package sid.command;

import sid.task.TaskList;
import sid.ui.Dialogue;

/**
 * Prints all tasks in the task list in a numbered list format.
 */
public class ListCommand extends Command {
    /**
     * Prints out a numbered list of all tasks in the tasklist.
     * @param taskList The current taskList.
     * @param dialogue Handles user facing output.
     * @return false, indicating that the program should not quit after this function.
     */
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        dialogue.printList(taskList);
        return false;
    }

    /**
     * Indicates that executing the list command does not modify the tasklist.
     * @return false, indicating the task list does not need to be saved after executing the ListCommand.
     */
    @Override
    public boolean requiresSave() {
        return false;
    }
}
