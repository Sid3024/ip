package sid.parser;

import sid.command.*;
import sid.exception.SidException;
import sid.task.Deadline;
import sid.task.Event;
import sid.task.ToDo;


public class Parser {
    /**
     * Creates a Command object corresponding to the action the user wants
     * @param userInput The action input by the user
     * @return Command object corresponding to the user input
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

    private String deadlineMetadataToString(String[] deadlineMetadata) {
        return deadlineMetadata[0] + " (by: " + deadlineMetadata[1] + ")";
    }

    private String eventMetadataToString(String[] eventMetadata) {
        return eventMetadata[0] + " (from: " + eventMetadata[1] + " to: " + eventMetadata[2] + ")";
    }

    private String extractTaskFromFlag(String UnprocessedFlag) {
        int firstSpace = UnprocessedFlag.indexOf(' ');
        return UnprocessedFlag.substring(firstSpace + 1);
    }

    private String[] extractEventMetadata (String userInput) throws SidException {
        String[] parts = userInput.trim().split("/");
        verifyEventInput(parts);
        return new String[]{parts[0].substring(5).trim(), extractTaskFromFlag(parts[1]), extractTaskFromFlag(parts[2])};
    }

    private String[] extractDeadlineMetadata(String userInput) throws SidException {
        String[] parts = userInput.trim().split("/");
        verifyDeadlineInput(parts);
        return new String[]{parts[0].substring(8).trim(), extractTaskFromFlag(parts[1])};
    }

    private void verifyDeadlineInput(String[] parts) throws SidException {
        if (parts.length != 2) {
            throw new SidException("Deadline command requires exactly 1 flag ('/by')");
        }
        if (!verifyFlag(parts[1], "by")) {
            throw new SidException("Deadline command requires flag '/by'");
        }
    }

    private void verifyEventInput(String[] flags) throws SidException {
        if (flags.length != 3) {
            throw new SidException("Event command requires exactly 2 flags in order ('/from', '/to')");
        }
        if (!verifyFlag(flags[1], "from") || !verifyFlag(flags[2], "to")) {
            throw new SidException("Event command requires flags '/from', '/to' in order");
        }
    }


    private boolean verifyFlag(String unprocessedFlag, String expectedFlag) {
        return unprocessedFlag.split(" ")[0].equals(expectedFlag);
    }





    /**
     * Extracts idx from userInput while throwing error for invalid userInput
     * @param userInput The user input as a string
     * @return The extracted int
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
