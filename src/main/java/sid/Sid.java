package sid;

import sid.command.Command;
import sid.exception.SidException;
import sid.parser.Parser;
import sid.task.TaskList;
import sid.ui.Dialogue;

import java.util.Scanner;

public class Sid {
    private final Dialogue dialogue = new Dialogue();
    private final TaskList taskList = new TaskList();
    private final Parser parser = new Parser();

    public static void main(String[] args) {
        Sid sid = new Sid();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            userInput = scanner.nextLine().trim();

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
        dialogue.hello();
    }

    /**
     * Executes action the user wants (add item to list, print list, exit)
     * @param userInput The action input by the user
     * @return true if program should exit after executing this action
     */
    public boolean executeAction(String userInput) {
        Command command;
        try {
            command = parser.createCommand(userInput);
            return command.execute(taskList, dialogue);
        } catch (SidException e) {
            dialogue.error(userInput, e.getMessage());
            return false;
        }
    }
}

