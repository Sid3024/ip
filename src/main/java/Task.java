public class Task {
    private String task;
    private boolean isDone;

    Task(String task) {
        this.task = task;
        this.isDone = false;
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

    public void printTask() {
        System.out.println(task);
    }

    public void printTaskWithStatus() {
        char statusIcon = getStatusIcon();
        System.out.print("[" + statusIcon + "] ");
        printTask();
    }

    private char getStatusIcon() {
        return isDone ? 'X' : ' ';
    }
}
