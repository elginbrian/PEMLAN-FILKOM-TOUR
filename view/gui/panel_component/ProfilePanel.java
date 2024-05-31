package gui.panel_component;

import model.UserModel;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    public ProfilePanel(UserModel userModel){
        setBackground(new Color(30, 29, 29));
        setLayout(null);

        JLabel mainLabel = new JLabel("YOUR PROFILE");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainLabel.setBounds(50, 50, 300, 25);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setBounds(50, 100, 100, 25);

        JTextField userTextField = new JTextField();
        userTextField.setBounds(150, 100, 200, 25);
        userTextField.setFont(new Font("Arial", Font.PLAIN, 14));
        userTextField.setText(userModel.getUsername());

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setBounds(50, 150, 100, 25);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(150, 150, 200, 25);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));
        passwordField.setText(userModel.getPassword());

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        typeLabel.setBounds(50, 200, 100, 25);

        JTextField typeField = new JTextField();
        typeField.setBounds(150, 200, 200, 25);
        typeField.setFont(new Font("Arial", Font.PLAIN, 14));
        typeField.setText(userModel.getType());

        JButton saveButton = new JButton("Update Profile");
        saveButton.setBounds(50, 250, 160, 30);
        saveButton.setFont(new Font("Arial", Font.PLAIN, 14));
        saveButton.setBackground(new Color(97, 0, 141));
        saveButton.setForeground(Color.WHITE);
        saveButton.setBorderPainted(false);

        add(mainLabel);
        add(userLabel);
        add(userTextField);
        add(passwordLabel);
        add(passwordField);
        add(typeField);
        add(typeLabel);
        add(saveButton);
    }
}
