package com.tjkcht.databaseexport.util;

import java.sql.*;

/**
 * Created by xiaobailong24 on 2016/10/19.
 * A ResultSet object is automatically closed when the Statement object that generated it is closed,
 * re-executed, or used to retrieve the next result from a sequence of multiple results.
 */
public class MySqlJDBC implements JDBC {
    private static Connection connection = null;
    private static Statement statement = null;
    private ResultSet resultSet = null;

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public boolean connect(String Url) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Url + "&useUnicode=true&characterEncoding=UTF-8");
            statement = connection.createStatement();
            System.out.println("MySqlJDBC连接成功");
            return true;
        } catch (ClassNotFoundException e) {
            System.err.println("MySqlJDBC类异常");
            return false;
        } catch (SQLException e) {
            System.err.println("MySqlJDBC打开异常");
            return false;
        }
    }

    @Override
    public void listTable() {
    }

    @Override
    public boolean isTableExist(String tableName) {
        return false;
    }

    @Override
    public boolean delete(String tableName, String where) {
        return false;
    }

    @Override
    public boolean clearTable(String tableName) {
        String clearSQL = "TRUNCATE TABLE %s;";
        clearSQL = String.format(clearSQL, tableName);
        try {
            statement.execute(clearSQL);
            return true;
        } catch (SQLException e) {
            System.err.println("MySqlJDBC清空表异常!");
            return false;
        }
    }

    //插入到MySQL数据库entry_record
    public boolean insertEntryRecord() {
        if (!clearTable("entry_record")) {
            return false;
        }
        try {
            while (resultSet.next()) {
                String insertSQL = "INSERT INTO entry_record VALUES (%s);";
                StringBuffer er = new StringBuffer();
                er.append(resultSet.getInt("id"))
                        .append("," + resultSet.getLong("enterTime"))
                        .append(",'" + resultSet.getString("entryId"))
                        .append("','" + resultSet.getString("plateNo"))
                        .append("','" + resultSet.getString("vehicleType"))
                        .append("','" + resultSet.getString("rfidParsePlateNoResult"))
                        .append("','" + resultSet.getString("imgParsePlateNoResult"))
                        .append("','" + resultSet.getString("enterImg"))
                        .append("','" + resultSet.getString("state"))
                        .append("'," + resultSet.getInt("exited"))
                        .append("," + resultSet.getInt("ordering"));
//                System.out.println(sb.toString());
                insertSQL = String.format(insertSQL, er.toString());
                System.out.println(insertSQL);
                statement.execute(insertSQL);
            }
            return true;
        } catch (Exception e) {
            System.err.println("插入到MySQL数据库entry_record异常!");
            return false;
        }
    }

    //插入到MySQL数据库prepayment_parking
    public boolean insertPrepaymentParking() {
        if (!clearTable("prepayment_parking")) {
            return false;
        }
        try {
            while (resultSet.next()) {
                String insertSQL = "INSERT INTO prepayment_parking VALUES (%s);";
                StringBuffer pp = new StringBuffer();
                pp.append("'" + resultSet.getString("outerUUID"))
                        .append("','" + resultSet.getString("plateNo"))
                        .append("','" + resultSet.getString("vehicleType"))
                        .append("'," + resultSet.getLong("begin_date"))
                        .append("," + resultSet.getLong("end_date"))
                        .append("," + resultSet.getLong("begin_time"))
                        .append("," + resultSet.getLong("end_time"))
                        .append(",'" + resultSet.getString("slot"))
                        .append("'," + resultSet.getLong("updateTime"))
                        .append(",'" + resultSet.getString("attachedScript") + "'");
//                System.out.println(sb.toString());
                insertSQL = String.format(insertSQL, pp.toString());
                System.out.println(insertSQL);
                statement.execute(insertSQL);
            }
            return true;
        } catch (Exception e) {
            System.err.println("插入到MySQL数据库prepayment_parking异常!");
            return false;
        }
    }

    //插入到MySQL数据库white_list
    public boolean insertWhiteList() {
        if (!clearTable("white_list")) {
            return false;
        }
        try {
            while (resultSet.next()) {
                String insertSQL = "INSERT INTO white_list VALUES (%s);";
                StringBuffer wl = new StringBuffer();
                wl.append("'" + resultSet.getString("outerUUID"))
                        .append("','" + resultSet.getString("plateNo"))
                        .append("','" + resultSet.getString("vehicleType"))
                        .append("'," + resultSet.getLong("updateTime"))
                        .append("," + resultSet.getLong("validTime"))
                        .append("," + resultSet.getLong("expireTime"))
                        .append(",'" + resultSet.getString("selectedChannels"))
                        .append("','" + resultSet.getString("attachedScript") + "'");
//                System.out.println(sb.toString());
                insertSQL = String.format(insertSQL, wl.toString());
                System.out.println(insertSQL);
                statement.execute(insertSQL);
            }
            return true;
        } catch (Exception e) {
            System.err.println("插入到MySQL数据库white_list异常!");
            return false;
        }
    }

    //插入到MySQL数据库inner_park_terminal
    public boolean insertInnerParkTerminal() {
        if (!clearTable("inner_park_terminal")) {
            return false;
        }
        try {
            while (resultSet.next()) {
                String insertSQL = "INSERT INTO inner_park_terminal VALUES (%s);";
                StringBuffer ipt = new StringBuffer();
                ipt.append("'" + resultSet.getString("terminalId"))
                        .append("','" + resultSet.getString("terminalIp"))
                        .append("','" + resultSet.getString("entryList"))
                        .append("','" + resultSet.getString("exitList"))
                        .append("'," + resultSet.getInt("occupiedSlotCount"))
                        .append("," + resultSet.getInt("orderedSlotCount"))
                        .append("," + resultSet.getInt("subRegion1SlotCount"))
                        .append("," + resultSet.getInt("subRegion2SlotCount"))
                        .append("," + resultSet.getFloat("totalCash"));
//                System.out.println(sb.toString());
                insertSQL = String.format(insertSQL, ipt.toString());
                System.out.println(insertSQL);
                statement.execute(insertSQL);
            }
            return true;
        } catch (Exception e) {
            System.err.println("插入到MySQL数据库entry_record异常!");
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
            System.err.println("MySqlJDBC关闭异常!");
        }
    }

}
