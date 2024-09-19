package in.ATM_Functions;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import in.Transactions.Transaction;



public class PinChange extends JFrame implements ActionListener {
    String CardNumber, PinNumber;
    JTextField _oldPinNumber, _newPinNumber, _reEnterNewPin;
    JButton _back, _changePin;
    Boolean isTransactionPossible = null;

    public PinChange(String CardNumber, String PinNumber) {
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


        _oldPinNumber = new JTextField("Enter the old PIN Number");
        _oldPinNumber.setBounds(195, 400, 300, 40);
        _oldPinNumber.setFont(new Font("System", Font.BOLD, 13));
        _oldPinNumber.setForeground(Color.white);
        _oldPinNumber.setBackground(Color.darkGray);
        _oldPinNumber.setCaretColor(Color.red);
        _oldPinNumber.setHorizontalAlignment(JTextField.CENTER);
        _atmImage.add(_oldPinNumber);

        _oldPinNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(_oldPinNumber.getText().equals("Enter the old PIN Number")) {
                    _oldPinNumber.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(_oldPinNumber.getText().isEmpty()) {
                    _oldPinNumber.setText("Enter the old PIN Number");
                }
            }
        });
        
        _newPinNumber = new JTextField("Please Enter new PIN Number");
        _newPinNumber.setBounds(195, 450, 300, 40);
        _newPinNumber.setFont(new Font("System", Font.BOLD, 13));
        _newPinNumber.setForeground(Color.white);
        _newPinNumber.setBackground(Color.darkGray);
        _newPinNumber.setCaretColor(Color.red);
        _newPinNumber.setHorizontalAlignment(JTextField.CENTER);
        _atmImage.add(_newPinNumber);

        _newPinNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(_newPinNumber.getText().equals("Please Enter new PIN Number")) {
                    _newPinNumber.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(_newPinNumber.getText().isEmpty()) {
                    _newPinNumber.setText("Please Enter new PIN Number");
                }   
            }
        });



        _reEnterNewPin = new JTextField("Please Re-Enter new PIN");
        _reEnterNewPin.setBounds(195, 500, 300, 40);
        _reEnterNewPin.setFont(new Font("System", Font.BOLD, 13));
        _reEnterNewPin.setForeground(Color.white);
        _reEnterNewPin.setBackground(Color.darkGray);
        _reEnterNewPin.setCaretColor(Color.red);
        _reEnterNewPin.setHorizontalAlignment(JTextField.CENTER);
        _atmImage.add(_reEnterNewPin);

        _reEnterNewPin.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if(_reEnterNewPin.getText().equals("Please Re-Enter new PIN")) {
                    _reEnterNewPin.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(_reEnterNewPin.getText().isEmpty()) {
                    _reEnterNewPin.setText("Please Re-Enter new PIN");
                }
            }
        });

        // JButtons
        _back = new JButton("Back");
        _back.setBounds(385, 580, 175, 30);
        _back.setFocusable(false);
        _back.setFont(new Font("System", Font.BOLD, 15));
        _back.setBackground(Color.DARK_GRAY);
        _back.setForeground(Color.white);
        _back.addActionListener(this);
        _atmImage.add(_back);

        _changePin = new JButton("Change");
        _changePin.setBounds(190, 580, 175, 30);
        _changePin.setFocusable(false);
        _changePin.setFont(new Font("System", Font.BOLD, 15));
        _changePin.setBackground(Color.DARK_GRAY);
        _changePin.setForeground(Color.white);
        _changePin.addActionListener(this);
        _atmImage.add(_changePin);
        
        

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
            System.exit(0);
            // setVisible(false);
            // new Transaction(CardNumber, PinNumber);
        } else if(e.getSource() == _changePin) {
            if(!_newPinNumber.getText().equals(_reEnterNewPin.getText())) {
                JOptionPane.showMessageDialog(null, "Your new PIN number doesn't match");
                return;
            }
            // Database work
            DatabaseConnection_Transaction DBConnection = new DatabaseConnection_Transaction();
            isTransactionPossible = DBConnection.matchPassword(CardNumber, _oldPinNumber.getText());

            if(!isTransactionPossible) {
                JOptionPane.showMessageDialog(null, "Old PIN Number is incorrect");
                return;    
            }

            DBConnection.changePassword(CardNumber, PinNumber, _reEnterNewPin.getText());
            JOptionPane.showMessageDialog(null, "Your Password changed sucessfully");
            setVisible(false);
            new Transaction(CardNumber, PinNumber);
        }
    }

    public static void main(String[] args) {
        new PinChange("", "");
    }
    
}
