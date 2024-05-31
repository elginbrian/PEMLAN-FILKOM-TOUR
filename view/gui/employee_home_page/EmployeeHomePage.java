package gui.employee_home_page;

import gui.login_page.LoginPage;
import gui.panel_component.ProfilePanel;
import model.UserModel;
import util.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class EmployeeHomePage extends JFrame {
    private JLabel mainLabel;
    private JPanel panel;
    private boolean openSidePanel = false;
    private boolean showProfile = false;
    private EmployeeSidePanel employeeSidePanel;

    public EmployeeHomePage(UserModel user) {
        setTitle("FILKOM TOUR & TRAVEL - Employee Home");
        setSize(1000, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(30, 29, 29));
        add(panel);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(30, 29, 29));

        mainLabel = new JLabel("WELCOME BACK, " + user.getUsername().toUpperCase() + "!");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));

        ImageIcon backgroundImage = new ImageIcon("view/gui/src/background.jpg");

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
        centerPanel.add(backgroundPanel, BorderLayout.CENTER);

        employeeSidePanel = new EmployeeSidePanel(centerPanel);
        EmployeeTopPanel employeeTopPanel = new EmployeeTopPanel(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSidePanel = !openSidePanel;
                employeeSidePanel.setVisible(openSidePanel);
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
        }, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProfile = !showProfile;
                if(showProfile){
                    SwitchPanel.implement(centerPanel, new ProfilePanel(user));
                } else {
                    SwitchPanel.implement(centerPanel, backgroundPanel);
                }
            }
        });

        panel.add(employeeTopPanel, BorderLayout.NORTH);
        panel.add(employeeSidePanel, BorderLayout.WEST);
        panel.add(centerPanel, BorderLayout.CENTER);
        employeeSidePanel.setVisible(false);
    }

    public static void run(UserModel user) {
        EmployeeHomePage page = new EmployeeHomePage(user);
        page.setVisible(true);
    }

    public static void main(String[] args){
        EmployeeHomePage page = new EmployeeHomePage(new UserModel(
                "PREVIEW",
                "123456",
                "employee"
        ));
        page.setVisible(true);
    }
}
