package sid.task;

public class Deadline extends Task {
    private final String dueAt;

    public Deadline(String deadline, String dueAt) {
        super(deadline, TaskType.DEADLINE);
        this.dueAt = dueAt;
    }

    public String getDue() {
        return dueAt;
    }

    public String toString() {
        return super.toString() + " (by: " + dueAt + ")";
    }

    public char getTypeIcon() {
        return 'D';
    }
}
