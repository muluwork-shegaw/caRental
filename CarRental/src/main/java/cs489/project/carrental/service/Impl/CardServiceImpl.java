package cs489.project.carrental.service.Impl;

import cs489.project.carrental.model.domain.Card;
import cs489.project.carrental.repository.CardRepository;
import cs489.project.carrental.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card getCardById(String id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteCard(String id) {
        cardRepository.deleteById(id);
    }
}
