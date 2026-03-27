 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fttnesstracker;

/**
 *
 * @author fahazkhan
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BMICalculator {

    public BMICalculator(String userName,String userAge, String userGender){
        // Create a new JFrame container
        JFrame frame = new JFrame("BMI Calculator");
        Style.frameDecor(frame);

        // Create a main panel and set its layout to BoxLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(238, 186, 76));

        // Create a header panel for the heading
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(238, 186, 76));
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));

        JLabel bmiLabel = new JLabel("BMI Calculator");
        bmiLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font and size for heading
        bmiLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment for the label
        headerPanel.add(bmiLabel);

        // Add space below the heading
        headerPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Add header panel to the main panel
        mainPanel.add(headerPanel);

        // Create input panel for fields and labels
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(new Color(238, 186, 76));

        // Height input fields
        JLabel heightLabel = new JLabel("Enter Height (feet and inches):");
        heightLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        inputPanel.add(heightLabel);

        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.X_AXIS));
        heightPanel.setBackground(new Color(238, 186, 76));
        JTextField feetField = new JTextField();
        JTextField inchesField = new JTextField();
        feetField.setMaximumSize(new Dimension(100, 30));
        inchesField.setMaximumSize(new Dimension(100, 30));
        heightPanel.add(feetField);
        heightPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Space between fields
        heightPanel.add(inchesField);
        inputPanel.add(heightPanel);

        // Add spacing after height input
        inputPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Weight input field
        JLabel weightLabel = new JLabel("Enter Weight (kg):");
        weightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(weightLabel);

        JTextField weightField = new JTextField();
        weightField.setMaximumSize(new Dimension(200, 30)); // Set width and height for consistency
        inputPanel.add(weightField);

        // Add spacing after weight input
        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Buttons
        JButton calculateButton = new JButton("Calculate BMI");
        Style.button(calculateButton);
        calculateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(calculateButton);

        inputPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Space between buttons

        JButton backButton = new JButton("Back");
        Style.button(backButton);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(backButton);

        // Add spacing after buttons
        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Result Label
        JLabel resultLabel = new JLabel("Your BMI will be displayed here.");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(resultLabel);

        // Add input panel to the main panel
        mainPanel.add(inputPanel);

        // Add action listener to calculate BMI
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double feet = Double.parseDouble(feetField.getText());
                    double inches = Double.parseDouble(inchesField.getText());
                    double weight = Double.parseDouble(weightField.getText());

                    // Convert height to meters
                    double heightInMeters = (feet * 0.3048) + (inches * 0.0254);
                    double bmi = weight / (heightInMeters * heightInMeters);
                    String category;
                    if (bmi < 18.5) {
                        category = "Underweight";
                    } else if (bmi >= 18.5 && bmi < 24.9) {
                        category = "Normal";
                    } else if (bmi >= 25 && bmi < 29.9) {
                        category = "Overweight";
                    } else {
                        category = "Obese";
                    }

                    // Display BMI and category
                    resultLabel.setText(String.format("Your BMI is: %.2f (%s)", bmi, category));
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers for height and weight.");
                }
            }
        });

        // Add action listener for the next button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new MenuPage(userName,userAge,userGender);
            }
        });

        // Add the main panel to the frame
        frame.add(mainPanel); // Adjust frame size
        frame.setVisible(true); // Make the frame visible

    }
}
