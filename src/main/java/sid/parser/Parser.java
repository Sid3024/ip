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
        userInput = userInput.trim();
        if (userInput.equals("bye")) {
            return new ByeCommand();
        } else if (userInput.equals("list")) {
            return new ListCommand();
        } else if (userInput.startsWith("mark")) {
            int idxToMark = extractInt(userInput, "mark");
            return new MarkCommand(idxToMark);
        } else if (userInput.startsWith("unmark")) {
            int idxToUnmark = extractInt(userInput, "unmark");
            return new UnmarkCommand(idxToUnmark);
        } else if (userInput.startsWith("todo")) {
            verifyChunk(userInput, "todo");
            return new AddCommand(new ToDo(extractTaskFromChunk(userInput)));
            //return new AddCommand(new ToDo(userInput.substring(4).trim()));
        } else if (userInput.startsWith("deadline")) {
            String[] deadlineMetadata = extractDeadlineMetadata(userInput);
            return new AddCommand(new Deadline(deadlineMetadata[0], deadlineMetadata[1]));
        } else if (userInput.startsWith("event")) {
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
        String[] parts = userInput.trim().split("/", -1);
        verifyDeadlineInput(parts);
        return new String[]{extractTaskFromChunk(parts[0]), extractTaskFromChunk(parts[1])};
        //return new String[]{parts[0].substring(8).trim(), extractTaskFromFlag(parts[1])};
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
        if (!verifyChunk(parts[0], "deadline") || !verifyChunk(parts[1], "by")) {
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
        String[] parts = userInput.trim().split("/", -1);
        verifyEventInput(parts);
        return new String[]{extractTaskFromChunk(parts[0]), extractTaskFromChunk(parts[1]), extractTaskFromChunk(parts[2])};
        //return new String[]{parts[0].substring(5).trim(), extractTaskFromChunk(parts[1]), extractTaskFromChunk(parts[2])};
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
        if (!verifyChunk(parts[0], "event") || !verifyChunk(parts[1], "from") || !verifyChunk(parts[2], "to")) {
            throw new SidException("Event command requires flags '/from', '/to' in order");
        }
    }

    /**
     * Extracts the relevant text (metadata) from the unprocessedFlag.
     * @param unprocessedChunk Substring starting from 1 flag till the next flag/end of string.
     * @return Metadata as a String.
     * @throws SidException If flag does not have a trailing space (' ').
     */
    private String extractTaskFromChunk(String unprocessedChunk) throws SidException {
        int firstSpace = unprocessedChunk.indexOf(' ');
        if (firstSpace == -1) {
            throw new SidException("'" + unprocessedChunk + "' must be immediately followed by a space");
        }
        return unprocessedChunk.substring(firstSpace + 1).trim();
    }

    /**
     * Verifies that the flag String is what is expected.
     * @param unprocessedChunk Substring starting from 1 flag till the next flag/end of string.
     * @param expectedString String of the expected flag.
     * @return true if flag String is what is expected.
     */
    private boolean verifyChunk(String unprocessedChunk, String expectedString) throws SidException {
        String[] parts = unprocessedChunk.trim().split("\\s+", 2);
        if (!parts[0].equals(expectedString)) {
            return false;
        }
        if (parts.length < 2 || parts[1].trim().isEmpty()) {
            throw new SidException("'" + expectedString + "' requires a non-empty description");
        }
        return true;
    }

    /**
     * Extracts idx from userInput for mark/unmark commands while throwing error for invalid userInput.
     * @param userInput The user input as a string.
     * @param commandString String of the command.
     * @return The extracted int.
     */
    private int extractInt(String userInput, String commandString) throws SidException {
        if (commandString.length() == userInput.length()) {
            throw new SidException(userInput + " command requires an index arg");
        }
        if (userInput.charAt(commandString.length()) != ' ') {
            throw new SidException(commandString + " command must be immediately followed by a space character (' ')");
        }
        int startIdx = commandString.length() + 1; //+1 due to space character
        try {
            return Integer.parseInt(userInput.substring(startIdx)) - 1; //-1 since list idx starts from 1, not 0
        } catch (NumberFormatException e){
            throw new SidException("User input for " + commandString + " command is not of valid format");
        }
    }
}
