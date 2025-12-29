public class SplitIntoThousand {

    public static Stack splitIntoThousand(int num) {

        // Max chunks for int is small (billion → 4 chunks)
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
