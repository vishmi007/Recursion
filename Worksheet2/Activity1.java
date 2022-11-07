
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date:  14th August 2021                                    
 * Purpose: To take an input from the user and calculate the factorial and the fibonacci of the integer..                    
 *********************************************************************************************************/
import java.util.*;

class Activity1 {
    public static void main(String args[]) {
        // A welcome message to the user.
        System.out.println(" Welcome to the program that calculates Factorial and Fibonacci of an Integer");
        mainMenu();

    }

    class MyExceptionHandler extends Exception // Building my own exception handler.
    {
        public MyExceptionHandler(String message) {
            super(message);
        }

    }

    /*********************************************************************
     * Name- mainMenu Date 14/08/2021 import - None Export - None Purpose- To print
     * the menu of the program.
     *********************************************************************/
    public static void mainMenu() {
        int inputChoice = 0;
        int number = 0;
        long startTime = 0;

        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("   Please choose what you want to do \n NOTE :press either number 1,2,3");
            System.out.println(
                    "   >>>>>>> 1. Caclculate the factorial of an integer \n >>>>>>> 2. Calculate the fibonacci of an integer. \n >>>>>>> 3. Exit");
            inputChoice = sc.nextInt();
            if (inputChoice < 0) {
                // gives an error message when a negative number is inserted as the choice.
                throw new IllegalArgumentException(" \n Your choice cannot be a negative integer");

            } else {

                switch (inputChoice) {
                    case 1: {
                        System.out.println("Please enter a valid integer \n NOTE : Should be a positive integer.");
                        number = sc.nextInt();
                        startTime = System.nanoTime();
                        factorialWrapper(number);
                        long endTime = System.nanoTime();
                        // The run time was calculated according to the test harness given to us in
                        // worksheet one.
                        int runningTotal = (int) ((double) (endTime - startTime) / 1000.0);
                        System.out.println("\nTotal runtime for your method is: " + runningTotal + "ms");

                        mainMenu();
                        break;
                    }
                    case 2:
                        System.out.println("Please enter a valid integer \n NOTE : Should be a positive integer.");
                        number = sc.nextInt();
                        startTime = System.nanoTime();
                        fibonacciWrapper(number);
                        long endTime = System.nanoTime();
                        // The run time was calculated according to the test harness given to us in
                        // worksheet one.
                        int runningTotal = (int) ((double) (endTime - startTime) / 1000.0);
                        System.out.println("\nTotal runtime for your method is: " + runningTotal + "ms");

                        mainMenu();
                        break;
                    case 3:
                        System.out.println("Goodbye have a nice day !!!!!");
                        break;
                    default:
                        System.out.println("Please enter a valid integer!!!!!");
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

        sc.close();

    }

    /*********************************************************************
     * Name- factorial Date 14/08/2021 import - pNumber Export - output Purpose- To
     * calculate the factorial of a number.
     ******************************************************************/

    private static int factorial(int pNumber) {
        int output = 1;

        if (pNumber < 0) {
            throw new IllegalArgumentException(" \n The input cannot be negative");// gives an error when a negative
                                                                                   // number is inserted.

        } else if (pNumber == 0) // The base case
        {
            output = 1;

        } else {
            output = pNumber * factorial(pNumber - 1);
            // System.out.println(output);
        }

        return output;
    }

    /*********************************************************************
     * Name- Fibonacci Date 14/08/2021 import - number Export - answer Purpose- To
     * calculate the fibonacci value of an integer.
     ******************************************************************/

    private static int Fibonacci(int pNumber) {
        int answer = 0;

        if (pNumber < 0) { // base case one
            throw new IllegalArgumentException(
                    " \n The input cannot be negative"); /*
                                                          * gives an error message when negative number is inserted
                                                          */

        } else if (pNumber == 0) { // base case One
            answer = 0;
        } else if (pNumber == 1) { // Base Case two2
            answer = 1;

        } else {
            answer = Fibonacci(pNumber - 1) + Fibonacci(pNumber - 2);

        }
        return answer;
    }

    /*********************************************************************
     * Name- factorialWrapper Date - 14/08/2021 import - inputNumber Export -
     * inputNumber Purpose- To wrap the fibonacci method so that incorrect parameter
     * values are not passed.
     *******************************************************************************/

    public static void factorialWrapper(int inputNumber) {
        factorial(inputNumber);
        System.out.println("The Factorial of " + inputNumber + " is " + factorial(inputNumber));
    }

    /*********************************************************************
     * Name- fibonacciWrapper Date - 14/08/2021 import - pinputs Export - pinputs
     * Purpose- To wrap the fibonacci method so that incorrect parameter values are
     * not passed.
     *******************************************************************************/

    public static void fibonacciWrapper(int pinputs) {
        Fibonacci(pinputs);
        System.out.println("The Fibonacci of " + pinputs + " is " + Fibonacci(pinputs));

    }

}