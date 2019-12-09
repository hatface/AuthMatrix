package com.huawei.swing;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

public class SwingTest {

    public static class UserTableModel extends AbstractTableModel{

        private String[] tableHeader = new String[]{"userName", "passWord", "pass?"};
        private Object[][] tableData = {new Object[]{"kongzhen", "kongzhen@123", Boolean.valueOf("false")},
                new Object[]{"kongzhen1", "kongzhen1@123", Boolean.valueOf("false")}};

        @Override
        public String getColumnName(int column) {
            return  tableHeader[column];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return getValueAt(0, columnIndex).getClass();
        }

        @Override
        public int getRowCount() {
            return tableData.length;
        }

        @Override
        public int getColumnCount() {
            return tableHeader.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            return tableData[rowIndex][columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return  true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            tableData[rowIndex][columnIndex] = aValue;
        }
    }

    public static void main(String [] args)
    {
        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UserTableModel userTableModel = new UserTableModel();
        JTable table = new JTable(userTableModel);
//        table.setPreferredScrollableViewportSize(new Dimension(500, 400));
//        table.setFillsViewportHeight(true);

        JTable table1 = new JTable(userTableModel);
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());


        JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, new JScrollPane(table), new JScrollPane(table1));

        panel.add(jSplitPane, BorderLayout.CENTER);
        panel.add(new JButton("Run"), BorderLayout.SOUTH);


        mainFrame.setContentPane(panel);
        mainFrame.setSize(new Dimension(500, 300));
        mainFrame.setVisible(true);
    }
}
