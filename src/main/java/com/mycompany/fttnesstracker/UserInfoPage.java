/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fttnesstracker;

/**
 *
 * @author fahazkhan
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoPage extends JFrame {

    public UserInfoPage(String userName, String userAge, String userGender) {
        setTitle("User Information");
        setLocationRelativeTo(null);
        Style.frameDecor(this);

        // Theme color
        Color themeColor = new Color(238, 186, 76);

        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(themeColor);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Header label
        JLabel headerLabel = new JLabel("User Information");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 22));
        headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(headerLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        // Display user details
        JLabel nameLabel = new JLabel("Name: " + userName);
        JLabel ageLabel = new JLabel("Age: " + userAge);
        JLabel genderLabel = new JLabel("Gender: " + userGender);

        // Set font and alignment
        Font infoFont = new Font("Arial", Font.PLAIN, 16);
        nameLabel.setFont(infoFont);
        ageLabel.setFont(infoFont);
        genderLabel.setFont(infoFont);

        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        genderLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Add labels to the panel
        mainPanel.add(nameLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        mainPanel.add(ageLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        mainPanel.add(genderLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer

        // Back button
        JButton backButton = new JButton("Back");
        Style.button(backButton);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(backButton);

        // Sign Out button
        JButton signOutButton = new JButton("Sign Out");
        Style.button(signOutButton);
        signOutButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer
        mainPanel.add(signOutButton);

        // Back button functionality
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuPage(userName, userAge, userGender); // Navigate back to the menu
            }
        });

        // Sign Out button functionality
        signOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle sign out logic here (for example, navigate to login page)
                JOptionPane.showMessageDialog(null, "Signed out successfully!");
                dispose(); // Close the current page
                new SecondPage("Login");// Redirect to the login page (You should create this class)
            }
        });

        // Set up the frame
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        setVisible(true);
    }
}

