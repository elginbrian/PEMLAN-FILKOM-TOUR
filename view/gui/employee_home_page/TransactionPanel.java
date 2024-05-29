package gui.employee_home_page;

import javax.swing.*;
import java.awt.*;

public class TransactionPanel extends JPanel {
    public TransactionPanel(){
        setBackground(new Color(30, 29, 29));
        setLayout(null);

        JLabel mainLabel = new JLabel("ALL CUSTOMER'S TRANSACTIONS");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainLabel.setBounds(50, 50, 600, 25);

        add(mainLabel);
    }
}
