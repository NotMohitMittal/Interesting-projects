import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


import com.toedter.calendar.JDateChooser;


public class signUpOne extends JFrame implements ActionListener {

    //Globalling the variable
    long randomFormNumber;
    JDateChooser dateChooser;
    JTextField nameTextField, fatherTextField, emailTextBox, addressTextBox, stateTextBox, cityTextBox, postalTextBox;
    JRadioButton male, female, married, unmarried, other;
    JButton next;


    signUpOne() {

        setLayout(null);

        Random ran = new Random();
        randomFormNumber = Math.abs(ran.nextLong() % 9000L) + 1000L ;    // this gives the 4 digit random number

        JLabel formIntro = new JLabel("Application Number: " + randomFormNumber);
        formIntro.setFont(new Font("geneva", Font.BOLD, 30));
        formIntro.setBounds(350, 20, 600, 40);
        formIntro.setForeground(Color.white);
        
        JLabel info = new JLabel("Page: 1 - Personal Details");
        info.setFont(new Font("geneva", Font.BOLD, 25));
        info.setBounds(125, 90, 600, 40);
        info.setForeground(Color.white);

        JLabel line = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        line.setBounds(0, 130, 1200, 20);
        line.setForeground(Color.white);


        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("geneva", Font.BOLD, 20));
        name.setBounds(150, 180, 100, 40);
        name.setForeground(Color.white);

        JLabel fatherName = new JLabel("Father's Name: ");
        fatherName.setFont(new Font("arial", Font.BOLD, 20));
        fatherName.setBounds(150, 240, 200, 40);
        fatherName.setForeground(Color.white);

