import java.util.Scanner;

public class Sid {
    private static final int MAX_LIST_SIZE = 100;
    private String[] myList = new String[MAX_LIST_SIZE];
    private int mySize = 0;

    public static void main(String[] args) {
        Sid sid = new Sid();
        Scanner scanner = new Scanner(System.in);
        String user_input;
        sid.hello();
        while (true) {
            user_input = scanner.nextLine();
            if (sid.decide_action(user_input)) { // returns true if userInput == "bye"
                break;
            }
        }
    }

    /**
     * decides which action the user wants (add item to list, print list, exit)
     * @param action the action input by the user
     * @return doExit tells bot to exit if userInput is "bye"
     */
    public boolean decide_action(String action) {
        boolean doExit = false;
        switch (action) {
        case "bye":
            bye();
            doExit = true;
            break;
        case "list":
            printMyList();;
            break;
        default:
            addToList(action);
            break;
        }
        return doExit;
    }

    /**
     * Print out myList in expected format
     */
    public void printMyList() {
        System.out.println("______________________________");
        for (int i=0;i<mySize;i++) {
            System.out.println((i+1) + ". " + myList[i]);
        }
        System.out.println("______________________________");
    }

    /**
     * Adds an item to myList
     * @param item the string to be added to myList
     */
    public void addToList(String item) {
        myList[mySize] = item;
        mySize++;
        printItem(item);
    }

    /**
     * prints out item just added to list
     * @param item the item that was just added to list
     */
    public void printItem(String item) {
        System.out.println("______________________________");
        System.out.println("added: " + item);
        System.out.println("______________________________");
    }

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

}
