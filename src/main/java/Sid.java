import java.util.Scanner;

public class Sid {
    private final Dialogue myDialogue = new Dialogue();
    private final TaskList myTaskList = new TaskList();

    public static void main(String[] args) {
        Sid sid = new Sid();
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            userInput = scanner.nextLine();
            if (sid.decideAction(userInput)) { // returns true if userInput == "bye"
                break;
            }
        }
    }

    /**
     * runs hello() on instantiation
     */
    Sid() {
        myDialogue.hello();
    }

    /**
     * decides which action the user wants (add item to list, print list, exit)
     * @param userInput the action input by the user
     * @return doExit tells bot to exit if userInput is "bye"
     */
    public boolean decideAction(String userInput) {
        boolean doExit = false;
        if (userInput.equals("bye")) {
            myDialogue.bye();
            doExit = true;
        } else if (userInput.equals("list")) {
            myDialogue.printMyList(myTaskList);
        } else if (userInput.startsWith("mark ")) {
            int idxToMark = extractIntSafely(userInput);
            if (idxToMark == -1) {
                return doExit;
            } else {
                String taskString = myTaskList.setMarked(idxToMark);
                myDialogue.printTaskMarked(taskString);
            }
        } else if (userInput.startsWith("unmark ")) {
            int idxToUnmark = extractIntSafely(userInput);
            if (idxToUnmark == -1) {
                return doExit;
            } else {
                String taskString = myTaskList.setUnmarked(idxToUnmark);
                myDialogue.printTaskUnmarked(taskString);
            }
        } else {
            myTaskList.addToList(userInput);
            myDialogue.printTaskAdded(userInput);
        }
        return doExit;
    }

    /**
     * Extracts idx from userInput safely (without throwing exception) while printing out error for invalid userInput
     * @param userInput the user input as a string
     * @return the extracted int. in case of error, returns -1
     */
    private int extractIntSafely(String userInput) {
        int i;
        int intStartIdx = 0;
        if (userInput.startsWith("mark ")) {
            intStartIdx = 5;
        } else if (userInput.startsWith("unmark ")) {
            intStartIdx = 7;
        } else {
            assert false: "invalid extractIntSafely() call\n";
        }
        try {
            i = Integer.parseInt(userInput.substring(intStartIdx)) - 1; //-1 since list idx starts from 1, not 0
        } catch (NumberFormatException e){
            myDialogue.error(userInput, 1);
            return -1;
        }
        if (i < 0 || i >= myTaskList.getMySize()) {
            myDialogue.error(userInput, 2);
            return -1;
        }
        return i;
    }

}
