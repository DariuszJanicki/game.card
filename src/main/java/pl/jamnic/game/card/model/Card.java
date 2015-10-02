package pl.jamnic.game.card.model;

import pl.jamnic.game.card.model.type.CardNumber;
import pl.jamnic.game.card.model.type.CardSuit;

/**
 * Immutable typical game {@link Card}.
 * 
 * @author Dariusz Janicki
 */
public final class Card {

	private CardNumber cardNumber;
	private CardSuit cardSuit;

	public Card(CardNumber cardNumber, CardSuit cardSuit) {
		this.cardNumber = cardNumber;
		this.cardSuit = cardSuit;
	}

	public CardNumber getCardNumber() {
		return cardNumber;
	}

	public CardSuit getCardSuit() {
		return cardSuit;
	}
}
