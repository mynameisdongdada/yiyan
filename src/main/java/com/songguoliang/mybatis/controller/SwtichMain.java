package com.songguoliang.mybatis.controller;

import com.alibaba.fastjson.JSON;
import com.songguoliang.mybatis.entity.SwitchTradeDto;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class SwtichMain {
    public static void main(String[] args) {
        SwitchTradeDto switchTradeDto=new SwitchTradeDto();
        switchTradeDto.setApiurl("https://web-zj.dccnet.com.cn:8443/api");
        switchTradeDto.setApiName("com.icbc.eracct.predictopen");
        switchTradeDto.setAppid("ERACCT12001007");
        switchTradeDto.setInterfaceType("2");
        switchTradeDto.setTradeFlag("predictopen");
        Map<String,Object> inputParam=new HashMap<>();
        inputParam.put("busisno","20231121");
        inputParam.put("corp_no","ERACCT12001007");
        inputParam.put("corp_cis_no","412728199603040014");
        inputParam.put("corp_medium_id","412728199603040014");
        inputParam.put("cert_type","0");
        inputParam.put("cert_no","412728199603040014");
        inputParam.put("cust_name","董航");
        inputParam.put("mobile_no","15538093681");
        switchTradeDto.setInputParam(inputParam);

        HttpPost httpPost=new HttpPost("22.4.29.42:20005/doMain/switchTradeOfZJ");

        StringEntity entity=new StringEntity(JSON.toJSONString(switchTradeDto),"UTF-8");

        entity.setContentType("application/json");

        httpPost.setEntity(entity);
        CloseableHttpClient httpClient=null;
        try {
            httpClient= HttpClients.createDefault();

            CloseableHttpResponse response= httpClient.execute(httpPost);

            String resp= EntityUtils.toString(response.getEntity(),"utf-8");

            System.out.println("返回信息："+resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(httpClient!=null){
                    httpClient.close();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
