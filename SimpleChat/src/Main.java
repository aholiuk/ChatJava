import java.util.Scanner;
import java.lang.Math;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int width = 100;
    static int height = 100;
    static Profile myProfile;
    static String message = "";
    static int score = 0;

    // function does not work as supposed and very hard coded
    public static void drawAppearance() {
        if (message.equals(null)) {
            for (int i = 0; i < height; i++) {
                System.out.print("—");
                System.out.print("|");
                for (int j = 0; j < width; j++) {
                    System.out.print(" ");
                }
                System.out.println("|");
                if (i == 1 || i == 96) {
                    System.out.print("|");
                    for (int k = 0; k < width; k++) {
                        System.out.print("—");
                    }
                }
            }
        } else {

            for (int i = 0; i < height; i++) {
                System.out.print("|");
                for (int j = 0; j < width; j++) {
                    System.out.print(" ");
                }
                System.out.println("|");
                if (i == 1 || i == 96) {
                    System.out.print("|");
                    for (int k = 0; k < width; k++) {
                        System.out.print("—");
                    }
                }
                if (i == 97) {
                    System.out.print("|");
                    for (int l = 0; l < width - message.length(); l++) {
                        System.out.print(" ");
                    }
                    message = scanner.nextLine();
                }

            }
        }

    }
