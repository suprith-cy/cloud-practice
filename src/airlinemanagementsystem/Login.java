package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;


    class Login extends JFrame implements ActionListener {
    JButton submit, reset, close;
    JTextField tfusername;
    JPasswordField tfpassword;

    public Login() {
 

        setLayout(null);

// Add background image
ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/air.jpg"));
JLabel image = new JLabel(i1);
image.setBounds(0, 0, 1600, 800); // Full-screen image
add(image);

// Position username label and text field
JLabel lblusername = new JLabel("Username");
lblusername.setBounds(20, 60, 120, 25);
Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
lblusername.setFont(font);
lblusername.setForeground(Color.WHITE);
tfusername = new JTextField();
tfusername.setBounds(130, 60, 170, 25);
image.add(tfusername);
image.add(lblusername);

// Position password label and text field
JLabel lblpassword = new JLabel("Password");
lblpassword.setBounds(20, 110, 120, 25);
image.add(lblpassword);
lblpassword.setFont(font);
lblpassword.setForeground(Color.WHITE);
tfpassword = new JPasswordField();
tfpassword.setBounds(130, 110, 170, 25);
image.add(tfpassword);

// Position the buttons below the text fields
reset = new JButton("Reset");
reset.setBounds(130, 160, 70, 25);
reset.addActionListener(this);
image.add(reset);

close = new JButton("Close");
close.setBounds(240, 160, 70, 25);
close.addActionListener(this);
image.add(close);

submit = new JButton("Submit");
submit.setBounds(180, 200, 80, 25);
submit.addActionListener(this);
image.add(submit);

// Set frame properties
setExtendedState(JFrame.MAXIMIZED_BOTH);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
   
    }


   public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == submit) {
        String username = tfusername.getText();
        char[] passwordChars = tfpassword.getPassword();
String password = new String(passwordChars);
        try {
             Conn c=new Conn();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
//            // Use PreparedStatement to prevent SQL Injection
//            PreparedStatement pst = c.s.prepareStatement(query);
//            pst.setString(1, username);
//            pst.setString(2, password);
            ResultSet rs = c.s.executeQuery(query);
            
            if (rs.next()) {
                 new Home();
                // Open the main window or dashboard here
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                tfusername.setText("");
                tfpassword.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    } else if (ae.getSource() == close) {
        setVisible(false);
    } else if (ae.getSource() == reset) {
        tfusername.setText("");
        tfpassword.setText("");
    }
    
}

    public static void main(String[] args) {
        new Login();
    }
}