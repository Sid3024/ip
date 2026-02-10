public class TaskList {
    private static final int MAX_LIST_SIZE = 100;
    private Task[] myList = new Task[MAX_LIST_SIZE];
    private int mySize = 0;

    /**
     * Print out myList in expected format
     */
    public void printMyList() {
        System.out.println("______________________________");
        String cross;
        for (int i=0;i<mySize;i++) {
            System.out.print((i+1)+".");
            myList[i].printTaskWithStatus();
        }
        System.out.println("______________________________");
    }

    /**
     * Adds an task to myList
     * @param task the string to be added to myList
     */
    public void addToList(String task) {
        Task newTaskObj = new Task(task);
        myList[mySize] = newTaskObj;
        mySize++;
        printTaskAdded(newTaskObj);
    }

    /**
     * prints out task just added to list
     * @param task the task that was just added to list
     */
    public void printTaskAdded(Task task) {
        System.out.println("______________________________");
        System.out.print("added: ");
        task.printTask();
        System.out.println("______________________________");
    }

    public void printTaskMarked(int idx) {
        System.out.println("______________________________");
        System.out.println("Nice! I've marked this task as done:");
        myList[idx].printTaskWithStatus();
        System.out.println("______________________________");
    }

    public void printTaskUnmarked(int idx) {
        System.out.println("______________________________");
        System.out.println("Ok, I've marked this task as not done yet:");
        myList[idx].printTaskWithStatus();
        System.out.println("______________________________");
    }


    public void setMarked(int idx) {
        this.myList[idx].mark();
        printTaskMarked(idx);
    }

    public void setUnmarked(int idx) {
        this.myList[idx].unmark();
        printTaskUnmarked(idx);
    }

    public int getMySize() {
        return mySize;
    }

    public void setMySize(int mySize) {
        this.mySize = mySize;
    }

    public int getMaxListSize() {
        return MAX_LIST_SIZE;
    }
}
