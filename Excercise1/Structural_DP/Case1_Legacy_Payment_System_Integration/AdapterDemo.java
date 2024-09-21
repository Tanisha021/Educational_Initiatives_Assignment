public class AdapterDemo {
    public static void main(String[] args) {
        // Using the modern payment system
        NewPaymentSystem modernSystem = new ModernPaymentProcessor();
        PaymentProcessor modernProcessor = new PaymentProcessor(modernSystem);
        modernProcessor.processPayment("100.00,1234567890");

        System.out.println();

        // Using the legacy payment system through the adapter
        LegacyPaymentSystem legacySystem = new LegacyPaymentSystem();
        NewPaymentSystem legacyAdapter = new LegacyPaymentAdapter(legacySystem);
        PaymentProcessor legacyProcessor = new PaymentProcessor(legacyAdapter);
        legacyProcessor.processPayment("200.00,9876543210");
    }
}