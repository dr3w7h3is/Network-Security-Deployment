import java.util.*;

public class Menu {

    private final static int MIN = 1;
    private final static int MAX = 4;
    private boolean loop = true;


    public Menu() {
        System.out.println("Welcome the the Network Security Deployment");
    }

    public void display() {
        System.out.println("\nSelect one of the following operations: \n" +
                "1) Show current config template\n" +
                "2) Edit config template\n" +
                "3) Apply template\n" +
                "4) Check devices compliance\n" +
                "5) Quit");
    }

    public int getSelection() {
        int choiceNum;
        do {
            Scanner scan = new Scanner(System.in);
            choiceNum = scan.nextInt();
            if (choiceNum >= MIN && choiceNum <= MAX) {
                System.out.println("You have selected: " + choiceNum + "\n");
                loop = false;
            } else {
                System.out.println("Invalid entry please reenter option number");
            }
        } while (loop);
        return choiceNum;
    }
}