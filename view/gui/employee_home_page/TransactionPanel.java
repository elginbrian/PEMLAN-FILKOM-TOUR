package gui.employee_home_page;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransactionPanel extends JPanel {
    private JTable taskTable;
    private DefaultTableModel tableModel;
    private boolean expand = false;

    public TransactionPanel(){
        setBackground(new Color(30, 29, 29));
        setLayout(null);

        JLabel mainLabel = new JLabel("ALL CUSTOMER'S TRANSACTIONS");
        mainLabel.setForeground(Color.WHITE);
        mainLabel.setFont(new Font("Arial", Font.BOLD, 30));
        mainLabel.setBounds(50, 50, 600, 25);

        String[] columnNames = {"Id", "Customer", "Employee", "Vehicle", "Day", "Price", "Is Returned"};
        tableModel = new DefaultTableModel(columnNames, 0);
        taskTable = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(taskTable);
        scrollPane.setBounds(50, 100, 650, 560);

        JButton expandButton = new JButton("Expand");
        expandButton.setBounds(50, 670, 100, 30);
        expandButton.setFont(new Font("Arial", Font.PLAIN, 14));
        expandButton.setBackground(new Color(97, 0, 141));
        expandButton.setForeground(Color.WHITE);
        expandButton.setBorderPainted(false);

        add(scrollPane);
        add(mainLabel);
        add(expandButton);


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
