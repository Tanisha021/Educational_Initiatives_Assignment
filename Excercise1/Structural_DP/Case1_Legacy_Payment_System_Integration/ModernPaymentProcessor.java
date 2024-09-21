public class ModernPaymentProcessor implements NewPaymentSystem {
    @Override
    public void processPayment(String paymentDetails) {
        System.out.println("Processing payment with modern system: " + paymentDetails);
    }
}