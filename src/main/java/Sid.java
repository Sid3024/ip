import java.util.Scanner;

public class Sid {

    public static void main(String[] args) {
        Sid sid = new Sid();
        Scanner scanner = new Scanner(System.in);
        String user_input;
        sid.hello();
        while (true) {
            user_input = scanner.nextLine();
            if (user_input.equals("bye")) {
                break;
            } else {
                sid.echo(user_input);
            }
        }
        sid.bye();
    }

    /**
     * Prints hello message
     */
    public void hello() {
        System.out.println("______________________________\n"
                + "Hello! I'm Sid\n"
                + "What can I do for you?\n"
                + "______________________________\n");
    }

    /**
     * Prints bye message
     */
    public void bye() {
        System.out.println("______________________________\n" +
                " Bye. Hope to see you again soon!\n"
                + "______________________________\n");
    }

    /**
     * Echoes user input
     */
    public void echo(String s) {
        System.out.println("______________________________\n"
                + s
                + "\n"
                + "______________________________\n");
    }

}
