package pl.jamnic.game.card.component.manager.impl;

import org.springframework.stereotype.Component;

import pl.jamnic.game.card.component.manager.CardManager;
import pl.jamnic.game.card.model.Card;

@Component
public final class CardManagerImpl implements CardManager {

	@Override
	public String getCardInfo(Card card) {
		return "[" + card.getCardNumber().getNumber() + " " + card.getCardSuit().getSymbol() + "]";
	}
}
