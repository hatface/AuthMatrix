package com.knightsoft.test;

import burp.BurpExtender;
import com.knightsoft.data.MatrixDB;
import com.knightsoft.ui.UserTableModel;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TableTest {


    @Test
    public void TableTest()
    {
        BurpExtender burpExtender = new BurpExtender();
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JTable table = new JTable(new UserTableModel(burpExtender));
        panel.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton button = new JButton("addUser");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String addUser = JOptionPane.showInputDialog(mainFrame, "addUser");
                Object[] userEntry = MatrixDB.getUserEntry();
                userEntry[0] = addUser;
                burpExtender.getDb().getUserData().add(userEntry);
                mainFrame.revalidate();
            }
        });

        panel.add(button, BorderLayout.SOUTH);

        mainFrame.setContentPane(panel);
        mainFrame.setSize(new Dimension(500, 300));

        mainFrame.setVisible(true);
        while (true);
    }
}
