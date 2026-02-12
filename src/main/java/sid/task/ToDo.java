package sid.task;

import static sid.task.TaskType.TODO;

public class ToDo extends Task {
    public ToDo(String toDo) {
        super(toDo, TaskType.TODO);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public char getTypeIcon() {
        return 'T';
    }
}
