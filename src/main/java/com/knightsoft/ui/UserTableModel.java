package com.knightsoft.ui;

import burp.BurpExtender;
import burp.IBurpExtender;
import com.knightsoft.data.MatrixDB;

import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {

    IBurpExtender parent = null;
    MatrixDB db = null;

    public UserTableModel(IBurpExtender parent) {
        this.parent = parent;
        if (parent instanceof BurpExtender)
        {
            this.db = ((BurpExtender)parent).getDb();
        }
    }

    @Override
    public String getColumnName(int column) {
        return MatrixDB.USERINDEX.values()[column].getName();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return db.getUserData().get(0) == null? Object.class: db.getUserData().get(0)[columnIndex].getClass();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        db.getUserData().get(rowIndex)[columnIndex] = aValue;
    }

    @Override
    public int getRowCount() {
        return db.getUserData().size();
    }

    @Override
    public int getColumnCount() {
        return MatrixDB.USERINDEX.values().length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return db.getUserData().get(rowIndex)[columnIndex];
    }
}
