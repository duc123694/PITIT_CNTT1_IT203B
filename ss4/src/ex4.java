public class ex4 {
    public String evaluatePasswordStrength(String password) {
        if (password == null || password.length() < 8) {
            return "Yếu";
        }
        boolean hasUpper = password.matches(".*[A-Z].*"); // có chữ hoa
        boolean hasLower = password.matches(".*[a-z].*"); // có chữ thường
        boolean hasDigit = password.matches(".*[0-9].*"); // có số
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*"); // có ký tự đặc biệt

        int count = 0;
        if (hasUpper) count++;
        if (hasLower) count++;
        if (hasDigit) count++;
        if (hasSpecial) count++;

        if (count == 4) {
            return "Mạnh";
        }

        if (count == 3) {
            return "Trung bình";
        }

        return "Yếu";
    }
}