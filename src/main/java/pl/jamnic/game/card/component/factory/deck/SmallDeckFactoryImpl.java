package pl.jamnic.game.card.component.factory.deck;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import pl.jamnic.game.card.model.type.CardNumber;
import pl.jamnic.game.card.model.type.CardSuit;

/**
 * Factory used to create small decks (9, 10, J, Q, K, A).
 * 
 * @author Dariusz Janicki
 */
@Component
public class SmallDeckFactoryImpl extends AbstractDeckFactory {

	@Override
	protected CardNumber[] getCardNumbers() {
		CardNumber[] values = CardNumber.values();
		return Arrays.copyOfRange(values, 7, values.length);
	}

	@Override
	protected CardSuit[] getCardSuits() {
		return CardSuit.values();
	}
}
