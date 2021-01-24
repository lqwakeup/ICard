package com.gradu.dao.impl;

import com.gradu.dao.ICardDao;
import com.gradu.entity.Card;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cardDao")
public class CardDaoImpl implements ICardDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public Card findCargByStuId(String stuId) {
        try {
            List<Card> cards = runner.query("select * from card where stuId = ?",new BeanListHandler<Card>(Card.class),stuId);
            if(cards.size()==0){
                return null;
            }
            if(cards.size()>1){
                throw new RuntimeException("数据集不唯一，数据不唯一");
            }
            return cards.get(0);
        }catch (Exception e){
            throw  new RuntimeException(e);
        }
    }

    @Override
    public void updateBalance(Card card) {
        try{
            runner.update("update card set balance = ? where stuId = ?",card.getBalance(),card.getStuId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Card> findAllCards() {
        try {
            List<Card> cards = runner.query("select * from card",new BeanListHandler<Card>(Card.class));
            return cards;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCard(String stuId) {
        try{
            runner.update("delete from card where stuId = ?",stuId);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateStatus(Card card) {
        try{
            runner.update("update card set status = ? where stuId = ?",card.getStatus(),card.getStuId());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
