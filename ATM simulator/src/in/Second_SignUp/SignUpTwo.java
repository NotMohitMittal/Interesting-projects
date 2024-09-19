package in.Second_SignUp;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import in.Third_SignUp.SignUpThree;


public class SignUpTwo extends JFrame implements ActionListener {


    // global delaration of all the variables
    JTextField _textAadharNumber, _textPanNumber;
    JRadioButton _notHavingAccount, _havingAccount, _isSeniorCitizen, _isNotSeniorCitizen;
    JComboBox<String> _incomeOptions, _religionOptions, _categoryOptions, _educationOptions, _occupationOptions;
    JButton _next;

    private String _formNumber;

    public SignUpTwo(String _formNumber) {

        this._formNumber = _formNumber;

        ImageIcon _logoImage = new ImageIcon(ClassLoader.getSystemResource("images/Logo_3.png"));
        Image _logoImageResizing = _logoImage.getImage().getScaledInstance(400,150, Image.SCALE_DEFAULT);
        ImageIcon _logoImageFinalized = new ImageIcon(_logoImageResizing);
        JLabel labelLogoImage = new JLabel(_logoImageFinalized);
        labelLogoImage.setBounds(80,20,400,150); 
        add(labelLogoImage);


        
        JLabel _details = new JLabel("Additional Details:");
        _details.setBounds(100, 180,500, 40);
        _details.setFont(new Font("SansSerif", Font.BOLD,35));
        add(_details);


        // Religion
        JLabel _religion = new JLabel("Religion");
        _religion.setBounds(100, 270, 200, 40);
        _religion.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_religion);


        String[] _varReligions = {"Hindu", "Islam", "Christian", "Jain", "Sikh"};
        _religionOptions = new JComboBox<String>(_varReligions);
        _religionOptions.setBounds(450, 260, 500, 40);
        _religionOptions.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(_religionOptions);


