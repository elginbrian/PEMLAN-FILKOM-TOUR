package gui.employee_home_page;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidePanel extends JPanel {
    private boolean openVehicleDrop = false;
    private boolean openEmployeeDrop = false;
    private boolean openCustDrop = false;
    private JButton createVehicleButton;
    private JButton showVehicleButton;
    private JButton createEmployeeButton;
    private JButton showEmployeeButton;
    private JButton createCustomerButton;
    private JButton showCustomerButton;
    private Dimension buttonSize = new Dimension(240, 40);

    public SidePanel() {
        setBackground(new Color(0x121212));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton transactionButton = createButton("TRANSACTION", new Color(43, 42, 42));
        JButton vehicleButton = createButton("VEHICLE", new Color(43, 42, 42));
        createVehicleButton = createButton("INSERT NEW VEHICLE", new Color(82, 58, 214));
        showVehicleButton = createButton("SHOW ALL VEHICLES", new Color(82, 58, 214));
        JButton employeeButton = createButton("EMPLOYEE", new Color(43, 42, 42));
        createEmployeeButton = createButton("INSERT NEW EMPLOYEE", new Color(82, 58, 214));
        showEmployeeButton = createButton("SHOW ALL EMPLOYEES", new Color(82, 58, 214));
        JButton customerButton = createButton("CUSTOMER", new Color(43, 42, 42));
        createCustomerButton = createButton("INSERT NEW CUSTOMER", new Color(82, 58, 214));
        showCustomerButton = createButton("SHOW ALL CUSTOMERS", new Color(82, 58, 214));

        createVehicleButton.setVisible(false);
        showVehicleButton.setVisible(false);
        createEmployeeButton.setVisible(false);
        showEmployeeButton.setVisible(false);
        createCustomerButton.setVisible(false);
        showCustomerButton.setVisible(false);

        add(transactionButton);
        add(vehicleButton);
        add(createVehicleButton);
        add(showVehicleButton);
        add(employeeButton);
        add(createEmployeeButton);
        add(showEmployeeButton);
        add(customerButton);
        add(createCustomerButton);
        add(showCustomerButton);

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
        openCustDrop = false;
        createVehicleButton.setVisible(false);
        showVehicleButton.setVisible(false);
        createEmployeeButton.setVisible(false);
        showEmployeeButton.setVisible(false);
        createCustomerButton.setVisible(false);
        showCustomerButton.setVisible(false);
    }
}
