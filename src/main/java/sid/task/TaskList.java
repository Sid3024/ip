package sid.task;

import sid.exception.SidException;

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
     * Adds a task to list.
     * @param task The Task to be added to list.
     */
    public void addToList(Task task) throws SidException {
        if (isFull()) {
            throw new SidException("Unable to add any tasks to list because list is full");
        }
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

    public boolean isFull() {
        return size == MAX_LIST_SIZE;
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
