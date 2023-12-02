package org.hbase.config;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseConfig {
    private static ThreadLocal<Connection> connection=new ThreadLocal<Connection>();
    private HbaseConfig(){}
    public static void connectionHBase(String hostName,String post) throws IOException, IOException {
        Configuration config=HBaseConfiguration.create();
        config.set("hbase.zookeeper.quorum",hostName);
        config.set("hbase.zookeeper.property.clientPort",post);
        Connection connection=ConnectionFactory.createConnection(config);
        Admin admin=connection.getAdmin();
        TableName[] tableNames = admin.listTableNames();
    }
    public static void insertData(String tableName,String rowKey,String family,String clo,String value) throws IOException {
        Connection conn=connection.get();
        Table table=conn.getTable(TableName.valueOf(tableName));
        Put put=new Put(Bytes.toBytes(rowKey));
        put.addColumn(Bytes.toBytes(family),Bytes.toBytes(clo),Bytes.toBytes(value));
        table.put(put);
        table.close();
    }
    public static Result getData(String tableName, String rowKey) throws IOException {
        Connection conn=connection.get();
        Table table=conn.getTable(TableName.valueOf(tableName));
        Get get=new Get(Bytes.toBytes(rowKey));
        Result result=table.get(get);
        return result;
    }
    public static void createTable(String tableName,String colFamily){
        HTableDescriptor table=new HTableDescriptor(TableName.valueOf(tableName));
        HColumnDescriptor col=new HColumnDescriptor(colFamily);
        table.addFamily(col);
    }
    public static void close() throws IOException {
        Connection conn=connection.get();
        if (conn!=null){
            conn.close();
            connection.remove();
        }
    }

}
