package in.ATM_Functions;

import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;
import in.Transactions.Transaction;


public class Withdraw extends JFrame implements ActionListener {

    String CardNumber, PinNumber;
    JTextField _amount;
    JButton _back, _withdraw;

    public Withdraw(String CardNumber, String PinNumber) {
        this.CardNumber = CardNumber;
        this.PinNumber = PinNumber;

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImage);
        imageLabel.setBounds(0, 0, 1000, 1000);

        add(imageLabel);

        JLabel _instruction = new JLabel("Enter the amount you want to Withdraw");
        _instruction.setFont(new Font("System", Font.BOLD, 15));
        _instruction.setForeground(Color.WHITE);
        _instruction.setBounds(195, 350, 500, 40);
        imageLabel.add(_instruction);


        // Amount JTextField
        _amount = new JTextField("Enter the amount");
        _amount.setBounds(195, 400, 300, 40);
        _amount.setFont(new Font("System", Font.BOLD, 13));
        _amount.setForeground(Color.white);
        _amount.setBackground(Color.darkGray);
        _amount.setCaretColor(Color.red);
        _amount.setHorizontalAlignment(JTextField.CENTER);
        imageLabel.add(_amount);

        

        // Deposite Button
        _withdraw = new JButton("Withdraw");
        _withdraw.setBounds(385, 535, 175, 35);
        _withdraw.setFocusable(false);
        _withdraw.setFont(new Font("System", Font.BOLD, 15));
        _withdraw.setBackground(Color.DARK_GRAY);
        _withdraw.setForeground(Color.white);
        _withdraw.addActionListener(this);
        imageLabel.add(_withdraw);
        
        // Exit Button
        _back = new JButton("Back");
        _back.setBounds(385, 580, 175, 30);
        _back.setFocusable(false);
        _back.setFont(new Font("System", Font.BOLD, 15));
        _back.setBackground(Color.DARK_GRAY);
        _back.setForeground(Color.white);
        _back.addActionListener(this);
        imageLabel.add(_back);


        JPanel invisiblePanel = new JPanel();
        invisiblePanel.setFocusable(true);
        invisiblePanel.setBounds(0, 0, 1, 1);
        invisiblePanel.requestFocusInWindow();
        add(invisiblePanel);


        _amount.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(_amount.getText().equals("Enter the amount")) {
                    _amount.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(_amount.getText().isEmpty()) {
                    _amount.setText("Enter the amount");
                }
            }
        });


        // attributes of the frame
        setTitle("Application form");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String withdrawAmount = null;
        if(e.getSource() == _back) {
            setVisible(false);
            new Transaction(CardNumber, PinNumber);
        } else if(e.getSource() == _withdraw) {
            if(_amount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Amount First");
                return;
            } 
            withdrawAmount = _amount.getText();
            // current data
            Date date = new Date();
            String currentDate = date.toString();

            DatabaseConnection_Transaction DBConnection = new DatabaseConnection_Transaction();
            DBConnection.insertDeposite(CardNumber, PinNumber, "Withdraw", withdrawAmount, currentDate);

            Boolean isTransactionPossible = null;
            isTransactionPossible = DBConnection.updateBalance(CardNumber, PinNumber, withdrawAmount, "withdraw");

            if(!isTransactionPossible) {
                JOptionPane.showMessageDialog(null, "Insufficient balance in account");
                return;
            }



            JOptionPane.showMessageDialog(null, "Rs." + withdrawAmount + " Withdrawn from your account \n Current Balance : " + DBConnection.getCustomerBalance(CardNumber, PinNumber));
            setVisible(false);
            new Transaction(CardNumber, PinNumber);
        }
    }

        

    public static void main(String[] args) {
        new Withdraw("", "");
    }
    
}
