import java.util.HashMap;

public class Command {
    public enum CommandType {
        One, Two, Third, Four
    }

    private CommandType type;
    private HashMap<String, Double> attributes;
}
