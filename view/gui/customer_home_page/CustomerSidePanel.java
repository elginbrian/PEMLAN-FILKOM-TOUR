package gui.customer_home_page;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerSidePanel extends JPanel {
    private boolean openVehicleDrop = false;
    private boolean openEmployeeDrop = false;
    private JButton rentVehicleButton;
    private JButton showVehicleButton;
    private JButton showEmployeeButton;
    private Dimension buttonSize = new Dimension(240, 40);

    public CustomerSidePanel() {
        setBackground(new Color(0x121212));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton topUpButton = createButton("TOP-UP", new Color(43, 42, 42));
        JButton vehicleButton = createButton("VEHICLE", new Color(43, 42, 42));
        showVehicleButton = createButton("SHOW ALL VEHICLES", new Color(82, 58, 214));
        rentVehicleButton = createButton("RENT VEHICLE", new Color(82, 58, 214));
        JButton employeeButton = createButton("EMPLOYEE", new Color(43, 42, 42));
        showEmployeeButton = createButton("SHOW ALL EMPLOYEES", new Color(82, 58, 214));

        rentVehicleButton.setVisible(false);
        showVehicleButton.setVisible(false);
        showEmployeeButton.setVisible(false);

        add(topUpButton);
        add(vehicleButton);
        add(rentVehicleButton);
        add(showVehicleButton);
        add(employeeButton);
        add(showEmployeeButton);

        vehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openVehicleDrop = !openVehicleDrop;
                rentVehicleButton.setVisible(openVehicleDrop);
                showVehicleButton.setVisible(openVehicleDrop);
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openEmployeeDrop = !openEmployeeDrop;
                showEmployeeButton.setVisible(openEmployeeDrop);
            }
        });
    }

    private JButton createButton(String text, Color backgroundColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(backgroundColor);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);
        button.setPreferredSize(buttonSize);
        button.setMinimumSize(buttonSize);
        button.setMaximumSize(buttonSize);
        return button;
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (!aFlag) {
            resetDropdowns();
        }
    }

    private void resetDropdowns() {
        openVehicleDrop = false;
        openEmployeeDrop = false;
        rentVehicleButton.setVisible(false);
        showVehicleButton.setVisible(false);
        showEmployeeButton.setVisible(false);
    }
}
