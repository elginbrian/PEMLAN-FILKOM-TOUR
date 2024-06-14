package gui.panel_component;

import javax.swing.*;
import java.awt.*;

public class VehicleModifyPanel extends JPanel {
    private InitPanel initPanel;
    private RightPanel rightPanel;

    public VehicleModifyPanel() {
        initComponents();
    }

    private void initComponents() {
        setBackground(new Color(30, 29, 29));
        setLayout(new BorderLayout());

        initPanel = new InitPanel();
        add(initPanel, BorderLayout.CENTER);

        rightPanel = new RightPanel();
        add(rightPanel, BorderLayout.EAST);
    }

    public class InitPanel extends JPanel {

        private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8;
        private JTextField jTextField1, jTextField2, jTextField3, jTextField4, jTextField5, jTextField6, jTextField7;
        private JButton jButton1, jButton2, jButton3;

        public InitPanel() {
            setBackground(new Color(30, 29, 29));
            initComponents();
        }

        private void initComponents() {
            jLabel1 = new JLabel();
            jLabel2 = new JLabel();
            jLabel3 = new JLabel();
            jLabel4 = new JLabel();
            jLabel5 = new JLabel();
            jLabel6 = new JLabel();
            jLabel7 = new JLabel();
            jLabel8 = new JLabel();
            jTextField1 = new JTextField();
            jTextField2 = new JTextField();
            jTextField3 = new JTextField();
            jTextField4 = new JTextField();
            jTextField5 = new JTextField();
            jTextField6 = new JTextField();
            jTextField6.setVisible(false);
            jTextField7 = new JTextField();
            jTextField7.setVisible(false);
            jButton1 = new JButton();
            jButton2 = new JButton();
            jButton3 = new JButton();

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

            jButton3.setBackground(new Color(97, 0, 141));
            jButton3.setForeground(new Color(255, 255, 255));
            jButton3.setText("SAVE CHANGES");
            jButton3.setBorderPainted(false);

            jLabel2.setForeground(new Color(255, 255, 255));
            jLabel2.setText("Plat Nomor");

            jLabel3.setForeground(new Color(255, 255, 255));
            jLabel3.setText("Brand");

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
                                                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 326, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 50, Short.MAX_VALUE)) // Add 50 padding to the right
                                            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGap(0, 0, Short.MAX_VALUE)
                                                                    .addComponent(jButton3)
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
                                                                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextField5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(jButton3))
                                    .addGap(126, 126, 126))
            );
        }
    }

    class RightPanel extends JPanel {
        private Dimension buttonSize = new Dimension(200, 40);

        RightPanel() {
            setBackground(new Color(0x121212));
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JButton createButton = createButton("CREATE", new Color(43, 42, 42));
            JButton updateButton = createButton("UPDATE", new Color(43, 42, 42));
            JButton deleteButton = createButton("DELETE", new Color(43, 42, 42));

            add(createButton);
            add(updateButton);
            add(deleteButton);
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
    }
}
