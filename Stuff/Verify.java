package Stuff;


import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

public class Verify {
    private JTextField enterEncrypted;
    private JTextField enterPub;
    private JTextField Result;
    private JButton verifyButton;
    private JTextField enterSHA;
    private JPanel verify;

    public static void display() {
        JFrame frame = new JFrame("Verify");
        frame.setContentPane(new Verify().verify);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
