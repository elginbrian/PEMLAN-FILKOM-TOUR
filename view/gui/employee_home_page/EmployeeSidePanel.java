package gui.employee_home_page;


import gui.panel_component.*;
import util.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeSidePanel extends JPanel {
    private boolean openTransactionDrop = false;
    private boolean openVehicleDrop = false;
    private boolean openEmployeeDrop = false;
    private boolean openCustDrop = false;
    private JButton showTransactionButton;
    private JButton createVehicleButton;
    private JButton showVehicleButton;
    private JButton createEmployeeButton;
    private JButton showEmployeeButton;
    private JButton createCustomerButton;
    private JButton showCustomerButton;
    private Dimension buttonSize = new Dimension(240, 40);


    public EmployeeSidePanel(JPanel centerPanel) {
        VehicleModifyPanel vehicleModifyPanel = new VehicleModifyPanel(centerPanel);
        EmployeeModifyPanel employeeModifyPanel = new EmployeeModifyPanel(centerPanel);
        CustomerModifyPanel customerModifyPanel = new CustomerModifyPanel(centerPanel);
        setBackground(new Color(0x121212));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton transactionButton = createButton("TRANSACTION", new Color(43, 42, 42));
        showTransactionButton     = createButton("SHOW ALL TRANSACTION", new Color(82, 58, 214));
        JButton vehicleButton     = createButton("VEHICLE", new Color(43, 42, 42));
        createVehicleButton       = createButton("MODIFY VEHICLES", new Color(82, 58, 214));
        showVehicleButton         = createButton("SHOW ALL VEHICLES", new Color(82, 58, 214));
        JButton employeeButton    = createButton("EMPLOYEE", new Color(43, 42, 42));
        createEmployeeButton      = createButton("MODIFY EMPLOYEES", new Color(82, 58, 214));
        showEmployeeButton        = createButton("SHOW ALL EMPLOYEES", new Color(82, 58, 214));
        JButton customerButton    = createButton("CUSTOMER", new Color(43, 42, 42));
        createCustomerButton      = createButton("MODIFY CUSTOMERS", new Color(82, 58, 214));
        showCustomerButton        = createButton("SHOW ALL CUSTOMERS", new Color(82, 58, 214));

        createVehicleButton.setVisible(false);
        showVehicleButton.setVisible(false);
        createEmployeeButton.setVisible(false);
        showEmployeeButton.setVisible(false);
        createCustomerButton.setVisible(false);
        showCustomerButton.setVisible(false);

        add(transactionButton);
        add(showTransactionButton);
        add(vehicleButton);
        add(createVehicleButton);
        add(showVehicleButton);
        add(employeeButton);
        add(createEmployeeButton);
        add(showEmployeeButton);
        add(customerButton);
        add(createCustomerButton);
        add(showCustomerButton);

        transactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openTransactionDrop = !openTransactionDrop;
                showTransactionButton.setVisible(openTransactionDrop);
            }
        });

        vehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openVehicleDrop = !openVehicleDrop;
                createVehicleButton.setVisible(openVehicleDrop);
                showVehicleButton.setVisible(openVehicleDrop);
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openEmployeeDrop = !openEmployeeDrop;
                createEmployeeButton.setVisible(openEmployeeDrop);
                showEmployeeButton.setVisible(openEmployeeDrop);
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCustDrop = !openCustDrop;
                createCustomerButton.setVisible(openCustDrop);
                showCustomerButton.setVisible(openCustDrop);
            }
        });

        showTransactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, new TransactionPanel());
            }
        });

        showVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, new VehiclePanel());
            }
        });

        createVehicleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { SwitchPanel.implement(centerPanel, vehicleModifyPanel); }
        });

        showEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, new EmployeePanel());
            }
        });

        createEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, employeeModifyPanel);
            }
        });

        showCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, new CustomerPanel());
            }
        });

        createCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwitchPanel.implement(centerPanel, customerModifyPanel);
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
        openTransactionDrop = false;
        openVehicleDrop = false;
        openEmployeeDrop = false;
        openCustDrop = false;
        showTransactionButton.setVisible(false);
        createVehicleButton.setVisible(false);
        showVehicleButton.setVisible(false);
        createEmployeeButton.setVisible(false);
        showEmployeeButton.setVisible(false);
        createCustomerButton.setVisible(false);
        showCustomerButton.setVisible(false);
    }
}
