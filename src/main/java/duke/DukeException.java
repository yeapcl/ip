package duke;

public class DukeException extends Exception{

    protected enum ExceptionType {
        INVALID_INPUT("\u2639 OOPS!!! I'm sorry, but I don't know what that means :-(\n"),
        EMPTY_DESCRIPTION("\u2639 OOPS!!! The description of a task cannot be empty.\n"),
        INDEX_OUT_OF_BOUND("\u2639 OOPS!!! No such task is found!\n");

        private String error;
        private String horizontalLine = "____________________________________________________________\n";

        ExceptionType(String error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return "\n" + horizontalLine + error + horizontalLine;
        }

    }

    public DukeException(ExceptionType error) {
        super(error.toString());
    }


}
