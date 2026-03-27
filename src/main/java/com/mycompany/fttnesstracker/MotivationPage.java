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

public class MotivationPage {
    public MotivationPage(String userName, String userAge, String userGender) {
        // Create the JFrame for the fourth page
        JFrame frame = new JFrame("Motivation Time!");
        Style.frameDecor(frame);

        // Panel for the motivational message
        JPanel messagePanel = new JPanel();
        messagePanel.setBackground(new Color(238, 186, 76));

        // Motivational message
        JLabel motivationLabel = new JLabel("Let's Do This, " + userName + "!", SwingConstants.CENTER);
        motivationLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Bold font, size 24
        motivationLabel.setForeground(Color.BLUE); // Set text color to blue

        JLabel subMessageLabel = new JLabel("Your health is your wealth. Keep pushing forward!", SwingConstants.CENTER);
        subMessageLabel.setFont(new Font("Serif", Font.PLAIN, 16)); // Plain font, size 16
        subMessageLabel.setForeground(Color.DARK_GRAY);

        messagePanel.add(motivationLabel, BorderLayout.NORTH);
        messagePanel.add(subMessageLabel, BorderLayout.CENTER);

        // Add a motivational image (optional)
        JLabel imageLabel = new JLabel(new ImageIcon(getClass().getResource("/Motivation.jpeg"))); // Replace with an actual image path
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messagePanel.add(imageLabel, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(messagePanel, BorderLayout.CENTER);

        // A button to close the motivation page
        JPanel buttonPanel= new JPanel();
        buttonPanel.setBackground(new Color(238, 186, 76));
        
        JButton closeButton = new JButton("Start Workout!");
        Style.button(closeButton);
        closeButton.setFont(new Font("SansSerif", Font.BOLD, 16));

        closeButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "All the best, " + userName + "!");
            frame.dispose(); // Close the fourth page
            new GoalSelectionPage(userName,userAge,userGender);
        });

        buttonPanel.add(closeButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Show the frame
        frame.setVisible(true);
    }
}

