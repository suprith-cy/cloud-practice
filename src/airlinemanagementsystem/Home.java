package airlinemanagementsystem;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Home extends JFrame implements ActionListener {
    
    JLabel heading;

    public Home() {
        // Set layout for the frame
        setLayout(null);

        // Add background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/air1.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1600, 800); // Full-screen image
        add(image);
        
        // Heading Text - Centering it manually
        heading = new JLabel("WELCOME TO AIRLINES");
        heading.setFont(new Font("Arial", Font.BOLD, 40));  
        heading.setForeground(Color.BLACK);  
        heading.setBounds(500, 50, 600, 60); // Fixed position
        image.add(heading);

        // Menu Bar
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("DETAILS");
        menubar.add(details);
        
        JMenuItem flightDetails = new JMenuItem("FLIGHT DETAILS");
        flightDetails.addActionListener(this);
        details.add(flightDetails); 
        
        JMenuItem customerDetails = new JMenuItem("ADD CUSTOMER DETAILS");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem  bookFlight = new JMenuItem("BOOK FLIGHT");
         bookFlight.addActionListener(this);
        details.add(bookFlight);
       
        JMenuItem journeyDetails = new JMenuItem("JOURNEY DETAILS");
        journeyDetails.addActionListener(this);
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation = new JMenuItem("CANCEL TICKETS");
        ticketCancellation.addActionListener(this);
        details.add(ticketCancellation);
        
        JMenu tickets = new JMenu("TICKETS");
        menubar.add(tickets);
        
        JMenuItem boardingPass = new JMenuItem("BOARDING PASS");
        boardingPass.addActionListener(this);
        tickets.add(boardingPass);

        // Set frame properties
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Action handling for menu items
    public void actionPerformed(ActionEvent ae) {
        String text = ae.getActionCommand();
        
        if (text.equals("FLIGHT DETAILS")) {
            new Flightinfo();  
        } else if (text.equals("ADD CUSTOMER DETAILS")) {
            new AddCustomer();   
        } else if (text.equals("JOURNEY DETAILS")) {
             new JourneyDetails();
        }  
        else if (text.equals("CANCEL TICKETS")) {
            new Cancel();
        }else if (text.equals("BOOK FLIGHT")) {
            new BookFlight();
             
        }
        else if (text.equals("BOARDING PASS")) {
            new BoardingPass ();
             
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
