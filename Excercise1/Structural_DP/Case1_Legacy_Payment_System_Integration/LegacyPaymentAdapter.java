public class LegacyPaymentAdapter implements NewPaymentSystem {
    private LegacyPaymentSystem legacySystem;

    public LegacyPaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public void processPayment(String paymentDetails) {
        // Parse the payment details
        String[] details = paymentDetails.split(",");
        double amount = Double.parseDouble(details[0]);
        String accountNumber = details[1];

        // Use the legacy system to make the payment
        legacySystem.makePayment(amount, accountNumber);
    }
}