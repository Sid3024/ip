package sid.task;

import sid.exception.SidException;

import java.util.ArrayList;

public class TaskList {
    //private static final int MAX_LIST_SIZE = 100;
    private final ArrayList<Task> list = new ArrayList<>();
    private int size = 0;

    @Override
    public String toString() {
        String s = "";
        for (int i=0;i<size;i++) {
            s += (i+1) + "." + list.get(i).toString() + "\n";
        }
        return s;
    }

    public Task deleteFromList(int idx) {
        size--;
        return list.remove(idx);
    }

    /**
     * Adds a task to list.
     * @param task The Task to be added to list.
     */
    public void addToList(Task task) throws SidException {
        list.add(task);
        size++;
    }

    public Task setMarked(int idx) {
        this.list.get(idx).mark();
        return list.get(idx);
    }

    public Task setUnmarked(int idx) {
        this.list.get(idx).unmark();
        return list.get(idx);
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Task get(int idx) {
        return list.get(idx);
    }

}
