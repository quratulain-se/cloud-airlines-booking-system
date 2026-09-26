package backend;

public class PaymentManager {

    // Simple validation-only "payment" processor - no real payment
    // gateway is involved, this just checks the card details look complete
    // and reasonably formatted.
    public static boolean processCardPayment(String bank, String account, String cardNumber,
                                              String expiry, String cvv) {
        if (isBlank(bank) || isBlank(account) || isBlank(cardNumber)
                || isBlank(expiry) || isBlank(cvv)) {
            return false;
        }

        String digitsOnlyCard = cardNumber.replaceAll("[\\s-]", "");
        if (!digitsOnlyCard.matches("\\d{12,19}")) {
            return false;
        }

        if (!cvv.matches("\\d{3,4}")) {
            return false;
        }

        return true;
    }

    private static boolean isBlank(String value) {
        return value == null || value.trim().isEmpty();
    }
}