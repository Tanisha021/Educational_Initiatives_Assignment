public class PaymentProcessor {
    private NewPaymentSystem paymentSystem;

    public PaymentProcessor(NewPaymentSystem paymentSystem) {
        this.paymentSystem = paymentSystem;
    }

    public void processPayment(String paymentDetails) {
        paymentSystem.processPayment(paymentDetails);
    }
}