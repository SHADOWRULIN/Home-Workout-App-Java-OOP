/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fttnesstracker;

/**
 *
 * @author fahazkhan
 */
import javax.swing.*;
import java.awt.*;

public class Fittnesstracker {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Home Workout App");
        Style.frameDecor(frame);

        // Create a label for the greeting message
        JLabel greetingLabel = new JLabel("Hello!", SwingConstants.CENTER);
        JLabel greetingLabel2 = new JLabel("I am your personal coach.", SwingConstants.CENTER);
        greetingLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        greetingLabel2.setFont(new Font("Arial", Font.PLAIN, 20));

        // Create the logo label
        ImageIcon logoIcon = new ImageIcon(Fittnesstracker.class.getResource("/Logo.jpg"));// Replace with the path to your logo
        JLabel logoLabel = new JLabel(logoIcon, SwingConstants.CENTER);

        // Use a JPanel to stack the two labels and the logo
        JPanel greetingPanel = new JPanel();
        greetingPanel.setBackground(new Color(238, 186, 76)); 
        greetingPanel.setLayout(new GridLayout(3, 1)); // Three rows for two labels and one logo
        greetingPanel.add(greetingLabel);
        greetingPanel.add(logoLabel);  // Add logo between the text labels
        greetingPanel.add(greetingLabel2);

        frame.add(greetingPanel, BorderLayout.CENTER);

        // Create the button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(new Color(238, 186, 76)); 

        JButton loginButton = new JButton("Login");
        Style.button(loginButton);
        JButton signUpButton = new JButton("Sign Up");
        Style.button(signUpButton);

        buttonPanel.add(loginButton);
        buttonPanel.add(signUpButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Add ActionListeners to buttons
        loginButton.addActionListener(e -> {
            // Open the second page for Login
            new SecondPage("Login");
            frame.dispose(); // Close the first page
        });

        signUpButton.addActionListener(e -> {
            // Open the second page for Sign Up
            new SecondPage("Sign Up");
            frame.dispose(); // Close the first page
        });

        frame.setVisible(true);
    }
}

class Style {
    public static void button(JButton buttName) {
        buttName.setFont(new Font("Arial", Font.BOLD, 16)); // Set font and size
        buttName.setBackground(new Color(58, 58, 60)); // Set background color (Dodger Blue)
        buttName.setForeground(Color.WHITE); // Set text color
        buttName.setFocusPainted(false); // Remove focus border
        buttName.setBorder(BorderFactory.createLineBorder(new Color(58, 58, 60), 2)); // Add a custom border
        buttName.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Change cursor on hover
    }

    public static void frameDecor(JFrame frameName) {
        frameName.setSize(600, 500);
        frameName.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameName.setLayout(new BorderLayout());
        frameName.setLocationRelativeTo(null);

        // Set a custom background color
        frameName.getContentPane().setBackground(new Color(238, 186, 76)); // Alice Blue
    }
}
