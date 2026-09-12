public class MatchDayGridAnalyzer {
    public static double rowAverage(int[] row) {
        int total = 0;

        for (int value : row) {
            total += value;
        }

        return total / (double) row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double average = rowAverage(runsPerOver[i]);
            if (average > threshold) {
                result.append("Match ").append(i).append(": Power Surge");
            } else {
                result.append("Match ").append(i).append(": Normal");
            }

            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] matches = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };

        System.out.println(classifyMatches(matches, 8));
    }
}
