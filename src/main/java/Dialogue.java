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
     * Print error message caused by userInput
     * @param userInput input that caused the error
     * @param errorCode code of error type
     */
    public void error(String userInput, int errorCode) {
        System.out.println("______________________________");
        switch (errorCode) {
        case 1:
            System.out.println("ERROR: userInput for mark/unmark command is not of valid format");
            printUserInput(userInput);
            break;
        case 2:
            System.out.println("ERROR: userInput for mark/unmark command indicated an index that was out of range");
            printUserInput(userInput);
            break;
        default:
            System.out.println("userInput caused some unknown error");
            printUserInput(userInput);
            break;
        }
        System.out.println("______________________________");
    }

    private void printTaskString(String taskString) {
        System.out.println(taskString);
    }

    private void printUserInput(String userInput) {
        System.out.println("User Input: " + userInput);
    }
}
