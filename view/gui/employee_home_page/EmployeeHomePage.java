package gui.employee_home_page;

import gui.login_page.LoginPage;
import model.UserModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EmployeeHomePage extends JFrame {
    private JLabel mainLabel;
    private JPanel panel;
    private boolean openSidePanel = false;
    private SidePanel sidePanel;

    public EmployeeHomePage(UserModel user) {
        setTitle("FILKOM TOUR & TRAVEL - Employee Home");
        setSize(1000, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(30, 29, 29));
        add(panel);

        mainLabel = new JLabel("WELCOME BACK, " + user.getUsername().toUpperCase() + "!");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));

        ImageIcon backgroundImage = new ImageIcon("view/gui/src/background.jpg");

        // Create a custom panel with the background image
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        backgroundPanel.add(mainLabel, gbc);

        sidePanel = new SidePanel();
        TopPanel topPanel = new TopPanel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSidePanel = !openSidePanel;
                sidePanel.setVisible(openSidePanel);
            }
        }, new ActionListener() {
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

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(sidePanel, BorderLayout.WEST);
        panel.add(backgroundPanel, BorderLayout.CENTER);
        sidePanel.setVisible(false);
    }

    public static void run(UserModel user) {
        EmployeeHomePage page = new EmployeeHomePage(user);
        page.setVisible(true);
    }
}
