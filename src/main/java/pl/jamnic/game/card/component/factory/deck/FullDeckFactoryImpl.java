package pl.jamnic.game.card.component.factory.deck;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import pl.jamnic.game.card.component.factory.DeckFactory;
import pl.jamnic.game.card.model.Card;
import pl.jamnic.game.card.model.Deck;
import pl.jamnic.game.card.model.type.CardNumber;
import pl.jamnic.game.card.model.type.CardSuit;

/**
 * Factory used to create full decks.
 * 
 * @author Dariusz Janicki
 */
public final class FullDeckFactoryImpl extends AbstractDeckFactory implements DeckFactory {

	@Override
	public Deck createNew() {
		List<Card> cards = Lists.newLinkedList();

		pickCardNumber(cards);

		return new Deck(cards);
	}
	
	@Override
	protected CardNumber[] getCardNumbers() {
		return CardNumber.values();
	}

	@Override
	protected CardSuit[] getCardSuits() {
		return CardSuit.values();
	}
}
