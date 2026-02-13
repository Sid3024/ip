package sid.parser;

import sid.command.*;
import sid.exception.SidException;
import sid.task.Deadline;
import sid.task.Event;
import sid.task.ToDo;


public class Parser {
    /**
     * Creates a Command object corresponding to the action the user wants.
     * @param userInput The action input by the user.
     * @return Command object corresponding to the user input.
     */
    public Command createCommand(String userInput) throws SidException {
        if (userInput.equals("bye")) {
            return new ByeCommand();
        } else if (userInput.equals("list")) {
            return new ListCommand();
        } else if (userInput.startsWith("mark ")) {
            int idxToMark = extractInt(userInput);
            return new MarkCommand(idxToMark);
        } else if (userInput.startsWith("unmark ")) {
            int idxToUnmark = extractInt(userInput);
            return new UnmarkCommand(idxToUnmark);
        } else if (userInput.startsWith("todo ")) {
            return new AddCommand(new ToDo(userInput.substring(4).trim()));
        } else if (userInput.startsWith("deadline ")) {
            String[] deadlineMetadata = extractDeadlineMetadata(userInput);
            return new AddCommand(new Deadline(deadlineMetadata[0], deadlineMetadata[1]));
        } else if (userInput.startsWith("event ")) {
            String[] eventMetadata = extractEventMetadata(userInput);
            return new AddCommand(new Event(eventMetadata[0], eventMetadata[1], eventMetadata[2]));
        }
        else {
            throw new SidException("User input is of invalid format");
        }
    }

    /**
     * Extracts metadata of Deadline (task, dueAt) from userInput.
     * Expected format: "deadline <task> /by <dueAt>".
     * @param userInput Full raw input entered by user.
     * @return String[] of the metadata in the form {task, dueAt}.
     * @throws SidException If the input format is invalid.
     */
    private String[] extractDeadlineMetadata(String userInput) throws SidException {
        String[] parts = userInput.trim().split("/");
        verifyDeadlineInput(parts);
        return new String[]{parts[0].substring(8).trim(), extractTaskFromFlag(parts[1])};
    }

    /**
     * Verifies that userInput for a deadline task is of correct format.
     * @param parts String[] of the deadline metadata in the form {task, dueAt}.
     * @throws SidException If the input format is invalid.
     */
    private void verifyDeadlineInput(String[] parts) throws SidException {
        if (parts.length != 2) {
            throw new SidException("Deadline command requires exactly 1 flag ('/by')");
        }
        if (!verifyFlag(parts[1], "by")) {
            throw new SidException("Deadline command requires flag '/by'");
        }
    }

    /**
     * Extracts metadata of Event (task, startTime, endTime) from userInput.
     * Expected format: "event <task> /from <startTime> /to <endTime>".
     * Assumes that userInput has already been verified to be of the correct format.
     * @param userInput Full raw input entered by user.
     * @return String[] of the metadata in the form {task, startTime, endTime}.
     * @throws SidException If the input format is invalid.
     */
    private String[] extractEventMetadata (String userInput) throws SidException {
        String[] parts = userInput.trim().split("/");
        verifyEventInput(parts);
        return new String[]{parts[0].substring(5).trim(), extractTaskFromFlag(parts[1]), extractTaskFromFlag(parts[2])};
    }

    /**
     * Verifies that userInput for an event task is of correct format.
     * @param parts String[] of the event metadata in the form {task, startTime, endTime}.
     * @throws SidException If the input format is invalid.
     */
    private void verifyEventInput(String[] parts) throws SidException {
        if (parts.length != 3) {
            throw new SidException("Event command requires exactly 2 flags in order ('/from', '/to')");
        }
        if (!verifyFlag(parts[1], "from") || !verifyFlag(parts[2], "to")) {
            throw new SidException("Event command requires flags '/from', '/to' in order");
        }
    }

    /**
     * Extracts the relevant text (metadata) from the unprocessedFlag.
     * @param unprocessedFlag Substring starting from 1 flag till the next flag/end of string.
     * @return Metadata as a String.
     * @throws SidException If flag does not have a trailing space (' ').
     */
    private String extractTaskFromFlag(String unprocessedFlag) throws SidException{
        int firstSpace = unprocessedFlag.indexOf(' ');
        if (firstSpace == -1) {
            throw new SidException("Flag must be immediately followed by a space");
        }
        return unprocessedFlag.substring(firstSpace + 1);
    }

    /**
     * Verifies that the flag String is what is expected.
     * @param unprocessedFlag Substring starting from 1 flag till the next flag/end of string.
     * @param expectedFlag String of the expected flag.
     * @return true if flag String is what is expected.
     */
    private boolean verifyFlag(String unprocessedFlag, String expectedFlag) {
        return unprocessedFlag.split(" ")[0].equals(expectedFlag);
    }

    /**
     * Extracts idx from userInput for mark/unmark commands while throwing error for invalid userInput.
     * @param userInput The user input as a string.
     * @return The extracted int.
     */
    private int extractInt(String userInput) throws SidException {
        int i;
        int intStartIdx = 0;
        if (userInput.startsWith("mark ")) {
            intStartIdx = 5;
        } else if (userInput.startsWith("unmark ")) {
            intStartIdx = 7;
        } else {
            assert false: "invalid extractIntSafely() call\n"; //programmer error, this branch should never be reached
        }
        try {
            i = Integer.parseInt(userInput.substring(intStartIdx)) - 1; //-1 since list idx starts from 1, not 0
        } catch (NumberFormatException e){
            throw new SidException("User input for mark/unmark command is not of valid format");
        }
        return i;
    }
}
