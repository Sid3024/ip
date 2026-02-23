package sid.task;

public enum TaskType {
    TODO("T"),
    DEADLINE("D"),
    EVENT("E");

    private final String code;

    TaskType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static TaskType findTaskType(String code) throws IllegalArgumentException {
        for (TaskType t : values()) {
            if (t.code.equals(code)) {
                return t;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
