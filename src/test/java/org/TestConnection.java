package org;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.hbase.config.HbaseConfig;

public class TestConnection {
    public static void main(String[] args) throws Exception {
        Configuration config=HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum","d7f4a800eda6");
        config.set("hbase.zookeeper.property.clientPort","2181");
        Connection connection=ConnectionFactory.createConnection(config);
        Admin admin=connection.getAdmin();
        TableName[] tableNames =admin.listTableNames();
        for (TableName tableName : tableNames) {
            System.out.println("Table Name: " + tableName.getNameAsString());
        }
    }
}
