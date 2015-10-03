package pl.jamnic.game.card.component.factory.deck;

import java.util.List;

import pl.jamnic.game.card.component.factory.DeckFactory;
import pl.jamnic.game.card.model.Card;
import pl.jamnic.game.card.model.Deck;
import pl.jamnic.game.card.model.type.CardNumber;
import pl.jamnic.game.card.model.type.CardSuit;

import com.google.common.collect.Lists;

public abstract class AbstractDeckFactory implements DeckFactory {

	@Override
	public Deck createNew() {
		List<Card> cards = Lists.newLinkedList();

		pickCardNumber(cards);

		return new Deck(cards);
	}

	protected void pickCardNumber(List<Card> cards) {
		for (CardNumber cardNumber : getCardNumbers()) {
			pickCardSuit(cards, cardNumber);
		}
	}

	protected void pickCardSuit(List<Card> cards, CardNumber cardNumber) {
		for (CardSuit cardSuit : getCardSuits()) {
			Card card = new Card(cardNumber, cardSuit);
			cards.add(card);
		}
	}

	protected abstract CardNumber[] getCardNumbers();

	protected abstract CardSuit[] getCardSuits();
}
