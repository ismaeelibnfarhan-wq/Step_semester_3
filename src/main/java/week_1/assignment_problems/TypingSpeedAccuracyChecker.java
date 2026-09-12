public class Question2 {
    public static void checkTypingAccuracy(String original, String typed) {
        if (original.length() != typed.length()) {
            System.out.println("Length mismatch");
            return;
        }

        int matched = 0;
        int mismatchIndex = -1;

        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (mismatchIndex == -1) {
                mismatchIndex = i;
            }
        }

        double accuracy = (matched * 100.0) / original.length();

        if (mismatchIndex == -1) {
            System.out.println("Matched: " + matched + "/" + original.length() + " | Accuracy: " + accuracy + "% | No Mismatches");
        } else {
            System.out.println("Matched: " + matched + "/" + original.length() + " | Accuracy: " + accuracy + "% | First Mismatch at position " + mismatchIndex + " ('" + typed.charAt(mismatchIndex) + "' vs '" + original.charAt(mismatchIndex) + "')");
        }
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }
}
