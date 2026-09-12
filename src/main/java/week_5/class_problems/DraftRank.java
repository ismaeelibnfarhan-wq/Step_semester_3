import java.util.Arrays;

public class FantasyLeagueAutoDraftRankingEngine {
    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage;
        boolean injured;

        Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        public int compareTo(Player other) {
            if (this.battingAverage > other.battingAverage) {
                return -1;
            } else if (this.battingAverage < other.battingAverage) {
                return 1;
            }
            return 0;
        }

        boolean isDraftable() {
            return matchesPlayed >= 10 || battingAverage >= 30;
        }

        boolean isDraftable(int minimumMatches) {
            return matchesPlayed >= minimumMatches;
        }
    }

    static String draftAndRank(Player[] players) {
        Arrays.sort(players);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < players.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append((i + 1)).append(". ").append(players[i].name);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}
