package gui.panel_component;

import controller.AppController;
import model.CarModel;
import model.CustomerModel;
import util.StringToArray;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerPanel extends JPanel {
    private boolean expand = false;

    public CustomerPanel() {
        setBackground(new Color(30, 29, 29));
        setLayout(null);

        JLabel mainLabel = new JLabel("ALL FILKOM TOUR'S CUSTOMERS");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainLabel.setBounds(50, 50, 600, 25);

        String[] columnNames = {"ID", "Name", "Gender", "Address", "Balance", "Age"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable taskTable = new JTable(tableModel);

        loadData(AppController.getCustomerList(), tableModel);

        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBounds(50, 100, 650, 560);

        JButton expandButton = new JButton("Expand");
        expandButton.setBounds(50, 670, 100, 30);
        expandButton.setFont(new Font("Arial", Font.PLAIN, 14));
        expandButton.setBackground(new Color(97, 0, 141));
        expandButton.setForeground(Color.WHITE);
        expandButton.setBorderPainted(false);

        String[] sortCriteria = {"Name", "Gender", "Balance"};
        JComboBox comboBox = new JComboBox<>(sortCriteria);
        comboBox.setBounds(160, 670, 120, 30);
        comboBox.setBackground(new Color(30, 29, 29));
        comboBox.setForeground(Color.WHITE);

        JButton sortButton = new JButton("Sort");
        sortButton.setBounds(290, 670, 80, 30);
        sortButton.setFont(new Font("Arial", Font.PLAIN, 14));
        sortButton.setBackground(new Color(97, 0, 141));
        sortButton.setForeground(Color.WHITE);
        sortButton.setBorderPainted(false);

        add(scrollPane);
        add(mainLabel);
        add(expandButton);
        add(comboBox);
        add(sortButton);


        expandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expand = !expand;
                if(expand){
                    scrollPane.setBounds(50, 100, 870, 560);
                    expandButton.setText("Shrink");
                } else {
                    scrollPane.setBounds(50, 100, 650, 560);
                    expandButton.setText("Expand");
                }
            }
        });
    }

    private void loadData(List<CustomerModel> customerList, DefaultTableModel tableModel) {
        tableModel.setRowCount(0);
        for (CustomerModel customer : customerList) {
            String[] arr = StringToArray.convert(customer.getStringArray());
            Object[] rowData = {
                    arr[0],
                    arr[2],
                    arr[1],
                    arr[3],
                    arr[4],
                    arr[5]
            };
            tableModel.addRow(rowData);
        }
    }
}
