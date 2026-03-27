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
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserInfo {
    List<String[][]> user = new ArrayList<>();
    String fileName = "UserData.txt";

    

    public void userFileWrite() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String[][] layer : user) {
                for (String[] row : layer) {
                    for (String value : row) {
                        writer.write(value + ","); // Separate elements with a comma
                    }
                    writer.newLine(); // Newline for each row
                }
                writer.write("---\n"); // Separator between layers
            }
            System.out.println("3D array written to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userFileRead() {
        List<String[][]> layers = new ArrayList<>();

        File file = new File(fileName);
        if (!file.exists()) {
            try {
                // Create an empty file if it doesn't exist
                file.createNewFile();
                JOptionPane.showMessageDialog(null, "No existing user data found. A new file has been created.", "File Not Found", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Failed to create user data file. Please check permissions.", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
                return; // Exit the method if the file cannot be created
            }
        }

        try (Scanner scanner = new Scanner(file)) {
            List<String[]> rows = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("---")) {
                    // End of a layer
                    layers.add(rows.toArray(new String[0][]));
                    rows.clear();
                } else {
                    // Process a row
                    String[] row = line.split(","); // Split values by comma
                    rows.add(row);
                }
            }

            // Replace the current user list with the loaded data
            user = layers;
            System.out.println("User data loaded from file.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error reading user data file. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

public class SecondPage extends UserInfo {
    String loggedInUser = null;
    
    public SecondPage(String action) {
        // Load user data from the file at runtime
        userFileRead();

        JFrame frame = new JFrame(action.equals("Login") ? "Login Page" : "Sign Up Page");
        Style.frameDecor(frame);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(238, 186, 76)); // Background color for the main panel

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(238, 186, 76)); // Match the background color
        panel1.setLayout(new BorderLayout()); // Use BorderLayout for proper centering

        // Add label to panel1
        JLabel label = new JLabel(
                action.equals("Login") ? "Please Login" : "Create a New Account",
                SwingConstants.CENTER
        );
        label.setFont(new Font("Arial", Font.BOLD, 18)); // Set font and size
        label.setAlignmentX(Component.CENTER_ALIGNMENT); // Center alignment for the label
        panel1.add(label, BorderLayout.CENTER);

        // Add name label and field to panel
        JLabel nameLabel = new JLabel("Enter Name:");
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to center
        panel.add(nameLabel);

        JTextField nameField = new JTextField("");
        nameField.setMaximumSize(new Dimension(200, 30)); // Set size for text field
        panel.add(nameField);

        // Add password label and field to panel
        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Align to center
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField("");
        passwordField.setMaximumSize(new Dimension(200, 30)); // Set size for password field
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        panel.add(passwordField);

        // Add action button to panel
        JButton actionButton = new JButton(action);
        Style.button(actionButton);
        actionButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Align button to center
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Add spacing
        panel.add(actionButton);

        // Add panels to frame
        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.NORTH); // Add panel1 at the top
        frame.add(panel, BorderLayout.CENTER); // Add panel in the center

        frame.setVisible(true); // Make the frame visible

        actionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText().trim();
                
                
                String password = new String(passwordField.getPassword()).trim();
                // check if user didnt give wrong information
                if (!name.matches("[a-zA-Z]+")) {
                    JOptionPane.showMessageDialog(frame, "Name should contain only alphabets.");
                    return; // Stop further processing
                 }

                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Password cannot be empty.");
                    return; // Stop further processing
                }
                boolean userExists = false;

                // Check if user exists in the loaded data
                for (String[][] userLayer : user) {
                    String[] userDetails = userLayer[0]; // First row contains user details
                    if (userDetails[0].equals(name)) {
                        userExists = true;
                        if (userDetails[1].equals(password)) {
                            loggedInUser = name;
                            JOptionPane.showMessageDialog(frame, "Login Successful!");
                            frame.dispose(); // Exit after successful login

                            // Open MenuPage after successful login
                            new MenuPage(name,null,null);


                        } else {
                            JOptionPane.showMessageDialog(frame, "Incorrect Password. Try again.");
                        }
                    }
                }
                
                if (!userExists) {
                    if (action.equals("Sign Up")) {
                        // Add new user with null values for unspecified fields
                        String[][] newUser = {
                            {name, password, null, null}, // First column
                            {null, null, null, null} // Second column
                        };
                        user.add(newUser);
                        userFileWrite(); // Save updated user data to file
                        JOptionPane.showMessageDialog(frame, "Account Created Successfully!");
                        frame.dispose();

                        // Open ThirdPage after sign-up
                        new ThirdPage().showThirdPage(user, user.size() - 1,name);
                    } else {
                        JOptionPane.showMessageDialog(frame, "User not found. Please sign up.");
                        frame.dispose();
                        new SecondPage("Sign Up");
                        
                    }
                }
            }
        });

        frame.setVisible(true);
    }
    
    public int findUserIndex(String name) {
        for (int i = 0; i < user.size(); i++) {
            if (user.get(i)[0][0].equals(name)) {
                return i;
            }
        }
        return -1; // In case user is not found, though it should never happen
    }

    public static void main(String[] args) {
        new SecondPage("Sign Up"); // Test Sign Up
        new SecondPage("Login");  // Test Login
    }
}
