package com.tjkcht.databaseexport.util;

import java.sql.*;

/**
 * Created by LiuYinlong on 2016/10/14.
 */
public class SQLiteJDBC implements JDBC {

    private static Connection connection = null;
    private static Statement statement = null;

    @Override
    public boolean connect(String Url) {
        //(jdbc:sqlite:test.db)
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + Url);
            statement = connection.createStatement();
            connection.setAutoCommit(true);
            System.out.println("SQLiteJDBC连接成功!");
            return true;
        } catch (SQLException e) {
            System.err.println("SQLiteJDBC数据库连接异常!");
            return false;
        } catch (ClassNotFoundException e) {
            System.err.println("SQLiteJDBC类不存在异常!");
            return false;
        }
    }

    @Override
    public void listTable() {
        //SELECT name FROM SQLITE_MASTER WHERE type='table' ORDER BY name;
        try {
            String listSQL = "SELECT name FROM SQLITE_MASTER WHERE type='table' ORDER BY name;";
            ResultSet resultSet = statement.executeQuery(listSQL);
            System.out.print("All lists: ");
            while (resultSet.next()) {
                String table = resultSet.getString("name");
                System.out.print(table + ", ");
            }
        } catch (SQLException e) {
            System.err.println("SQLiteJDBC列出数据库中所有表异常!");
        }
    }

    @Override
    public boolean isTableExist(String tableName) {
        //SELECT count(*) FROM SQLITE_MASTER WHERE type='table' AND name='tableName';
        try {
            String sql = "SELECT name FROM SQLITE_MASTER WHERE type='table' AND name='%s';";
            sql = String.format(sql, tableName);
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("name").equals(tableName)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println(tableName + " 不存在!");
            return false;
        }
    }

    /**
     * 表中添加一列
     *
     * @param tableName
     * @param cName
     * @param cType
     * @param cValue
     */
    public boolean addColumn(String tableName, String cName, String cType, String cValue) {
        //ALTER TABLE prepayment_parking ADD COLUMN attachedScript BLOB DEFAULT null;
        if (isColumnExit(tableName, cName)) {
            return true;
        }
        String alterSQL = "ALTER TABLE %s ADD COLUMN %s %s DEFAULT %s;";
        alterSQL = String.format(alterSQL, tableName, cName, cType, cValue);
        try {
            statement.execute(alterSQL);
            return true;
        } catch (SQLException e) {
            System.err.println("SQLiteJdbc添加一列异常!");
            return false;
        }
    }

    @Override
    public boolean delete(String tableName, String where) {
        //DELETE FROM entry_record WHERE exited=1;
        String deleteSQL = "DELETE FROM %s WHERE %s;";
        deleteSQL = String.format(deleteSQL, tableName, where);
        try {
            statement.execute(deleteSQL);
            return true;
        } catch (SQLException e) {
            System.err.println("SQLiteJdbc删除异常!");
            return false;
        }
    }


    /**
     * 查询表
     *
     * @param tableName
     * @return
     * @throws Exception
     */
    public ResultSet selectAll(String tableName) throws Exception {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM " + tableName + ";");
        } catch (SQLException e) {
            System.err.println("SQLiteJDBC查询所有异常!");
        }
        return resultSet;
    }

    @Override
    public boolean clearTable(String tableName) {
        String clearSQL = "DELETE FROM %s;";
        clearSQL = String.format(clearSQL, tableName);
        try {
            statement.execute(clearSQL);
            return true;
        } catch (SQLException e) {
            System.err.println("SQLiteJdbc清空表异常!");
            return false;
        }
    }

    @Override
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.err.println("SQLiteJdbc关闭异常!");
        }
    }

    /**
     * 判断字段（列）是否存在
     * @param tableName
     * @param cName
     * @return
     */
    private boolean isColumnExit(String tableName, String cName) {
        String columnSQL = "SELECT * FROM SQLITE_MASTER WHERE NAME = '%s';";
        columnSQL = String.format(columnSQL, tableName);
        try {
            ResultSet resultSet = statement.executeQuery(columnSQL);
            while (resultSet.next()) {
//                System.out.println(resultSet.getString("SQL"));
                if (resultSet.getString("SQL").contains(cName)) {
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            System.err.println("SQLiteJdbc查找一列异常!");
            return false;
        }
    }

}


