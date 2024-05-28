package gui.register_page;

import gui.login_page.LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterPage extends JFrame {
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton createButton;
    private JButton backButton;
    private JLabel messageLabel;
    private JPanel panel;

    public RegisterPage() {
        setTitle("FILKOM TOUR & TRAVEL - Register Page");
        setSize(800, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        panel = new JPanel();
        panel.setBackground(new Color(30, 29, 29));
        panel.setLayout(null);
        add(panel);


        ImageIcon imageIcon = new ImageIcon("D:\\PEMLAN-FILKOM-TOUR\\view\\gui\\src\\image.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0,0,400,500);
        panel.add(imageLabel);


        userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Arial", Font.BOLD, 14));
        userLabel.setBounds(450, 150, 100, 25);

        userTextField = new JTextField();
        userTextField.setBounds(550, 150, 200, 25);
        userTextField.setFont(new Font("Arial", Font.PLAIN, 14));

        passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel.setBounds(450, 200, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(550, 200, 200, 25);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 14));

        createButton = new JButton("Create Account");
        createButton.setBounds(470, 260, 160, 30);
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBackground(new Color(97, 0, 141));
        createButton.setForeground(Color.WHITE);
        createButton.setBorderPainted(false);

        backButton = new JButton("Back");
        backButton.setBounds(640, 260, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(220, 53, 69));
        backButton.setForeground(Color.WHITE);
        backButton.setBorderPainted(false);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setBounds(450, 310, 300, 25);
        messageLabel.setForeground(Color.YELLOW);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));


        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(createButton);
        panel.add(backButton);
        panel.add(messageLabel);


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginPage.run();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
    }

    public static void run() {
        RegisterPage page = new RegisterPage();
        page.setVisible(true);
    }
}
