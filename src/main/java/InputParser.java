public class InputParser {
    protected String input;
    protected String[] strings = new String[2];

    public InputParser(String input) {
        this.input = input;
    }

    public void analyseTask() {
        strings = input.split(" ", 2);
    }

    public void analyseTaskDescription() {
        strings = input.split("/");
    }

}
