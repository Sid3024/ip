package sid.task;

/**
 * Represents a single event task with description and from, to flags metadata.
 */
public class Event extends Task {
    private final String startTime;
    private final String endTime;

    /**
     * Creates an event object.
     * @param event String of the event.
     * @param startTime String of the from flag metadata.
     * @param endTime String of the to flag metadata.
     */
    public Event(String event, String startTime, String endTime) {
        super(event, TaskType.EVENT);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Returns a formatted string of the event task and its metadata (from, to flags).
     * @return Formatted string of the event task and its metadata (from, to flags).
     */
    public String toString() {
        return super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }

    /**
     * Returns the char representing an event object.
     * @return 'E'.
     */
    @Override
    public char getTypeIcon() {
        return 'E';
    }

    /**
     * Returns a string of the event task and its metadata (from, to flags), formatted for storage.
     * @return Formatted string of the event task and its metadata (from, to flags).
     */
    @Override
    public String getFileString() {
        return super.getFileString() + " | " + startTime + " | " + endTime;
    }
}
