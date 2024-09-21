public class PaymentDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentStrategy(new CreditCardStrategy("John Doe", "1234567890123456", "786", "12/2025"));
        cart.checkout(100);

        cart.setPaymentStrategy(new PayPalStrategy("johndoe@example.com", "mypaypalpassword"));
        cart.checkout(200);

        cart.setPaymentStrategy(new CryptoStrategy("0x742d35Cc6634C0532925a3b844Bc454e4438f44e"));
        cart.checkout(300);
    }
}