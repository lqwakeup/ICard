package com.gradu.utils;

import com.alibaba.fastjson.JSON;
import com.gradu.entity.UpdatePsd;

import javax.servlet.http.HttpServletResponse;

/*
将密码转化成JSON格式
 */
public class JSONPsd {
    public JSONPsd(){

    }

    public static void JSONPsdResult(String psd1, String psd2, Integer code, String des, HttpServletResponse response){
        try{
            UpdatePsd updatePsd = new UpdatePsd();
            updatePsd.setOldPsd(psd1);
            updatePsd.setPsd(psd2);
            updatePsd.setRecode(code);
            updatePsd.setDesc(des);
            String psdStr = JSON.toJSONString(updatePsd);
            response.getWriter().print(psdStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
