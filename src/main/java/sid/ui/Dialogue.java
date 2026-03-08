package sid.ui;

import sid.task.Task;
import sid.task.TaskList;

import java.util.ArrayList;

/**
 * Handles all printing out of messages.
 */
public class Dialogue {
    private final String LINE = "______________________________\n";

    /**
     * Prints hello message.
     */
    public void hello() {
        System.out.print(LINE
                + "Hello! I'm Sid\n"
                + "What can I do for you?\n"
                + LINE);
    }

    /**
     * Prints bye message.
     */
    public void bye() {
        System.out.print(LINE +
                " Bye. Hope to see you again soon!\n"
                + LINE);
    }

    /**
     * Echoes user input (for earlier task, no longer used).
     */
    public void echo(String s) {
        System.out.print(LINE
                + s
                + "\n"
                + LINE);
    }

    /**
     * Prints a specific task and mentions that it has been added to the list, as well as the total number of tasks in the list.
     * @param task Added task to be printed.
     * @param size Size of task list.
     */
    public void printTaskAdded(Task task, int size) {
        System.out.print(LINE);
        System.out.print("added: ");
        printTaskString(task.toString());
        printNumTasksInList(size);
        System.out.print(LINE);
    }

    /**
     * Prints a specific task and mentions that it has been deleted from the list, as well as the total number of tasks in the list.
     * @param task Deleted task to be printed.
     * @param size Size of task list.
     */
    public void printTaskDeleted(Task task, int size) {
        System.out.print(LINE);
        System.out.print("deleted: ");
        printTaskString(task.toString());
        printNumTasksInList(size);
        System.out.print(LINE);
    }

    /**
     * Prints a specific task and mentions that it has been marked.
     * @param task Marked task to be printed.
     */
    public void printTaskMarked(Task task) {
        System.out.print(LINE);
        System.out.println("Nice! I've marked this task as done:");
        printTaskString(task.toString());

        System.out.print(LINE);
    }

    /**
     * Prints a specific task and mentions that it has been unmarked.
     * @param task Unmarked task to be printed.
     */
    public void printTaskUnmarked(Task task) {
        System.out.print(LINE);
        System.out.println("Ok, I've marked this task as not done yet:");
        printTaskString(task.toString());
        System.out.print(LINE);
    }

    /**
     * Prints out the full list of tasks.
     * @param taskList TaskList object containing all tasks to be printed out.
     */
    public void printList(TaskList taskList) {
        System.out.print(LINE);
        System.out.print(taskList.toString());
        System.out.print(LINE);
    }

    /**
     * Prints out only a sub list of tasks.
     * @param tasks ArrayList of tasks to be printed out.
     */
    public void printSubList(ArrayList<Task> tasks) {
        System.out.print(LINE);
        for (int i=0;i<tasks.size();i++) {
            System.out.println((i+1) + ". " + tasks.get(i).toString());
        }
        System.out.print(LINE);
    }

    /**
     * Prints error message caused by userInput.
     * @param userInput Raw user input that caused the error.
     * @param errorDesc String of desc of error type.
     */
    public void error(String userInput, String errorDesc) {
        System.out.print(LINE);
        System.out.println(errorDesc);
        System.out.println("User Input: " + userInput);
        System.out.print(LINE);
    }

    private void printNumTasksInList(int size) {
        System.out.println("You have " + size + " tasks in your list currently");
    }

    private void printTaskString(String taskString) {
        System.out.println(taskString);
    }
}
