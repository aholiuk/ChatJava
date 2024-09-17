import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int width = 100;
    static int height = 100;
    static Profile myProfile;

///////////////////////////////////////////////
    public static void drawVertical() {
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            drawHorizontalSpace();
            System.out.println("|");
            if (i == 1 || i == 96) {
                System.out.print("|");
                drawHorizontalLine();
            }
        }

    }

    private static void drawHorizontalLine() {
        for (int i = 0; i < width; i++) {
            System.out.print("—");
        }
    }

    private static void drawHorizontalSpace() {
        for (int i = 0; i < width; i++) {
            System.out.print(" ");
        }
    }

    public static void drawAppearance() {
        System.out.print(" ");
        drawHorizontalLine();
        System.out.print("\n");
        drawVertical();
        System.out.print(" ");
        drawHorizontalLine();
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
        boolean closed = false;
        switch (choice) {
            case 1:
                isOpenedChat(closed);
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
        if(profile != null) {
            System.out.println("Profile No: " + profile);
            System.out.println("Name: " + profile.firstName + " " + profile.lastName);
            System.out.println("Sex: " + profile.gender);
            System.out.println("Place of birth: " + profile.placeOfBirth);
        } else {
            throw new NullPointerException("Profile is null");
        }
    }

    ///////////////////////////////////////
    private static boolean isOpenedChat(boolean closed) {
        return !closed;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void createProfile() {
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


    public static void main(String[] args) {

        while (true) {
            displayMainMenu();
            makeChoice();
        }


    }
}