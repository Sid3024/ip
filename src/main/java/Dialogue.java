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

    public void printTaskAdded(String taskString) {
        System.out.println("______________________________");
        System.out.print("added: ");
        printTaskString(taskString);
        System.out.println("______________________________");
    }

    public void printTaskMarked(String taskString) {
        System.out.println("______________________________");
        System.out.println("Nice! I've marked this task as done:");
        printTaskString(taskString);
        System.out.println("______________________________");
    }

    public void printTaskUnmarked(String taskString) {
        System.out.println("______________________________");
        System.out.println("Ok, I've marked this task as not done yet:");
        printTaskString(taskString);
        System.out.println("______________________________");
    }

    public void printMyList(TaskList taskList) {
        System.out.println("______________________________");
        System.out.println(taskList.toString());
        System.out.println("______________________________");
    }

    /**
     * Prints error message caused by userInput
     * @param userInput User input that caused the error
     * @param errorDesc String of desc of error type
     */
    public void error(String userInput, String errorDesc) {
        System.out.println("______________________________");
        System.out.println(errorDesc);
        System.out.println("User Input: " + userInput);
        System.out.println("______________________________");
    }

    private void printTaskString(String taskString) {
        System.out.println(taskString);
    }

    private void printUserInput(String userInput) {
        System.out.println("User Input: " + userInput);
    }
}
