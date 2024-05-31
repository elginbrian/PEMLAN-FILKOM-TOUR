package gui.panel_component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeePanel extends JPanel {
    private boolean expand = false;

    public EmployeePanel(){
        setBackground(new Color(30, 29, 29));
        setLayout(null);

        JLabel mainLabel = new JLabel("ALL FILKOM TOUR'S EMPLOYEES");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainLabel.setBounds(50, 50, 600, 25);

        String[] columnNames = {"ID", "Name", "Address", "Email", "PhoneNum", "Gender", "Position", "Salary"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable taskTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBounds(50, 100, 650, 560);

        JButton expandButton = new JButton("Expand");
        expandButton.setBounds(50, 670, 100, 30);
        expandButton.setFont(new Font("Arial", Font.PLAIN, 14));
        expandButton.setBackground(new Color(97, 0, 141));
        expandButton.setForeground(Color.WHITE);
        expandButton.setBorderPainted(false);

        String[] sortCriteria = {"Name", "Gender", "Position", "Salary"};
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
}
