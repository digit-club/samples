package app;

public class Bank {

    static double balance = 100;
    static double comission = 3; //%

    public static void main(String[] args) {
        withdraw(50);
        withdraw(50);
    }

    static void withdraw(double amount) {
        double fee = comission / 100 * amount;
        if ((amount + fee) > balance) {
            System.out.println("CANCELLED. Not enough money. Balance: $" + balance + ".");
        } else {
            balance = balance - amount - fee;
            System.out.println("OK. Fee: $" + fee + ". Balance: $" + balance);
        }
    }

}
