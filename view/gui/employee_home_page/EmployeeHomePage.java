package gui.employee_home_page;

import gui.login_page.LoginPage;
import model.UserModel;
import util.DateTimeConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;

public class EmployeeHomePage extends JFrame {
    private JLabel mainLabel;
    private JPanel panel;
    private JButton logoutButton;

    public EmployeeHomePage(UserModel user){
        setTitle("FILKOM TOUR & TRAVEL - Employee Home");
        setSize(1000, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(30, 29, 29));
        add(panel);

        mainLabel = new JLabel("   WELCOME BACK, " + user.getUsername().toUpperCase() + "!");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainLabel.setBounds(50, 50, 500, 25);
        panel.add(mainLabel, BorderLayout.CENTER);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(97, 0, 141));
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton menuButton = new JButton("Menu");
        menuButton.setFont(new Font("Arial", Font.PLAIN, 14));
        menuButton.setBackground(new Color(136, 0, 215));
        menuButton.setForeground(Color.WHITE);
        menuButton.setBorderPainted(false);

        logoutButton = new JButton("Logout");
        logoutButton.setFont(new Font("Arial", Font.PLAIN, 14));
        logoutButton.setBackground(new Color(136, 0, 215));
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBorderPainted(false);

        JLabel date = new JLabel(DateTimeConverter.convert(LocalDateTime.now().toString()));
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Arial", Font.PLAIN, 14));

        topPanel.add(menuButton);
        topPanel.add(logoutButton);
        topPanel.add(date);

        panel.add(topPanel, BorderLayout.NORTH);

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LoginPage.run();
                    setVisible(false);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void run(UserModel user) {
        EmployeeHomePage page = new EmployeeHomePage(user);
        page.setVisible(true);
    }
}


