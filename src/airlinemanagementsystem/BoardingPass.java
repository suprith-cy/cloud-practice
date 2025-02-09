
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;


public class BoardingPass extends JFrame implements ActionListener{
    
    JTextField tfpnr;
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchButton,download;
    
    public BoardingPass() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        
        JLabel subheading = new JLabel("Boarding Pass");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 24));
        subheading.setForeground(Color.BLUE);
        add(subheading);
        
        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60, 100, 150, 25);
        subheading.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 24));
        add(lblaadhar);
        
        tfpnr = new JTextField();
        tfpnr.setBounds(220, 100, 150, 25);
        add(tfpnr);
        
        fetchButton = new JButton("Enter");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 100, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
         download = new JButton("print");
        download.setBackground(Color.BLACK);
        download.setForeground(Color.WHITE);
        download.setBounds(380, 150, 120, 25);
        download.addActionListener(this);
        add(download);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setBounds(60, 140, 150, 25);
       lblname.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("NATIONALITY");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);
        
        JLabel lbladdress = new JLabel("SRC");
        lbladdress.setBounds(60, 220, 150, 25);
        lbladdress.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        add(lbladdress);
        
        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc);
        
        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(380, 220, 150, 25);
        lblgender.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        add(lblgender);
        
        lbldest = new JLabel();
        lbldest.setBounds(540, 220, 150, 25);
        add(lbldest);
        
        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 260, 150, 25);
        lblfname.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220, 260, 150, 25);
        add(labelfname);
        
        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(380, 260, 150, 25);
        lblfcode.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));;
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(540, 260, 150, 25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 300, 150, 25);
        lbldate.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        add(lbldate);
        
        labeldate = new JLabel();
        labeldate.setBounds(220, 300, 150, 25);
        add(labeldate);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        java.awt.Image i2 = i1.getImage().getScaledInstance(300, 230, java.awt.Image.SCALE_SMOOTH);

        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);
        
        setSize(1000, 450);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText();

        try {
            Conn conn = new Conn();

            String query = "select * from reservation where PNR = '"+pnr+"'";

            ResultSet rs = conn.s.executeQuery(query);

            if (rs.next()) {
                tfname.setText(rs.getString("NAME")); 
                tfnationality.setText(rs.getString("NATIONALITY")); 
                lblsrc.setText(rs.getString("src")); 
                lbldest.setText(rs.getString("des"));  
                labelfname.setText(rs.getString("flightname"));  
                labelfcode.setText(rs.getString("flightcode"));  
                labeldate.setText(rs.getString("ddate")); 
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct PNR");                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
                if (ae.getSource() == download) {
            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream("BoardingPass.pdf"));
                document.open();
                
                document.add(new Paragraph("BOARDING PASS\n\n"));
                document.add(new Paragraph("PNR: " + tfpnr.getText()));
                document.add(new Paragraph("Name: " + tfname.getText()));
                document.add(new Paragraph("Nationality: " + tfnationality.getText()));
                document.add(new Paragraph("From: " + lblsrc.getText()));
                document.add(new Paragraph("To: " + lbldest.getText()));
                document.add(new Paragraph("Flight: " + labelfname.getText()));
                document.add(new Paragraph("Flight Code: " + labelfcode.getText()));
                document.add(new Paragraph("Date: " + labeldate.getText()));

                document.close();
                JOptionPane.showMessageDialog(null, "Boarding Pass downloaded successfully!");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
