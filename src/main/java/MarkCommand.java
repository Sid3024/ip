public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) throws SidException {
        if (index < 0 || index >= taskList.getMySize()) {
            throw new SidException("User input indicated an index that was out of range");
        }
        String taskString = taskList.setMarked(index);
        dialogue.printTaskMarked(taskString);
        return false;
    }

}
