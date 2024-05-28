package gui.login_page;

import gui.register_page.RegisterPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginPage extends JFrame {
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private JLabel messageLabel;
    private JLabel switchLabel;
    private JPanel panel;

    public LoginPage() throws IOException {
        setTitle("FILKOM TOUR & TRAVEL - Login Page");
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

        loginButton = new JButton("Login");
        loginButton.setBounds(500, 260, 80, 30);
        loginButton.setFont(new Font("Arial", Font.BOLD, 14));
        loginButton.setBackground(new Color(97, 0, 141));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorderPainted(false);

        registerButton = new JButton("Register");
        registerButton.setBounds(590, 260, 100, 30);
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(82, 58, 214));
        registerButton.setForeground(Color.WHITE);
        registerButton.setBorderPainted(false);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setBounds(450, 300, 300, 25);
        messageLabel.setForeground(Color.YELLOW);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        switchLabel = new JLabel("Belum punya akun? Klik Register", SwingConstants.CENTER);
        switchLabel.setBounds(440, 320, 300, 25);
        switchLabel.setForeground(Color.WHITE);
        switchLabel.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(messageLabel);
        panel.add(switchLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterPage.run();
                setVisible(false);
            }
        });

    }


    public static void run() throws IOException {
        LoginPage page = new LoginPage();
        page.setVisible(true);
    }
}