/////////////////////////////////////////////

    // displays a menu with 4 main functions of the program
    public static void displayMainMenu() {
        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELCOME TO SIMPLE CHAT\n\n\n\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWhat do you want to do today?\n\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1.Open chat\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2.View my profile\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t3.Create profile\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t4.Play mini games\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t5.Exit program\n");
    }

    private static void exitProgram() {
        System.exit(0);
    }

    // executes the menu function
    public static void makeChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                openChat();
                break;
            case 2:
                viewMyProfile(myProfile);
                break;
            case 3:
                createProfile();
                break;
            case 4:
                playMiniGames();
                break;
            case 5:
                exitProgram();
            default:
                throw new IllegalArgumentException("Invalid choice");

        }
    }

    private static void playMiniGames() {
        System.out.println("Choose a game:\n1.Rock Paper Scissors\n2.Tic Tac Toe");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                rockPaperScissors();
                break;
            case 2:
                ticTacToe();
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static void ticTacToe() {
    }

    // simple rock paper scissors game
    private static void rockPaperScissors() {
        boolean exit = false;
        while (true) {
            if (!exit){
                double computerMove = Math.random();
                String computerShow = "";
                System.out.println("\n\n\n\nChoose your move: ");
                char move = scanner.nextLine().charAt(0);
                if (computerMove <= 0.33) {
                    computerShow = "SCISSORS";
                } else if (computerMove <= 0.66) {
                    computerShow = "PAPER";
                } else {
                    computerShow = "ROCK";
                }
                switch (move) {
                    case 'S', 's':
                        System.out.println("\n\nYour move:\tSCISSORS");
                        if (computerShow.equals("SCISSORS")) {
                            System.out.println("Computer move:\t" + computerShow + "\n\nTie");
                        } else if (computerShow.equals("PAPER")) {
                            System.out.println("Computer move:\t" + computerShow + "\n\nYou win!");
                            score++;
                        } else {
                            System.out.println("Computer move:\t" + computerShow + "\n\nYou lose!");
                        }
                        break;
                    case 'P', 'p':
                        System.out.println("\n\nYour move:\tPAPER");
                        if (computerShow.equals("PAPER")) {
                            System.out.println("Computer move:\t" + computerShow + "\n\nTie");
                        } else if (computerShow.equals("ROCK")) {
                            System.out.println("Computer move:\t" + computerShow + "\n\nYou win!");
                            score++;
                        } else {
                            System.out.println("Computer move:\t" + computerShow + "\n\nYou lose!");
                        }
                        break;
                    case 'R', 'r':
                        System.out.println("\n\nYour move:\tROCK");
                        if (computerShow.equals("ROCK")) {
                            System.out.println("Computer move:\t" + computerShow + "\n\nTie");
                        } else if (computerShow.equals("SCISSORS")) {
                            System.out.println("Computer move:\t" + computerShow + "\n\nYou win!");
                            score++;
                        } else {
                            System.out.println("Computer move:\t" + computerShow + "\n\nYou lose!");
                        }
                    case 'e':
                        exit = true;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid move");
                }
                System.out.println(showScore(score));
            }
            else {
                break;
            }
        }

    }

    //// function with return value and with parameters
    // just shows your score
    public static String showScore(int score){
        return "\nYour score is: " + score;
    }

    //// function without return value and with parameters
    // shows a "dummy" account if one exists;
    // will only show the last created account
    private static void viewMyProfile(Profile profile) {
        if (profile != null) {
            System.out.println("Profile No: " + profile);
            System.out.println("Name: " + profile.firstName + " " + profile.lastName);
            System.out.println("Sex: " + profile.gender);
            System.out.println("Place of birth: " + profile.placeOfBirth);
        } else {
            throw new NullPointerException("Profile is null");
        }
    }

    private static void openChat() {

        while (true) {
            //drawAppearance();
            System.out.print("\nWrite a message: ");
            message = scanner.nextLine();
            clearScreen();
            System.out.println("You: " + message);
            System.out.println("Computer: " + showComputerAnswer());
            if (message.equals("\\exit")) {
                break;
            }
        }
    }

    //// function with return value and without parameters
    // small but valid conversation with "computer"
    private static String showComputerAnswer() {
        double computerAnswer = Math.random();
        String[] answers = {"Hello!", "Hi", "Greetings", "Good afternoon", "How are you?", "How is it going?", "What`s new?", "What`s up?", "Bye", "Goodbye", "Have a good one!", "Bye-bye", "=)",
                            "I am glad to hear that", "So sorry that you feel this way", "Same"};
        switch (message) {
            case "Goodbye", "Bye-bye", "Bye":
                if (computerAnswer < 0.25 && computerAnswer > 0.0) {
                  return answers[8];
                } else if (computerAnswer < 0.5 && computerAnswer > 0.25) {
                  return answers[9];
                } else if (computerAnswer < 0.75 && computerAnswer > 0.5) {
                  return answers[10];
                } else if (computerAnswer < 0.99 && computerAnswer > 0.75) {
                  return answers[11];
                } else {
                  return answers[12];
                }
            case "Hello", "Hi":
                if (computerAnswer < 0.25 && computerAnswer > 0.0) {
                  return answers[4];
                } else if (computerAnswer < 0.5 && computerAnswer > 0.25) {
                  return answers[5];
                } else if (computerAnswer < 0.75 && computerAnswer > 0.5) {
                  return answers[6];
                } else if (computerAnswer < 0.99 && computerAnswer > 0.75) {
                  return answers[7];
                } else {
                  return answers[12];
                }
            case " ", "\n":
                if (computerAnswer < 0.25 && computerAnswer > 0.0) {
                  return answers[0];
                } else if (computerAnswer < 0.5 && computerAnswer > 0.25) {
                  return answers[1];
                } else if (computerAnswer < 0.75 && computerAnswer > 0.5) {
                  return answers[2];
                } else if (computerAnswer < 0.99 && computerAnswer > 0.75) {
                  return answers[3];
                } else {
                  return answers[12];
                }
            case "Good":
                return answers[13];
            case "Bad":
                return answers[14];
            case "So-so", "Could have been better":
                return answers[15];
            default:
                return answers[12];
        }
    }

    // only for the reference, does nothing
    public static void clearScreen () {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // creates a "dummy" account
    public static void createProfile () {
        myProfile = new Profile();

        System.out.print("\n\nEnter your first name: ");
        String firstName = scanner.nextLine();
        myProfile.firstName = firstName;

        System.out.print("\nEnter your last name: ");
        String lastName = scanner.nextLine();
        myProfile.lastName = lastName;

        System.out.print("\nEnter your date of birth: ");
        String birthday = scanner.nextLine();
        myProfile.birthday = birthday;

        System.out.print("Choose your gender: \n\t1.Male\n\t2.Female\n\t3.Other\n");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                myProfile.gender = Gender.male;
                break;
            case 2:
                myProfile.gender = Gender.female;
                break;
            case 3:
                myProfile.gender = Gender.other;
                break;
            default:
                throw new IllegalArgumentException("Invalid choice");
        }

        scanner.nextLine();

        System.out.print("\nEnter your place of birth: ");
        String placeOfBirth = scanner.nextLine();
        myProfile.placeOfBirth = placeOfBirth;

        System.out.print("\n\n\nThe profile is successfully created!\n\n\n");

    }


    public static void main (String[]args) {
        while (true) {
            displayMainMenu();
            makeChoice();
        }
    }
}