import java.util.HashMap;
import java.util.Map;

public class Question4 {
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency.get(ch) == 1) {
                return ch;
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String text1 = "swiss";
        char result1 = findFirstNonRepeatingChar(text1);
        if (result1 == ' ') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result1 + "'");
        }

        String text2 = "aabbcc";
        char result2 = findFirstNonRepeatingChar(text2);
        if (result2 == ' ') {
            System.out.println("No Non-Repeating Character Found");
        } else {
            System.out.println("First Non-Repeating Character: '" + result2 + "'");
        }
    }
}
