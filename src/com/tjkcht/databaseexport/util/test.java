package com.tjkcht.databaseexport.util;

import com.tjkcht.databaseexport.CustomJLabel;

import javax.swing.*;

/**
 * Created by xiaobailong24 on 2016/10/19.
 */
public class test {
    public static void main(String[] args) {
        MySqlJDBC mySqlJDBC = new MySqlJDBC();
        SQLiteJDBC sqLiteJDBC = new SQLiteJDBC();

        try {
            boolean scon = sqLiteJDBC.connect("sql.db");
//            if (scon) {
//                ResultSet rs = sqLiteJDBC.select("entry_record","*");
//                while (rs.next() ) {
//                	int enterTime=rs.getInt("enterTime");
//                    System.out.println(enterTime);
//                }
//            }
            boolean connecting = mySqlJDBC.connect("jdbc:mysql://localhost/parking_test?user=root&password=tjkcht");
            if (connecting) {
                JDialog jDialog = new JDialog();
                jDialog.setSize(800,800);
                jDialog.setTitle("Hello");
                jDialog.add(new CustomJLabel("World"));
                jDialog.add(new CustomJLabel("World"));
                jDialog.add(new CustomJLabel("World"));
                jDialog.setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
