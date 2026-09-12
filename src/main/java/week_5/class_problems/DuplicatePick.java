public class DuplicatePlayerPickChecker {
    public static void findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equalsIgnoreCase(playerNames[j])) {
                    System.out.println("Duplicate Found: " + playerNames[i]);
                    return;
                }
            }
        }

        System.out.println("No Duplicates Found");
    }

    public static void main(String[] args) {
        String[] players1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        String[] players2 = {"Kohli", "Bumrah", "Rohit"};

        findDuplicatePick(players1);
        findDuplicatePick(players2);
    }
}
