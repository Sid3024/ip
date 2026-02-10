public class Dialogue {
    /**
     * Prints hello message
     */
    public void hello() {
        System.out.println("______________________________\n"
                + "Hello! I'm Sid\n"
                + "What can I do for you?\n"
                + "______________________________");
    }

    /**
     * Prints bye message
     */
    public void bye() {
        System.out.println("______________________________\n" +
                " Bye. Hope to see you again soon!\n"
                + "______________________________");
    }

    /**
     * Echoes user input
     */
    public void echo(String s) {
        System.out.println("______________________________\n"
                + s
                + "\n"
                + "______________________________");
    }

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

    private void printUserInput(String userInput) {
        System.out.println("User Input: " + userInput);
    }
}
