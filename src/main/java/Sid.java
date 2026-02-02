public class Sid {

    public static void main(String[] args) {
        Sid sid = new Sid();
        sid.hello();
        sid.bye();
    }

    
    public void hello() {
        System.out.println("______________________________\n"
                + "Hello! I'm Sid\n"
                + "What can I do for you?\n"
                + "______________________________\n");
    }

    public void bye() {
        System.out.println("______________________________\n" +
                " Bye. Hope to see you again soon!\n"
                + "______________________________\n");
    }

}
