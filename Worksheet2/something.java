import java.util.Scanner;

public class something {
    public static void main(String[] args) {
        // Displaying welcome message
        System.out.println("Welcome to the Number conversion program implemented using recursive. ");
        mainMenu();
    }

    public static void mainMenu() {
        try {
            long endTime = 0;
            long startTime = 0;
            int runningTotal = 0;

            int menuSelect;
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("\nPlease make a selection from the Menu below");
                System.out.println("> 1. Number conversions \n> 2. Exit program");
                menuSelect = sc.nextInt();
                switch (menuSelect) // switch case for the factorial and fianocci selection
                {
                    case 1:
                        System.out.println("Please enter any decimal number: ");
                        int deciNum = sc.nextInt();

                        System.out.println("Enter the base to be converted to:");
                        int base = sc.nextInt();

                        startTime = System.nanoTime();
                        endTime = System.nanoTime();
                        runningTotal += (int) ((double) (endTime - startTime) / 1000.0);
                        System.out.println("Total runtime taken by the recursive method is: " + runningTotal + "ms");
                        break;

                    case 2:
                        System.out.println("This is the end of the program. Have a nice day!!");
                        break;

                    default:
                        System.err.println("Please enter valid input and try again!");
                        break;
                }
            } while (menuSelect != 2); // looping the main menu with the do while loop
        } catch (Exception e) {
            System.out.println("Something is wrong. Please try again! " + e.getMessage());
            mainMenu(); // Calling main menu
        }
    }

    /*************************************************************************
     * METHOD: numberConverter IMPORTS: deciNum, base EXPORTS: answer PURPOSE:
     * calculates the decimal number accordingly to the base entered.
     *************************************************************************/

    private static String numberConverter(int deciNum, int base) {
        int quotient = 0;
        int remainder = 0;
        quotient = deciNum / base;
        remainder = deciNum % base;
        String answer = "";
        if (base == 2 || base == 8) {
            System.out.println("The decimal value in base " + base + " is: " + numberConverterWrapper(deciNum, base));
        }
        if (deciNum < 0) // To check if the entered value is positive
        {
            throw new IllegalArgumentException("Import must not be negative."); // Throws an exception if not positive
        }
        if (base == 6) {
            if (deciNum == 0) {
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
                        answer = numberConverter(quotient, base) + Integer.toString(remainder);
                        break;
                }
            }
        } else if (quotient == 0) // base case
        {
            answer = Integer.toString(remainder);
        } else {
            answer = numberConverter(quotient, base) + Integer.toString(remainder);
        }
        return answer;
    }

    public static String numberConverterWrapper(int deciNum, int base) // Wrapper method for nuumber conversion
    {
        if (base > 16) // To check if the value is less than 0
        {
            throw new IllegalArgumentException("Import must not be negative.");
        }
        return numberConverter(deciNum, base);
    }
}
