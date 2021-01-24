package com.gradu.service;

import com.gradu.entity.Card;

import java.util.List;

public interface ICardService {
    Card findCargByStuId(String stuId);

    void updateBalance(Card card);

    List<Card> findAllCards();

    void deleteCard(String stuId);

    void updateStatus(Card card);
}
