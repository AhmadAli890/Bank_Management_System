package BankingSystem;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
class Bank implements Serializable {
    private String name;
    private List<Client> clList;
    private List<Account> acList;

    public Bank(String name) {
        this.name = name;
        this.clList = new ArrayList<>();
        this.acList = new ArrayList<>();
    }

    // getters and setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClList() {
        return clList;
    }

    public void setClList(List<Client> clList) {
        this.clList = clList;
    }

    public List<Account> getAcList() {
        return acList;
    }

    public void setAcList(List<Account> acList) {
        this.acList = acList;
    }

    public Client addClient(Person p) {
        Client client = new Client(p);
        clList.add(client);
        return client;
    }

    public Account addAccount(float amount, Client c) {
        Account account = new Account(amount, c);
        acList.add(account);
        c.addAccount(account);
        return account;
    }

    public Account searchAccount(String id) {
        for (Account account : acList) {
            if (account.getNumber().equals(id)) {
                return account;
            }
        }
        return null;
    }
    // Save bank data to a file
    public void saveBankData(String filename) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(this);
            System.out.println("Bank data saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving bank data: " + e.getMessage());
        }
    }
    // Load bank data from a file
    public static Bank loadBankData(String filename) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Bank bank = (Bank) inputStream.readObject();
            System.out.println("Bank data loaded successfully.");
            return bank;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading bank data: " + e.getMessage());
            return null;
        }
    }

    public boolean removeClient(String id) {
        Client clientToRemove = null;
        for (Client client : clList) {
            if (Integer.toString(client.getId()).equals(id)) {
                clientToRemove = client;
                break;
            }
        }
        if (clientToRemove != null) {
            clList.remove(clientToRemove);
            Client finalClientToRemove = clientToRemove;
            acList.removeIf(account -> account.getAcHolder() == finalClientToRemove);
            return true;
        }
        return false;
    }

    public float totalAmount() {
        float total = 0;
        for (Account account : acList) {
            total += account.getAmount();
        }
        return total;
    }

    public Client searchCustomerDetail(String cnic) {
        for (Client client : clList) {
            if (client.getPersonDetails().getCnic().equals(cnic)) {
                return client;
            }
        }
        return null;
    }


    public void client_from_File() throws IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\Banking System\\src\\BankingSystem\\clients.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        clList=(ArrayList<Client>) ois.readObject();
        ois.close();
        fis.close();
    }


    public void Client_To_File() throws IOException
    {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Desktop\\Banking System\\src\\BankingSystem\\clients.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(clList);
        oos.close();
        fos.close();
    }

    public void ACC_from_File() throws IOException, ClassNotFoundException{
        FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\Desktop\\Banking System\\src\\BankingSystem\\accounts.txt");
        ObjectInputStream ois=new ObjectInputStream(fis);
        acList=(ArrayList<Account>) ois.readObject();
        ois.close();
        fis.close();
    }


    public void ACC_To_File() throws IOException
    {
        FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Desktop\\Banking System\\src\\BankingSystem\\accounts.txt");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(acList);
        oos.close();
        fos.close();
    }
    @Override
    public String toString() {
        int numClients = clList.size();
        int numAccounts = acList.size();
        float totalAmount = totalAmount();

        StringBuilder result = new StringBuilder("Bank Details:\n");
        result.append("Number of Clients: ").append(numClients).append("\n");
        result.append("Number of Accounts: ").append(numAccounts).append("\n");
        result.append("Total Amount in the Bank: ").append(totalAmount).append("\n");

        return result.toString();
    }
}
