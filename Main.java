package BankingSystem;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import java.io.Serializable;

public class Main implements Serializable{
//    private Bank MyBank;
    Bank myBank= new Bank("HEHEHEHEH");
    Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
    JFrame f = new JFrame("BANK MANAGEMENT SYSTEM ");
    boolean is_click= false;
    boolean is_deposit=false;
    boolean is_withdraw=false;
    Font font= new Font("Arial",Font.BOLD,31);
    Font ff= new Font("Arial",Font.BOLD,19);
    public  Main (){
        myBank = Bank.loadBankData("bank_data.ser");
        if (myBank == null) {
            myBank = new Bank("MyBank");
        }
//        try {
//            myBank.client_from_File();
//            myBank.ACC_from_File();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        f.setSize(800,600);
        f.setLayout(null);
        welcomepage();
        f.setVisible(true);
    }
    private void  welcomepage(){
        f.getContentPane().removeAll();
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\DELL\\Desktop\\BMS\\src\\BankingSystem\\vv.jpg");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, f.getWidth(), f.getHeight());

        JLabel l1 = new JLabel("CHILLAR BANK");
        int X = f.getWidth()/2;
        int y = f.getHeight()/2;
        l1.setBounds(X-100,100,400,30);
        l1.setFont(font);
        f.add(l1);


        JButton B1= new JButton("ADD CLIENT ");
        B1.setBounds(100,200,310,33);
        B1.setCursor(handCursor);
        B1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ADD_CLIENT();
            }
        });
        B1.setFont(ff);
        f.add(B1);


        JButton B2= new JButton("ADD ACCOUNT ");
        B2.setBounds(100,250,310,33);
        B2.setCursor(handCursor);
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ADD_ACCOUNT();

            }
        });
        B2.setFont(ff);
        f.add(B2);

        JButton B3= new JButton("PERFORM OPERATIONS ");
        B3.setBounds(100,300,310,33);
        B3.setCursor(handCursor);
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OPERATIONS();

            }
        });
        B3.setFont(ff);
        f.add(B3);
        JButton B4= new JButton("VIEW CURRENT BALANCE ");
        B4.setBounds(100,350,310,33);
        B4.setCursor(handCursor);
        B4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CURRENT_BALANCE();


            }
        });
        B4.setFont(ff);
        f.add(B4);
        JButton B5= new JButton("BANK DETAILS");
        B5.setBounds(100,400,310,33);
        B5.setCursor(handCursor);
        B5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, myBank.toString(), "Bank Details", JOptionPane.INFORMATION_MESSAGE);
                welcomepage();

            }
        });
        B5.setFont(ff);
        f.add(B5);

        JButton B6= new JButton("CLOSE ");
        B6.setBounds(100,450,310,33);
        B6.setCursor(handCursor);
        B6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myBank.Client_To_File();
                    myBank.ACC_To_File();
                    System.exit(0);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        B6.setFont(ff);
        f.add(B6);

