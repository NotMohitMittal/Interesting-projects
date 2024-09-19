package in.ATM_Functions;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


import in.Transactions.Transaction;



public class Deposite extends JFrame implements ActionListener {

    private String PinNumber, CardNumber;
    JButton _back, _deposite;
    JTextField _amount;
    Boolean isTransactionPossible;


    public Deposite(String CardNumber, String PinNumber) {
        this.CardNumber = CardNumber;
        this.PinNumber = PinNumber;

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(1000, 1000, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(image);
        JLabel imageLabel = new JLabel(scaledImage);
        imageLabel.setBounds(0, 0, 1000, 1000);

        add(imageLabel);

        JLabel _instruction = new JLabel("Enter the amount you want to deposite");
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
        _deposite = new JButton("Deposite");
        _deposite.setBounds(385, 535, 175, 35);
        _deposite.setFocusable(false);
        _deposite.setFont(new Font("System", Font.BOLD, 15));
        _deposite.setBackground(Color.DARK_GRAY);
        _deposite.setForeground(Color.white);
        _deposite.addActionListener(this);
        imageLabel.add(_deposite);
        
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
        String _amountToDeposite = null;

        if(e.getSource() == _back) {
            setVisible(false);
            new Transaction(CardNumber, PinNumber);
        } else if(e.getSource() == _deposite) {
            _amountToDeposite = _amount.getText();
            if(_amount.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount first");
            } else {
                // database connection and storage of the money
                Date date = new Date();
                String _dateString = date.toString();
                DatabaseConnection_Transaction DBConnection = new DatabaseConnection_Transaction();
                DBConnection.insertDeposite(CardNumber, PinNumber, "Deposite", _amountToDeposite, _dateString);
                DBConnection.insertDeposite(CardNumber, PinNumber, _amountToDeposite);

                isTransactionPossible = DBConnection.updateBalance(CardNumber, PinNumber, _amountToDeposite, "deposite");

                
                JOptionPane.showMessageDialog(null,"Rs." + _amountToDeposite + "  Added successfull to your Account \n Curren Balance: " + DBConnection.getCustomerBalance(CardNumber, PinNumber));
                
                setVisible(false);
                new Transaction(CardNumber, PinNumber);
            }
        }
    }

    public static void main(String[] args) {
        new Deposite("", "");
    }
    
}
