package com.songguoliang.mybatis.entity;

import java.util.Map;

public class SwitchTradeDto {
    private String appno;

    private String apiName;

    private String txcode;

    private String rid;

    private String apiurl;

    private String appid;
    //
    private String priKey;
    //
    private Map<String,Object> inputParam;

    private String interfaceType;

    private String tradeFlag;

    public String getAppno() {
        return appno;
    }

    public void setAppno(String appno) {
        this.appno = appno;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getTxcode() {
        return txcode;
    }

    public void setTxcode(String txcode) {
        this.txcode = txcode;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getApiurl() {
        return apiurl;
    }

    public void setApiurl(String apiurl) {
        this.apiurl = apiurl;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPriKey() {
        return priKey;
    }

    public void setPriKey(String priKey) {
        this.priKey = priKey;
    }

    public Map<String, Object> getInputParam() {
        return inputParam;
    }

    public void setInputParam(Map<String, Object> inputParam) {
        this.inputParam = inputParam;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getTradeFlag() {
        return tradeFlag;
    }

    public void setTradeFlag(String tradeFlag) {
        this.tradeFlag = tradeFlag;
    }
}
