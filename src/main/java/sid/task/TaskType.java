package sid.task;

public enum TaskType {
    TODO("T"),
    DEADLINE("D"),
    EVENT("E");

    private final String code;

    TaskType(String code) {
        this.code = code;
    }

    /**
     * Returns the char representing the task type.
     * @return The char representing the task type.
     */
    public String getCode() {
        return code;
    }

    /**
     * Finds and returns the task type of a specific code.
     * @param code The char representing the task type.
     * @return The task type of the input code.
     * @throws IllegalArgumentException If the code does not represent any task type.
     */
    public static TaskType findTaskType(String code) throws IllegalArgumentException {
        for (TaskType t : values()) {
            if (t.code.equals(code)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
