package timerapplication;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Main {

    public static Image iconForTray(SystemTray st) {
        Image trayIconImage = Toolkit.getDefaultToolkit().getImage("src/resources/timer.png");
        Dimension trayIconSize = st.getTrayIconSize();
        trayIconImage = trayIconImage.getScaledInstance(trayIconSize.width, trayIconSize.height, Image.SCALE_SMOOTH);
        return trayIconImage;
    }

    public static void ignite() {
        JOptionPane.showMessageDialog(null, "Application has loaded. Check your tray bar.");
        PopupMenu pm = new PopupMenu();
        MenuItem miSettings = new MenuItem("Settings");
        MenuItem miClose = new MenuItem("Close");
        miSettings.addActionListener((ActionEvent e) -> {
            new SettingsWindow().setVisible(true);
        });
        miClose.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        pm.add(miSettings);
        pm.add(miClose);
        if (SystemTray.isSupported()) {
            SystemTray st = SystemTray.getSystemTray();
            TrayIcon trayIcon = new TrayIcon(iconForTray(st));
            trayIcon.setPopupMenu(pm);
            try {
                st.add(trayIcon);
            } catch (AWTException ex) {
                JOptionPane.showMessageDialog(null, "Error in adding the application to system tray. Please try again!", "SystemTray error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "SystemTray is not supported", "SystemTray error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        ignite();
    }
}
