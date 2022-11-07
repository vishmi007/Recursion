
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date:  14th August 2021                                    
 * Purpose: To take in the number of disks to play the game tower of hanoi and to display the play steps...                    
 *********************************************************************************************************/
import java.util.*;

class Activity5 {
    public static int DEPTH = 0;

    public static void main(String args[]) {
        System.out.println("Welcome to the program that shows the steps to play the game tower of Hanoi.");
        mainMenu();
    }

    /*********************************************************************
     * Name- mainMenu Date 14/08/2021 import - None Export - None Purpose- To print
     * the menu of the program.
     *********************************************************************/

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        int userChoice = 0;
        try {
            System.out.println("Please select an option from the below two options \n Note : press 1 or 2");
            System.out.println(" >> 1.Convert a number to a desired base \n >> 2.Exit program.");
            userChoice = sc.nextInt();
            if (userChoice < 0) {
                // gives an error message when a negative number is inserted as the choice.
                throw new IllegalArgumentException(" \n Your choice cannot be a negative integer");

            } else {
                switch (userChoice) {

                    case 1:
                        ;
                        System.out.println(
                                " >>>> Please Enter the number of Disks \n Note that only positive integers can be entered.");
                        number = sc.nextInt();
                        if (number < 0) {
                            throw new IllegalArgumentException(" \n You cannot enter a negative integer");

                        }

                        towersOfHanoiWrappers(number);
                        mainMenu();
                        break;

                    case 2:
                        System.out.println("Goodbye Have a nice day !!!!");
                        break;
                    default:
                        System.out.println("Invalid integer entered please try again later");
                        mainMenu();
                }
            }

        } catch (InputMismatchException error) {
            System.out.println("Something is wrong \n Please try again " + error.getMessage());
            mainMenu();
        } catch (Exception e) {
            System.out.println("Something is wrong \n Please try again " + e.getMessage());
            mainMenu();
        } finally {

        }

    }

    /*********************************************************************
     * Name- indentOutput Date 14/08/2021 Import - message Export - message.
     * Purpose- To indent the output results by increasing the depth.
     *********************************************************************/
    public static String indentOutput(String message, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");

        }
        sb.append(message);
        return sb.toString();
    }

    /*********************************************************************
     * Name- towersOfHanoi Date 14/08/2021 Import - pNumber (int), src (int),
     * dest(int) Export - NONE Purpose- to print the steps to play the game.
     *********************************************************************/
    private static void towersOfHanoi(int pNumber, int src, int dest) {

        int temp = 0;
        if (pNumber < 0) {
            throw new IllegalArgumentException(" \n You cannot enter a negative integer"); // Error if a negative int is
                                                                                           // entered
        } else if (pNumber == 1) {
            System.out.println(indentOutput(("Moving top disk from peg source " + src + " to peg " + dest), DEPTH++)); // base
                                                                                                                       // case
                                                                                                                       // 1.
        } else {
            temp = 6 - src - dest;
            towersOfHanoi(pNumber - 1, src, temp);
            System.out.println(indentOutput(("Moving top disk from peg source " + src + " to peg " + dest), DEPTH++));
            towersOfHanoi(pNumber - 1, temp, dest);

        }

        /*********************************************************************
         * Name- towersOfHanoiWrappers Date 14/08/2021 Import - number (int) Export -
         * NONE Purpose- to get in only valid parameters.
         *********************************************************************/
    }

    public static void towersOfHanoiWrappers(int number) {
        towersOfHanoi(number, 1, 3);
    }

}
