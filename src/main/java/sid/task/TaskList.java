package sid.task;

public class TaskList {
    private static final int MAX_LIST_SIZE = 100;
    private final Task[] list = new Task[MAX_LIST_SIZE];
    private int size = 0;

    @Override
    public String toString() {
        String s = "";
        for (int i=0;i<size;i++) {
            s += (i+1) + "." + list[i].toString() + "\n";
        }
        return s;
    }

    /**
     * Adds an task to list
     * @param task the Task to be added to list
     */
    public void addToList(Task task) {
        list[size] = task;
        size++;
    }

    public Task setMarked(int idx) {
        this.list[idx].mark();
        return list[idx];
    }

    public Task setUnmarked(int idx) {
        this.list[idx].unmark();
        return list[idx];
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMaxListSize() {
        return MAX_LIST_SIZE;
    }
}
