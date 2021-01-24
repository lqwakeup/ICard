package com.gradu.service.impl;

import com.gradu.dao.ICardDao;
import com.gradu.entity.Card;
import com.gradu.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cardService")
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardDao cardDao;

    @Override
    public Card findCargByStuId(String stuId) {
        return cardDao.findCargByStuId(stuId);
    }

    @Override
    public void updateBalance(Card card) {
        cardDao.updateBalance(card);
    }

    @Override
    public List<Card> findAllCards() {
        return cardDao.findAllCards();
    }

    @Override
    public void deleteCard(String stuId) {
        cardDao.deleteCard(stuId);
    }

    @Override
    public void updateStatus(Card card) {
        cardDao.updateStatus(card);
    }
}
