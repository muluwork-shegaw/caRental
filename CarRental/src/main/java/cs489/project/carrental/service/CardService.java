package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Card;

public interface CardService {
    Card saveCard(Card card);
    Card getCardById(String id);
    void deleteCard(String id);
}
