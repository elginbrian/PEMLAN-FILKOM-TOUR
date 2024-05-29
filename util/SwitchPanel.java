package util;

import javax.swing.*;
import java.awt.*;

public class SwitchPanel {
    public static void implement(JPanel panel, JPanel newPanel) {
        panel.removeAll();
        panel.add(newPanel, BorderLayout.CENTER);
        panel.revalidate();
        panel.repaint();
    }
}
