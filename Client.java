package BankingSystem;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
class Client implements Serializable{
    private int id;
    private Person personDetails;
    private List<Account> acList;
    private static int count = 1;

    public Client(Person personDetails) {
        this.id = count++;
        this.personDetails = personDetails;
        this.acList = new ArrayList<>();
    }

    // getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPersonDetails() {
        return personDetails;
    }

    public void setPersonDetails(Person personDetails) {
        this.personDetails = personDetails;
    }

    public List<Account> getAcList() {
        return acList;
    }

    public void setAcList(List<Account> acList) {
        this.acList = acList;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Client.count = count;
    }

    public  Account GETACCOUNT(String acc_no){
        for (Account acc:acList) {
            if (acc.getNumber().equals(acc_no)){
                return acc;
            }
        }
        return null;
    }

    public float totalAmount() {
        float total = 0;
        for (Account account : acList) {
            total += account.getAmount();
        }
        return total;
    }

    public void withdraw(float amount, String accNo) {
        Account account = searchAccount(accNo);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void deposit(float amount, String accNo) {
        Account account = searchAccount(accNo);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found");
        }
    }

    public void addAccount(Account a) {
        acList.add(a);
    }

    public Account searchAccount(String accNo) {
        for (Account account : acList) {
            if (account.getNumber().equals(accNo)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Client{" +
                "id=" + id +
                ", personDetails=" + personDetails +
                "}\nAccounts:\n");
        for (Account account : acList) {
            result.append(account).append("\n");
        }
        return result.toString();
    }

}
