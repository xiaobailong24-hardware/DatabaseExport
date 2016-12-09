package com.tjkcht.databaseexport.util;

import java.io.File;

/**
 * Created by xiaobailong24 on 2016/10/13.
 * 文件过滤器：显示文件夹和.db文件
 */
public class DbFileFilter extends javax.swing.filechooser.FileFilter {
    @Override
    public boolean accept(File f) {
        String nameString = f.getName();
        return !f.isFile() || nameString.toLowerCase().endsWith(".db");
    }

    @Override
    public String getDescription() {
        return "*.db(数据库文件)";
    }
}
