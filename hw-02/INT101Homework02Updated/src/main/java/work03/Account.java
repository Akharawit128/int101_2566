package work03;

import work01.Utilitor;
import work02.Person;

public class Account {

    private static long nextNo = 100_000_000;
    private final long no = 0;
    private Person owner;
    private double balance;

    public Account(Person owner) {
        if (owner == null) {
            throw new NullPointerException("Owner cannot be null");
        }

        this.owner = owner;
        this.balance = 0.0;

        long tempNo;
        do {
            long result = Utilitor.computeIsbn10(nextNo);
            while (result == 10) {
                nextNo++;
                result = Utilitor.computeIsbn10(nextNo);
            }

            tempNo = 10 * nextNo + result;
            nextNo++;
        } while (Utilitor.computeIsbn10(this.no) == 10);
        this.no = tempNo;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount) {

        Utilitor util = new Utilitor();
        util.testPositive(amount);

        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {

        Utilitor util = new Utilitor();
        util.testPositive(amount);

        if (balance - amount >= 0) {
            balance -= amount;
        }

        return balance;
    }

    public void transfer(double amount, Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account to transfer to cannot be null");
        }

        double withdrawnAmount = withdraw(amount);
        account.deposit(withdrawnAmount);
    }

    @Override
    public String toString() {
        return "Account(" + no + "," + balance + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return false;
    }
}
