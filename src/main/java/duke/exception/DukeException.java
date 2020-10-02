package duke.exception;

public class DukeException extends Exception {

    /**
     * Returns an exception error.
     *
     * @param message the reason for exception.
     */
    public DukeException(String message) {
        super(message);
    }
}
