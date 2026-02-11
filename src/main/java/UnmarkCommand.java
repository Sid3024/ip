public class UnmarkCommand extends Command {
    private final int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    @Override
    public boolean execute(TaskList taskList, Dialogue dialogue) throws SidException{
        if (index < 0 || index >= taskList.getMySize()) {
            throw new SidException("User input indicated an index that was out of range");
        }
        String taskString = taskList.setUnmarked(index);
        dialogue.printTaskUnmarked(taskString);
        return false;
    }
}
