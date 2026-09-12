public class Question4 {
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        for (int value : sectionA) {
            totalA += value;
        }

        for (int value : sectionB) {
            totalB += value;
        }

        int highestValue = sectionA[0];
        int highestIndex = 0;

        for (int i = 1; i < sectionA.length; i++) {
            if (sectionA[i] > highestValue) {
                highestValue = sectionA[i];
                highestIndex = i;
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            if (sectionB[i] > highestValue) {
                highestValue = sectionB[i];
                highestIndex = i;
            }
        }

        if (totalA == totalB) {
            System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: Balanced | Highest Quantity: " + highestValue + " (Section " + (highestIndex < sectionA.length ? "A" : "B") + ", Item " + (highestIndex < sectionA.length ? highestIndex + 1 : highestIndex - sectionA.length + 1) + ")");
        } else {
            System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: Not Balanced | Highest Quantity: " + highestValue + " (Section " + (highestIndex < sectionA.length ? "A" : "B") + ", Item " + (highestIndex < sectionA.length ? highestIndex + 1 : highestIndex - sectionA.length + 1) + ")");
        }
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
