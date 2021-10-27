package Stuff;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sign {
    private JTextField filePath;
    private JButton selectButton;
    private JTextField HashValue;
    private JTextField SecretKey;
    private JTextField PubKey;
    private JButton ComputeSHA;
    private JButton CopySecret;
    private JButton CopyPub;
    private JTextField Encrypted;
    private JButton CopyEncrypted;
    private JButton generateRSAKeyPairButton;
    private JButton encryptButton;

    public Sign() {
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

                j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                // invoke the showsOpenDialog function to show the save dialog
                int r = j.showOpenDialog(null);

                if (r == JFileChooser.APPROVE_OPTION) {
                    // set the label to the path of the selected directory
                    filePath.setText(j.getSelectedFile().getAbsolutePath());
                }
            }
        });
    }
}
