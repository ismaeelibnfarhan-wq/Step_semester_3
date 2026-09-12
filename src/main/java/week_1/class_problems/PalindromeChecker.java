public class Question2 {
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] chars = text.toCharArray();
        char[] reversed = new char[chars.length];

        for (int i = 0; i < chars.length; i++) {
            reversed[i] = chars[chars.length - 1 - i];
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "madam";
        System.out.println("Iterative: " + isPalindromeIterative(input) + " | Recursive: " + isPalindromeRecursive(input) + " | Array Reversal: " + isPalindromeArrayReversal(input));

        String input2 = "hello";
        System.out.println("Iterative: " + isPalindromeIterative(input2) + " | Recursive: " + isPalindromeRecursive(input2) + " | Array Reversal: " + isPalindromeArrayReversal(input2));
    }
}
