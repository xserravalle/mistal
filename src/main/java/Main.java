import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private boolean isRunning = true;


    public static void main(String[] args) {
        Main game = new Main();
        game.run();
    }


    public void run() {
        System.out.println("**********************************************************");
        System.out.println("**********************************************************");
        System.out.println("                    WELCOME TO MISTAL                     ");
        System.out.println("**********************************************************");
        System.out.println("**********************************************************");
        System.out.println("");
        System.out.println("This project was designed by Peyton Holland ((c) 2026) and");
        System.out.println("is meant to demonstrate Java and OOP programming knowledge");
        System.out.println("as a portfolio component.                                 ");
        System.out.println("**********************************************************");
        System.out.println("**********************************************************");

        System.out.println("**********************************************************");

        // PLAYER ENTERS NAME

        System.out.println("\nFirst, please enter your character's name: \n");

        String playerName = scanner.nextLine().trim();
        if (playerName.isEmpty()) {
            playerName = "Default";
        }

        System.out.println("\nGreetings, " + playerName + ". Your journey begins.\n");
        System.out.println("**********************************************************");

        // PLAYER ENTERS RACE

        System.out.println("\nNext, please choose your character's race: \n");
        System.out.println("**********************************************************");
        System.out.println("1: Human");
        System.out.println("2: Elvan");
        System.out.println("3: Kurgar");
        System.out.println("");

        String playerRace = null;

        String raceChoice = scanner.nextLine().trim();

        // DECISION STRUCTURE -- USING SWITCH CASE FOR NUMERICALLY GOVERNED OPTIONS MENU

        switch (raceChoice) {
            case "1":
                System.out.println("You have chosen HUMAN");
                playerRace = "human";
                break;
            case "2":
                System.out.println("You have chosen ELVAN");
                playerRace = "elvan";
                break;
            case "3":
                System.out.println("You have chosen KURGAR");
                playerRace = "kurgar";
                break;
            default:
                System.out.println("Invalid input. Defaulting to HUMAN.");
                playerRace = "human";
                break;
        }

        System.out.println("**********************************************************");
        System.out.println("\n              CHARACTER ROLLER                        \n");
        System.out.println("**********************************************************");
        System.out.println("NAME: " + playerName + "\n");
        System.out.println("RACE: " + playerRace + "\n");
        System.out.println("**********************************************************");
        System.out.println("**********************************************************");

        // CREATE Statistics REFERENCE rolledStats TO STORE VALIDATED STATISTICS
        // CREATE Boolean statsConfirmed TO GOVERN DO-WHILE LOOP FOR CHARACTER ROLLER

        Statistics rolledStats;
        boolean statsConfirmed = false;

        // DO-WHILE LOOP FOR CHARACTER ROLLER ALLOWS PLAYER CHANCE TO CONTROL STATISTICAL
        // OUTCOMES IN STAT GENERATION FOR Player OBJECT

        do {
            rolledStats = Statistics.rollRandom(3, 18);

            System.out.println(rolledStats);
            System.out.println("\nAccept these stats? SELECT Y (YES) to PROCEED, SELECT N (NO) to REROLL: [Y/N]");

            String choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("Y")) {
                statsConfirmed = true;
                System.out.println("Stats accepted!");
            } else {
                System.out.println("Rerolling..\n");
            }
        } while (!statsConfirmed);

        // INSTANTIATE Player OBJECT WITH playerName, playerRace, and rolledStats FOR CONSTRUCTION

        Player player = new Player(playerName, playerRace, rolledStats);

        System.out.println("\n**********************************************************");
        System.out.println("                 CHARACTER CREATION COMPLETE              ");
        System.out.println("**********************************************************");
        System.out.println(player);
    }
}