package sid.task;

/**
 * Represents a single task with description, metadata, and completion status.
 */
public abstract class Task {
    private String task;
    private boolean isDone;
    private final TaskType taskType;

    /**
     * Creates a task object.
     * @param task String of the task.
     * @param taskType TaskType enum of the task type.
     */
    Task(String task, TaskType taskType) {
        this.task = task;
        this.isDone = false;
        this.taskType = taskType;
    }

    /**
     * Checks whether task contains a specified substring.
     * @param substring The substring to check for in the task.
     * @return true if substring is in the task string, false otherwise.
     */
    public boolean containsSubstring(String substring) {
        return task.contains(substring);
    }

    /**
     * Returns String of the task.
     * @return String of the task.
     */
    public String getTask() {
        return task;
    }

    /**
     * Modifies string of the task.
     * @param task string of the task.
     */
    public void setTask(String task) {
        this.task = task;
    }

    /**
     * Marks task as done.
     */
    public void mark() {
        isDone = true;
    }

    /**
     * Marks task as not done.
     */
    public void unmark() {
        isDone = false;
    }

    /**
     * Generates and returns the task in a string format used for the user interface.
     * @return The task in the String format of the user interface.
     */
    @Override
    public String toString() {
        return "[" + getTypeIcon() + "][" + getStatusIcon() + "] " + task;
    }

    private char getStatusIcon() {
        return isDone ? 'X' : ' ';
    }

    /**
     * Returns char that represents the taskType.
     * @return The char that represents the taskType
     */
    public abstract char getTypeIcon();

    /**
     * Generates and returns the task in a string format used to save it in the data file.
     * @return The task in the String format of the data file.
     */
    public String getFileString() {
        return getTypeIcon() + " | " + getStatusIcon() + " | " + task;
    }
}
