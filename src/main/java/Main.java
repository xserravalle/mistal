import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);
    private final boolean isRunning = true;

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
        System.out.println("\nFirst, please enter your character's name: \n");

        String playerName = scanner.nextLine().trim();

        System.out.println("\nGreetings, " + playerName + ". Your journey begins.\n");
        System.out.println("**********************************************************");

        System.out.println("\nNext, please choose your character's race: \n");
        System.out.println("**********************************************************");
        System.out.println("1: Human");
        System.out.println("2: Elven");
        System.out.println("3: Kurgar");
        System.out.println("");

        String playerRace = null;

        String raceChoice = scanner.nextLine();

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
        }
    }
}