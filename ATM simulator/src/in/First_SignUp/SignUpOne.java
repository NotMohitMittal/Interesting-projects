package in.First_SignUp;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

import in.Second_SignUp.SignUpTwo;


public class SignUpOne extends JFrame implements ActionListener {


    // global delaration of all the variables
    JTextField _textName, _textFathersName, _textEmailAddress, _textState, _textPinCode, _textCity, _textAddress;
    JRadioButton _radioMale, _radioFemale, _others, _maritalStatusPositive, _maritalStatusNegative;
    JDateChooser chooseDate;
    JButton _next;


    // getting the random Application number
    Random random = new Random();
    int randomNumber = random.nextInt(90000) + 10000;


    public SignUpOne() {

        ImageIcon _logoImage = new ImageIcon(ClassLoader.getSystemResource("images/Logo_2.png"));
        Image _logoImageResizing = _logoImage.getImage().getScaledInstance(300,200, Image.SCALE_DEFAULT);
        ImageIcon _logoImageFinalized = new ImageIcon(_logoImageResizing);
        JLabel labelLogoImage = new JLabel(_logoImageFinalized);
        labelLogoImage.setBounds(20,20,300,200); 
        add(labelLogoImage);



        
        JLabel personDetails = new JLabel("Personal Details");
        personDetails.setBounds(320, 70,500, 40);
        personDetails.setFont(new Font("SansSerif", Font.BOLD,45));
        add(personDetails);

        
        JLabel _applicationNumber = new JLabel("Application Number: " + randomNumber);
        _applicationNumber.setBounds(320,130,500, 30);
        _applicationNumber.setFont(new Font("SansSerif", Font.PLAIN,27));
        add(_applicationNumber);


        JLabel _name = new JLabel("Name");
        _name.setBounds(100, 240, 100, 40);
        _name.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_name);
        
        
        JLabel _fathersName = new JLabel("Father's Name");
        _fathersName.setBounds(100, 290,200, 40);
        _fathersName.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_fathersName);
        
        JLabel _dateOfBirth = new JLabel("Date Of Birth");
        _dateOfBirth.setBounds(100,330,200, 40);
        _dateOfBirth.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_dateOfBirth);
        
        
        chooseDate = new JDateChooser();
        chooseDate.setBounds(450, 330, 320, 40);
        chooseDate.setFont(new Font("Raleway", Font.BOLD, 15));
        add(chooseDate);
        
        
        JLabel _gender = new JLabel("Gender");
        _gender.setBounds(100, 380,200, 40);
        _gender.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_gender);
        
        // defining the radio buttons  
        _radioMale = new JRadioButton("MALE");
        _radioMale.setBounds(450, 380, 100, 40);
        _radioMale.setBackground(Color.white);
        _radioMale.setFont(new Font("Raleway", Font.BOLD, 15));
        _radioMale.setFocusable(false);
        add(_radioMale);
        
        
        _radioFemale = new JRadioButton("FEMALE");
        _radioFemale.setBounds(550, 380, 100, 40);
        _radioFemale.setBackground(Color.white);
        _radioFemale.setFont(new Font("Raleway", Font.BOLD, 15));
        _radioFemale.setFocusable(false);
        add(_radioFemale);
        
        
        _others = new JRadioButton("PREFER NOT TO SAY");
        _others.setBounds(650, 380, 200, 40);
        _others.setBackground(Color.white);
        _others.setFont(new Font("Raleway", Font.BOLD, 15));
        _others.setFocusable(false);
        add(_others);


        // Grouping the radio buttons avoid the condition where you can select more than one radios at the same time
        ButtonGroup _genderGroup = new ButtonGroup();
        _genderGroup.add(_radioFemale);
        _genderGroup.add(_others);
        _genderGroup.add(_radioMale);




        JLabel _emailAddress = new JLabel("Email Address");
        _emailAddress.setBounds(100, 430,200, 40);
        _emailAddress.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_emailAddress);
        
        
        JLabel _maritalAddress = new JLabel("Marital Status");
        _maritalAddress.setBounds(100, 480,250, 40);
        _maritalAddress.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_maritalAddress);


        _maritalStatusPositive = new JRadioButton("YES");
        _maritalStatusPositive.setBounds(450, 480, 100, 40);
        _maritalStatusPositive.setBackground(Color.white);
        _maritalStatusPositive.setFont(new Font("Raleway", Font.BOLD, 15));
        _maritalStatusPositive.setFocusable(false);
        add(_maritalStatusPositive);
        
        
        _maritalStatusNegative = new JRadioButton("NO");
        _maritalStatusNegative.setBounds(550, 480, 200, 40);
        _maritalStatusNegative.setBackground(Color.white);
        _maritalStatusNegative.setFont(new Font("Raleway", Font.BOLD, 15));
        _maritalStatusNegative.setFocusable(false);
        add(_maritalStatusNegative);
        

        ButtonGroup _maritalStatusGroup = new ButtonGroup();
        _maritalStatusGroup.add(_maritalStatusNegative);
        _maritalStatusGroup.add(_maritalStatusPositive);

        
        
        JLabel _address = new JLabel("Address");
        _address.setBounds(100, 530, 200, 40);
        _address.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_address);
        
        
        JLabel _city = new JLabel("City");
        _city.setBounds(100, 580, 200, 40);
        _city.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_city);
        
        
        JLabel _state = new JLabel("State");
        _state.setBounds(100, 630, 200, 40);
        _state.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_state);
        
        
        JLabel _pinCode = new JLabel("Pin Code");
        _pinCode.setBounds(100, 680, 200, 40);
        _pinCode.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_pinCode);


        // all the textFields
        _textName = new JTextField();
        _textName.setBounds(450, 230, 500, 40);
        _textName.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textName.setHorizontalAlignment(JTextField.CENTER);
        add(_textName);
        
        _textFathersName = new JTextField();
        _textFathersName.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textFathersName.setBounds(450, 280, 500, 40);
        _textFathersName.setHorizontalAlignment(JTextField.CENTER);
        add(_textFathersName);

        _textEmailAddress = new JTextField();
        _textEmailAddress.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textEmailAddress.setBounds(450, 430, 500, 40);
        _textEmailAddress.setHorizontalAlignment(JTextField.CENTER);
        add(_textEmailAddress);
        
        _textAddress = new JTextField();
        _textAddress.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textAddress.setHorizontalAlignment(JTextField.CENTER);
        _textAddress.setBounds(450, 530, 500, 40);
        add(_textAddress);
        
        _textCity = new JTextField();
        _textCity.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textCity.setBounds(450, 580, 500, 40);
        _textCity.setHorizontalAlignment(JTextField.CENTER);
        add(_textCity);
        
        _textState = new JTextField();
        _textState.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textState.setBounds(450, 630, 500, 40);
        _textState.setHorizontalAlignment(JTextField.CENTER);
        add(_textState);
        
        _textPinCode = new JTextField();
        _textPinCode.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textPinCode.setBounds(450, 680, 500, 40);
        _textPinCode.setHorizontalAlignment(JTextField.CENTER);
        add(_textPinCode);

        _next = new JButton("Next");
        _next.setBounds(800,740, 150 ,40);
        _next.setFont(new Font("Raleway", Font.BOLD, 15));
        _next.setFocusable(false);
        _next.setBackground(Color.BLACK);
        _next.setForeground(Color.white);
        _next.addActionListener(this);
        add(_next);


        
        
        // attributes of the frame
        setTitle("Union Bank Of India                         |   New Account Application form:  Page-1");
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
        String _formNumber = "" + randomNumber;     // if you add ("" + int) this will convert the int to String
        String _userName = _textName.getText();
        String _userFathersName = _textFathersName.getText();
        String _userDOB = ((JTextField)chooseDate.getDateEditor().getUiComponent()).getText();
        String _userGender = null;
        if(_radioMale.isSelected()) {
            _userGender = "Male";
        } else if(_radioFemale.isSelected()) {
            _userGender = "Female";
        } else if(_others.isSelected()) {
            _userGender = "Not-Defined";
        }

        String _userEmail = _textEmailAddress.getText();  

        String _userMarried = null;
        if(_maritalStatusNegative.isSelected()) {
            _userMarried = "Unmarried";
        } else if(_maritalStatusPositive.isSelected()) {
            _userMarried = "Married";
        }

        String _userAddress = _textAddress.getText();
        String _userCity = _textCity.getText();
        String _userState = _textState.getText();
        String _userPinCode = _textPinCode.getText();




        // try to write all the if's for the error collection and checking
        try {
            if(_userName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name is Required.");
            } else if (_userFathersName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the father's Name");
            } else if(_userDOB.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Date Of Birth");
            } else if(_userGender.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Gender");
            } else if(_userEmail.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Email Address");
            } else if(_userMarried.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Marital Status");
            } else if(_userAddress.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Address");
            } else if(_userCity.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the City.");
            } else if(_userState.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the State");
            } else if(_userPinCode.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Pin Code");
            } else {
                DataBaseConnection DBConnection = new DataBaseConnection();
                DBConnection.insertCustomerData(_formNumber, _userName, _userFathersName, _userDOB, _userGender, _userEmail, _userMarried, _userAddress, _userCity, _userState, _userPinCode);


                setVisible(false);
                new SignUpTwo(_formNumber);
            }
        } catch (Exception except) {
            except.getMessage();
        }


    }

    public static void main(String[] args) {
        
        new SignUpOne();
    }
    
}
