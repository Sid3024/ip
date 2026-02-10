public class TaskList {
    private static final int MAX_LIST_SIZE = 100;
    private Task[] myList = new Task[MAX_LIST_SIZE];
    private int mySize = 0;


    public String toString() {
        String s = "";
        for (int i=0;i<mySize;i++) {
            s += (i+1) + "." + myList[i].toString() + "\n";
        }
        return s;
    }

    /**
     * Adds an task to myList
     * @param task the string to be added to myList
     */
    public void addToList(String task) {
        Task newTaskObj = new Task(task);
        myList[mySize] = newTaskObj;
        mySize++;
    }




    public String setMarked(int idx) {
        this.myList[idx].mark();
        return myList[idx].toString();
    }

    public String setUnmarked(int idx) {
        this.myList[idx].unmark();
        return myList[idx].toString();
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
