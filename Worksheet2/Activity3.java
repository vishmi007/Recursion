
/*********************************************************
 * Author: Vishmi Kalansooriya                               
 * Date:  14th August 2021                                    
 * Purpose: To take an input from the user and convert the number in to the user desired base.                    
 *********************************************************************************************************/
import java.util.*;

class Activity3 {
    public static void main(String args[]) {
        System.out.println("Welcome to the program that takes in a number and converts it to a desired base .");
        mainMenu();

    }

    class MyExceptionHandler extends Exception // Building my own exception handler.
    {
        public MyExceptionHandler(String message) {
            super(message);
        }

    }

    public static void mainMenu() {
        Scanner sc = new Scanner(System.in);
        int number = 0;
        int base = 0;
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
                        System.out.println(
                                " >>Please enter the number and the base that you want the number to be converted to");
                        System.out.println(" >>>>Enter the number \n Note that only positive integers can be entered.");
                        number = sc.nextInt();
                        if (number < 0) {
                            throw new IllegalArgumentException(" \n You cannot enter a negative integer");

                        }
                        System.out.println(" >>>>Enter the base  \n Note that only positive integers can be entered.");
                        base = sc.nextInt();
                        if (base < 0) {
                            throw new IllegalArgumentException(" \n You cannot enter a negative integer");
                        }
                        numberConvertionsWrapper(number, base);
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

    private static String numberConvertions(int pNumber, int pBase) {
        String answer;
        int quotient = 0;
        quotient = pNumber / pBase;
        int remainder = 0;
        remainder = pNumber % pBase;
        // if (pBase != 2 || pBase != 8 || pBase != 16) {
        // throw new IllegalArgumentException(" Please input bases 2,8 and 16 only
        // \nPlease try again.");
        // }
        if (pNumber < 0) {
            throw new IllegalArgumentException("Your choice cannot be negative \nPlease try again.");
        }
        if (pBase == 16) {
            if (pNumber == 0) {
                answer = "";
            } else {
                switch (remainder) {
                    case 10:
                        answer = "A";
                        break;
                    case 11:
                        answer = "B";
                        break;
                    case 12:
                        answer = "C";
                        break;
                    case 13:
                        answer = "D";
                        break;
                    case 14:
                        answer = "E";
                        break;
                    case 15:
                        answer = "F";
                        break;
                    default:
                        answer = numberConvertions(quotient, pBase) + Integer.toString(remainder);
                        break;
                }
            }
        } else if (quotient == 0) {
            answer = Integer.toString(remainder);

        } else {
            answer = numberConvertions(quotient, pBase) + Integer.toString(remainder);
        }
        return answer;

    }

    public static void numberConvertionsWrapper(int pNumber, int pBase) {
        numberConvertions(pNumber, pBase);
        System.out.println(pNumber + " to the base " + pBase + " is " + numberConvertions(pNumber, pBase));
    }
}