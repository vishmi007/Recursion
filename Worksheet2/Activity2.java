
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date:  14th August 2021                                    
 * Purpose: To take an input from the user and calculate the factorial and the fibonacci of the integer..                    
 *********************************************************************************************************/
import java.util.*;

class Activity2 {
    public static void main(String args[]) {
        System.out.println("Welcome to the program that calculates the Greatest Common denominator of two integers.");
        mainMenu();

    }

    /*********************************************************************
     * Name- mainMenu Date 14/08/2021 import - None Export - None Purpose- To print
     * the menu of the program.
     ******************************************************************/

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int inputOne = 0;
        int inputTwo = 0;
        int userChoice = 0;
        try {
            System.out.println("Please select an option from the below two options \n Note : press 1 or 2");
            System.out.println(" >> 1.Calculate the greatest common denominator of two numbers. \n >> 2.Exit");
            userChoice = sc.nextInt();
            if (userChoice < 0) {
                // gives an error message when a negative number is inserted as the choice.
                throw new IllegalArgumentException(" \n Your choice cannot be a negative integer");

            } else {
                switch (userChoice) {

                    case 1:
                        System.out.println(
                                " >>Please enter  two integers to calculate the GCD (Greates Common Denominator )");
                        System.out.println(" >>>>Enter number ONE \n Note that only positive integers can be entered.");
                        inputOne = sc.nextInt();
                        if (inputOne < 0) {
                            throw new IllegalArgumentException(" \n You cannot enter a negative integer");

                        }
                        System.out.println(" >>>>Enter number TWO \n Note that only positive integers can be entered.");
                        inputTwo = sc.nextInt();
                        if (inputTwo < 0) {
                            throw new IllegalArgumentException(" \n You cannot enter a negative integer");
                        }
                        GCDWrapper(inputOne, inputTwo);
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

    class MyExceptionHandler extends Exception // Building my own exception handler.
    {
        public MyExceptionHandler(String message) {
            super(message);
        }

    }

    /*********************************************************************
     * Name- greatestCommonDenominator Date 14/08/2021 import - number1 (int),
     * number2(int) Export - None Purpose- To print the menu of the program.
     ******************************************************************/

    private static int greatestCommonDenominator(int number1, int number2) {
        int output = 0;
        if ((number1 < 0) || (number2 < 0)) {
            throw new IllegalArgumentException(" \n The input cannot be negative");// gives an error when a negative
            // number is inserted.

        } else if ((number1 == 0) && (number2 == 0)) // base case 1
        {
            output = 0;
        } else if (number1 == 0) // base case 2
        {
            output = number2;
        } else if (number2 == 0) // base case 3
        {
            output = number1;
        } else if (number1 == number2) // base case 4
        {
            output = number1;
        } else if (number1 > number2) {
            output = greatestCommonDenominator(number1 - number2, number2);
        } else {
            output = greatestCommonDenominator(number1, number2 - number1);
        }
        return output;

    }

    /*********************************************************************
     * Name- GCDWrapper Date - 14/08/2021 import - numberOne Export - numberTwo
     * Purpose- To wrap the fibonacci method so that incorrect parameter values are
     * not passed.
     *******************************************************************************/

    public static void GCDWrapper(int numberOne, int numberTwo) {
        greatestCommonDenominator(numberOne, numberTwo);
        System.out.println("The greatest common denominator of " + numberOne + " and " + numberTwo + " is "
                + greatestCommonDenominator(numberOne, numberTwo));
    }
}
