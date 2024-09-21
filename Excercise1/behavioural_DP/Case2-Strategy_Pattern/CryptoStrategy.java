public class CryptoStrategy implements PaymentStrategy {
    private String walletAddress;

    public CryptoStrategy(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid using Cryptocurrency");
    }
}