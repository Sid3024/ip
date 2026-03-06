package sid.command;

import sid.exception.SidException;
import sid.task.Task;
import sid.task.TaskList;
import sid.ui.Dialogue;

import java.util.ArrayList;

public class FindCommand extends Command {
    private final String findSubString;

    public FindCommand(String findSubString) {
        this.findSubString = findSubString;
    }

    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) throws SidException {
        ArrayList<Task> tasks = taskList.findTasks(findSubString);
        dialogue.printSubList(tasks);
        return false;
    }

    @Override
    public boolean requiresSave() {
        return false;
    }
}
