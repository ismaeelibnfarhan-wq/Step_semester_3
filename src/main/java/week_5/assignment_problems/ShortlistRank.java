public class PlacementDriveShortlistingAndRankingEngine {
    public static class Candidate implements Comparable<Candidate> {
        String name;
        double cgpa;
        int codingScore;

        Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public int compareTo(Candidate other) {
            if (this.cgpa != other.cgpa) {
                return Double.compare(other.cgpa, this.cgpa);
            }
            return Integer.compare(other.codingScore, this.codingScore);
        }
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        java.util.Arrays.sort(candidates);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < candidates.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append((i + 1)).append(". ").append(candidates[i].name).append(" (" + candidates[i].cgpa + ")");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        System.out.println(shortlistAndRank(candidates));
    }
}
