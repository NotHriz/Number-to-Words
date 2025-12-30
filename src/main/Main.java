import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        // Get user input
        System.out.println("Welcome to Number to Words Converter!");
        System.out.print("Please enter your number (-9,223,372,036,854,775,808 to 9,223,372,036,854,775,807): ");

        // Validate User input
        long number;
        while (true) {
                try (Scanner scan = new Scanner(System.in)) {
                number = scan.nextLong();
                if (number < Long.MIN_VALUE || number > Long.MAX_VALUE) {
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
        // Scales for the thousand groups
        String[] scales = {"", "Thousand", "Million", "Billion", "Trillion", "Quadrillion"};

        while(!stack.isEmpty()) {
            int threeDigitGroup = stack.pop();
            if (threeDigitGroup != 0) {
                String words = ThreeDigitConversion.convertThreeDigits(threeDigitGroup);
                String scale = scales[stack.size];
                result.append(words).append(" ").append(scale).append(" ");
            }
        }
        System.out.println(result.toString());
    }
}