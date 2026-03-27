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

public class GoalSelectionPage extends JFrame {

    public GoalSelectionPage(String userName, String userAge, String userGender) {
        setTitle("Choose Your Goal");
        setLocationRelativeTo(null);
        Style.frameDecor(this);

        // Theme color
        Color themeColor = new Color(238, 186, 76);

        // Create components
        JLabel titleLabel = new JLabel("Select Your Goal");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(Color.BLACK);

        // Create buttons for weight loss and weight gain
        JButton loseWeightButton = new JButton("Lose Weight");
        JButton gainWeightButton = new JButton("Gain Weight");

        // Style the buttons
        Style.button(loseWeightButton);
        Style.button(gainWeightButton);

        // Panel to hold buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.setBackground(themeColor);
        buttonPanel.add(loseWeightButton);
        buttonPanel.add(gainWeightButton);

        // Add components to the frame
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        // Action listeners for the buttons
        loseWeightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current frame
                new ExercisePage(userName, userAge, userGender, "Lose Weight"); // Navigate to Lose Weight page
            }
        });

        gainWeightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current frame
                new ExercisePage(userName, userAge, userGender, "Gain Weight"); // Navigate to Gain Weight page
            }
        });

        // Make frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Example usage
        new GoalSelectionPage("John", "25", "Male");
    }
}

