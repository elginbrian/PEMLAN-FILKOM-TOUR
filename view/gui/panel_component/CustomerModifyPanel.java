package gui.panel_component;

import controller.DataController;
import model.CustomerModel;
import util.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerModifyPanel extends JPanel {

    private InitPanel initPanel;
    private RightPanel rightPanel;
    private int state = 0;
    private JTextField phoneNum, name, age, address, gender, jTextField6, jTextField7;

    public CustomerModifyPanel(JPanel centerPanel) {
        initComponents(centerPanel);
    }

    private void initComponents(JPanel centerPanel) {
        setBackground(new Color(30, 29, 29));
        setLayout(new BorderLayout());

        initPanel = new InitPanel(centerPanel);
        add(initPanel, BorderLayout.CENTER);

        rightPanel = new RightPanel();
        add(rightPanel, BorderLayout.EAST);
    }

    public class InitPanel extends JPanel {

        private JLabel jLabel1, nameLabel, ageLabel, addressLabel, genderLabel, phoneLabel, jLabel7, jLabel8;

        private JButton jButton1, jButton2, saves;

        public InitPanel(JPanel centerPanel) {

            setBackground(new Color(30, 29, 29));
            initComponents();

            saves.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch(state){
                        case 0:
                            DataController.postCustomer(new CustomerModel(
                                    "",
                                    phoneNum.getText(),
                                    name.getText(),
                                    Integer.valueOf(age.getText()),
                                    address.getText(),
                                    gender.getText()
                            ));
                            SwitchPanel.implement(centerPanel, new CustomerPanel());
                            break;
                        case 1:
                            DataController.putCustomer(
                                    "",
                                    name.getText(),
                                    phoneNum.getText(),
                                    address.getText(),
                                    gender.getText()
                            );
                            SwitchPanel.implement(centerPanel, new CustomerPanel());
                            break;
                        case 2:
                            DataController.deleteCustomer(name.getText());
                            SwitchPanel.implement(centerPanel, new CustomerPanel());
                            break;
                        default:
                            break;
                    }
                }
            });
        }

        private void initComponents() {
            jLabel1 = new JLabel();
            nameLabel = new JLabel();
            ageLabel = new JLabel();
            addressLabel = new JLabel();
            genderLabel = new JLabel();
            phoneLabel = new JLabel();
            jLabel7 = new JLabel();
            jLabel8 = new JLabel();
            phoneNum = new JTextField();
            name = new JTextField();
            age = new JTextField();
            address = new JTextField();
            gender = new JTextField();
            jTextField6 = new JTextField();
            jTextField6.setVisible(false);
            jTextField7 = new JTextField();
            jTextField7.setVisible(false);
            jButton1 = new JButton();
            jButton2 = new JButton();
            saves = new JButton();

            jLabel1.setFont(new Font("Segoe UI", Font.PLAIN, 36));
            jLabel1.setForeground(new Color(233, 230, 230));
            jLabel1.setText("MODIFY CUSTOMER");

            jButton1.setBackground(new Color(97, 0, 141));
            jButton1.setForeground(new Color(255, 255, 255));
            jButton1.setBorderPainted(false);
            jButton1.setText("SAVES");
            jButton1.setVisible(false);

            jButton2.setBackground(new Color(97, 0, 141));
            jButton2.setForeground(new Color(255, 255, 255));
            jButton2.setText("ADD");
            jButton2.setBorderPainted(false);
            jButton2.setVisible(false);

            saves.setBackground(new Color(97, 0, 141));
            saves.setForeground(new Color(255, 255, 255));
            saves.setText("SAVE CHANGES");
            saves.setBorderPainted(false);

            nameLabel.setForeground(new Color(255, 255, 255));
            nameLabel.setText("Nama");

            ageLabel.setForeground(new Color(255, 255, 255));
            ageLabel.setText("Umur");

            addressLabel.setForeground(new Color(255, 255, 255));
            addressLabel.setText("Alamat");

            genderLabel.setForeground(new Color(255, 255, 255));
            genderLabel.setText("Gender");

            phoneLabel.setForeground(new Color(255, 255, 255));
            phoneLabel.setText("Nomor Telepon");

            jLabel7.setForeground(new Color(255, 255, 255));
            jLabel7.setText("Jabatan");
            jLabel7.setVisible(false);

            jLabel8.setForeground(new Color(255, 255, 255));
            jLabel8.setText("Gaji");
            jLabel8.setVisible(false);

            GroupLayout layout = new GroupLayout(this);
            setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap(50, Short.MAX_VALUE) // Add 50 padding to the left
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 50, Short.MAX_VALUE)) // Add 50 padding to the right
                                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                                    .addComponent(saves)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jButton1)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jButton2))
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                            .addComponent(ageLabel)
                                                                            .addComponent(nameLabel)
                                                                            .addComponent(addressLabel)
                                                                            .addComponent(genderLabel)
                                                                            .addComponent(phoneLabel)
                                                                            .addComponent(jLabel7)
                                                                            .addComponent(jLabel8))
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                            .addComponent(phoneNum, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(name, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(age, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(address, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(gender, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                                    .addContainerGap(50, Short.MAX_VALUE))))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel1)
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(phoneNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phoneLabel))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(nameLabel))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ageLabel))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(addressLabel))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(gender, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(genderLabel))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jButton2)
                                            .addComponent(jButton1)
                                            .addComponent(saves))
                                    .addGap(126, 126, 126))
            );
        }
    }

    class RightPanel extends JPanel {
        private Dimension buttonSize = new Dimension(200, 40);
        JButton createButton = createButton("CREATE", new Color(43, 42, 42));
        JButton updateButton = createButton("UPDATE", new Color(43, 42, 42));
        JButton deleteButton = createButton("DELETE", new Color(43, 42, 42));

        RightPanel() {
            updateState();
            setBackground(new Color(0x121212));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            add(createButton);
            add(updateButton);
            add(deleteButton);

            createButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    state = 0;
                    updateState();
                }
            });

            updateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    state = 1;
                    updateState();
                }
            });

            deleteButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    state = 2;
                    updateState();
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

        private void updateState(){
            switch(state){
                case 0:
                    createButton.setBackground(new Color(82, 58, 214));
                    updateButton.setBackground(new Color(43, 42, 42));
                    deleteButton.setBackground(new Color(43, 42, 42));
                    phoneNum.setBackground(new Color(255, 255, 255));
                    age.setBackground(new Color(255, 255, 255));
                    address.setBackground(new Color(255, 255, 255));
                    gender.setBackground(new Color(255, 255, 255));
                    break;
                case 1:
                    createButton.setBackground(new Color(43, 42, 42));
                    updateButton.setBackground(new Color(82, 58, 214));
                    deleteButton.setBackground(new Color(43, 42, 42));
                    phoneNum.setBackground(new Color(255, 255, 255));
                    age.setBackground(new Color(255, 255, 255));
                    address.setBackground(new Color(255, 255, 255));
                    gender.setBackground(new Color(255, 255, 255));
                    break;
                case 2:
                    createButton.setBackground(new Color(43, 42, 42));
                    updateButton.setBackground(new Color(43, 42, 42));
                    deleteButton.setBackground(new Color(82, 58, 214));
                    phoneNum.setBackground(new Color(43, 42, 42));
                    age.setBackground(new Color(43, 42, 42));
                    address.setBackground(new Color(43, 42, 42));
                    gender.setBackground(new Color(43, 42, 42));
                    break;
                default:
                    break;
            }
        }
    }
}
