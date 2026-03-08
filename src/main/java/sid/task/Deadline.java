package sid.task;

/**
 * Represents a single deadline task with description and by flag metadata.
 */
public class Deadline extends Task {
    private final String dueAt;

    /**
     * Creates a deadline object.
     * @param deadline String of the deadline.
     * @param dueAt String of the by flag metadata.
     */
    public Deadline(String deadline, String dueAt) {
        super(deadline, TaskType.DEADLINE);
        this.dueAt = dueAt;
    }

    /**
     * Returns a formatted string of the deadline task and its metadata (by flag).
     * @return Formatted string of the deadline task and its metadata (by flag).
     */
    public String toString() {
        return super.toString() + " (by: " + dueAt + ")";
    }

    /**
     * Returns the char representing a deadline object.
     * @return 'D'.
     */
    @Override
    public char getTypeIcon() {
        return 'D';
    }

    /**
     * Returns a string of the deadline task and its metadata (by flag), formatted for storage.
     * @return Formatted string of the deadline task and its metadata (by flag).
     */
    @Override
    public String getFileString() {
        return super.getFileString() + " | " + dueAt;
    }

}
