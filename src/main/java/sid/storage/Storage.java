package sid.storage;

import sid.exception.SidException;
import sid.task.*;

import java.io.*;

import static sid.task.TaskType.DEADLINE;

public class Storage {
    private static String filePath;

    public Storage(String FILE_PATH) {
        filePath = FILE_PATH;
    }

    /**
     * Verifies that file (and parent folders) exist, and if not, creates them.
     * @throws SidException Throws when file (and/or parent folders) do not exist and unable to create it/them.
     */
    public void ensureFileExists() throws SidException {
        try {
            File file = new File(filePath);
            file.getParentFile().mkdirs(); //creates parent folder if it doesnt exit
            if (!file.exists()) {
                file.createNewFile(); //creates file if it doesnt exist
            }
        } catch (IOException e) {
            throw new SidException("Storage file does not exist and unable to create it, due to error: " + e + "\n"
                    + "Any changes made to list in this session will not be saved");
        }

    }

    /**
     * Saves current taskList to a text file.
     * @param taskList List to be saved.
     * @throws SidException Throws when unable to write to file.
     */
    public void saveTaskList(TaskList taskList) throws SidException {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            Task task;
            for (int i = 0; i < taskList.getSize(); i++) {
                task = taskList.get(i);
                writer.write(task.getFileString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new SidException("Unable to save list to hard disk, due to error: " + e);
        }
    }

    /**
     * Loads taskList from text file.
     * @param taskList The taskList the data is to be loaded into.
     * @throws SidException Throws when unable to retrieve data from file or data is of the wrong format.
     */
    public void loadTaskList(TaskList taskList) throws SidException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            String line;
            while ((line = reader.readLine()) != null) {
                Task task = parseLine(line);
                taskList.addToList(task);
            }
            reader.close();
        } catch (IOException | SidException e) {
            throw new SidException("Unable to load list from hard disk, due to error: " + e + "\n"
                    + "List will be initialised as empty");
        }

    }

    /**
     * Creates a task object that corresponds to parameters specified in the String input.
     * @param line String input that specifies the parameters of the task object to be created.
     * @return Returns the task object created.
     * @throws SidException Throws when the String input is not of the expected format.
     */
    private Task parseLine(String line) throws SidException {
        String[] parts = line.split("\\s*\\|\\s*");
        TaskType taskType = TaskType.findTaskType(parts[0]);
        switch (taskType) {
        case TODO: {
            if (parts.length != 3) {
                throw new SidException("Read toDo task line from file is of incorrect format\n"
                        + "Expected format: " + "T | <markIcon> | <toDoTask>\n"
                        + "Actual line: " + line
                        );
            }
            ToDo toDo = new ToDo(parts[2]);
            markTaskIfDone(toDo, parts[1]);
            return toDo;
        }
        case DEADLINE: {
            if (parts.length != 4) {
                throw new SidException("Read deadline task line from file is of incorrect format\n"
                        + "Expected format: " + "D | <markIcon> | <deadlineTask> | <dueAt>\n"
                        + "Actual line: " + line
                        );
            }
            Deadline deadline = new Deadline(parts[2], parts[3]);
            markTaskIfDone(deadline, parts[1]);
            return deadline;
        }
        case EVENT: {
            if (parts.length != 5) {
                throw new SidException("Read toDo task line from file is of incorrect format\n"
                        + "Expected format: " + "T | <markIcon> | <startTime> | <endTime>\n"
                        + "Actual line: " + line
                        );
            }
            Event event = new Event(parts[2], parts[3], parts[4]);
            markTaskIfDone(event, parts[1]);
            return event;
        }
        default:
            throw new SidException("Read task line in file is of incorrect format, failing to resolve to any task type\n"
                    + "Actual task line: " + line
                    );
        }

    }

    /**
     * Marks task of object if the object is done.
     * @param task Task object to be marked if needed.
     * @param icon Substring of input line that specifies whether task is done.
     * @throws SidException Throws if icon is not of expected format.
     */
    private void markTaskIfDone(Task task, String icon) throws SidException {
        if (icon.equals("X")) {
            task.mark();
        } else if (icon.isEmpty()) {
            return;
        } else {
            throw new SidException("mark icon of task stored in file is of invalid format.\n"
                    + "Expected: 'X' OR ' '\n" +
                    "Actual: " + icon);
        }
    }



}
