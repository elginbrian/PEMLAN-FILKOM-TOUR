package gui.panel_component;

import javax.swing.*;
import java.awt.*;

public class ModifyVehiclePanel extends JPanel {

    public ModifyVehiclePanel(){
        setBackground(new Color(30, 29, 29));
        setLayout(new BorderLayout());
        RightPanel rightPanel = new RightPanel();
        add(rightPanel, BorderLayout.EAST);
    }

    class RightPanel extends JPanel{
        private Dimension buttonSize = new Dimension(200, 40);

        RightPanel(){
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
