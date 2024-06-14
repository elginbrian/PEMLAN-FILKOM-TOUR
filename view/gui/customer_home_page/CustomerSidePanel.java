package gui.customer_home_page;


import gui.panel_component.EmployeePanel;
import gui.panel_component.TopUpPanel;
import gui.panel_component.VehiclePanel;
import model.CustomerModel;
import model.UserModel;
import util.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerSidePanel extends JPanel {
    private boolean openBalanceDrop = false;
    private boolean openVehicleDrop = false;
    private boolean openEmployeeDrop = false;
    private JButton topUpButton;
    private JButton rentVehicleButton;
    private JButton showVehicleButton;
    private JButton showEmployeeButton;
    private Dimension buttonSize = new Dimension(240, 40);

    public CustomerSidePanel(JPanel centerPanel, UserModel current) {
        setBackground(new Color(0x121212));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton balanceButton = createButton("BALANCE", new Color(43, 42, 42));
        topUpButton = createButton("TOP-UP BALANCE", new Color(82, 58, 214));
        JButton vehicleButton = createButton("VEHICLE", new Color(43, 42, 42));
        showVehicleButton = createButton("SHOW ALL VEHICLES", new Color(82, 58, 214));
        rentVehicleButton = createButton("RENT VEHICLE", new Color(82, 58, 214));
        JButton employeeButton = createButton("EMPLOYEE", new Color(43, 42, 42));
        showEmployeeButton = createButton("SHOW ALL EMPLOYEES", new Color(82, 58, 214));

        topUpButton.setVisible(false);
        rentVehicleButton.setVisible(false);
        showVehicleButton.setVisible(false);
        showEmployeeButton.setVisible(false);

        add(balanceButton);
        add(topUpButton);
        add(vehicleButton);
        add(rentVehicleButton);
        add(showVehicleButton);
        add(employeeButton);
        add(showEmployeeButton);

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openBalanceDrop = !openBalanceDrop;
                topUpButton.setVisible(openBalanceDrop);
            }
        });

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

        topUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, new TopUpPanel(current, centerPanel));
            }
        });

        showVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, new VehiclePanel());
            }
        });

        showEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, new EmployeePanel());
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
