public class Question3 {
    public static void findLongestStreak(String signalLog) {
        char bestColor = ' ';
        int bestLength = 0;

        char currentColor = ' ';
        int currentLength = 0;

        for (int i = 0; i < signalLog.length(); i++) {
            char ch = signalLog.charAt(i);

            if (ch == currentColor) {
                currentLength++;
            } else {
                currentColor = ch;
                currentLength = 1;
            }

            if (currentLength > bestLength) {
                bestLength = currentLength;
                bestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + bestColor + "' repeated " + bestLength + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}
