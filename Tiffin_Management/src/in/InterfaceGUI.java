package in;

import java.awt.*;
import javax.swing.*;
import java.util.Date;
import java.awt.event.*;
import DatabaseManagement.DatabaseConnection;

public class InterfaceGUI extends JFrame implements ActionListener {

    JRadioButton _today, _anotherDay, _morning, _evening, _orderedBiryani, _orderedOthers;
    JTextField _leaveDescription, _prevDate;
    JLabel backGroundImage;
    JButton _submit, _exit, _getTotal;

    public InterfaceGUI() {

        // Image of the ATM
        ImageIcon _logoImage = new ImageIcon(ClassLoader.getSystemResource("images/forNow.jpg"));
        Image _logoImageResizing = _logoImage.getImage().getScaledInstance(1400, 1000, Image.SCALE_SMOOTH);
        ImageIcon _logoImageFinalized = new ImageIcon(_logoImageResizing);
        backGroundImage = new JLabel(_logoImageFinalized);
        backGroundImage.setBounds(0,0,1400, 1000);
        add(backGroundImage);


        JLabel description = new JLabel("Tiffin's Leave Management");
        description.setBounds(50, 150, 1000, 50);
        description.setFont(new Font("System", Font.BOLD, 45));
        description.setForeground(Color.cyan);
        backGroundImage.add(description);
        
        
        JLabel day = new JLabel("↣ What's the day we are talking about");
        day.setBounds(50, 300, 1000, 40);
        day.setFont(new Font("System", Font.BOLD, 25));
        day.setForeground(Color.decode("#75ff33"));
        backGroundImage.add(day);

        _today = new JRadioButton("Today");
        _today.setBounds(125, 350, 100, 40);
        _today.setFont(new Font("System", Font.BOLD, 20));
        _today.setFocusable(false);
        _today.setForeground(Color.ORANGE);
        _today.setOpaque(false);
        _today.setContentAreaFilled(false);
        _today.setBorderPainted(false);
        _today.addActionListener(this);
        backGroundImage.add(_today);
        
        
        _anotherDay = new JRadioButton("Another Day");
        _anotherDay.setBounds(300, 350, 170, 40);
        _anotherDay.setFont(new Font("System", Font.BOLD, 20));
        _anotherDay.setFocusable(false);
        _anotherDay.setForeground(Color.ORANGE);
        _anotherDay.setOpaque(false);
        _anotherDay.setContentAreaFilled(false);
        _anotherDay.setBorderPainted(false);
        _anotherDay.addActionListener(this);
        backGroundImage.add(_anotherDay);

        ButtonGroup dayGroup = new ButtonGroup();
        dayGroup.add(_today);
        dayGroup.add(_anotherDay);

        JLabel time = new JLabel("↣ What time 'Morning' or 'Evening'");
        time.setBounds(50, 500, 1000, 40);
        time.setFont(new Font("System", Font.BOLD, 25));
        time.setForeground(Color.decode("#75ff33"));
        backGroundImage.add(time);


        _morning = new JRadioButton("Morning");
        _morning.setBounds(125, 550, 120, 40);
        _morning.setFont(new Font("System", Font.BOLD, 20));
        _morning.setFocusable(false);
        _morning.setForeground(Color.WHITE);
        _morning.setOpaque(false);
        _morning.setContentAreaFilled(false);
        _morning.setBorderPainted(false);
        backGroundImage.add(_morning);
        
        
        
        _evening = new JRadioButton("Evening");
        _evening.setBounds(300, 550, 120, 40);
        _evening.setFont(new Font("System", Font.BOLD, 20));
        _evening.setFocusable(false);
        _evening.setForeground(Color.white);
        _evening.setOpaque(false);
        _evening.setContentAreaFilled(false);
        _evening.setBorderPainted(false);
        backGroundImage.add(_evening);

        ButtonGroup timeButtonGroup = new ButtonGroup();
        timeButtonGroup.add(_evening);
        timeButtonGroup.add(_morning);


        JLabel reason = new JLabel("Reason");
        reason.setBounds(50, 630, 200, 40);
        reason.setFont(new Font("System", Font.BOLD, 25));
        reason.setForeground(Color.decode("#75ff33"));
        backGroundImage.add(reason);

        _orderedBiryani = new JRadioButton("Ordered Biryani");
        _orderedBiryani.setBounds(125, 680, 210, 40);
        _orderedBiryani.setFont(new Font("System", Font.BOLD, 20));
        _orderedBiryani.setFocusable(false);
        _orderedBiryani.setForeground(Color.white);
        _orderedBiryani.setOpaque(false);
        _orderedBiryani.setContentAreaFilled(false);
        _orderedBiryani.setBorderPainted(false);
        _orderedBiryani.addActionListener(this);
        backGroundImage.add(_orderedBiryani);
        
        
        _orderedOthers = new JRadioButton("Something Other");
        _orderedOthers.setBounds(350, 680, 220, 40);
        _orderedOthers.setFont(new Font("System", Font.BOLD, 20));
        _orderedOthers.setFocusable(false);
        _orderedOthers.setForeground(Color.white);
        _orderedOthers.setOpaque(false);
        _orderedOthers.setContentAreaFilled(false);
        _orderedOthers.setBorderPainted(false);
        _orderedOthers.addActionListener(this);
        backGroundImage.add(_orderedOthers);


        ButtonGroup leave = new ButtonGroup();
        leave.add(_orderedBiryani);
        leave.add(_orderedOthers);



        _submit = new JButton("SUBMIT");
        _submit.setBounds(350, 950, 230, 40);
        _submit.setFont(new Font("System", Font.BOLD, 18));
        _submit.setForeground(Color.white);
        _submit.setBackground(Color.black);
        _submit.setFocusable(false);
        _submit.addActionListener(this);
        backGroundImage.add(_submit);
        

        _exit = new JButton("EXIT");
        _exit.setBounds(50, 950, 230, 40);
        _exit.setFont(new Font("System", Font.BOLD, 18));
        _exit.setForeground(Color.white);
        _exit.setBackground(Color.black);
        _exit.setFocusable(false);
        _exit.addActionListener(this);
        backGroundImage.add(_exit);
        

        _getTotal = new JButton("TOTAL");
        _getTotal.setBounds(1000, 950, 230, 40);
        _getTotal.setFont(new Font("System", Font.BOLD, 18));
        _getTotal.setForeground(Color.white);
        _getTotal.setBackground(Color.black);
        _getTotal.setFocusable(false);
        _getTotal.addActionListener(this);
        backGroundImage.add(_getTotal);



        // this is the attributes of the frame
        setTitle("Tiffin Leave Management");
        setSize(1350, 1000);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == _anotherDay) {

            if(_prevDate == null) {

                JLabel PrevDate = new JLabel("Previous Date");
                PrevDate.setBounds(50, 425, 200, 40);
                PrevDate.setFont(new Font("System", Font.BOLD, 20));
                PrevDate.setForeground(Color.white);
                PrevDate.setName("prevDateLabel");
                backGroundImage.add(PrevDate);
                

                _prevDate = new JTextField("Enter previous date");
                _prevDate.setBounds(235, 425, 250, 40);
                _prevDate.setFont(new Font("System", Font.PLAIN, 18));
                _prevDate.setForeground(Color.white);
                _prevDate.setBackground(Color.darkGray);
                _prevDate.setCaretColor(Color.red);
                _prevDate.setHorizontalAlignment(JTextField.CENTER);
                backGroundImage.add(_prevDate);

                _prevDate.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if(_prevDate.getText().equals("Enter previous date")) {
                            _prevDate.setText("");
                        }
                    }


                    @Override
                    public void focusLost(FocusEvent e) {
                        if(_prevDate.getText().isEmpty()) {
                            _prevDate.setText("Enter previous date");
                        }
                    }
                });

                // both these lines help the image to formated after the alteration
                backGroundImage.revalidate();
                backGroundImage.repaint();
            }

        } else if(e.getSource() == _today && _prevDate != null) {
            // Removing the TextField
            backGroundImage.remove(_prevDate);
            _prevDate = null;

            // findin the JLabel component and removing it
            for(Component comp : backGroundImage.getComponents()) {
                if(comp instanceof JLabel && "prevDateLabel".equals(comp.getName())) {
                    backGroundImage.remove(comp);
                }
            }

            // Reganing the backGroundImage again
            backGroundImage.revalidate();
            backGroundImage.repaint();
        } else if(e.getSource() == _orderedOthers) {

            if(_leaveDescription == null) {

                _leaveDescription = new JTextField("Enter the REASON");
                _leaveDescription.setBounds(170, 750, 350, 50);
                _leaveDescription.setFont(new Font("System", Font.PLAIN, 20));
                _leaveDescription.setForeground(Color.white);
                _leaveDescription.setBackground(Color.DARK_GRAY);
                _leaveDescription.setCaretColor(Color.red);
                _leaveDescription.setHorizontalAlignment(JTextField.CENTER);
                backGroundImage.add(_leaveDescription);

                JLabel _leaveReason = new JLabel("Reason");
                _leaveReason.setBounds(50, 750, 200, 40);
                _leaveReason.setFont(new Font("System", Font.BOLD, 20));
                _leaveReason.setForeground(Color.white);
                _leaveReason.setName("reason");
                backGroundImage.add(_leaveReason);
                
                
                _leaveDescription.addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        if(_leaveDescription.getText().equals("Enter the REASON")) {
                            _leaveDescription.setText("");
                        }
                    }
                    
                    @Override
                    public void focusLost(FocusEvent e) {
                        if(_leaveDescription.getText().isEmpty()) {
                            _leaveDescription.setText("Enter the REASON");
                        }
                    }
                });
                
                backGroundImage.revalidate();
                backGroundImage.repaint();
            }

        } else if(e.getSource() == _orderedBiryani && _leaveDescription != null) {
            backGroundImage.remove(_leaveDescription);
            _leaveDescription = null;


            for(Component comp : backGroundImage.getComponents()) {
                if(comp instanceof JLabel && "reason".equals(comp.getName())) {
                    backGroundImage.remove(comp);
                }
            }
            backGroundImage.revalidate();
            backGroundImage.repaint();

        } else if(e.getSource() == _submit) {
            int mealPrice = 60;
            String time = null;
            String date = null;
            String reason = null;
            
            if(_leaveDescription != null) {
                reason =  _leaveDescription.getText();
            } else if(_leaveDescription == null) {
                reason = "No specifice Reason Provided";
            }

            if(_morning.isSelected()) {
                time = "Evening";
            } else if(_evening.isSelected()) {
                time = "Morning";
            }
            
            if(_today.isSelected()) {
                date = new Date().toString();   // gives the current date and time in String
            } else if(_anotherDay.isSelected()) {
                date = _prevDate.getText();
            }

            DatabaseConnection DBConnection = new DatabaseConnection();
            DBConnection.insertIntoDatabase(reason, time, date, mealPrice);
            
            JOptionPane.showMessageDialog(null, "YOUR MEAL LEAVE HAS \n     BEEN UPDATED.");
            System.exit(0);

        } else if(e.getSource() == _exit) {
            System.exit(0);
        } else if(e.getSource() == _getTotal) {
            int TotalMoney = new DatabaseConnection().getTotalCost();
            JOptionPane.showMessageDialog(null, "Your Total Balance Saved " + TotalMoney);
        }
    }


    public static void main(String[] args) {
        new InterfaceGUI();
    }
    
}
