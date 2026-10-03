import java.util.HashMap;
import java.util.Map;

public class Room {
    private final String name;
    private final String description;
    private final Map<String, Room> exits;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction.toLowerCase(), neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getExitString() {
        return "Exits: " + String.join(", ", exits.keySet());
    }
}
