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

public class ExercisePage extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JLabel timerLabel;
    private int secondsPassed = 0;
    private Timer timer;
    private boolean isTimerRunning = false; // To track if the timer is running
    private JButton startStopButton; // The button to start/stop the timer

    public ExercisePage(String userName, String userAge, String userGender, String goal) {
        setTitle("Exercise List");
        setLocationRelativeTo(null);
        Style.frameDecor(this);

        // Theme color
        Color themeColor = new Color(238, 186, 76);

        // Define exercise lists for different goals
        String[] weightLossWeek1Exercises = {
                "Burpees",
                "Jumping Jacks",
                "Mountain Climbers",
                "High Knees"
        };

        String[] weightLossWeek2Exercises = {
                "Running",
                "Jump Rope",
                "Squat Jumps",
                "Plank to Push-up"
        };

        String[] weightGainWeek1Exercises = {
                "Push-ups",
                "Squats",
                "Deadlifts",
                "Lunges"
        };

        String[] weightGainWeek2Exercises = {
                "Bench Press",
                "Pull-ups",
                "Leg Press",
                "Dumbbell Rows"
        };

        // Select exercises based on the goal
        String[] week1Exercises = goal.equals("Lose Weight") ? weightLossWeek1Exercises : weightGainWeek1Exercises;
        String[] week2Exercises = goal.equals("Lose Weight") ? weightLossWeek2Exercises : weightGainWeek2Exercises;

        JList<String> week1List = new JList<>(week1Exercises);
        JList<String> week2List = new JList<>(week2Exercises);

        JScrollPane week1Scroller = new JScrollPane(week1List);
        JScrollPane week2Scroller = new JScrollPane(week2List);

        // Main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.add(createListPanel(week1Scroller), "Week 1");
        mainPanel.add(createListPanel(week2Scroller), "Week 2");
        mainPanel.setBackground(themeColor);

        // Button panel for navigation
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBackground(themeColor);

        // Back button panel (aligned to left)
        JPanel backButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        backButtonPanel.setBackground(themeColor);
        JButton backButton = new JButton("Back");
        Style.button(backButton);
        backButtonPanel.add(backButton);

        // Center button panel (for Week 1 and Week 2 buttons)
        JPanel centerButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        centerButtonPanel.setBackground(themeColor);
        JButton week1Button = new JButton("Week 1");
        JButton week2Button = new JButton("Week 2");
        Style.button(week1Button);
        Style.button(week2Button);
        centerButtonPanel.add(week1Button);
        centerButtonPanel.add(week2Button);

        // Add sub-panels to the button panel
        buttonPanel.add(backButtonPanel, BorderLayout.WEST);
        buttonPanel.add(centerButtonPanel, BorderLayout.CENTER);

        // Timer label for the timer
        timerLabel = new JLabel("00:00");
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timerLabel.setPreferredSize(new Dimension(400, 50));
        JPanel timerPanel = new JPanel(new BorderLayout());
        timerPanel.setBackground(themeColor);
        timerPanel.add(timerLabel, BorderLayout.CENTER);

        // Start/Stop button
        startStopButton = new JButton("Start");
        Style.button(startStopButton);
        startStopButton.setPreferredSize(new Dimension(100, 40));
        startStopButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isTimerRunning) {
                    // Stop the timer
                    timer.stop();
                    startStopButton.setText("Start");
                } else {
                    // Start the timer
                    timer.start();
                    startStopButton.setText("Stop");
                }
                isTimerRunning = !isTimerRunning; // Toggle the timer state
            }
        });

        // Add the start/stop button to the bottom panel
        timerPanel.add(startStopButton, BorderLayout.SOUTH);

        // Add action listeners to buttons
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current frame
                new MenuPage(userName, userAge, userGender); // Navigate back to MenuPage
            }
        });

        week1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Week 1");
            }
        });

        week2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Week 2");
            }
        });

        // Timer functionality
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                secondsPassed++;
                int minutes = secondsPassed / 60;
                int seconds = secondsPassed % 60;
                String timeString = String.format("%02d:%02d", minutes, seconds);
                timerLabel.setText(timeString);
            }
        });

        // Set layout and add components to the frame
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(timerPanel, BorderLayout.SOUTH);

        // Make frame visible
        setVisible(true);
    }

    // Helper method to create list panels
    private JPanel createListPanel(JScrollPane scroller) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(238, 186, 76)); // Theme color
        panel.add(scroller, BorderLayout.CENTER);
        return panel;
    }

}



