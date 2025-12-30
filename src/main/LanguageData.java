import java.util.HashMap;
public class LanguageData {
    public static final HashMap<Integer, String> ONES = new HashMap<>();
    public static final HashMap<Integer, String> TENS = new HashMap<>();

    static {
        ONES.put(0, "Zero");
        ONES.put(1, "One");
        ONES.put(2, "Two");
        ONES.put(3, "Three");
        ONES.put(4, "Four");
        ONES.put(5, "Five");
        ONES.put(6, "Six");
        ONES.put(7, "Seven");
        ONES.put(8, "Eight");
        ONES.put(9, "Nine");
        ONES.put(10, "Ten");
        ONES.put(11, "Eleven");
        ONES.put(12, "Twelve");
        ONES.put(13, "Thirteen");
        ONES.put(14, "Fourteen");
        ONES.put(15, "Fifteen");
        ONES.put(16, "Sixteen");
        ONES.put(17, "Seventeen");
        ONES.put(18, "Eighteen");
        ONES.put(19, "Nineteen");

        TENS.put(2, "Twenty");
        TENS.put(3, "Thirty");
        TENS.put(4, "Forty");
        TENS.put(5, "Fifty");
        TENS.put(6, "Sixty");
        TENS.put(7, "Seventy");
        TENS.put(8, "Eighty");
        TENS.put(9, "Ninety");
    }
    
}
