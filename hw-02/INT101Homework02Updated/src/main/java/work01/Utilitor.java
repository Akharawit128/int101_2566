package work01;

public class Utilitor {

    public String testString(String value) {
        if (value == null) {
            throw new NullPointerException("Value cannot be null");
        } else if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("Value cannot be a blank string");
        }
        return value;
    }

    public double testPositive(double value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be a positive number");
        }
        return value;
    }

    public static long computeIsbn10(long isbn10) {
        int sum = 0;
        int weight = 10;

        while (isbn10 > 0) {
            int digit = (int) (isbn10 % 10);
            sum += digit * weight;
            isbn10 /= 10;
            weight--;
        }

        int checkDigit = (11 - (sum % 11)) % 11;
        return checkDigit;
    }
}
