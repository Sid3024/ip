package sid.task;

import static sid.task.TaskType.TODO;

/**
 * Represents a single to do task with description.
 */
public class ToDo extends Task {
    /**
     * Creates a to do object
     * @param toDo string of the to do.
     */
    public ToDo(String toDo) {
        super(toDo, TaskType.TODO);
    }

    /**
     * Returns a formatted string of the to do task and its metadata.
     * @return formatted string of the to do task and its metadata.
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * Returns the char representing to do object.
     * @return 'T'.
     */
    @Override
    public char getTypeIcon() {
        return 'T';
    }
}
