package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

import Command.Command;
import Command.Command.AttributeType;
import Command.Command.CommandType;

public class FileIO {
    private Queue<Command> data;

    public void setup() {
        try {
            Scanner scanner = new Scanner(new File("src\\FileIO\\ExampleCommands.csv"));
        
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                int code = Integer.parseInt(data[0]);
                CommandType commandCode = Command.CommandType.valueOfInt(code);

                switch (commandCode) {
                    case NEW_OBJECT: addNewObjectCommand(data); break;
                    case LOAD: addLoadCommand(data); break;
                    case SHIP: addShipCommand(data); break;
                    case SHOW: addShowCommand(data); break;
                    default: throw new Exception("Invalid Command Type");
                }
            }
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addNewObjectCommand(String[] data) {
        char objectCode = data[1].charAt(1);

        switch (objectCode) {
            case 'B': addNewBox(data);
            case 'C': addNewContainer(data);
            default: addNewItem(data);
        }
    }

    private void addNewItem(String[] data) {
        HashMap<AttributeType, String> attributes = new HashMap<>();
        attributes.put(AttributeType.ITEM_CODE, data[1]);

        if (data.length == 4) {
            // Countable item
            attributes.put(AttributeType.VOLUME, data[2]);
            attributes.put(AttributeType.SERIAL_NUMBER, data[3]);
        }
        else if (data.length == 5) {
            // Uncountable item
            attributes.put(AttributeType.MASS, data[2]);
            attributes.put(AttributeType.VOLUME, data[3]);
            attributes.put(AttributeType.SERIAL_NUMBER, data[4]);
        }
        else {
            System.exit(-66);
        }

        this.data.add(new Command(CommandType.NEW_OBJECT, attributes));
    }

    private void addNewBox(String[] data) {
        String boxCode = data[1];
        
        if (boxCode.length() != 2) {
            System.exit(-85);
        }
        
        HashMap<AttributeType, String> attributes = new HashMap<>();
        attributes.put(AttributeType.BOX_CODE, boxCode);
        
        if (boxCode.charAt(1) == '1') {
            // Countable Box
            attributes.put(AttributeType.NUMBER_OF_ITEMS, data[2]);
        }
        else {
            // Uncountable Box
            attributes.put(AttributeType.MASS, data[2]);
        }

        attributes.put(AttributeType.VOLUME, data[3]);
        attributes.put(AttributeType.SERIAL_NUMBER, data[4]);

        this.data.add(new Command(CommandType.NEW_OBJECT, attributes));
    }

    private void addNewContainer(String[] data) {
        HashMap<AttributeType, String> attributes = new HashMap<>();
        attributes.put(AttributeType.CONTAINER_CODE, data[1]);
        attributes.put(AttributeType.VOLUME, data[2]);
        attributes.put(AttributeType.SERIAL_NUMBER, data[3]);

        this.data.add(new Command(CommandType.NEW_OBJECT, attributes));
    }

    private void addLoadCommand(String[] data) {
        HashMap<AttributeType, String> attributes = new HashMap<>();
        attributes.put(AttributeType.SERIAL_NUMBER_OF_LOADING_ITEM, data[2]);
        attributes.put(AttributeType.SERIAL_NUMBER_OF_HOLDER, data[3]);

        this.data.add(new Command(CommandType.LOAD, attributes));
    }

    private void addShipCommand(String[] data) {
        HashMap<AttributeType, String> attributes = new HashMap<>();
        attributes.put(AttributeType.SERIAL_NUMBER, data[1]);

        this.data.add(new Command(CommandType.SHIP, attributes));
    }

    private void addShowCommand(String[] data) {
        HashMap<AttributeType, String> attributes = new HashMap<>();

        if (data[1] == "1") {
            attributes.put(AttributeType.TOTAL_UNEARNED_REVENUE, null);
        }
        else if (data[2] == "2") {
            attributes.put(AttributeType.TOTAL_REVENUE, null);
        }

        this.data.add(new Command(CommandType.SHIP, attributes));
    }
}