//dONT WRITE UNDER
        f.add(backgroundLabel);
        f.revalidate();
        f.repaint();
    }
    private void ADD_CLIENT(){

        f.getContentPane().removeAll();
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\DELL\\Desktop\\BMS\\src\\BankingSystem\\ll.jpg");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, f.getWidth(), f.getHeight());


        JLabel l5 = new JLabel("KINDLY ADD CLIENT INFO:");
        int X = f.getWidth()/2;
        l5.setBounds(X-200,50,400,30);
        l5.setFont(font);
        f.add(l5);


        JLabel l2 = new JLabel("CLIENT NAME");
        l2.setBounds(170,260,200,20);
        f.add(l2);
        l2.setFont(ff);
        JTextField t1 = new JTextField();
        t1.setBounds(470,260,130,30);
        f.add(t1);
        JLabel l3 = new JLabel("PHONE NUMBER");
        l3.setBounds(170,310,200,20);
        l3.setFont(ff);
        f.add(l3);
        JTextField t2 = new JTextField();
        t2.setBounds(470,310,130,30);
        f.add(t2);
        JLabel l4 = new JLabel("CNIC NUMBER");
        l4.setBounds(170,360,200,20);
        l4.setFont(ff);
        f.add(l4);
        JTextField t3 = new JTextField();
        t3.setBounds(470,360,130,30);
        f.add(t3);
        JButton Bb= new JButton("ENTER");
        Bb.setBounds(150,465,200,30);
        Bb.setCursor(handCursor);
        Bb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name= new String(t1.getText());
                String phoneNumber= new String(t2.getText());
                String cnic= new String(t3.getText());

                    if (!name.isEmpty() && !phoneNumber.isEmpty() && !cnic.isEmpty()) {
                        Person person = new Person(name, phoneNumber, cnic);
                        Client client = myBank.addClient(person);
                        JOptionPane.showMessageDialog(null, "Client added successfully. Client ID: " + client, "Success", JOptionPane.INFORMATION_MESSAGE);
                        welcomepage();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter valid client information.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
        });
        f.add(Bb);
        JButton Bc= new JButton("CANCEL");
        Bc.setBounds(450,465,200,30);
        Bc.setCursor(handCursor);
        Bc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomepage();
            }
        });
        f.add(Bc);
        f.add(backgroundLabel);
        f.revalidate();
        f.repaint();
    }
    private void ADD_ACCOUNT(){
        f.getContentPane().removeAll();
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\DELL\\Desktop\\BMS\\src\\BankingSystem\\xx.jpg");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, f.getWidth(), f.getHeight());
        JLabel l5 = new JLabel("KINDLY ADD ACCOUNT INFO:");
        int X = f.getWidth()/2;
        l5.setBounds(X-200,50,500,30);
        l5.setFont(font);
        f.add(l5);
        JLabel l2 = new JLabel("CLIENT ID");
        l2.setBounds(190,200,200,30);
        l2.setFont(ff);
        f.add(l2);
        JTextField t1 = new JTextField();
        t1.setBounds(450,200,160,30);
        f.add(t1);
        JLabel l3 = new JLabel("INITIAL AMOUNT");
        l3.setBounds(190,250,200,30);
        l3.setFont(ff);
        f.add(l3);
        JTextField t2 = new JTextField();
        t2.setBounds(450,250,160,30);
        l3.setFont(ff);
        f.add(t2);
        JButton B2= new JButton("ENTER");
        B2.setBounds(100,450,200,30);
        B2.setCursor(handCursor);
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = null;
                try {
                    int client_id = Integer.parseInt(t1.getText());
                    String initial_amount = t2.getText(); // No need to use new String()

                    if (client_id != 0 && !initial_amount.isEmpty()) {
                        for (Client c : myBank.getClList()) {
                            if (c.getId() == client_id) {
                                client = c;
                                break;
                            }
                        }

                        if (client != null) {
                            Account account = myBank.addAccount(Float.parseFloat(initial_amount), client);
                            JOptionPane.showMessageDialog(null, "Account added successfully. Account Number: " + account.getNumber(), "Success", JOptionPane.INFORMATION_MESSAGE);
                            welcomepage();
                        } else {
                            JOptionPane.showMessageDialog(null, "Client not found with ID: " + client_id, "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please enter valid client ID and initial amount.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid client ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        B2.setFont(ff);
        f.add(B2);


        JButton B3= new JButton("CANCEL");
        B3.setBounds(400,450,200,30);
        B3.setCursor(handCursor);
        B3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomepage();
            }
        });
        B3.setFont(ff);
        f.add(B3);
        f.add(backgroundLabel);
        f.revalidate();
        f.repaint();
    }
    private void OPERATIONS(){
        f.getContentPane().removeAll();
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\DELL\\Desktop\\BMS\\src\\BankingSystem\\bnm.jpg");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, f.getWidth(), f.getHeight());

        JButton add_cash = new JButton("DEPOSIT AMOUNT");
        add_cash.setBounds(100,100,260,30);
        add_cash.setCursor(handCursor);
        add_cash.setFont(ff);
        f.add(add_cash);

        JButton get_cash = new JButton("WITHDRAW AMOUNT");
        get_cash.setBounds(100,200,260,30);
        get_cash.setCursor(handCursor);
        get_cash.setFont(ff);
        f.add(get_cash);

        JLabel l2 = new JLabel("ENTER AMOUNT :");
        l2.setBounds(150,250,200,20);
        l2.setFont(ff);
        JTextField t1 = new JTextField();
        t1.setBounds(400,250,140,28);

        JLabel l4 = new JLabel("CLIENT ID :");
        l4.setBounds(150,390,200,20);
        l4.setFont(ff);
        JTextField t3 = new JTextField();
        t3.setBounds(400,390,140,28);


        JLabel l3= new JLabel("ACCOUNT NUMBER :");
        l3.setBounds(150,320,200,20);
        l3.setFont(ff);
        JTextField t2 = new JTextField();
        t2.setBounds(400,320,140,28);




        JButton B2= new JButton("CANCEL");
        B2.setBounds(430,460,150,30);
        B2.setCursor(handCursor);
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomepage();
                is_click = false;
                is_withdraw=false;
                is_deposit=false;
            }
        });
        B2.setFont(ff);
        f.add(B2);
        JButton Bq= new JButton("ENTER");
        Bq.setBounds(130,460,150,30);
        Bq.setCursor(handCursor);
        Bq.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client = null;
                is_click = false;
                String amount= new String(t1.getText());
                String acc_no= new String(t2.getText());
                String client_id= new String(t3.getText());
                int clientid = Integer.parseInt(client_id);


                for (Client c : myBank.getClList()) {
                    if (c.getId() == clientid) {
                        client = c;
                        break;
                    }
                }
