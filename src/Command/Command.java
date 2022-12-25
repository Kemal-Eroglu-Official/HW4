package Command;
import java.util.HashMap;

public class Command {
    public enum CommandType {
        NewObject, // 1
        Load, // 2
        Ship, // 3
        Show // 4
    }

    private CommandType type;
    private HashMap<String, Double> attributes;
}
