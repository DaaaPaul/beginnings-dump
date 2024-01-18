import java.awt.*;
import javax.swing.*;

public class FrameTest {
    public static void main(String[] args) {
        Timer timer = new Timer(5000, e -> showMessage());
        timer.start();
    }

    public static void showMessage() {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("icon.png"); // Replace with your icon path
            TrayIcon trayIcon = new TrayIcon(image, "Message");
            trayIcon.setImageAutoSize(true);

            try {
                tray.add(trayIcon);
                trayIcon.displayMessage("Message", "This is your popup message!", TrayIcon.MessageType.INFO);
            } catch (AWTException ex) {
                System.err.println("TrayIcon could not be added.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "This is your popup message!");
        }
    }
}