import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Account {
    private double balance = 5000.00; // Initial balance
    private int accountNumber = 123456; // Account number

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            JOptionPane.showMessageDialog(null, "Withdrawal of ₹" + amount + " successful.\nNew balance: ₹" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid amount or insufficient funds.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            JOptionPane.showMessageDialog(null, "Deposit of ₹" + amount + " successful.\nNew balance: ₹" + balance);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid amount.");
        }
    }
}

public class ATMInterface extends JFrame {
    private Account userAccount = new Account();
    private int correctPIN = 1234; // Change this to your desired PIN
    private int enteredPIN;

    public ATMInterface() {
        setTitle("ATM Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JLabel enterPINLabel = new JLabel("Enter your PIN:");
        JTextField pinField = new JTextField(10);
        JButton submitButton = new JButton("Submit");

        panel.add(enterPINLabel);
        panel.add(pinField);
        panel.add(submitButton);

        add(panel);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    enteredPIN = Integer.parseInt(pinField.getText());

                    if (enteredPIN == correctPIN) {
                        showOptions();
                    } else {
                        JOptionPane.showMessageDialog(null, "Incorrect PIN. Please try again.");
                        pinField.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid PIN.");
                    pinField.setText("");
                }
            }
        });

        pack();
        setVisible(true);
    }

    private void showOptions() {
        getContentPane().removeAll();

        JLabel optionsLabel = new JLabel("Choose an option:");
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton balanceButton = new JButton("Check Balance");

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.add(optionsLabel);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(balanceButton);

        add(panel);

        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter withdrawal amount:");
                try {
                    double amount = Double.parseDouble(input);
                    userAccount.withdraw(amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(null, "Enter deposit amount:");
                try {
                    double amount = Double.parseDouble(input);
                    userAccount.deposit(amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input.");
                }
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double balance = userAccount.getBalance();
                JOptionPane.showMessageDialog(null, "Account Number: " + userAccount.getAccountNumber() + "\nCurrent balance: ₹" + balance);
            }
        });

        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ATMInterface());
    }
}
