package in.ATM_Functions;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import in.Transactions.Transaction;


public class ShowBalance extends JFrame implements ActionListener {
    
    private final String CardNumber, PinNumber;
    JButton _back;


    public ShowBalance(String CardNumber, String PinNumber) {
        this.CardNumber = CardNumber;
        this.PinNumber = PinNumber;


        // Image of the ATM
        ImageIcon _logoImage = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg"));
        Image _logoImageResizing = _logoImage.getImage().getScaledInstance(1000,1000, Image.SCALE_DEFAULT);
        ImageIcon _logoImageFinalized = new ImageIcon(_logoImageResizing);
        JLabel _atmImage = new JLabel(_logoImageFinalized);
        _atmImage.setBounds(0,0,1000,1000);
        add(_atmImage);


        JLabel message = new JLabel("Current balance: " + new DatabaseConnection_Transaction().getCustomerBalance(CardNumber, PinNumber));
        message.setFont(new Font("System", Font.BOLD, 20));
        message.setForeground(Color.WHITE);
        message.setBounds(195, 350, 400, 40);
        _atmImage.add(message);



        // JButtons
        _back = new JButton("Back");
        _back.setBounds(385, 580, 175, 30);
        _back.setFocusable(false);
        _back.setFont(new Font("System", Font.BOLD, 15));
        _back.setBackground(Color.DARK_GRAY);
        _back.setForeground(Color.white);
        _back.addActionListener(this);
        _atmImage.add(_back);



        // attributes of the frame
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
        }
        
    }

    public static void main(String[] args) {
        new ShowBalance("", "");
    }
    
}
