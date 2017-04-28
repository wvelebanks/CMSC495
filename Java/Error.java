package etmsclient;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *  @date created 
 *  @author Ian Spooner
 */

public class Error {
static JFrame popup = new JFrame("Popup Window");
public static void warning(String error){
        JOptionPane.showMessageDialog(popup,
        "That doesn't seem to be valid... \n"
        + error,
        "Try again",
        JOptionPane.WARNING_MESSAGE);
    }

}