public class SplitIntoThousand {

    public static Stack splitIntoThousand(int num) {

        Stack stack = new Stack(10);

        if (num == 0) {
            stack.push(0);
            return stack;
        }

        while (num > 0) {
            stack.push(num % 1000);
            num = num / 1000;
        }

        return stack;
    }
}
