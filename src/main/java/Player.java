public class Player {

    // INSTANCE VARIABLES GO HERE - DEFINE THE STATE OF EACH Player OBJECT
    // private ENFORCES ENCAPSULATION - VALUES CAN ONLY BE MODIFIED BY MODIFYING
    // INTERNAL VALUES DIRECTLY

    private String name;
    private String race;
    private Statistics stats;

    // DEFAULT/NO-ARGUMENT CONSTRUCTOR
    // INITIALIZES INSTANCE VARIABLES TO BASE VALUES
    // INSTANTIATES A DEFAULT Statistics OBJECT TO AVOID NULL POINTER EXCEPTION

    public Player() {
        this.name = "Default";
        this.race = "Default";
        this.stats = new Statistics();
    }

    // CONSTRUCTOR PARAMETERS

    public Player(String name, String race, Statistics stats) {
        this.name = name;
        this.race = race;
        this.stats = stats;
    }

    // getName GETTER

    public String getName() {
        return name;
    }

    // getRACE GETTER

    public String getRace() {
        return race;
    }

    // getSTATS GETTER

    public Statistics getStats() {
        return stats;
    }

    // setName SETTER

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    // setRace SETTER

    public void setRace(String race) {
        if (race != null && !race.trim().isEmpty()) {
            this.race = race;
        }
    }

    // setStats SETTER

    public void setStats(Statistics stats) {
        this.stats = stats;
    }

    // toString() OVERRIDE

    @Override
    public String toString() {
        return "Player Info: \n" +
                "name: " + name + "\n" +
                "race: " + race + "\n" +
                "statistics: " + stats;
    }
}