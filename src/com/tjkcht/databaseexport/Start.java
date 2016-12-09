package com.tjkcht.databaseexport;

import java.io.IOException;

/**
 * Created by LiuYinlong on 2016/10/13.
 */
public class Start {

    public static void main(String[] args) throws IOException {
        UiInit.start();
    }

/*
    public static List<String> findJar(String txtPath) throws IOException {
        List<String> list = new ArrayList<>();
        Files.readAllLines(Paths.get(txtPath), Charset.forName("GBK")).forEach(s -> {
            if (s.contains("DatabaseExport_jar") && !list.contains(s.split("DatabaseExport_jar")[1])) {
                list.add(s.split("DatabaseExport_jar")[1]);
            }
        });
        return list;
    }*/

}
