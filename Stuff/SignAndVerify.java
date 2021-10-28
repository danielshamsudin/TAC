package Stuff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignAndVerify {
    private JButton generateAndSignButton;
    private JButton verifyButton;
    private JPanel gensign;

    public SignAndVerify() {
        generateAndSignButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent c = (JComponent) e.getSource();
                Window w = SwingUtilities.getWindowAncestor(c);
                w.dispose();
                Sign s = new Sign();
                s.display();
            }
        });
        verifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComponent c = (JComponent) e.getSource();
                Window w = SwingUtilities.getWindowAncestor(c);
                w.dispose();
                Verify v = new Verify();
                v.display();
            }
        });
    }

    public static void display() {
        JFrame frame = new JFrame("SignAndVerify");
        frame.setContentPane(new SignAndVerify().gensign);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
