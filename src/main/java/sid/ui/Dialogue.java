package sid.ui;

import sid.task.Task;
import sid.task.TaskList;

import java.util.ArrayList;

public class Dialogue {
    public void hello() {
        System.out.println("______________________________\n"
                + "Hello! I'm Sid\n"
                + "What can I do for you?\n"
                + "______________________________");
    }

    public void bye() {
        System.out.println("______________________________\n" +
                " Bye. Hope to see you again soon!\n"
                + "______________________________");
    }

    public void echo(String s) {
        System.out.println("______________________________\n"
                + s
                + "\n"
                + "______________________________");
    }

    public void printTaskAdded(Task task, int size) {
        System.out.println("______________________________");
        System.out.print("added: ");
        printTaskString(task.toString());
        printNumTasksInList(size);
        System.out.println("______________________________");
    }

    public void printTaskDeleted(Task task, int size) {
        System.out.println("______________________________");
        System.out.print("deleted: ");
        printTaskString(task.toString());
        printNumTasksInList(size);
        System.out.println("______________________________");
    }

    public void printTaskMarked(Task task) {
        System.out.println("______________________________");
        System.out.println("Nice! I've marked this task as done:");
        printTaskString(task.toString());

        System.out.println("______________________________");
    }

    public void printTaskUnmarked(Task task) {
        System.out.println("______________________________");
        System.out.println("Ok, I've marked this task as not done yet:");
        printTaskString(task.toString());
        System.out.println("______________________________");
    }

    /**
     * Prints out the full list of tasks.
     * @param taskList taskList object containing all tasks to be printed out.
     */
    public void printList(TaskList taskList) {
        System.out.println("______________________________");
        System.out.print(taskList.toString());
        System.out.println("______________________________");
    }

    /**
     * Prints out only a sub list of tasks.
     * @param tasks ArrayList of tasks to be printed out.
     */
    public void printSubList(ArrayList<Task> tasks) {
        System.out.println("______________________________");
        for (int i=0;i<tasks.size();i++) {
            System.out.println((i+1) + ". " + tasks.get(i).toString());
        }
        System.out.println("______________________________");
    }

    /**
     * Prints error message caused by userInput.
     * @param userInput Raw user input that caused the error.
     * @param errorDesc String of desc of error type.
     */
    public void error(String userInput, String errorDesc) {
        System.out.println("______________________________");
        System.out.println(errorDesc);
        System.out.println("User Input: " + userInput);
        System.out.println("______________________________");
    }

    private void printNumTasksInList(int size) {
        System.out.println("You have " + size + " tasks in your list currently");
    }

    private void printTaskString(String taskString) {
        System.out.println(taskString);
    }

    private void printUserInput(String userInput) {
        System.out.println("User Input: " + userInput);
    }
}
