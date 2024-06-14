package gui.panel_component;

import controller.DataController;
import model.CarModel;
import util.SwitchPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleModifyPanel extends JPanel {
    private InitPanel initPanel;
    private RightPanel rightPanel;
    private int state = 0;
    private JTextField numPlate, carBrand, carColor, year, capacity, jTextField6, jTextField7;

    public VehicleModifyPanel(JPanel centerPanel) {
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

        private JLabel header, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8;
        private JButton jButton1, jButton2, saves;

        public InitPanel(JPanel centerPanel) {
            setBackground(new Color(30, 29, 29));
            initComponents();

            saves.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch(state){
                        case 0:
                            DataController.postCar(new CarModel(
                                    numPlate.getText(),
                                    carBrand.getText(),
                                    carColor.getText(),
                                    Integer.valueOf(year.getText()),
                                    Double.valueOf(capacity.getText())
                            ));
                            SwitchPanel.implement(centerPanel, new VehiclePanel());
                            break;
                        case 1:
                            DataController.putCar(
                                    numPlate.getText(),
                                    carBrand.getText(),
                                    carColor.getText(),
                                    Integer.valueOf(year.getText()),
                                    Double.valueOf(capacity.getText())
                            );
                            SwitchPanel.implement(centerPanel, new VehiclePanel());
                            break;
                        case 2:
                            DataController.deleteCar(numPlate.getText());
                            SwitchPanel.implement(centerPanel, new VehiclePanel());
                            break;
                        default:
                            break;
                    }
                }
            });
        }

        private void initComponents() {
            header = new JLabel();
            jLabel2 = new JLabel();
            jLabel3 = new JLabel();
            jLabel4 = new JLabel();
            jLabel5 = new JLabel();
            jLabel6 = new JLabel();
            jLabel7 = new JLabel();
            jLabel8 = new JLabel();
            numPlate = new JTextField();
            carBrand = new JTextField();
            carColor = new JTextField();
            year = new JTextField();
            capacity = new JTextField();
            jTextField6 = new JTextField();
            jTextField6.setVisible(false);
            jTextField7 = new JTextField();
            jTextField7.setVisible(false);
            jButton1 = new JButton();
            jButton2 = new JButton();
            saves = new JButton();

            header.setFont(new Font("Segoe UI", Font.PLAIN, 36));
            header.setForeground(new Color(233, 230, 230));
            header.setText("MODIFY VEHICLE");

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

            jLabel2.setForeground(new Color(255, 255, 255));
            jLabel3.setText("Plat Nomor");

            jLabel3.setForeground(new Color(255, 255, 255));
            jLabel2.setText("Brand");

            jLabel4.setForeground(new Color(255, 255, 255));
            jLabel4.setText("Warna");

            jLabel5.setForeground(new Color(255, 255, 255));
            jLabel5.setText("Tahun");

            jLabel6.setForeground(new Color(255, 255, 255));
            jLabel6.setText("Kapasitas");

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
                                                    .addComponent(header, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
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
                                                                            .addComponent(jLabel3)
                                                                            .addComponent(jLabel2)
                                                                            .addComponent(jLabel4)
                                                                            .addComponent(jLabel5)
                                                                            .addComponent(jLabel6)
                                                                            .addComponent(jLabel7)
                                                                            .addComponent(jLabel8))
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                            .addComponent(numPlate, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(carBrand, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(carColor, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(year, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(capacity, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                                    .addContainerGap(50, Short.MAX_VALUE))))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(header)
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(numPlate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(carBrand, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(carColor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(capacity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6))
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
                    carBrand.setBackground(new Color(255, 255, 255));
                    carColor.setBackground(new Color(255, 255, 255));
                    year.setBackground(new Color(255, 255, 255));
                    capacity.setBackground(new Color(255, 255, 255));
                    break;
                case 1:
                    createButton.setBackground(new Color(43, 42, 42));
                    updateButton.setBackground(new Color(82, 58, 214));
                    deleteButton.setBackground(new Color(43, 42, 42));
                    carBrand.setBackground(new Color(255, 255, 255));
                    carColor.setBackground(new Color(255, 255, 255));
                    year.setBackground(new Color(255, 255, 255));
                    capacity.setBackground(new Color(255, 255, 255));
                    break;
                case 2:
                    createButton.setBackground(new Color(43, 42, 42));
                    updateButton.setBackground(new Color(43, 42, 42));
                    deleteButton.setBackground(new Color(82, 58, 214));
                    carBrand.setBackground(new Color(43, 42, 42));
                    carColor.setBackground(new Color(43, 42, 42));
                    year.setBackground(new Color(43, 42, 42));
                    capacity.setBackground(new Color(43, 42, 42));
                    break;
                default:
                    break;
            }
        }
    }
}
