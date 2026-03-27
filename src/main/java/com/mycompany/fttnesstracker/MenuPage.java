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

public class MenuPage {

    public String userName; // To store the logged-in user's name

    public MenuPage(String userName,String userAge,String gender) {
        this.userName = userName;

        // Create a JFrame container
        JFrame frame = new JFrame("Menu");
        Style.frameDecor(frame);

        // Main panel for the menu
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(238, 186, 76));

        // Header panel for the welcome text
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setBackground(new Color(238, 186, 76));

        JLabel welcomeLabel = new JLabel("Welcome " + userName + "!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Font and size for heading
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment
        headerPanel.add(welcomeLabel);

        // Add space after the heading
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Add header panel to the main panel
        mainPanel.add(headerPanel);

        // Add menu buttons
        JButton bmiButton = new JButton(" BMI Calculator ");
        Style.button(bmiButton);
        bmiButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(bmiButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        JButton exerciseButton = new JButton("     Exercise     ");
        Style.button(exerciseButton);
        exerciseButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(exerciseButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing

        JButton userButton = new JButton("User Information");
        Style.button(userButton);
        userButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(userButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Add spacing

        // Add action listeners for buttons
        bmiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new BMICalculator(userName,userAge,gender); // Navigate to BMI Calculator page
            }
        });

        exerciseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MotivationPage(userName,userAge,gender); // Navigate to Exercise page
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new UserInfoPage(userName,userAge,gender); // Navigate to User page
            }
        });

        // Add the main panel to the frame
        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true); // Make the frame visible
    }
}

