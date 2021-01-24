package com.gradu.utils;

import com.alibaba.fastjson.JSON;
import com.gradu.entity.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class JSONResult {
    public JSONResult(){

    }

    /*
    将状态码以及请求数据转化为json格式传给前端
     */
    public static void JSONReturnWithData(String recode, Object data, HttpServletResponse response){
        try{
            ResultObj resultObj = new ResultObj();
            resultObj.setRecode(recode);
            resultObj.setDesc(data);
            String resultStr = JSON.toJSONString(resultObj);
            response.getWriter().print(resultStr);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnAllUser(List<User> users,HttpServletResponse response){
        try{
            AllUser allUser = new AllUser();
            allUser.setUsers(users);
            String res = JSON.toJSONString(allUser);
            response.getWriter().print(res);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnAllCard(List<Card> cards,HttpServletResponse response){
        try{
            AllCard allCard = new AllCard();
            allCard.setCards(cards);
            String res = JSON.toJSONString(allCard);
            response.getWriter().print(res);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnAllAccount(List<Account> accounts,HttpServletResponse response){
        try{
            AllAccount allAccount = new AllAccount();
            allAccount.setAccounts(accounts);
            String res = JSON.toJSONString(allAccount);
            response.getWriter().print(res);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnUser(User user,HttpServletResponse response){
        try{
            SignleUser signleUser = new SignleUser();
            signleUser.setUser(user);
            String res = JSON.toJSONString(signleUser);
            response.getWriter().print(res);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void JSONReturnCard(Card card,HttpServletResponse response){
        try{
            SignleCard signleCard = new SignleCard();
            signleCard.setCard(card);
            String res = JSON.toJSONString(signleCard);
            response.getWriter().print(res);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