        // Category
        JLabel _category = new JLabel("Category");
        _category.setBounds(100, 320,200, 40);
        _category.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_category);
        
        String[] _varCategory = {"General", "SC", "ST", "OBC"};
        _categoryOptions = new JComboBox<String>(_varCategory);
        _categoryOptions.setBounds(450, 320, 500, 40);
        _categoryOptions.setFont(new Font("SansSerif", Font.BOLD, 15));
        add(_categoryOptions);
        
        // Income
        JLabel _income = new JLabel("Income");
        _income.setBounds(100, 370,350, 40);
        _income.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_income);


        String[] _varIncomes = {"NULL", "< 1,50,000", "< 2,50,000", "< 5,00,000", "upto 10,00,000"};
        _incomeOptions = new JComboBox<String>(_varIncomes);
        _incomeOptions.setFont(new Font("Raleway", Font.BOLD, 15));
        _incomeOptions.setBounds(450, 370, 500, 40);
        add(_incomeOptions);

        
        // Education        
        JLabel _education = new JLabel("Educational Qualification");
        _education.setBounds(100, 430,350, 40);
        _education.setFont(new Font("SansSerif", Font.BOLD, 22));
        add(_education);

        String[] _varEducations = {"Graduate", "Non-Graduate", "Post-Graduate", "Docatrate", "Others"};
        _educationOptions = new JComboBox<String>(_varEducations);
        _educationOptions.setFont(new Font("Raleway", Font.BOLD, 15));
        _educationOptions.setBounds(450, 430, 500, 40);
        add(_educationOptions);



        // Occupation
        JLabel _occupation = new JLabel("Occupation");
        _occupation.setBounds(100, 510,250, 40);
        _occupation.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_occupation);

        String[] _varOccupations = {"Salried", "Self-Employed", "Business", "Student", "Retired"};
        _occupationOptions = new JComboBox<String>(_varOccupations);
        _occupationOptions.setFont(new Font("Raleway", Font.BOLD, 15));
        _occupationOptions.setBounds(450, 510, 500, 40);
        add(_occupationOptions);




        // PAN Number
        JLabel _panNumber = new JLabel("Pan Number");
        _panNumber.setBounds(100, 560, 200, 40);
        _panNumber.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_panNumber);
        
        _textPanNumber = new JTextField();
        _textPanNumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textPanNumber.setHorizontalAlignment(JTextField.CENTER);
        _textPanNumber.setBounds(450, 560, 500, 40);
        add(_textPanNumber);
        

        // Aadhar Number
        JLabel _aadharNumber = new JLabel("Aadhar Number");
        _aadharNumber.setBounds(100, 610, 300, 40);
        _aadharNumber.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_aadharNumber);

        _textAadharNumber = new JTextField();
        _textAadharNumber.setFont(new Font("Raleway", Font.PLAIN, 20));
        _textAadharNumber.setBounds(450, 610, 500, 40);
        _textAadharNumber.setHorizontalAlignment(JTextField.CENTER);
        add(_textAadharNumber);
        
        

        // Senior Citizen
        JLabel _seniorCitizen = new JLabel("Senior Citizen");
        _seniorCitizen.setBounds(100, 700, 200, 40);
        _seniorCitizen.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_seniorCitizen);


        _isSeniorCitizen = new JRadioButton("YES");
        _isSeniorCitizen.setBounds(450, 700, 100, 40);
        _isSeniorCitizen.setBackground(Color.white);
        _isSeniorCitizen.setFont(new Font("Raleway", Font.BOLD, 15));
        _isSeniorCitizen.setFocusable(false);
        add(_isSeniorCitizen);
        
        
        _isNotSeniorCitizen = new JRadioButton("NO");
        _isNotSeniorCitizen.setBounds(550, 700, 200, 40);
        _isNotSeniorCitizen.setBackground(Color.white);
        _isNotSeniorCitizen.setFont(new Font("Raleway", Font.BOLD, 15));
        _isNotSeniorCitizen.setFocusable(false);
        add(_isNotSeniorCitizen);
        

        ButtonGroup _seniorGroup = new ButtonGroup();
        _seniorGroup.add(_isNotSeniorCitizen);
        _seniorGroup.add(_isSeniorCitizen);

        
        // Existing Account
        JLabel _existingAccount= new JLabel("Existing Account");
        _existingAccount.setBounds(100, 750, 300, 40);
        _existingAccount.setFont(new Font("SansSerif", Font.BOLD, 23));
        add(_existingAccount);


        _havingAccount = new JRadioButton("YES");
        _havingAccount.setBounds(450, 750, 100, 40);
        _havingAccount.setBackground(Color.white);
        _havingAccount.setFont(new Font("Raleway", Font.BOLD, 15));
        _havingAccount.setFocusable(false);
        add(_havingAccount);
        
        
        _notHavingAccount = new JRadioButton("NO");
        _notHavingAccount.setBounds(550, 750, 200, 40);
        _notHavingAccount.setBackground(Color.white);
        _notHavingAccount.setFont(new Font("Raleway", Font.BOLD, 15));
        _notHavingAccount.setFocusable(false);
        add(_notHavingAccount);
        

        ButtonGroup _oldAccountGroup = new ButtonGroup();
        _oldAccountGroup.add(_notHavingAccount);
        _oldAccountGroup.add(_havingAccount);


        

        _next = new JButton("Next");
        _next.setBounds(800,780, 150 ,40);
        _next.setFont(new Font("Raleway", Font.BOLD, 15));
        _next.setFocusable(false);
        _next.setBackground(Color.BLACK);
        _next.setForeground(Color.white);
        _next.addActionListener(this);
        add(_next);


        
        
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
        String _userReligion = (String)_religionOptions.getSelectedItem();
        String _userCategory = (String)_categoryOptions.getSelectedItem();
        String _userIncome = (String)_incomeOptions.getSelectedItem();
        String _userEducation = (String)_educationOptions.getSelectedItem();
        String _userOccupation = (String)_occupationOptions.getSelectedItem();
        String _userPanNumber = _textPanNumber.getText();
        String _userAadharNumber = _textAadharNumber.getText();
        String _userAgeCategory = null;
        if(_isSeniorCitizen.isSelected()) {
            _userAgeCategory = "YES";
        } else if(_isNotSeniorCitizen.isSelected()) {
            _userAgeCategory = "NO";
        }

        String _userOldCustomer = null;
        if(_havingAccount.isSelected()) {
            _userOldCustomer = "YES";
        } else if(_notHavingAccount.isSelected()) {
            _userOldCustomer = "NO";
        }

        try {
            if(_userReligion.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Religion");
            } else if(_userCategory.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Category");
            } else if(_userIncome.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Income");
            } else if(_userEducation.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Education");
            } else if(_userOccupation.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Occupation");
            } else if(_userPanNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Pan Number");
            } else if(_userAadharNumber.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please Enter the Aadhar Number");
            } else {
                DataBaseConnector_2 DBConnector = new DataBaseConnector_2();
                DBConnector.insertAdditionalDetail(_formNumber, _userReligion, _userCategory, _userIncome, _userEducation, _userOccupation, _userPanNumber, _userAadharNumber, _userAgeCategory, _userOldCustomer);

                setVisible(false);
                new SignUpThree(_formNumber);
            }
        } catch(Exception except) {
            except.getMessage();
        }

    }

    public static void main(String[] args) {
        
        new SignUpTwo("");
    }
    
}
