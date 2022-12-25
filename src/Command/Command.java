package Command;
import java.util.HashMap;

public class Command {
    public enum CommandType {
        NEW_OBJECT, // 1
        LOAD, // 2
        SHIP, // 3
        SHOW; // 4

        public static CommandType valueOfInt(int n) {
            switch (n) {
                case 1: return NEW_OBJECT;
                case 2: return LOAD;
                case 3: return SHIP;
                case 4: return SHOW;
                default: return null;
            }
        }
    }

    public enum AttributeType {
        ITEM_CODE,
        BOX_CODE,
        CONTAINER_CODE,
        NUMBER_OF_ITEMS,
        TOTAL_UNEARNED_REVENUE,
        TOTAL_REVENUE,
        SERIAL_NUMBER,
        SERIAL_NUMBER_OF_LOADING_ITEM,
        SERIAL_NUMBER_OF_HOLDER,
        VOLUME,
        MASS
    }

    private CommandType type;
    private HashMap<AttributeType, String> attributes;

    public Command(CommandType type, HashMap<AttributeType, String> attributes) {
        this.type = type;
        this.attributes = attributes;
    }

    public HashMap<AttributeType, String> getAttributes() {
        return new HashMap<>(this.attributes);
    }

    public CommandType getType() {
        return type;
    }

    @Override
    public String toString() {
        return this.type.toString() + ": " + this.attributes.toString();
    }
}
