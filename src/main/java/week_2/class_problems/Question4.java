public class Question4 {
    public static String maskPhoneNumber(String phone) {
        if (phone.length() != 10 || !phone.matches("\\d+")) {
            return "Invalid phone number";
        }

        StringBuilder masked = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            masked.append('X');
        }

        masked.append(phone.substring(6));
        return masked.toString();
    }

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
    }
}