        JLabel dateOfBirth = new JLabel("Date of Birth: ");
        dateOfBirth.setFont(new Font("arial", Font.BOLD, 20));
        dateOfBirth.setBounds(150, 300, 200, 40);
        dateOfBirth.setForeground(Color.white);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("arial", Font.BOLD, 20));
        gender.setBounds(150, 360, 200, 40);
        gender.setForeground(Color.white);

        JLabel Email = new JLabel("Email Address: ");
        Email.setFont(new Font("arial", Font.BOLD, 20));
        Email.setBounds(150, 420, 200, 40);
        Email.setForeground(Color.white);

        JLabel isBachlor = new JLabel("Marital Status: ");
        isBachlor.setFont(new Font("arial", Font.BOLD, 20));
        isBachlor.setBounds(150, 480, 200, 40);
        isBachlor.setForeground(Color.white);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("arial", Font.BOLD, 20));
        address.setBounds(150, 540, 200, 40);
        address.setForeground(Color.white);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("arial", Font.BOLD, 20));
        city.setBounds(150, 600, 200, 40);
        city.setForeground(Color.white);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("arial", Font.BOLD, 20));
        state.setBounds(150, 660, 200, 40);
        state.setForeground(Color.white);

        JLabel postalNum = new JLabel("Pin Code: ");
        postalNum.setFont(new Font("arial", Font.BOLD, 20));
        postalNum.setBounds(150, 720, 200, 40);
        postalNum.setForeground(Color.white);


        // adding the textFields 

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("arial", Font.BOLD, 16));
        nameTextField.setBounds(500, 180, 500, 30);
        nameTextField.setBackground(Color.lightGray);
        nameTextField.setForeground(Color.BLACK);

        fatherTextField = new JTextField();
        fatherTextField.setFont(new Font("arial", Font.BOLD, 16));
        fatherTextField.setBounds(500, 240, 500, 30);
        fatherTextField.setBackground(Color.lightGray);
        fatherTextField.setForeground(Color.BLACK);

        emailTextBox = new JTextField();
        emailTextBox.setFont(new Font("arial", Font.BOLD, 16));
        emailTextBox.setBounds(500, 420, 500, 30);
        emailTextBox.setBackground(Color.lightGray);
        emailTextBox.setForeground(Color.BLACK);

        addressTextBox = new JTextField();
        addressTextBox.setFont(new Font("arial", Font.BOLD, 16));
        addressTextBox.setBounds(500, 540, 500, 30);
        addressTextBox.setBackground(Color.lightGray);
        addressTextBox.setForeground(Color.BLACK);

        cityTextBox = new JTextField();
        cityTextBox.setFont(new Font("arial", Font.BOLD, 16));
        cityTextBox.setBounds(500, 600, 500, 30);
        cityTextBox.setBackground(Color.lightGray);
        cityTextBox.setForeground(Color.BLACK);

        stateTextBox = new JTextField();
        stateTextBox.setFont(new Font("arial", Font.BOLD, 16));
        stateTextBox.setBounds(500, 660, 500, 30);
        stateTextBox.setBackground(Color.lightGray);
        stateTextBox.setForeground(Color.BLACK);

        postalTextBox = new JTextField();
        postalTextBox.setFont(new Font("arial", Font.BOLD, 16));
        postalTextBox.setBounds(500, 720, 500, 30);
        postalTextBox.setBackground(Color.lightGray);
        postalTextBox.setForeground(Color.BLACK);


        dateChooser = new JDateChooser();
        dateChooser.setBounds(500, 300, 350, 30);
        dateChooser.setBackground(Color.lightGray);


        male = new JRadioButton("Male");
        male.setBounds(500, 360, 100, 30);
        male.setFont(new Font("arial", Font.BOLD, 14));
        male.setBackground(Color.darkGray);
        male.setForeground(Color.WHITE);
        
        female = new JRadioButton("Female");
        female.setBounds(650, 360, 100, 30);
        female.setFont(new Font("arial", Font.BOLD, 14));
        female.setBackground(Color.darkGray);
        female.setForeground(Color.WHITE);


        // to select only one radio button at a time
        ButtonGroup groupMaleFemale = new ButtonGroup();
        groupMaleFemale.add(male);
        groupMaleFemale.add(female);
        

        married = new JRadioButton("Married");
        married.setBounds(500, 480, 100, 30);
        married.setFont(new Font("arial", Font.BOLD, 14));
        married.setBackground(Color.darkGray);
        married.setForeground(Color.WHITE);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(650, 480, 150, 30);
        unmarried.setFont(new Font("arial", Font.BOLD, 14));
        unmarried.setBackground(Color.darkGray);
        unmarried.setForeground(Color.WHITE);
        
        other = new JRadioButton("Other");
        other.setBounds(800, 480, 100, 30);
        other.setFont(new Font("arial", Font.BOLD, 14));
        other.setBackground(Color.darkGray);
        other.setForeground(Color.WHITE);

        ButtonGroup relationShip = new ButtonGroup();
        relationShip.add(married);
        relationShip.add(unmarried);
        relationShip.add(other);


        //making the next button

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(910, 800, 80, 30);
        next.setFont(new Font("arial", Font.BOLD, 14));
        next.addActionListener(this);

        // adding the Labels into the form
        add(formIntro);
        add(info);
        add(line);
        add(name);
        add(fatherName);
        add(dateOfBirth);
        add(gender);
        add(Email);
        add(isBachlor);
        add(address);
        add(city);
        add(state);
        add(postalNum);

        // adding textFields
        add(nameTextField);
        add(fatherTextField);
        add(male); add(female);
        add(emailTextBox);
        add(married); add(unmarried); add(other);
        add(addressTextBox);
        add(stateTextBox);
        add(cityTextBox);
        add(postalTextBox);
        add(next);


        add(dateChooser);




        setTitle("SingUp");
        setSize(1200, 1000);
        setVisible(true);
        setLocation(370, 100);
        getContentPane().setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }


    // listining to all the inputs and the buttons

    public void actionPerformed(ActionEvent e) {
        String formNum = "" + randomFormNumber; // converting the long into string for string into database
        String name = nameTextField.getText();
        String father = fatherTextField.getText();
        String birthDate = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if(female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextBox.getText();
        String relationStatus = null;
        if(married.isSelected()) {
            relationStatus = "Married";
        } else if(unmarried.isSelected()) {
            relationStatus = "Unmarried";
        } else if(other.isSelected()) {
            relationStatus = "Other";
        }   
        String address = addressTextBox.getText();
        String state = stateTextBox.getText();
        String city = cityTextBox.getText();
        String postalNum = postalTextBox.getText();
        
        // this portion is not working
        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Needed.");
            }
            else {
                dataBaseConnection connect = new dataBaseConnection();
                String query = "insert into signUp values ('"+formNum+"', '"+name+"', '"+father+"', '"+birthDate+"', '"+gender+"', '"+email+"', '"+relationStatus+"', '"+address+"', '"+city+"', '"+state+"','"+postalNum+"')";
                connect.s.executeUpdate(query);
            }
        } catch(Exception ae) {
            System.out.println(ae);
        }
    }



    public static void main(String[] args) {
        new signUpOne();
    }
}


// this is the command to compile and run it due to the calander


// cd /home/infector/Documents/Project/bank_management_system/src/
// javac -cp .:../lib/jcalendar-1.4.jar signUpOne.java
// java -cp .:../lib/jcalendar-1.4.jar signUpOne
