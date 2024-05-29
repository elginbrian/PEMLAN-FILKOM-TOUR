package gui.login_page;

import controller.UserController;
import gui.customer_home_page.CustomerHomePage;
import gui.employee_home_page.EmployeeHomePage;
import gui.register_page.RegisterPage;
import model.UserModel;
import util.StringToArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoginPage extends JFrame {
    private JLabel mainLabel;
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

        ImageIcon imageIcon = new ImageIcon("view/gui/src/image.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0,0,400,500);
        panel.add(imageLabel);

        mainLabel = new JLabel("LOGIN");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainLabel.setBounds(450, 100, 300, 25);

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
        messageLabel.setBounds(440, 300, 300, 25);
        messageLabel.setForeground(Color.YELLOW);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        switchLabel = new JLabel("Belum punya akun? Klik Register", SwingConstants.CENTER);
        switchLabel.setBounds(440, 320, 300, 25);
        switchLabel.setForeground(Color.WHITE);
        switchLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        panel.add(mainLabel);
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
                String result = UserController.LoginUser(
                        userTextField.getText(),
                        passwordField.getText()
                );
                messageLabel.setText(result);

                String[] arr   = StringToArray.convert(result);
                UserModel user = new UserModel(arr[0], arr[1], arr[2], arr[3]);
                if(arr[3].equals("customer")){
                    CustomerHomePage.run(user);
                    setVisible(false);
                } else if(arr[3].equals("employee")){
                    EmployeeHomePage.run(user);
                    setVisible(false);
                }
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
