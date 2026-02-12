package sid.task;

public class Event extends Task {
    private final String startTime;
    private final String endTime;

    public Event(String event, String startTime, String endTime) {
        super(event, TaskType.EVENT);
        this.startTime = startTime;
        this.endTime = endTime;
        //this.statusIcon = 'E';
    }

    public String toString() {
        return super.toString() + " (from: " + startTime + " to: " + endTime + ")";
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    @Override
    public char getTypeIcon() {
        return 'E';
    }
}
