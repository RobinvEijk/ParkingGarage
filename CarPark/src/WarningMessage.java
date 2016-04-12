import javax.swing.JOptionPane;

public class WarningMessage
{

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Waarschuwing: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}