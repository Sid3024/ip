import java.util.Scanner;

public class Sid {
    private final Dialogue myDialogue = new Dialogue();
    private final TaskList myTaskList = new TaskList();
    private final Parser myParser = new Parser();

    public static void main(String[] args) {
        Sid sid = new Sid();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            userInput = scanner.nextLine();
            if (sid.executeAction(userInput)) { // returns true if userInput == "bye"
                break;
            }
        }
        scanner.close();
    }

    /**
     * Constructs Sid and prints the greeting message
     */
    Sid() {
        myDialogue.hello();
    }

    /**
     * Executes action the user wants (add item to list, print list, exit)
     * @param userInput The action input by the user
     * @return true if program should exit after executing this action
     */
    public boolean executeAction(String userInput) {
        Command command;
        try {
            command = myParser.createCommand(userInput);
            return command.execute(myTaskList, myDialogue);
        } catch (SidException e) {
            myDialogue.error(userInput, e.getMessage());
            return false;
        }
    }
}
