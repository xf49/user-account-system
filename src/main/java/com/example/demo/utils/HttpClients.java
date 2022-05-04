package com.example.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpClients {

    public static String get(JSONObject headers,String url,JSONObject params) throws IOException{

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet httpGet = null;
        List<BasicNameValuePair> paramList = new ArrayList<>();
        if(params!=null){
           Iterator<String> iterator = params.keySet().iterator();
           while(iterator.hasNext()){
               String paramName= iterator.next();
               paramList.add(new BasicNameValuePair(paramName,params.get(paramName).toString()));
           }
        }
        if(url.contains("?")) {
            httpGet = new HttpGet(url + "&" + EntityUtils.toString(new UrlEncodedFormEntity(paramList, Consts.UTF_8)));
        }else{
            httpGet = new HttpGet(url + "?" + EntityUtils.toString(new UrlEncodedFormEntity(paramList, Consts.UTF_8)));
        }
        if(headers!=null){
            for(Map.Entry<String,Object>entry: headers.entrySet()){
                httpGet.addHeader(entry.getKey(),entry.getValue().toString());
            }
        }
        httpGet.addHeader("Content-Type", "application/json");
        HttpEntity entity=httpClient.execute(httpGet).getEntity();
        String response=EntityUtils.toString(entity);
        httpClient.close();;
        return response;
    }

    public static String post(JSONObject headers, String url, JSONObject params) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost httpPost = new HttpPost(url);
        if (headers != null) {
            for(Map.Entry<String,Object>entry:headers.entrySet()){
                httpPost.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        httpPost.addHeader("Content-Type", "application/json");
        if (params != null) {
            StringEntity stringEntity = new StringEntity(params.toJSONString());
            httpPost.setEntity(stringEntity);
        }
        HttpEntity entity = httpClient.execute(httpPost).getEntity();
        String response = EntityUtils.toString(entity);
        httpClient.close();
        return response;
    }

    public static String delete(JSONObject headers, String url, JSONObject params) throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpDeleteWithBody httpDelete = new HttpDeleteWithBody(url);
        if (headers != null) {
            for(Map.Entry<String,Object>entry:headers.entrySet()){
                httpDelete.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        httpDelete.addHeader("Content-Type", "application/json");
        if (params != null) {
            StringEntity stringEntity = new StringEntity(params.toJSONString());
            httpDelete.setEntity(stringEntity);
        }
        HttpEntity entity = httpClient.execute(httpDelete).getEntity();
        String response = EntityUtils.toString(entity);
        httpClient.close();
        return response;
    }
    public static String put(JSONObject headers, String url, JSONObject params) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPut httpPut = new HttpPut(url);
        if (headers != null) {
            for(Map.Entry<String,Object>entry:headers.entrySet()){
                httpPut.addHeader(entry.getKey(), entry.getValue().toString());
            }
        }
        httpPut.addHeader("Content-Type", "application/json");
        if (params != null) {
            StringEntity stringEntity = new StringEntity(params.toJSONString());
            httpPut.setEntity(stringEntity);
        }

        HttpEntity entity = httpClient.execute(httpPut).getEntity();
        String response = EntityUtils.toString(entity);
        httpClient.close();
        return response;
    }


    public static class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "DELETE";

        @Override
        public String getMethod() {
            return METHOD_NAME;
        }

        public HttpDeleteWithBody(final String uri) {
            super();
            setURI(URI.create(uri));
        }

        public HttpDeleteWithBody(final URI uri) {
            super();
            setURI(uri);
        }

        public HttpDeleteWithBody() {
            super();
        }
    }
}


