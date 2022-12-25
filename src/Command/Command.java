package Command;
import java.util.HashMap;

public class Command {
    public enum CommandType {
        NewObject, // 1
        Load, // 2
        Ship, // 3
        Show; // 4

        public CommandType valueOfInt(int n) {
            switch (n) {
                case 1: return NewObject;
                case 2: return Load;
                case 3: return Ship;
                case 4: return Show;
                default: return null;
            }
        }
    }

    private CommandType type;
    private HashMap<String, String> attributes;

    Command(CommandType type, HashMap<String, String> attrubutes) {
        this.type = type;
        this.attributes = attrubutes;
    }

    public HashMap<String, String> getAttributes() {
        return new HashMap<>(this.attributes);
    }

    public CommandType getType() {
        return type;
    }
}
