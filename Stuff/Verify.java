package Stuff;


import Src.RSA;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Verify {
    // match
    // mismatch - file tempura or corrupt
    private JTextField enterEncrypted;
    private JTextField enterPub;
    private JTextField Result;
    private JButton exitButton;
    private JTextField enterSHA;
    private JPanel verify;
    private JTextField filePathVerify;
    private JButton selectFile;
    private BigInteger mod, en, pubKey, message;
    private String msgTmp, pkTmp, enTmp, modTmp;

    public Verify() {
        selectFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                j.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

                int r = j.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION){
                    filePathVerify.setText(j.getSelectedFile().getAbsolutePath());
                }

                File input = j.getSelectedFile();
                Scanner reader;
                try {
                    reader = new Scanner(input);
                    while(reader.hasNextLine()){
                        enTmp = reader.nextLine();
                        pkTmp = reader.nextLine();
                        msgTmp = reader.nextLine();
                        modTmp = reader.nextLine();
                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                enterEncrypted.setText(enTmp);
                enterPub.setText(pkTmp);
                enterSHA.setText(msgTmp);

                en = new BigInteger(enTmp, 16);
                pubKey = new BigInteger(pkTmp, 16);
                mod = new BigInteger(modTmp, 16);

                BigInteger deMsg = en.modPow(pubKey, mod);
                String tmp = new String(deMsg.toByteArray());
                System.out.println(tmp);
                System.out.println(msgTmp);

                if (tmp.equals(msgTmp)){
                    Result.setText("File Match!");
                }else{
                    Result.setText("File Mismatch!");
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
    }

    public static void display() {
        JFrame frame = new JFrame("Verify");
        frame.setContentPane(new Verify().verify);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
