package Stuff;

import javax.swing.*;

public class SignAndVerify {
    private JButton generateAndSignButton;
    private JButton verifyButton;
    private JPanel gensign;

    public static void display() {
        JFrame frame = new JFrame("SignAndVerify");
        frame.setContentPane(new SignAndVerify().gensign);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
