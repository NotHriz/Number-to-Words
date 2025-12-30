import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        // Get user input
        System.out.println("Welcome to Number to Words Converter!");
        System.out.print("Please enter your number (-2,147,483,648 to 2,147,483,648): ");

        // Validate User input
        int number;
        while (true) {
                try (Scanner scan = new Scanner(System.in)) {
                number = scan.nextInt();
                if (number < -2147483648L || number > 2147483648L) {
                    System.out.println("Error: Number out of range.");
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a valid integer.");
                continue;
            }

            break;
        }

        // Check if number is zero
        if (number == 0) {
            System.out.println("Zero");
            return;
        }

        // Check if number is negative
        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = Math.abs(number);
        }

        // Split the number into 3 digit groups(thousand)
        Stack stack = new Stack();
        stack = SplitIntoThousand.splitIntoThousand(number);

        // Convert each 3 digit group into words
        StringBuilder result = new StringBuilder();
        // Append "Negative" if the number is negative
        result.append(isNegative ? "Negative " : "");

        // Pop all elements from stack and convert to words
        while(!stack.isEmpty()) {result.append(ThreeDigitConversion.convertThreeDigits(stack.pop())).append(" ");}
        System.out.println(result.toString());
    }
}