package pl.jamnic.game.card.component.factory.deck;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.jamnic.game.card.component.factory.DeckFactory;
import pl.jamnic.game.card.model.Card;
import pl.jamnic.game.card.model.Deck;
import pl.jamnic.game.card.model.type.CardNumber;
import pl.jamnic.game.card.model.type.CardSuit;

import com.google.common.collect.Lists;

/**
 * Factory used to create small decks (9, 10, J, Q, K, A).
 * 
 * @author Dariusz Janicki
 */
@Component
public final class SmallDeckFactoryImpl implements DeckFactory {

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
	
	protected CardNumber[] getCardNumbers() {
		CardNumber[] values = CardNumber.values();
		return Arrays.copyOfRange(values, 7, values.length);
	}

	protected CardSuit[] getCardSuits() {
		return CardSuit.values();
	}
}
