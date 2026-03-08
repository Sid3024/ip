package sid.exception;

/**
 * An exception specific to the Sid Chatbot.
 */
public class SidException extends Exception {
    /**
     * Creates a SidException with the specified message.
     * @param message The specific error message.
     */
    public SidException(String message) {
        super(message);
    }
}
