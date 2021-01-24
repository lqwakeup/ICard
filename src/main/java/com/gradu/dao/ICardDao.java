package com.gradu.dao;

import com.gradu.entity.Card;

import java.util.List;

public interface ICardDao {
    //通过学生证号找到学生卡信息
    Card findCargByStuId(String stuId);

    //对校园卡进行充值
    void updateBalance(Card card);

    //查找所有的校园卡信息
    List<Card> findAllCards();

    //删除一条记录
    void deleteCard(String stuId);

    //更新校园卡状态
    void updateStatus(Card card);


}
