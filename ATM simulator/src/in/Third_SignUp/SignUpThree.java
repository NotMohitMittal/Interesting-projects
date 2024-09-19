package in.Third_SignUp;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import in.ATM_Functions.Deposite;

import java.awt.event.*;


public class SignUpThree extends JFrame implements ActionListener{

    private final String _formNumber;
    JRadioButton _savingAccount, _FDAccount, _currentAccount, _recurringAccount;
    JCheckBox _ATMCard, _internetBanking, _mobileBanking, _emailSmsAlart, _chequeBook, _EStatement, _formDeclaration;
    JButton _cancel, _submit;
    boolean accountCreated = false;
    String _userCardNumber = null, _userPinNumber = null;

    public SignUpThree(String _formNumber) {
        this._formNumber = _formNumber;


        JLabel _pageInfo = new JLabel("Account Details");
        _pageInfo.setBounds(320, 50, 400, 40);
        _pageInfo.setFont(new Font("Source Sans Pro", Font.BOLD, 35));
        add(_pageInfo);

        JLabel _accountType = new JLabel("\u21E8 Account Type");
        _accountType.setBounds(100, 150, 400, 40);
        _accountType.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        add(_accountType);


        // RadioButtons --> Account Type
        _savingAccount = new JRadioButton("Saving Account");
        _savingAccount.setBounds(150, 200, 300, 40);
        _savingAccount.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        _savingAccount.setBackground(Color.white);
        _savingAccount.setFocusable(false);
        add(_savingAccount);
        
        _FDAccount = new JRadioButton("Fixed Deposite Account");
        _FDAccount.setBounds(450, 200, 300, 40);
        _FDAccount.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        _FDAccount.setBackground(Color.white);
        _FDAccount.setFocusable(false);
        add(_FDAccount);
        
        _currentAccount = new JRadioButton("Current Account");
        _currentAccount.setBounds(150, 230, 300, 40);
        _currentAccount.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        _currentAccount.setBackground(Color.white);
        _currentAccount.setFocusable(false);
        add(_currentAccount);
        
        _recurringAccount = new JRadioButton("Recurring Account");
        _recurringAccount.setBounds(450, 230, 300, 40);
        _recurringAccount.setFont(new Font("Source Sans Pro", Font.BOLD, 20));
        _recurringAccount.setBackground(Color.white);
        _recurringAccount.setFocusable(false);
        add(_recurringAccount);



        ButtonGroup _accountTypeGroup = new ButtonGroup();
        _accountTypeGroup.add(_savingAccount);
        _accountTypeGroup.add(_FDAccount);
        _accountTypeGroup.add(_currentAccount);
        _accountTypeGroup.add(_recurringAccount);


        JLabel _cardNumber = new JLabel("\u21E8 Card Number");
        _cardNumber.setBounds(100, 340, 400, 40);
        _cardNumber.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        add(_cardNumber);


        JLabel _cardInfo = new JLabel("Your 16 digit Card Number");
        _cardInfo.setBounds(100, 370, 400, 40);
        _cardInfo.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        add(_cardInfo);

        JLabel _ATMNumber = new JLabel("XXXX-XXXX-XXXX-1234");
        _ATMNumber.setBounds(480, 340, 400, 40);
        _ATMNumber.setFont(new Font("Raleway", Font.BOLD, 25));
        add(_ATMNumber);
        
        
        JLabel _pinNumber = new JLabel("\u21E8 PIN");
        _pinNumber.setBounds(100, 440, 400, 40);
        _pinNumber.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        add(_pinNumber);
        
        JLabel _ATMPassword = new JLabel("XXXX");
        _ATMPassword.setBounds(480, 440, 400, 40);
        _ATMPassword.setFont(new Font("Raleway", Font.BOLD, 25));
        add(_ATMPassword);
        

        JLabel _pinInfo = new JLabel("\u21E8 Your 4 digit Password");
        _pinInfo.setBounds(100, 470, 400, 40);
        _pinInfo.setFont(new Font("Source Sans Pro", Font.BOLD, 15));
        add(_pinInfo);


        JLabel _serviceRequired = new JLabel("\u21E8 Service Required");
        _serviceRequired.setBounds(100, 560, 400, 40);
        _serviceRequired.setFont(new Font("Source Sans Pro", Font.BOLD, 25));
        add(_serviceRequired);

        _ATMCard = new JCheckBox(" ATM Card");
        _ATMCard.setBounds(150, 610, 300, 40);
        _ATMCard.setFont(new Font("Raleway", Font.BOLD, 20));
        _ATMCard.setBackground(Color.white);
        _ATMCard.setFocusable(false);
        add(_ATMCard);
        
        
        _internetBanking = new JCheckBox(" Internet Banking");
        _internetBanking.setBounds(450, 610, 300, 40);
        _internetBanking.setFont(new Font("Raleway", Font.BOLD, 20));
        _internetBanking.setBackground(Color.white);
        _internetBanking.setFocusable(false);
        add(_internetBanking);
        
        _mobileBanking = new JCheckBox(" Mobile Banking");
        _mobileBanking.setBounds(150, 660, 300, 40);
        _mobileBanking.setFont(new Font("Raleway", Font.BOLD, 20));
        _mobileBanking.setBackground(Color.white);
        _mobileBanking.setFocusable(false);
        add(_mobileBanking);
        
        
        _emailSmsAlart = new JCheckBox(" Email and SMS alerts");
        _emailSmsAlart.setBounds(450, 660, 300, 40);
        _emailSmsAlart.setFont(new Font("Raleway", Font.BOLD, 20));
        _emailSmsAlart.setBackground(Color.white);
        _emailSmsAlart.setFocusable(false);
        add(_emailSmsAlart);
        
        
        _chequeBook = new JCheckBox(" Cheque Book");
        _chequeBook.setBounds(150, 710, 300, 40);
        _chequeBook.setFont(new Font("Raleway", Font.BOLD, 20));
        _chequeBook.setBackground(Color.white);
        _chequeBook.setFocusable(false);
        add(_chequeBook);
        
        _EStatement = new JCheckBox(" E-Statement");
        _EStatement.setBounds(450, 710, 300, 40);
        _EStatement.setFont(new Font("Raleway", Font.BOLD, 20));
        _EStatement.setBackground(Color.white);
        _EStatement.setFocusable(false);
        add(_EStatement);

        _formDeclaration = new JCheckBox("I hearby declare that above entered details are correct to best of my knowledge");
        _formDeclaration.setBounds(100, 790, 700, 40);
        _formDeclaration.setFont(new Font("Raleway", Font.PLAIN, 15));
        _formDeclaration.setBackground(Color.white);
        _formDeclaration.setFocusable(false);
        add(_formDeclaration);


        // JButton --> Cancel
        _submit = new JButton("Submit");
        _submit.setBounds(300, 860, 150, 40);
        _submit.setBackground(Color.black);
        _submit.setForeground(Color.white);
        _submit.setFocusable(false);
        _submit.addActionListener(this);
        add(_submit);
        
        
        _cancel = new JButton("Cancel");
        _cancel.setBounds(550, 860, 150, 40);
        _cancel.setBackground(Color.black);
        _cancel.setForeground(Color.white);
        _cancel.setFocusable(false);
        _cancel.addActionListener(this);
        add(_cancel);




        // attributes of the frame
        setTitle("Application form");
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setResizable(false);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _submit) {
            String _userAccountType = null;

            if(_savingAccount.isSelected()) {
                _userAccountType = "Saving Account";
            } else if(_FDAccount.isSelected()) {
                _userAccountType = "Fixed Deposite Account";
            } else if(_currentAccount.isSelected()) {
                _userAccountType = "Current Account";
            } else if(_recurringAccount.isSelected()) {
                _userAccountType = "Recurring Account";
            }

            // Finding the Random Card Number;
            Random random = new Random();
            long randomNumber = Math.abs(random.nextLong() % 90000000) + 5040936000000000L;

            _userCardNumber = "" + randomNumber; // "" (concatination) helps the numbers to make into String
            
            int pinNumber = random.nextInt(9000) + 1000;
            _userPinNumber = String.valueOf(pinNumber);  

            String _userServices = "";
            if(_ATMCard.isSelected()) {
                _userServices += " ATM Card,";
            } if(_internetBanking.isSelected()) {
                _userServices += " InterNet Banking,";
            } if(_mobileBanking.isSelected()) {
                _userServices += " Mobile Banking,";
            } if(_chequeBook.isSelected()) {
                _userServices += " Check Book,";
            } if(_EStatement.isSelected()) {
                _userServices += " E-Statement,";
            } if(_emailSmsAlart.isSelected()) {
                _userServices += " Email and SMS alart,";
            }

            try {
                if(_userAccountType == null) {
                    JOptionPane.showMessageDialog(null, "Please enter the Account Type");
                } else if(_userServices.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select the required services");
                } else if(!_formDeclaration.isSelected()) {
                    JOptionPane.showMessageDialog(null, "You have to select the confirmation Box First");
                } else {
                    DataBaseConnector_Three DBConnection = new DataBaseConnector_Three();
                    DBConnection.insertAccountDetails(_formNumber, _userAccountType, _userCardNumber, _userPinNumber, _userServices);
                    DBConnection.insertCardDetails(_formNumber, _userCardNumber, _userPinNumber);

                    JOptionPane.showMessageDialog(null, "Thanks for your Trust" +
                        "\n------------------------------" +
                        "\nCard Number: " + _userCardNumber +
                        "\nATM Pin: " + _userPinNumber);

                    accountCreated = true;
                    // _cancel = new JButton(accountCreated ? "Next" : "Cancel");
                    _cancel.setText("Next");
                    
                }
            } catch (Exception except) {
                except.getMessage();
            }
        } else if(e.getSource() == _cancel) {
            if(accountCreated) {
                JOptionPane.showMessageDialog(null, "Can't create account with Zero Balance, Please Enter al least 1000 in your Account");
                setVisible(false);
                new Deposite(_userCardNumber, _userPinNumber);
            } else {
                System.exit(0);
            }
            
        }



    }

    public static void main(String... args) {
        new SignUpThree("");
    }
    
}
