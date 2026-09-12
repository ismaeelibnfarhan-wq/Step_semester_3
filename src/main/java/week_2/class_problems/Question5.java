public class Question5 {
    public static String normalizeReference(String raw) {
        return raw.trim();
    }

    public static String validateAndFormat(String reference) {
        String code = normalizeReference(reference).toUpperCase();

        if (code.length() != 14) {
            return "Invalid: wrong length";
        }

        if (!Character.isLetter(code.charAt(0)) || !Character.isLetter(code.charAt(1)) || !Character.isLetter(code.charAt(2))) {
            return "Invalid: non-letter bank code";
        }

        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        return "[" + code.substring(0, 3) + "] DATE: " + code.substring(3, 5) + "/" + code.substring(5, 7) + "/" + code.substring(7, 9) + " | SEQ: " + code.substring(9);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" hdf03022600042 "));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}
