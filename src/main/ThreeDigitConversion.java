public class ThreeDigitConversion {
  public static String convertThreeDigits(int number) {
    // Objective: convert a number to word from 0 to 999 into words
    // base case
    if (number == 0) {
        return "";
    }
    // case 1: numbers < 20
    if (number < 20) {
      return LanguageData.ONES.get(number);
    }
    // case 2: number < 100
    if (number < 100) {
      return LanguageData.TENS.get(number / 10) + (number % 10 != 0 ? " " + convertThreeDigits(number % 10) : "");
    }
    // case 3: number >= 100
    return LanguageData.ONES.get(number / 100) + " Hundred" + (number % 100 != 0 ? " " + convertThreeDigits(number % 100) : "");
    
  } 
}
