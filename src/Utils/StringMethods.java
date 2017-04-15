package Utils;

/**
 * Created by YUNUS on 15.04.2017.
 */
public class StringMethods {
    public static int WordCount(String input) {
        if (input == null) return -1;
        return input.split(" ").length;
    }
}
