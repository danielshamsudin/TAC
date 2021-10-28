package Stuff;

import Src.RSA;
import Src.SHA256;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class Sign {
    private JTextField filePath;
    private JButton selectButton;
    private JTextField HashValue;
    private JTextField SecretKey;
    private JTextField PubKey;
    private JTextField Encrypted;
    private JButton generateRSAKeyPairButton;
    private JButton verifyButton;
    private JPanel panelSign;

    public void display() {
        JFrame frame = new JFrame("Sign");
        frame.setContentPane(new Sign().panelSign);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Sign() {
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                // invoke the showsOpenDialog function to show the save dialog
                int r = j.showOpenDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {
                    // set the label to the path of the selected directory
                    filePath.setText(j.getSelectedFile().getAbsolutePath());
                }

                File f = j.getSelectedFile();
                RSA key = new RSA(1024);
                try {
                    SHA256 shadigest = new SHA256(f);
                    byte[] bytes = shadigest.returnHex().getBytes();
                    BigInteger message = new BigInteger(bytes);
                    BigInteger en = key.encrypt(message);
                    BigInteger de = key.decrypt(en);

                    HashValue.setText(new String(message.toByteArray()));
                    SecretKey.setText(key.getPrivateKey());
                    PubKey.setText(key.getPublicKey());
                    Encrypted.setText(en.toString(16));

                    File out = new File("result.txt");
                    if (out.createNewFile()){
                        FileWriter fw = new FileWriter(out);
                        fw.write(en.toString(16));
                        fw.write("\n");
                        fw.write(key.getPublicKey());
                        fw.write("\n");
                        fw.write(new String(message.toByteArray()));
                        fw.write("\n");
                        fw.write(key.getModulus());
                        fw.close();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (NoSuchAlgorithmException ex) {
                    ex.printStackTrace();
                }

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
}
