package BankingSystem;
import java.io.Serializable;
class Account implements Serializable{
    private String number;
    private float amount;
    private Client acHolder;
    private static int count = 1;

    public Account(float amount, Client acHolder) {
        this.number = "ACC" + count++;
        this.amount = amount;
        this.acHolder = acHolder;
    }

    // getters and setters


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Client getAcHolder() {
        return acHolder;
    }

    public void setAcHolder(Client acHolder) {
        this.acHolder = acHolder;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Account.count = count;
    }

    public float withdraw(float amount) {
        if (this.amount >= amount) {
            this.amount -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
        return this.amount;
    }

    public float deposit(float amount) {
        this.amount += amount;
        return this.amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", amount=" + amount +
                ", acHolder=" + acHolder +
                '}';
    }
}