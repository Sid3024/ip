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
        } else {
            return new AddCommand(userInput);
        }
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