//                JOptionPane.showMessageDialog(null,client);
                if (is_deposit){
                    assert client != null;
                    client.deposit(Float.parseFloat(amount), acc_no);
                    JOptionPane.showMessageDialog(null, "AMOUNT DEPOSIT SUCCESSFULLY: ");
                    welcomepage();
                }
                else {
                    if (!is_withdraw) {
                        JOptionPane.showMessageDialog(null, "Please enter valid information.");
                    }
                }

                if (is_withdraw){
                    client.withdraw(Float.parseFloat(amount), acc_no);
                    JOptionPane.showMessageDialog(null, "AMOUNT WITHDRAW SUCCESSFULLY: ", "Success", JOptionPane.INFORMATION_MESSAGE);
                    welcomepage();
                }

                else {
                    if (!is_deposit) {
                        JOptionPane.showMessageDialog(null, "Please enter valid information.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                is_click=false;
                is_deposit=false;
                is_withdraw=false;
            }
        });
        add_cash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                is_click=true;
                is_deposit=true;
                is_withdraw =false;
                OPERATIONS();
            }
        });
        get_cash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                is_click=true;
                is_deposit=false;
                is_withdraw=true;
                OPERATIONS();
            }
        });
        Bq.setFont(ff);
        if (is_click){
            f.add(t1);
            f.add(l2);
            f.add(l3);
            f.add(t2);
            f.add(l4);
            f.add(t3);
        }
        f.add(Bq);
        f.add(backgroundLabel);
        f.revalidate();
        f.repaint();
    }
    private void CURRENT_BALANCE(){
        f.getContentPane().removeAll();
        ImageIcon backgroundImage = new ImageIcon("C:\\Users\\DELL\\Desktop\\BMS\\src\\BankingSystem\\mm.jpg");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(f.getWidth(), f.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, f.getWidth(), f.getHeight());


        JLabel l2 = new JLabel("ENTER ACCOUNT N0:");
        l2.setBounds(150,280,400,19);
        f.add(l2);
        l2.setFont(ff);
        JTextField t1 = new JTextField();
        t1.setBounds(400,280,140,28);
        f.add(t1);
        JButton B2= new JButton("CANCEL");
        B2.setBounds(400,400,180,30);
        B2.setCursor(handCursor);
        B2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                welcomepage();
            }
        });
        B2.setFont(ff);
        f.add(B2);
        JButton Bc= new JButton("ENTER");
        Bc.setBounds(100,400,180,30);
        Bc.setCursor(handCursor);
        Bc.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String accNo = t1.getText();

                if (!accNo.isEmpty()) {
                    Account account = myBank.searchAccount(accNo);

                    if (account != null) {
                        JOptionPane.showMessageDialog(null, "Current Balance is : " + account.getAmount(), "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Account not found with number: " + accNo, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid Account number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        Bc.setFont(ff);
        f.add(Bc);
        f.add(backgroundLabel);
        f.revalidate();
        f.repaint();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bank myBank = new Bank("MyBank");
        Main main=new Main();

        // Menu for user input
        int choice;
        do {
            System.out.println("\n===== Bank Management System =====");
            System.out.println("1. Add Client");
            System.out.println("2. Add Account");
            System.out.println("3. Perform Operations");
            System.out.println("4. View Current Balance");
            System.out.println("5. Display Bank Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addClient(scanner, myBank);
                    break;
                case 2:
                    addAccount(scanner, myBank);
                    break;
                case 3:
                    performOperations(scanner, myBank);
                    break;
                case 4:
                    viewCurrentBalance(scanner, myBank);
                    break;
                case 5:
                    System.out.println(myBank.toString());
                    break;
                case 6:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 6);

        scanner.close();
    }

    private static void addClient(Scanner scanner, Bank myBank) {
        System.out.print("Enter client name: ");
        String name = scanner.nextLine();
        System.out.print("Enter client CNIC: ");
        String cnic = scanner.nextLine();
        System.out.print("Enter client phone number: ");
        String phoneNo = scanner.nextLine();

        Person person = new Person(name, cnic, phoneNo);
        Client client = myBank.addClient(person);

        System.out.println("Client added successfully. Client ID: " + client.getId());
    }

    private static void addAccount(Scanner scanner, Bank myBank) {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        Client client = null;

        for (Client c : myBank.getClList()) {
            if (c.getId() == clientId) {
                client = c;
                break;
            }
        }

        if (client != null) {
            System.out.print("Enter initial amount for the account: ");
            float amount = scanner.nextFloat();

            Account account = myBank.addAccount(amount, client);

            System.out.println("Account added successfully. Account Number: " + account.getNumber());
        } else {
            System.out.println("Client not found with ID: " + clientId);
        }
    }

    private static void performOperations(Scanner scanner, Bank myBank) {
        System.out.print("Enter client ID: ");
        int clientId = scanner.nextInt();
        Client client = null;

        for (Client c : myBank.getClList()) {
            if (c.getId() == clientId) {
                client = c;
                break;
            }
        }

        if (client != null) {
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.print("Enter operation choice: ");
            int operationChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (operationChoice) {
                case 1:
                    performWithdraw(scanner, client);
                    break;
                case 2:
                    performDeposit(scanner, client);
                    break;
                default:
                    System.out.println("Invalid operation choice.");
            }
        } else {
            System.out.println("Client not found with ID: " + clientId);
        }
    }

    private static void performWithdraw(Scanner scanner, Client client) {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();
        System.out.print("Enter withdrawal amount: ");
        float amount = scanner.nextFloat();

        client.withdraw(amount, accNo);
    }

    private static void performDeposit(Scanner scanner, Client client) {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();
        System.out.print("Enter deposit amount: ");
        float amount = scanner.nextFloat();

        client.deposit(amount, accNo);
    }

    private static void viewCurrentBalance(Scanner scanner, Bank myBank) {
        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();
        Account account = myBank.searchAccount(accNo);

        if (account != null) {
            System.out.println("Current balance of Account " + accNo + ": " + account.getAmount());
        } else {
            System.out.println("Account not found with number: " + accNo);
        }
    }
}
