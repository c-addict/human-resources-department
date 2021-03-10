package com.zelenev.services;

import com.zelenev.data.dao.CardRepository;
import com.zelenev.data.entities.Card;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Optional<Card> readCardByAccountId(Integer id) {
        return cardRepository.findCardByAccountId(id);
    }

    public void create(Card card) {
        cardRepository.save(card);
    }
}
