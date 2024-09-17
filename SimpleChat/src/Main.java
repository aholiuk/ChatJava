import java.util.Scanner;
import java.lang.Math;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int width = 100;
    static int height = 100;
    static Profile myProfile;
    static String message = "";


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
///////////////////////////////////////////////

    public static void displayMainMenu() {
        System.out.print("\n\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWELCOME TO SIMPLE CHAT\n\n\n\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tWhat do you want to do today?\n\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1.Open chat\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2.View my profile\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t3.Create profile\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t4.Play mini games\n");
    }

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
            default:
                throw new IllegalArgumentException("Invalid choice");

        }
    }

    private static void playMiniGames() {
    }

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

    ///////////////////////////////////////
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

    private static String showComputerAnswer() {
        double computerAnswer = Math.random();
        String[] answers = {"Hello!", "Hi.", "Greetings.", "Good afternoon", "How are you?", "How is it going?", "What`s new?", "What`s up?", "Bye.", "Goodbye.", "Have a good one!", "Bye-bye.", "=)"};
        if (message.equals("Goodbye") || message.equals("Bye-bye") || message.equals("Bye")) {
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
        } else if (message.equals("Hello") || message.equals("Hi")) {
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
        }
        return answers[12];
    }

        public static void clearScreen () {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

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