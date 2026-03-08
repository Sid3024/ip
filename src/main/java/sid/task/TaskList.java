package sid.task;

import sid.exception.SidException;

import java.util.ArrayList;

/**
 * The list/collection of all the tasks in insertion order.
 */
public class TaskList {
    private final ArrayList<Task> list = new ArrayList<>();
    private int size = 0;

    /**
     * Converts list to a String format where all the tasks are listed in a numbered format.
     * @return the list in String format.
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += (i+1) + "." + list.get(i).toString() + "\n";
        }
        return s;
    }

    /**
     * Finds all tasks that contain a substring of interest.
     * @param substring the substring of interest.
     * @return an Arraylist of the tasks containing the substring.
     */
    public ArrayList<Task> findTasks(String substring) {
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : list) {
            if (task.containsSubstring(substring)) {
                tasks.add(task);
            }
        }
        return tasks;
    }

    /**
     * Deletes and returns a task at specified index from list.
     * @param idx the index of the task to be deleted in the list.
     * @return the task object that has been deleted from the list.
     */
    public Task deleteFromList(int idx) {
        size--;
        return list.remove(idx);
    }

    /**
     * Adds a task to list.
     * @param task The Task to be added to list.
     */
    public void addToList(Task task) {
        list.add(task);
        size++;
    }

    /**
     * Set task at the specified index as marked and return in.
     * @param idx index of task to mark.
     * @return Task that was marked.
     */
    public Task setMarked(int idx) {
        this.list.get(idx).mark();
        return list.get(idx);
    }

    /**
     * Set task at the specified index as marked and return in.
     * @param idx index of task to mark.
     * @return Task that was marked.
     */
    public Task setUnmarked(int idx) {
        this.list.get(idx).unmark();
        return list.get(idx);
    }

    /**
     * Returns the number of tasks in the list.
     * @return the number of tasks in the current list.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns a specific task from the list.
     * @param idx index of the task to be returned.
     * @return task object at the specified index in the list.
     */
    public Task get(int idx) {
        return list.get(idx);
    }

}
