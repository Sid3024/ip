package sid;

import sid.command.Command;
import sid.exception.SidException;
import sid.parser.Parser;
import sid.storage.Storage;
import sid.task.TaskList;
import sid.ui.Dialogue;

import java.io.IOException;
import java.util.Scanner;

public class Sid {
    private final Dialogue dialogue = new Dialogue();
    private final TaskList taskList = new TaskList();
    private final Parser parser = new Parser();
    private static final String FILE_PATH = "data/storeList.txt";
    private final Storage storage = new Storage(FILE_PATH);

    public static void main(String[] args) {
        Sid sid = new Sid();

        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            userInput = scanner.nextLine().trim();

            if (sid.executeCommand(userInput)) { // returns true if userInput == "bye"
                break;
            }
        }
        scanner.close();
    }

    /**
     * Constructs Sid object and prints the greeting message.
     */
    Sid() {
        try {
            storage.ensureFileExists();
            storage.loadTaskList(taskList);
        } catch (SidException e) {
            System.out.println(e.getMessage());
        }
        dialogue.hello();
    }

    /**
     * Executes command the user wants (add item to list, print list, exit).
     * @param userInput The command input by the user.
     * @return true if program should exit after executing this command.
     */
    public boolean executeCommand(String userInput) {
        Command command;
        try {
            command = parser.createCommand(userInput);
            boolean exitProgram = command.execute(taskList, dialogue);
            if (command.requiresSave()) {
                storage.saveTaskList(taskList);
            }
            return exitProgram;
        } catch (SidException e) {
            dialogue.error(userInput, e.getMessage());
            return false;
        }
    }
}

