interface PaymentStrategy {
    boolean processPayment(double amount);
}

class CreditCardStrategy implements PaymentStrategy {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing ₹" + amount + " using Credit Card.");
        return true;
    }
}

class CryptoStrategy implements PaymentStrategy {

    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing ₹" + amount + " using Cryptocurrency.");
        return true;
    }
}

class TransactionProcessor {
    private PaymentStrategy strategy;

    public TransactionProcessor(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeTransaction(double amount) {
        if (strategy.processPayment(amount)) {
            System.out.println("Transaction Successful.\n");
        } else {
            System.out.println("Transaction Failed.\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {

        TransactionProcessor processor =
                new TransactionProcessor(new CreditCardStrategy());

        processor.executeTransaction(2500);

        processor.setPaymentStrategy(new CryptoStrategy());

        processor.executeTransaction(5000);
    }
}
