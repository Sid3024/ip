package sid.task;

public abstract class Task {
    private String task;
    private boolean isDone;
    private final TaskType taskType;

    Task(String task, TaskType taskType) {
        this.task = task;
        this.isDone = false;
        this.taskType = taskType;
    }



    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return isDone;
    }

    public void mark() {
        isDone = true;
    }

    public void unmark() {
        isDone = false;
    }

    @Override
    public String toString() {
        return "[" + getTypeIcon() + "][" + getStatusIcon() + "] " + task;
    }

    private char getStatusIcon() {
        return isDone ? 'X' : ' ';
    }

    public abstract char getTypeIcon();
}
