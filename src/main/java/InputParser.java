public class InputParser {
    protected String input;
    protected String[] strings = new String[2];

    public InputParser(String input) throws DukeException {
        this.input = input;
        boolean isATask = input.startsWith("todo") || input.startsWith("deadline") || input.startsWith("event") || input.startsWith("done");

        if (!isATask) {
            strings[0] = input;
        } else if (isATask && input.contains(" ")) {
            strings = input.split(" ", 2);
        } else {
            throw new DukeException(DukeException.ExceptionType.EMPTY_DESCRIPTION);
        }

    }

    public void analyseTaskDescription() {
        strings = input.split("/");
    }

}
