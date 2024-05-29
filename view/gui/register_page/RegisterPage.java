package gui.register_page;

import controller.UserController;
import gui.login_page.LoginPage;
import model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterPage extends JFrame {
    private JLabel mainLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JLabel typeLabel;
    private JTextField userTextField;
    private JPasswordField passwordField;
    private JComboBox<String> typeBox;
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


        ImageIcon imageIcon = new ImageIcon("view/gui/src/image.jpg");
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(0,0,400,500);
        panel.add(imageLabel);

        mainLabel = new JLabel("REGISTER");
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

        typeLabel = new JLabel("Type:");
        typeLabel.setForeground(Color.WHITE);
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        typeLabel.setBounds(450, 250, 100, 25);

        String[] types = {"customer", "employee"};
        typeBox = new JComboBox<>(types);
        typeBox.setBounds(550, 250, 200, 25);

        createButton = new JButton("Create Account");
        createButton.setBounds(470, 310, 160, 30);
        createButton.setFont(new Font("Arial", Font.BOLD, 14));
        createButton.setBackground(new Color(97, 0, 141));
        createButton.setForeground(Color.WHITE);
        createButton.setBorderPainted(false);

        backButton = new JButton("Back");
        backButton.setBounds(640, 310, 80, 30);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setBackground(new Color(220, 53, 69));
        backButton.setForeground(Color.WHITE);
        backButton.setBorderPainted(false);

        messageLabel = new JLabel("", SwingConstants.CENTER);
        messageLabel.setBounds(450, 360, 300, 25);
        messageLabel.setForeground(Color.YELLOW);
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));


        panel.add(mainLabel);
        panel.add(userLabel);
        panel.add(userTextField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(typeLabel);
        panel.add(typeBox);
        panel.add(createButton);
        panel.add(backButton);
        panel.add(messageLabel);


        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String result = UserController.PostUser(new UserModel(
                        userTextField.getText(),
                        passwordField.getText(),
                        typeBox.getItemAt(typeBox.getSelectedIndex())
                ));

                messageLabel.setText(result);

                if(result.equals("Insert data success")){
                    messageLabel.setVisible(false);
                    JOptionPane.showMessageDialog(null, result, "Notification", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        LoginPage.run();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    setVisible(false);
                }
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
