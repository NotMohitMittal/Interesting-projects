// package BakingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends JFrame implements ActionListener{

    JButton login, signUp, clear;
    JTextField cardTextBox;
    JPasswordField pinTextBox;

    Login() {

        setLayout(null);
        // adding the image 
        ImageIcon bank = new ImageIcon(ClassLoader.getSystemResource("logo/images.png"));
        Image bank_1 = bank.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank_2 = new ImageIcon(bank_1);
        
        JLabel bankLogo = new JLabel(bank_2);
        bankLogo.setBounds(150, 100, 100, 100);
        
        // adding text labels to the window

        JLabel bankName = new JLabel("Union Bank of India");
        bankName.setBounds(300, 75, 600, 100);
        bankName.setFont(new Font("osward", Font.BOLD, 38));



        JLabel greet = new JLabel("Welcome to ATM");
        greet.setBounds(300, 125, 400, 100);
        greet.setFont(new Font("osward", Font.CENTER_BASELINE, 38));
        greet.setForeground(Color.white);
        
        
        JLabel cardNo = new JLabel("CARD NUMBER ");
        cardNo.setBounds(230, 300, 300, 100);
        cardNo.setFont(new Font("railway", Font.BOLD, 25));
        cardNo.setForeground(Color.white);

        // text box for the card number
        cardTextBox = new JTextField();
        cardTextBox.setBounds(600, 325, 400, 30);
        cardTextBox.setFont(new Font("arial", Font.CENTER_BASELINE, 20));

        
        
        JLabel atmPin = new JLabel("ATM PIN ");
        atmPin.setBounds(265, 350, 400, 100);
        atmPin.setFont(new Font("railway", Font.CENTER_BASELINE, 25));
        atmPin.setForeground(Color.white);
        

        // text box for the pin Number
        pinTextBox = new JPasswordField();
        pinTextBox.setBounds(600, 380, 400, 30);
        pinTextBox.setFont(new Font("arial", Font.BOLD, 20));


        // button
        login = new JButton("SIGN IN");
        login.setBounds(625, 475, 150, 50);
        login.setBackground(Color.darkGray);
        login.setForeground(Color.white);
        login.addActionListener(this);
        
        clear = new JButton("CLEAR");
        clear.setBounds(825, 475, 150, 50);
        clear.setBackground(Color.darkGray);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        
        signUp = new JButton("SIGN UP");
        signUp.setBounds(625, 575, 350, 50);
        signUp.setBackground(Color.darkGray);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);


        // adding the extras
        add(bankLogo);
        add(bankName);
        add(greet);
        add(cardNo);
        add(cardTextBox);
        add(atmPin);
        add(pinTextBox);
        add(login);
        add(clear);
        add(signUp);


        // desciption of the window for the app
        setTitle("Baking System");
        setSize(1200, 880);
        setVisible(true);
        setLocation(380, 200);
        getContentPane().setBackground(Color.gray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == clear) {
            cardTextBox.setText("");
            pinTextBox.setText("");
        }
        else if(e.getSource() == login) {

        }
        else if(e.getSource() == signUp) {

        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
