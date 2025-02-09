package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class Flightinfo extends JFrame {

    public Flightinfo() {
       Color Skyblue = new Color(135, 190, 200);
        getContentPane().setBackground(Skyblue);
        setLayout(new BorderLayout());
        setTitle("Flight Information");
        setSize(800, 500);
        setLocationRelativeTo(null); // Center the window
        

        // Add a title label
        JLabel titleLabel = new JLabel("Flight Information", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel, BorderLayout.NORTH);

        // Create table and scroll pane
        JTable table = new JTable();
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 0, 800, 500);
        add(jsp);

        // Fetch data from the database
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("SELECT * FROM flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching flight data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT)
          new Flightinfo();
    }
}