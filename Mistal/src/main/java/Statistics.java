import java.util.concurrent.ThreadLocalRandom;

public class Statistics {

    // INSTANCE VARIABLES

    private int playerStr;
    private int playerAgi;
    private int playerCon;

    // DEFAULT CONSTRUCTOR

    public Statistics() {
        this.playerStr = 0;
        this.playerAgi = 0;
        this.playerCon = 0;
    }

    // CONSTRUCTOR PARAMETERS

    public Statistics(int playerStr, int playerAgi, int playerCon) {
        this.playerStr = playerStr;
        this.playerAgi = playerAgi;
        this.playerCon = playerCon;
    }

    // STATIC FACTORY METHOD FOR GENERATING RANDOM INTEGERS TO ROLL CHARACTER STATISTICS
    // ThreadLocalRandom GIVES EVERY THREAD IT'S OWN ISOLATED SEED TO PREVENT PERFORMANCE
    // BOTTLENECKS. THIS IS AN IMPROVEMENT OVER Random WHICH GENERATES A SINGLE SEED
    // OTHER COMPONENTS MAY FIGHT OVER.
    // USE ThreadLocalRandom.current().nextInt(origin, bound) WHERE ORIGIN IS THE MINIMUM
    // AND BOUND IS MAXIMUM FOR THE DESIRED RANGE.

    public static Statistics rollRandom(int min, int max) {
        int playerStr = ThreadLocalRandom.current().nextInt(min, max + 1);
        int playerAgi = ThreadLocalRandom.current().nextInt(min, max + 1);
        int playerCon = ThreadLocalRandom.current().nextInt(min, max + 1);

        return new Statistics(playerStr, playerAgi, playerCon);
    }

    // GETTERS

    public int getPlayerStr() {
        return playerStr;
    }

    public int getPlayerAgi() {
        return playerAgi;
    }

    public int getPlayerCon() {
        return playerCon;
    }

    // SETTERS

    public void setPlayerStr(int playerStr) {
        if (playerStr >= 0) {
            this.playerStr = playerStr;
        }
    }

    public void setPlayerAgi(int playerAgi) {
        if (playerAgi >= 0) {
            this.playerAgi = playerAgi;
        }
    }

    public void setPlayerCon(int playerCon) {
        if (playerCon >= 0) {
            this.playerCon = playerCon;
        }
    }

    @Override
    public String toString() {
        return "\n" +
                " Strength:	" + playerStr + "\n" +
                " Agility: 	" + playerAgi + "\n" +
                " Constitution: " + playerCon;
    }
}