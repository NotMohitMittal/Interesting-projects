package in.ATM_Functions;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import in.Transactions.Transaction;


public class Fastcash extends JFrame implements ActionListener {

    JButton _100, _500, _1000, _2000, _5000, _10000, _back;
    Boolean isTransactionPossible = null;    
    
    private String CardNumber, PinNumber;

    public Fastcash(String CardNumber, String PinNumber) {
        this.CardNumber = CardNumber;
        this.PinNumber = PinNumber;

        // Image of the ATM
        ImageIcon _logoImage = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image _logoImageResizing = _logoImage.getImage().getScaledInstance(1000,1000, Image.SCALE_DEFAULT);
        ImageIcon _logoImageFinalized = new ImageIcon(_logoImageResizing);
        JLabel _atmImage = new JLabel(_logoImageFinalized);
        _atmImage.setBounds(0,0,1000,1000);
        add(_atmImage);


        JLabel _withdrawAmount = new JLabel("Select Withdrawl about");
        _withdrawAmount.setFont(new Font("System", Font.BOLD, 20));
        _withdrawAmount.setForeground(Color.WHITE);
        _withdrawAmount.setBounds(195, 350, 400, 40);
        _atmImage.add(_withdrawAmount);

        // Deposite Button
        _100 = new JButton("Rs. 100");
        _100.setBounds(190, 465, 175, 30);
        _100.setFocusable(false);
        _100.setFont(new Font("System", Font.BOLD, 15));
        _100.setBackground(Color.DARK_GRAY);
        _100.setForeground(Color.white);
        _100.addActionListener(this);
        _atmImage.add(_100);
        
        // Fast-Cash Button
        _500 = new JButton("Rs. 500");
        _500.setBounds(190, 500, 175, 30);
        _500.setFocusable(false);
        _500.setFont(new Font("System", Font.BOLD, 15));
        _500.setBackground(Color.DARK_GRAY);
        _500.setForeground(Color.white);
        _500.addActionListener(this);
        _atmImage.add(_500);
        
        // Pin Change Button
        _1000 = new JButton("Rs. 1000");
        _1000.setBounds(190, 535, 175, 30);
        _1000.setFocusable(false);
        _1000.setFont(new Font("System", Font.BOLD, 15));
        _1000.setBackground(Color.DARK_GRAY);
        _1000.setForeground(Color.white);
        _1000.addActionListener(this);
        _atmImage.add(_1000);
        
        // Cash withdrawl Button
        _2000 = new JButton("Rs. 2000");
        _2000.setBounds(385, 465, 175, 30);
        _2000.setFocusable(false);
        _2000.setFont(new Font("System", Font.BOLD, 15));
        _2000.setBackground(Color.DARK_GRAY);
        _2000.setForeground(Color.white);
        _2000.addActionListener(this);
        _atmImage.add(_2000);
        
        // Mini Statement Button
        _5000 = new JButton("Rs. 5000");
        _5000.setBounds(385, 500, 175, 30);
        _5000.setFocusable(false);
        _5000.setFont(new Font("System", Font.BOLD, 15));
        _5000.setBackground(Color.DARK_GRAY);
        _5000.setForeground(Color.white);
        _5000.addActionListener(this);
        _atmImage.add(_5000);
        
        // Balance enquiry Button
        _10000 = new JButton("Rs. 10000");
        _10000.setBounds(385, 535, 175, 30);
        _10000.setFocusable(false);
        _10000.setFont(new Font("System", Font.BOLD, 15));
        _10000.setBackground(Color.DARK_GRAY);
        _10000.setForeground(Color.white);
        _10000.addActionListener(this);
        _atmImage.add(_10000);
        
        // Exit Button
        _back = new JButton("Back");
        _back.setBounds(385, 580, 175, 30);
        _back.setFocusable(false);
        _back.setFont(new Font("System", Font.BOLD, 15));
        _back.setBackground(Color.DARK_GRAY);
        _back.setForeground(Color.white);
        _back.addActionListener(this);
        _atmImage.add(_back);




        // attributes of the frame
        setTitle("Application form");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setSize(1000,950);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _back) {
            setVisible(false);
            new Transaction(CardNumber, PinNumber);
        } else if(e.getSource() != _back) {
            
            String _buttonClicked = ((JButton)e.getSource()).getText();
            String _amountToWithdraw = _buttonClicked.substring(4);

            DatabaseConnection_Transaction DBConnection = new DatabaseConnection_Transaction();
            isTransactionPossible = DBConnection.updateBalance(CardNumber, PinNumber, _amountToWithdraw, "withdraw");

            if(isTransactionPossible) {
                JOptionPane.showMessageDialog(null, "Transaction sucessfull \n Current Balance: " + DBConnection.getCustomerBalance(CardNumber, PinNumber));
                setVisible(false);
                new Transaction(CardNumber, PinNumber);
            } else {
                JOptionPane.showMessageDialog(null, "Insufficien Balance");
                return;
            }
        }
    }

    public static void main(String[] args) {
        new Fastcash("", "");
    }
}
