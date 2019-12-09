package com.knightsoft.data;

import com.knightsoft.ui.UserTableModel;

import java.util.ArrayList;
import java.util.List;

public class MatrixDB {
    public enum USERINDEX {
        USERNAME("userName", ""), PASSWORD("passWord", "");
        private String name;
        private Object defaultValue;

        USERINDEX(String name, Object defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
        }

        public Object getDefaultValue() {
            return defaultValue;
        }

        public void setDefaultValue(Object defaultValue) {
            this.defaultValue = defaultValue;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    Object[] userEntry = new Object[USERINDEX.values().length];
    public static Object[] getUserEntry()
    {
        Object[] objects = new Object[USERINDEX.values().length];
        USERINDEX[] values = USERINDEX.values();
        for (int i = 0; i < values.length; i ++)
        {
            objects[i] = values[i].getDefaultValue();
        }

        return objects;
    }
    List<Object[]> userData = new ArrayList<Object[]>();

    public List<Object[]> getUserData() {
        return userData;
    }

    public void setUserData(List<Object[]> userData) {
        this.userData = userData;
    }

}
