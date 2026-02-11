public class ListCommand extends Command {
    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) {
        dialogue.printMyList(taskList);
        return false;
    }
}
