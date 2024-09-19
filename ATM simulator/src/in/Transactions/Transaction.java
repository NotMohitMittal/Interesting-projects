package in.Transactions;

import java.awt.*;
import javax.swing.*;
import in.ATM_Functions.Deposite;
import in.ATM_Functions.Fastcash;
import in.ATM_Functions.PinChange;
import in.ATM_Functions.ShowBalance;
import in.ATM_Functions.Withdraw;

import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{

    private String PinNumber, CardNumber; 
    JButton _deposite, _cashWithdrawl, _fastCash, _miniStatement, _pinChange, _balanceEnquiry, _exit;

    public Transaction(String CardNumber, String PinNumber) {
        this.CardNumber = CardNumber;
        this.PinNumber = PinNumber;

        // Image of the ATM
        ImageIcon _logoImage = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image _logoImageResizing = _logoImage.getImage().getScaledInstance(1000,1000, Image.SCALE_DEFAULT);
        ImageIcon _logoImageFinalized = new ImageIcon(_logoImageResizing);
        JLabel _atmImage = new JLabel(_logoImageFinalized);
        _atmImage.setBounds(0,0,1000,1000);
        add(_atmImage);


        JLabel _greetingText = new JLabel("Please select your Transaction");
        _greetingText.setFont(new Font("System", Font.BOLD, 20));
        _greetingText.setForeground(Color.WHITE);
        _greetingText.setBounds(195, 350, 400, 40);
        _atmImage.add(_greetingText);

        // Deposite Button
        _deposite = new JButton("Deposite");
        _deposite.setBounds(190, 465, 175, 30);
        _deposite.setFocusable(false);
        _deposite.setFont(new Font("System", Font.BOLD, 15));
        _deposite.setBackground(Color.DARK_GRAY);
        _deposite.setForeground(Color.white);
        _deposite.addActionListener(this);
        _atmImage.add(_deposite);
        
        // Fast-Cash Button
        _fastCash = new JButton("Fast-Cash");
        _fastCash.setBounds(190, 500, 175, 30);
        _fastCash.setFocusable(false);
        _fastCash.setFont(new Font("System", Font.BOLD, 15));
        _fastCash.setBackground(Color.DARK_GRAY);
        _fastCash.setForeground(Color.white);
        _fastCash.addActionListener(this);
        _atmImage.add(_fastCash);
        
        // Pin Change Button
        _pinChange = new JButton("Pin Change");
        _pinChange.setBounds(190, 535, 175, 30);
        _pinChange.setFocusable(false);
        _pinChange.setFont(new Font("System", Font.BOLD, 15));
        _pinChange.setBackground(Color.DARK_GRAY);
        _pinChange.setForeground(Color.white);
        _pinChange.addActionListener(this);
        _atmImage.add(_pinChange);
        
        // Cash withdrawl Button
        _cashWithdrawl = new JButton("Cash Withdrawl");
        _cashWithdrawl.setBounds(385, 465, 175, 30);
        _cashWithdrawl.setFocusable(false);
        _cashWithdrawl.setFont(new Font("System", Font.BOLD, 15));
        _cashWithdrawl.setBackground(Color.DARK_GRAY);
        _cashWithdrawl.setForeground(Color.white);
        _cashWithdrawl.addActionListener(this);
        _atmImage.add(_cashWithdrawl);
        
        // Mini Statement Button    
        _miniStatement = new JButton("Mini Statement");
        _miniStatement.setBounds(385, 500, 175, 30);
        _miniStatement.setFocusable(false);
        _miniStatement.setFont(new Font("System", Font.BOLD, 15));
        _miniStatement.setBackground(Color.DARK_GRAY);
        _miniStatement.setForeground(Color.white);
        _miniStatement.addActionListener(this);
        _atmImage.add(_miniStatement);
        
        // Balance enquiry Button
        _balanceEnquiry = new JButton("Balance Enquiry");
        _balanceEnquiry.setBounds(385, 535, 175, 30);
        _balanceEnquiry.setFocusable(false);
        _balanceEnquiry.setFont(new Font("System", Font.BOLD, 15));
        _balanceEnquiry.setBackground(Color.DARK_GRAY);
        _balanceEnquiry.setForeground(Color.white);
        _balanceEnquiry.addActionListener(this);
        _atmImage.add(_balanceEnquiry);
        
        // Exit Button
        _exit = new JButton("Exit");
        _exit.setBounds(385, 580, 175, 30);
        _exit.setFocusable(false);
        _exit.setFont(new Font("System", Font.BOLD, 15));
        _exit.setBackground(Color.DARK_GRAY);
        _exit.setForeground(Color.white);
        _exit.addActionListener(this);
        _atmImage.add(_exit);


        // attributes of the frame
        setTitle("Application form");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setSize(1000,970);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _exit) {
            System.exit(0);
        } else if(e.getSource() == _deposite) {
            setVisible(false);
            new Deposite(CardNumber, PinNumber);   
        } else if(e.getSource() == _cashWithdrawl) {
            setVisible(false);
            new Withdraw(CardNumber, PinNumber);
        } else if(e.getSource() == _fastCash) {
            setVisible(false);
            new Fastcash(CardNumber, PinNumber);
        } else if(e.getSource() == _pinChange) {
            setVisible(false);
            new PinChange(CardNumber, PinNumber);
        } else if(e.getSource() == _balanceEnquiry) {
            setVisible(false);
            new ShowBalance(CardNumber, PinNumber);
        } 
    }

    public static void main(String[] args) {
        new Transaction("", "");
    }



    
}
