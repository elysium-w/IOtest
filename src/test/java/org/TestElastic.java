package org;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestElastic {
    private static final String ELASTICSEARCH_URL = "http://localhost:9200";
    public static void createIndex(String indexName) throws IOException {
        HttpClient httpClient= HttpClients.createDefault();
        HttpPut httpPut=new HttpPut(ELASTICSEARCH_URL+"/"+indexName);
        HttpResponse httpResponse=httpClient.execute(httpPut);
        print(httpResponse);
    }
    public static void print(HttpResponse response) throws IOException {
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("ResponseCode:"+statusCode);
        BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line;
        StringBuilder result=new StringBuilder();
        while ((line=reader.readLine())!=null){
            result.append(line);
        }
        System.out.println("Response Body:"+result.toString());
    }
    public static void main(String[] args) throws IOException {
        TestElastic elasticTest=new TestElastic();
        createIndex("test001");

    }
}
