package in.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import in.First_SignUp.SignUpOne;
import in.Transactions.Transaction;

public class Login extends JFrame implements ActionListener{

    JButton _clear, _signUp, _signIn;
    JTextField _textCardNumber;
    JPasswordField _textPinNumber;

    Login() {

        // Bank Logo
        ImageIcon _logoImage = new ImageIcon(ClassLoader.getSystemResource("images/Bank_logo.png"));
        Image _logoImageResizing = _logoImage.getImage().getScaledInstance(400,300, Image.SCALE_DEFAULT);
        ImageIcon _logoImageFinalized = new ImageIcon(_logoImageResizing);
        JLabel labelLogoImage = new JLabel(_logoImageFinalized);
        labelLogoImage.setBounds(40,00,400,300); 

        // JLabel ---> Greeting
        JLabel _greeting = new JLabel("Welcome to Union Bank ATM");
        _greeting.setFont(new Font("Osward", Font.BOLD,35));
        _greeting.setBounds(200, 200,600, 40);
        

        // JLabel ---> Card Number
        JLabel _cardNumber = new JLabel("Card Number");
        _cardNumber.setFont(new Font("Osward", Font.BOLD, 27));
        _cardNumber.setBounds(200, 350,320, 40);

        // JLabel ---> Pin
        JLabel _pin = new JLabel("Pin Number");
        _pin.setFont(new Font("Osward", Font.BOLD, 27));
        _pin.setBounds(200, 450,250, 40);


        // JTextField ---> card Number 
        _textCardNumber = new JTextField("Card Number");
        _textCardNumber.setBounds(500, 340, 250, 50);
        _textCardNumber.setHorizontalAlignment(JTextField.CENTER);
        _textCardNumber.setFont(new Font("Arial", Font.BOLD, 15));


        // for the focus and the focus lost 
        _textCardNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(_textCardNumber.getText().equals("Card Number")) {
                    _textCardNumber.setText("");
                    _textCardNumber.setForeground(Color.black);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(_textCardNumber.getText().isEmpty()) {
                    _textCardNumber.setText("Card Number");
                    _textCardNumber.setForeground(Color.gray);
                }
            }
        });
        
        
        
        // JTextField ---> pin Number
        _textPinNumber = new JPasswordField("Pin Number");
        _textPinNumber.setBounds(500, 440, 250, 50);
        _textPinNumber.setHorizontalAlignment(JTextField.CENTER);
        _textPinNumber.setFont(new Font("Arial", Font.BOLD, 15));


        // for the focus and the focus lost 
        _textPinNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String pinText = new String(_textPinNumber.getPassword());
                if(pinText.equals("Pin Number")) {
                    _textPinNumber.setText("");
                    _textPinNumber.setEchoChar('•');
                    _textPinNumber.setForeground(Color.black);
                } 
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                String pinText = new String(_textPinNumber.getPassword());
                if(pinText.isEmpty()) {
                    _textPinNumber.setText("Pin Number");
                    _textPinNumber.setEchoChar((char)0);
                    _textPinNumber.setForeground(Color.gray);
                }
            }
        });



        // JButton ---> sing in
        _signIn = new JButton("SIGN IN");
        _signIn.setBounds(200, 550, 250,40);
        _signIn.setFocusable(false);
        _signIn.addActionListener(this);


        // JButton ---> Clear
        _clear = new JButton("CLEAR");
        _clear.setBounds(500, 550, 250, 40);
        // _clear.setFocusable(false);
        _clear.requestFocusInWindow();
        _clear.addActionListener(this);

        // JButton ---> sing UP
        _signUp = new JButton("SIGN UP");
        _signUp.setBounds(200, 630, 550, 50);
        _signUp.setFocusable(false);
        _signUp.addActionListener(this);


        
        // this is a invisible panel to remove the focus from the text-field initially 
        JPanel invisiblePanel = new JPanel();
        invisiblePanel.setFocusable(true);
        invisiblePanel.setBounds(0,0,1,1);
        invisiblePanel.requestFocusInWindow();



        // adding the components
        add(labelLogoImage);
        add(_greeting);
        add(_cardNumber);
        add(_pin);
        add(_textCardNumber);
        add(_textPinNumber);
        add(_signIn);
        add(_clear);
        add(_signUp);
        add(invisiblePanel);



        // attributes of the frame
        setTitle("Login:  Union Bank Of India");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _clear) {
            _textCardNumber.setText("");
            _textPinNumber.setText("");
        } else if(e.getSource() == _signUp) {
            setVisible(false);
            new SignUpOne();
        }else if(e.getSource() == _signIn) {
            String _userCardNumber = _textCardNumber.getText();
            String _userPinNumber = new String(_textPinNumber.getPassword());


            // String testCardNumber = "5040936051342377";
            // String testPinNumber = "8704";

            DatabaseConnection_Login DBConnection = new DatabaseConnection_Login();
            boolean isUserValid = DBConnection.readFromDB(_userCardNumber, _userPinNumber);

            if(isUserValid) {
                setVisible(false);
                new Transaction(_userCardNumber, _userPinNumber);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Card Number or Pin Number");
            }
        }
    }



    // this is the main 
    public static void main(String[] args) {
        new Login();
    }

    
}
