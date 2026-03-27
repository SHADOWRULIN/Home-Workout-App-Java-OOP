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
import java.util.List;

public class ThirdPage extends UserInfo{
    
    public void showThirdPage(List<String[][]> user, int userIndex, String userName) {
        // Create the JFrame for the third page (Matching second page dimensions)
        JFrame frame = new JFrame("Additional Information");
        Style.frameDecor(frame);
        frame.setLayout(new GridLayout(5, 1)); // Use GridLayout for consistent placement of components

        // Label for instructions
        JLabel label = new JLabel("Please provide additional information", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment for the label
        frame.add(label);

        // Gender selection components
        JPanel genderPanel = new JPanel();
        genderPanel.setBackground(new Color(238, 186, 76));
        JLabel genderLabel = new JLabel("Select your gender:");
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        genderPanel.add(genderLabel);
        genderPanel.add(maleButton);
        genderPanel.add(femaleButton);
        frame.add(genderPanel);

        // Age input components
        JPanel agePanel = new JPanel();
        agePanel.setBackground(new Color(238, 186, 76));
        JLabel ageLabel = new JLabel("Enter your age:");
        JTextField ageField = new JTextField(10); // TextField with width of 10 columns
        agePanel.add(ageLabel);
        agePanel.add(ageField);
        frame.add(agePanel);

        // Submit button
        JPanel submitPanel = new JPanel();
        submitPanel.setBackground(new Color(238, 186, 76));
        JButton submitButton = new JButton("Submit");
        Style.button(submitButton);
        submitPanel.add(submitButton);
        frame.add(submitPanel);

        // ActionListener for the Submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get selected gender
                String gender = null;
                if (maleButton.isSelected()) {
                    gender = "Male";
                } else if (femaleButton.isSelected()) {
                    gender = "Female";
                }

                // Get age input
                String age = ageField.getText().trim();

                // Validate inputs
                if (gender == null) {
                    JOptionPane.showMessageDialog(frame, "Please select your gender.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (age.isEmpty() || !age.matches("\\d+")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid age.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    // Update the user's array entry
                    String[][] userDetails = user.get(userIndex);
                    userDetails[0][2] = gender; // Update gender
                    userDetails[0][3] = age;   // Update age
                    JOptionPane.showMessageDialog(frame, "Information saved successfully!");
                    frame.dispose(); // Close the third page after saving info

                    // Navigate to the menu page with updated info
                    new MenuPage(userName, age, gender);
                } catch (IndexOutOfBoundsException ex) {
                    JOptionPane.showMessageDialog(frame, "Error: Invalid user index.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "An unexpected error occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

    // Show the frame after all components are added
    frame.setVisible(true);
    }
}
