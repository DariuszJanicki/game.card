package pl.jamnic.game.card.component.factory.deck;

import org.springframework.stereotype.Component;

import pl.jamnic.game.card.model.type.CardNumber;
import pl.jamnic.game.card.model.type.CardSuit;

/**
 * Factory used to create full decks.
 * 
 * @author Dariusz Janicki
 */
@Component
public class FullDeckFactoryImpl extends AbstractDeckFactory {

	@Override
	protected CardNumber[] getCardNumbers() {
		return CardNumber.values();
	}

	@Override
	protected CardSuit[] getCardSuits() {
		return CardSuit.values();
	}
}
