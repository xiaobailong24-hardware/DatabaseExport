package com.tjkcht.databaseexport.util;

import java.sql.ResultSet;

/**
 * Created by xiaobailong24 on 2016/10/19.
 */
public interface JDBC {
    /**
     * 首先连接数据库
     *
     * @param Url
     */
    boolean connect(String Url);

    /**
     * 列出数据库中所有表
     *
     * @return
     */
    void listTable();

    /**
     * 判断表是否存在
     *
     * @param tableName
     * @return
     */
    boolean isTableExist(String tableName);

    /**
     * 删除操作
     *
     * @param tableName
     * @param where
     */
    boolean delete(String tableName, String where);

    /**
     * 清空表
     *
     * @param tableName
     */
    boolean clearTable(String tableName);

    /**
     * 关闭数据库连接
     */
    void close();

}
