/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

 import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddCustomer extends JFrame implements ActionListener  {
     JTextField tfname, tfphone, tfaadhar, tfnationality, tfaddress;
     JRadioButton rbmale, rbfemale;
     
     
   public AddCustomer(){
       Color skyBlue = new Color(135, 190, 200); // RGB values for sky blue
getContentPane().setBackground(skyBlue);
        
       setLayout(null);
       
       
       JLabel heading=new JLabel("ADD CUSTOMER DETAILS");
       heading.setBounds(220,20,500,35);
       heading.setFont(new Font("Tahoma",Font.BOLD,32));
       heading.setForeground(Color.BLUE);
       add(heading);
       
       JLabel name=new JLabel("NAME");
       name.setBounds(50,100,500,30);
       name.setFont(new Font("Tahoma",Font.PLAIN,20));
       add(name);
       
       tfname=new JTextField();
       tfname.setBounds(250,100,200,30);
       add(tfname);
       
       JLabel nationality=new JLabel("NATIONALITY");
       nationality.setBounds(50,135,200,30);
       nationality.setFont(new Font("tahoma",Font.PLAIN,20));
       add(nationality);
       
       tfnationality=new JTextField();
       tfnationality.setBounds(250,135,200,30);
       add(tfnationality);
       
       JLabel aadhar=new JLabel("ADHAR NO");
       aadhar.setBounds(50,170,200,30);
       aadhar.setFont(new Font("tahoma",Font.PLAIN,20));
       add(aadhar);
       
       tfaadhar=new JTextField();
       tfaadhar.setBounds(250,170,200,30);
       add(tfaadhar);
       
        JLabel lbladdress = new JLabel("ADDRESS");
        lbladdress.setBounds(50, 205, 200, 30);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(250, 205, 200, 30);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("GENDER");
        lblgender.setBounds(50, 240, 200, 30);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblgender);
        
         ButtonGroup gendergroup = new ButtonGroup();
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(250, 240, 80, 20);
        rbmale.setBackground(skyBlue);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(320, 240, 100, 20);
        rbfemale.setBackground(skyBlue);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
        JLabel lblphone = new JLabel("PHONE");
        lblphone.setBounds(50, 270, 100, 30);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(250, 270, 200, 30);
        add(tfphone);
        
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.WHITE);
        save.setForeground(Color.BLACK);
        save.setBounds(250, 330, 100, 30);
        save.addActionListener(this); 
        add(save);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(480, 80, 280, 400);
        add(lblimage);
        
       setSize(900,600);
       setLocation(300,150);
       setVisible(true);
       
   }
   
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        try {
            Conn conn = new Conn();
            
            String query = "insert into passenger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"', '"+gender+"')";
        
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
        
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
   public static void main(String[] args){
       new AddCustomer();
   }
    
}
