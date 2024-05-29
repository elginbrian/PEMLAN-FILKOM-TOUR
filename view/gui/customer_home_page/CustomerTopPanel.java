package gui.customer_home_page;

import util.DateTimeConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class CustomerTopPanel extends JPanel {
    private JButton menuButton;
    private JButton profileButton;
    private JButton logoutButton;

    public CustomerTopPanel(ActionListener menuActionListener, ActionListener logoutActionListener) {
        setBackground(new Color(97, 0, 141));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        menuButton = createButton("Menu", new Color(136, 0, 215));
        profileButton = createButton("Profile", new Color(136, 0, 215));
        logoutButton = createButton("Logout", new Color(136, 0, 215));
        JLabel date = new JLabel("Login activities at " + DateTimeConverter.convert(LocalDateTime.now().toString()));
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Arial", Font.PLAIN, 14));

        menuButton.addActionListener(menuActionListener);
        logoutButton.addActionListener(logoutActionListener);

        add(menuButton);
        add(profileButton);
        add(logoutButton);
        add(date);
    }

    private JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        return button;
    }
}
