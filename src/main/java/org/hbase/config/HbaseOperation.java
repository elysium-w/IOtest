package org.hbase.config;

import java.io.IOException;

public class HbaseOperation {
    public static void main(String[] args) throws IOException {
        String tableName="goods";
        String family="electronic";
        HbaseConfig.connectionHBase("172.17.0.2","2181");
        HbaseConfig.createTable(tableName,family);
        HbaseConfig.insertData(tableName,"1001",family,"name","laptap");
        HbaseConfig.close();
    }
}
