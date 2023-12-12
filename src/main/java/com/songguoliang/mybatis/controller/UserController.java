package com.songguoliang.mybatis.controller;


import com.songguoliang.mybatis.entity.User;
import com.songguoliang.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description
 * @Author sgl
 * @Date 2018-05-02 14:59
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    @ResponseBody
    public List<User> lists() {
        return userService.getUsers();
    }

    @RequestMapping("/queryAge")
    @ResponseBody
    public Map<String,Object> queryAgeById(Integer id){
        Map<String,Object> resultMap=new HashMap<>();
        resultMap.put("id",userService.queryAge(id));
        return  resultMap;
    }

/*
    @RequestMapping("/icbcUpload")
    @ResponseBody
    public String icbcUpload(String filePath, String idCardNo){
        ApiClient ac=new ApiClient("4b455f1487d8aeab6821a530c1e1275ab19c90b4f60eeb21f5fa40917c315c4e");
        ApiRequest req=new ApiRequest("https://web-zj.dccnet.com.cn:8443/api","com.icbc.eracct.filereach","ERACCT12001007");
        req.setRequestField("corp_no","ERACCT12001007");
        req.setRequestField("cert_type","0");
        req.setRequestField("cert_no",idCardNo);
        System.out.println(filePath+":"+idCardNo);

        try {
            ApiResponse apiResponse = ac.doUpload(req, filePath);
            System.out.println("返回信息:"+JSON.toJSONString(apiResponse));
            return JSON.toJSONString(JSON.toJSONString(apiResponse));
        } catch (Exception e) {
            System.out.println("返回错误信息:"+JSON.toJSONString(e));
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/iiBindingCard")
    @ResponseBody
    public String iiBindingCard(String busisno, String medium_id){
        ApiClient ac=new ApiClient("4b455f1487d8aeab6821a530c1e1275ab19c90b4f60eeb21f5fa40917c315c4e");
        ApiRequest req=new ApiRequest("https://web-zj.dccnet.com.cn:8443/api","com.icbc.eracct.filereach","ERACCT12001007");
        req.setRequestField("corp_no","ERACCT12001007");
        req.setRequestField("busisno",busisno);
        req.setRequestField("medium_id",medium_id);
        System.out.println(busisno+":"+medium_id);

        try {
            ApiResponse execute = ac.execute(req);
            System.out.println("返回信息:"+JSON.toJSONString(execute));
            return JSON.toJSONString(execute);
        } catch (Exception e) {
            System.out.println("返回错误信息:"+JSON.toJSONString(e));
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("/iiStatusQuery")
    @ResponseBody
    public String iiStatusQuery(String busisno, String medium_id){
        ApiClient ac=new ApiClient("4b455f1487d8aeab6821a530c1e1275ab19c90b4f60eeb21f5fa40917c315c4e");
        ApiRequest req=new ApiRequest("https://web-zj.dccnet.com.cn:8443/api","com.icbc.eracct.statusquery","ERACCT12001007");
        req.setRequestField("corp_no","ERACCT12001007");
        req.setRequestField("busisno",busisno);
        req.setRequestField("medium_id",medium_id);
        System.out.println(busisno+":"+medium_id);

        try {
            ApiResponse execute = ac.execute(req);
            System.out.println("返回信息:"+JSON.toJSONString(execute));
            return JSON.toJSONString(execute);
        } catch (Exception e) {
            System.out.println("返回错误信息:"+JSON.toJSONString(e));
            e.printStackTrace();
        }
        return null;
    }*/
}
