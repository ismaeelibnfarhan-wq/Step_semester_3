import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem4 {

    static abstract class Question {
        protected String type;
        protected String questionText;
        protected String correctAnswer;
        protected String studentAnswer;
        protected int points;

        public Question(String type, String questionText, String correctAnswer, String studentAnswer, int points) {
            this.type = type;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String getType() {
            return type;
        }

        public abstract double evaluateScore();
    }

    static class McqQuestion extends Question {
        public McqQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("MCQ", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double evaluateScore() {
            if (studentAnswer.trim().equals(correctAnswer.trim())) {
                return points;
            }
            return 0.0;
        }
    }

    static class TfQuestion extends Question {
        public TfQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("TF", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double evaluateScore() {
            if (studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim())) {
                return points;
            }
            return 0.0;
        }
    }

    static class EssayQuestion extends Question {
        public EssayQuestion(String questionText, String correctAnswer, String studentAnswer, int points) {
            super("ESSAY", questionText, correctAnswer, studentAnswer, points);
        }

        @Override
        public double evaluateScore() {
            String[] keywords = correctAnswer.split(",");
            String studentLower = studentAnswer.toLowerCase();

            int matchedCount = 0;
            for (String kw : keywords) {
                String trimmedKw = kw.trim().toLowerCase();
                if (!trimmedKw.isEmpty() && studentLower.contains(trimmedKw)) {
                    matchedCount++;
                }
            }

            if (matchedCount >= 2) {
                return points * 0.75;
            } else if (matchedCount == 1) {
                return points * 0.50;
            } else {
                return 0.0;
            }
        }
    }

    private static List<String> parseTokens(String line) {
        List<String> tokens = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(\\S+)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(matcher.group(1));
            } else {
                tokens.add(matcher.group(2));
            }
        }
        return tokens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()) {
            return;
        }

        String firstLine = scanner.nextLine().trim();
        while (firstLine.isEmpty() && scanner.hasNextLine()) {
            firstLine = scanner.nextLine().trim();
        }
        int n = Integer.parseInt(firstLine);

        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!scanner.hasNextLine()) {
                break;
            }
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                i--;
                continue;
            }

            List<String> tokens = parseTokens(line);
            if (tokens.size() < 5) {
                continue;
            }

            String type = tokens.get(0);
            String questionText = tokens.get(1);
            String correctAnswer = tokens.get(2);
            String studentAnswer = tokens.get(3);
            int points = Integer.parseInt(tokens.get(4));

            if (type.equalsIgnoreCase("MCQ")) {
                questions.add(new McqQuestion(questionText, correctAnswer, studentAnswer, points));
            } else if (type.equalsIgnoreCase("TF")) {
                questions.add(new TfQuestion(questionText, correctAnswer, studentAnswer, points));
            } else if (type.equalsIgnoreCase("ESSAY")) {
                questions.add(new EssayQuestion(questionText, correctAnswer, studentAnswer, points));
            }
        }

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            System.out.printf("%s: %.2f%n", q.getType(), score);
            totalScore += score;
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }
}
