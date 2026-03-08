package sid.command;

import sid.exception.SidException;
import sid.task.Task;
import sid.task.TaskList;
import sid.ui.Dialogue;

import java.util.ArrayList;

/**
 * Finds and prints all tasks in the task list that contain a specified substring.
 */
public class FindCommand extends Command {
    private final String findSubString;

    /**
     * Creates a FindCommand object.
     * @param findSubString Sub-string to be searched for in list of tasks by the AddCommand object created.
     */
    public FindCommand(String findSubString) {
        this.findSubString = findSubString;
    }

    /**
     * Finds all tasks in the tasklist containing the substring specified in the ctor.
     * @param taskList The current taskList.
     * @param dialogue Handles user facing output.
     * @return false, indicating that the program should not quit after this function.
     */
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        ArrayList<Task> tasks = taskList.findTasks(findSubString);
        dialogue.printSubList(tasks);
        return false;
    }

    /**
     * Indicates that executing the find command does not modify the tasklist.
     * @return false, indicating the task list does not need to be saved after executing the FindCommand.
     */
    @Override
    public boolean requiresSave() {
        return false;
    }
}
