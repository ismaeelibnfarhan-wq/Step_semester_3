public class Top3PodiumFinder {
    public static int[] findTopThreeScores(int[] scores) {
        int[] topThree = new int[3];
        int index = 0;

        for (int i = 0; i < scores.length; i++) {
            if (index < 3) {
                topThree[index++] = scores[i];
            } else {
                int smallestIndex = 0;
                for (int j = 1; j < topThree.length; j++) {
                    if (topThree[j] < topThree[smallestIndex]) {
                        smallestIndex = j;
                    }
                }

                if (scores[i] > topThree[smallestIndex]) {
                    topThree[smallestIndex] = scores[i];
                }
            }
        }

        for (int i = 0; i < topThree.length; i++) {
            for (int j = i + 1; j < topThree.length; j++) {
                if (topThree[i] < topThree[j]) {
                    int temp = topThree[i];
                    topThree[i] = topThree[j];
                    topThree[j] = temp;
                }
            }
        }

        return topThree;
    }

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] top = findTopThreeScores(scores);
        System.out.println(java.util.Arrays.toString(top));
    }
}
